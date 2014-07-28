package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.CommentDAO;
import com.flying.xiao.dao.CommentDaoImpl;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.UsersDaoImpl;
import com.flying.xiao.entity.Base;
import com.flying.xiao.entity.XComment;
import com.flying.xiao.entity.XUserInfo;

public class PubComment extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		String contentIdStr = request.getParameter("contentid");
		String userIdStr = request.getParameter("userId");
		String commentInfo = request.getParameter("commentInfo");
		String replyIdStr=request.getParameter("replyId"); //回复评论编号
		UserInfo userSession = (UserInfo) request.getSession().getAttribute("user");
		XComment com = new XComment();
		if (userSession == null)
		{
			com.setErrorCode(Constant.ErrorCode.USER_NOT_LOGIN);
			com.setErrorMsg("未登陆，请重新登陆...");
		} else
		{
			if (contentIdStr != null && userIdStr != null && commentInfo != null)
			{
				try
				{
					long contentId = Long.parseLong(contentIdStr);
					long userId = Long.parseLong(userIdStr);
					long replyId=0;
					if(replyIdStr!=null){
						replyId=Long.parseLong(replyIdStr);
					}
					CommentDAO dao = new CommentDaoImpl();
					PingLun pl = new PingLun();
					pl.setPlInfo(commentInfo);
					PingLun plReply=dao.findById(replyId);
					if(plReply!=null)
						pl.setPingLun(plReply);
					Content con = new ContentDaoImpl().findById(contentId);
					pl.setContent(con);
					UserInfo user = new UsersDaoImpl().findById(userId);
					pl.setUserInfo(user);
					pl.setPlTime(new Timestamp(System.currentTimeMillis()));
					boolean result=dao.save(pl);
					if (!result)
					{
						com.setErrorCode(Constant.ErrorCode.PUB_COMMENT_ERROR);
						com.setErrorMsg("发布评论失败...");
					}else{
						com.copy(pl);
						com.setContentId(con.getId());
						XUserInfo userInfo=new XUserInfo() ;
						userInfo.copy(pl.getUserInfo());
						com.setXuserInfo(userInfo);
						if(pl.getPingLun()!=null)
						{
							com.setReplyCommentId(pl.getPingLun().getPlId());
						}
					}
				} catch (NumberFormatException e)
				{
					e.printStackTrace();
					com.setErrorCode(Constant.ErrorCode.PARAM_ERROR);
					com.setErrorMsg("参数错误!!");
				}
			} else
			{
				com.setErrorCode(Constant.ErrorCode.PARAM_ERROR);
				com.setErrorMsg("参数错误!!");
			}
		}
		pw.write(com.toJson());
		pw.flush();
		pw.close();
	}

	private boolean doSave(long contentId, long userId, String commentInfo)
	{
		IBaseHibernateDAO<PingLun> dao = new BaseHibernateDAO();
		PingLun pl = new PingLun();
		pl.setPlInfo(commentInfo);
		Content con = new ContentDaoImpl().findById(contentId);
		pl.setContent(con);
		UserInfo user = new UsersDaoImpl().findById(userId);
		pl.setUserInfo(user);
		pl.setPlTime(new Timestamp(System.currentTimeMillis()));
		return dao.save(pl);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
