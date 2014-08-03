package com.flying.xiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.CommentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.entity.XComment;
import com.flying.xiao.entity.XUserInfo;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetComments
 */
@WebServlet(description = "获取评论列表", urlPatterns = { "/servlet/GetComments" })
public class GetComments extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String conIdStr=request.getParameter("contentid");
		String pageStr=request.getParameter("page");
		if(conIdStr==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
			return ;
		}
		try{
			long contentid=Long.parseLong(conIdStr);
			pageStr=(pageStr==null?"0":pageStr);
			int page=Integer.parseInt(pageStr);
			IBaseHibernateDAO<PingLun> dao_pl = new CommentDaoImpl();
			// 获取评论列表
			String hql="";
			if(userSession==null)
				hql="from PingLun pl where pl.content.id=" + contentid;
			else
				hql="from PingLun pl where pl.content.id=" + contentid+" and pl.userInfo.id="+userSession.getId();
			List<PingLun> pls = dao_pl.findByHql(hql, page*Constant.MAX_PAGE_COUNT, Constant.MAX_PAGE_COUNT);
			List<XComment> comments = new ArrayList<XComment>();
			for (PingLun pl : pls)
			{
				XComment com = new XComment();
				com.copy(pl);
				com.setContentId(contentid);
				XUserInfo user = new XUserInfo();
				user.copy(pl.getUserInfo());
				com.setXuserInfo(user);
				if (pl.getPingLun() != null)
				{
					com.setReplyCommentId(pl.getPingLun().getPlId());
				}
				comments.add(com);
			}
			Gson gson=new Gson();
			pw.write(gson.toJson(comments));
			pw.flush();
			pw.close();
		}catch(NullPointerException e){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
			return ;
		}
	}

}
