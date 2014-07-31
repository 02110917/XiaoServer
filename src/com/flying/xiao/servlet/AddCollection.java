package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Collection;
import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;

/**
 * Servlet implementation class addCollection
 */
@WebServlet("/servlet/AddCollection")
public class AddCollection extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		PrintWriter pw = response.getWriter();
		UserInfo userSession = (UserInfo) request.getSession().getAttribute("user");
		if(userSession==null){
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return ;
		}
		String contentIdStr=request.getParameter("contentid") ;
		if(contentIdStr==null)
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
		try{
			long contentid=Long.parseLong(contentIdStr);
			doOperate(contentid,userSession,pw);
		}catch(NumberFormatException e){
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
	}		
	
	private void doOperate(long id,UserInfo user,PrintWriter pw){
		ContentDAO dao=new ContentDaoImpl();
		Content con=dao.findById(id); 
		if(con==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
		Collection collection=new Collection() ;
		collection.setContent(con);
		collection.setUserInfo(user);
		IBaseHibernateDAO<Collection> cc_dao=new BaseHibernateDAO<Collection>();
		boolean save=cc_dao.save(collection);
		if(save)
			printSuccessMsg(pw);
		else
			printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "保存出错...", pw);
	}
}
