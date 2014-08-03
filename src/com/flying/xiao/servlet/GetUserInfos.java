package com.flying.xiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Friend;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.UsersDao;
import com.flying.xiao.dao.UsersDaoImpl;
import com.flying.xiao.entity.XUserInfo;
import com.google.gson.Gson;

/**
 * 获取用户列表
 * 
 * @author zhangmin
 *
 */
@WebServlet(description = "获取用户列表", urlPatterns =
{ "/servlet/GetUserInfos" })
public class GetUserInfos extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		super.doGet(request, response);
		String t = request.getParameter("type");
		String p = request.getParameter("page");
		if (t == null || t.equals(""))
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
			return;
		}
		try
		{
			int type = Integer.parseInt(t);
			int page = (p == null ? 0 : Integer.parseInt(p));
			UsersDao userDao = new UsersDaoImpl();
			List<UserInfo> users = userDao.findByType(type, Constant.MAX_PAGE_COUNT * page,
					Constant.MAX_PAGE_COUNT);
			if (users == null)
			{
				printErrorMsg(Constant.ErrorCode.GET_USERINFOS_ERROR, "获取UserInfo出错", pw);
				return;
			}
			List<XUserInfo> xusers = new ArrayList<XUserInfo>();
			for (UserInfo user : users)
			{
				XUserInfo xuser = new XUserInfo();
				xuser.copy(user);
				if (userSession != null)
				{
					IBaseHibernateDAO<Friend> friend_dao = new BaseHibernateDAO<Friend>();
					Friend friend = friend_dao
							.findOneByHql("from Friend f where f.userInfoByUserFriendBelongUserId.id="
									+ userSession.getId() + " and f.userInfoByUserId.id=" + user.getId());
					if (friend != null)
					{
						xuser.setMeFriend(true);
					} else
					{
						xuser.setMeFriend(false);
					}
				} else
				{
					xuser.setMeFriend(false);
				}
				xusers.add(xuser);
			}
			Gson gson=new Gson();
			System.out.println("json:"+gson.toJson(xusers));
			pw.write(gson.toJson(xusers));
			pw.flush();
			pw.close();
		} catch (NumberFormatException e)
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
			return;
		}
	}

}
