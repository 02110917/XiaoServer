package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.entity.XContent;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class PubDiary
 */
@WebServlet("/servlet/PubDiary")
public class PubDiary extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String contentJson=request.getParameter("content") ;
		if(userSession==null){
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return ;
		}
		if(contentJson==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
		doOperate(contentJson,userSession,pw);
		
	}

	private void doOperate(String contentJson,UserInfo user,PrintWriter pw){
		XContent xcontent=new XContent() ;
		try
		{
			xcontent=(XContent) xcontent.jsonToBase(contentJson);
			Content content=new Content();
			xcontent.copyToHibernateBean(content);
			content.setUserInfo(user);
			content.setConPubTime(new Timestamp(System.currentTimeMillis()));
			ContentDAO dao=new ContentDaoImpl() ;
			boolean save=dao.add(content);
			if(!save)
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "保存数据出错...", pw);
			else
				printSuccessMsg(pw);
		}catch(JsonSyntaxException e){
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
	}
	

}
