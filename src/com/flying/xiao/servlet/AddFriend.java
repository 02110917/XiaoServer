package com.flying.xiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.FREE_MEM;

import com.flying.xiao.bean.Friend;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.UsersDao;
import com.flying.xiao.dao.UsersDaoImpl;

/**
 * Servlet implementation class AddFriend
 */
@WebServlet(description = "�������", urlPatterns = { "/servlet/AddFriend" })
public class AddFriend extends BaseServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String userIdStr=request.getParameter("userId");
		if(userSession==null){
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "����δ��½..���½����", pw);
			return ;
		}
		if(userIdStr==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "��������", pw);
			return ;
		}
		try{
			long userId=Long.parseLong(userIdStr);
			UsersDao userDao=new UsersDaoImpl();
			UserInfo user=userDao.findById(userId);
			if(user==null){
				printErrorMsg(Constant.ErrorCode.USER_NOT_FOUNT, "δ�ҵ��û�", pw);
				return ;
			}
			IBaseHibernateDAO<Friend> friend_dao=new BaseHibernateDAO<Friend>();
			Friend f=friend_dao.findOneByHql("from Friend f where f.userInfoByUserId.id="+user.getId()+" and f.userInfoByUserFriendBelongUserId.id="+userSession.getId());
			if(f!=null){ //�Ѿ������
				printErrorMsg(Constant.ErrorCode.ADD_FRIEND_IS_YOUR_FRIEND_ALERADY, "���Ѿ������Ϊ������", pw);
				return ;
			}
			Friend friend=new Friend();
			friend.setUserInfoByUserId(user);
			friend.setUserInfoByUserFriendBelongUserId(userSession);
			boolean save=friend_dao.save(friend);
			if(!save){
				printErrorMsg(Constant.ErrorCode.SAVE_ERROR, "��ӳ���..", pw);
				return ;
			}
			printSuccessMsg(pw);
		}catch(NumberFormatException e){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "��������", pw);
			return ;
		}
	}



}
