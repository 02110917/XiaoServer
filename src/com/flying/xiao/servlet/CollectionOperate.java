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
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "�û�δ��½...", pw);
			return ;
		}
		String contentIdStr=request.getParameter("contentid") ;
		String isCalcel=request.getParameter("isCancel");
		if(contentIdStr==null)
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "��������...", pw);
			return ;
		}
		try{
			long contentid=Long.parseLong(contentIdStr);
			doOperate(contentid,userSession,isCalcel,pw);
		}catch(NumberFormatException e){
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "��������...", pw);
			return ;
		}
	}		
	
	private void doOperate(long id,UserInfo user,String isCalcel,PrintWriter pw){
		ContentDAO dao=new ContentDaoImpl();
		Content con=dao.findById(id); 
		if(con==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "��������...", pw);
			return ;
		}
		IBaseHibernateDAO<Collection> cc_dao=new BaseHibernateDAO<Collection>();
		Collection collection=findCollection(cc_dao,user.getId(),id);
		boolean save=false ;
		if(isCalcel==null||isCalcel.equals("false")){ //����ղ�
			if(collection!=null){
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "����ղس���...���Ѿ��ղ��˸����ݣ������ٴ��ղ�", pw);
				return ;
			}else
			{
			collection=new Collection() ;
			collection.setContent(con);
			collection.setUserInfo(user);
			save=cc_dao.save(collection);
			}
		}else{ //ȡ���ղ�
			if(collection==null){
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "ȡ���ղس���...����δ�ղظ����£�����ȡ��", pw);
				return ;
			}
			save=cc_dao.delete(collection);
		}
		if(save)
			printSuccessMsg(pw);
		else
			printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "��������...", pw);
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
