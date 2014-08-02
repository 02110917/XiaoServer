package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/servlet/CollectionOperate")
public class CollectionOperate extends BaseServlet {
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
		String isCalcel=request.getParameter("isCancel");
		if(contentIdStr==null)
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
		try{
			long contentid=Long.parseLong(contentIdStr);
			doOperate(contentid,userSession,isCalcel,pw);
		}catch(NumberFormatException e){
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
	}		
	
	private void doOperate(long id,UserInfo user,String isCalcel,PrintWriter pw){
		ContentDAO dao=new ContentDaoImpl();
		Content con=dao.findById(id); 
		if(con==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
			return ;
		}
		IBaseHibernateDAO<Collection> cc_dao=new BaseHibernateDAO<Collection>();
		Collection collection=findCollection(cc_dao,user.getId(),id);
		boolean save=false ;
		if(isCalcel==null||isCalcel.equals("false")){ //添加收藏
			if(collection!=null){
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "添加收藏出错...您已经收藏了该内容，不能再次收藏", pw);
				return ;
			}else
			{
			collection=new Collection() ;
			collection.setContent(con);
			collection.setUserInfo(user);
			save=cc_dao.save(collection);
			}
		}else{ //取消收藏
			if(collection==null){
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "取消收藏出错...您还未收藏该文章，不能取消", pw);
				return ;
			}
			save=cc_dao.delete(collection);
		}
		if(save)
			printSuccessMsg(pw);
		else
			printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "操作出错...", pw);
	}

	private Collection findCollection(IBaseHibernateDAO<Collection> cc_dao,long userId,long contentId){
		Collection cc=null;
		List list=cc_dao.findByHql("from Collection as cc where cc.content.id="+contentId+" and cc.userInfo.id="+userId);
		if(list!=null&&list.size()>0){
			cc=(Collection) list.get(0);
		}
		return cc ;
	}
	
}
