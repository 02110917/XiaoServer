package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.flying.xiao.entity.XFriend;
import com.flying.xiao.entity.XUserInfo;
import com.google.gson.Gson;

/**
 * 获取我的好友列表
 * 
 * @author zhangmin
 *
 */
@WebServlet("/servlet/GetMyFriends")
public class GetMyFriends extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		PrintWriter pw = response.getWriter();
		UserInfo userSession = (UserInfo) request.getSession().getAttribute(
				"user");
		if (userSession == null) {
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return;
		}

		doOperate(userSession, pw);
	}

	private void doOperate(UserInfo user, PrintWriter pw) {
		IBaseHibernateDAO<Friend> friend_dao = new BaseHibernateDAO<Friend>();
		List<Friend> friendlist = friend_dao
				.findByHql("From Friend friend where friend.userInfoByUserId.id="
						+ user.getId());
		if (friendlist == null || friendlist.size() == 0) {
			printErrorMsg(Constant.ErrorCode.GET_COLLECTION_ERROR, "没有数据...",
					pw);
			return;
		}
		List<XFriend> xfriendlist = new ArrayList<XFriend>();
		for (Friend friend : friendlist) {
			XFriend xfr = new XFriend();
			xfr.setId(friend.getId());
			XUserInfo xuser = new XUserInfo();
			xuser.copy(friend.getUserInfoByUserFriendBelongUserId());
			xfr.setUserInfoByUserFriendBelongUserId(xuser);
			xfriendlist.add(xfr);
		}
		Gson gson = new Gson();
		pw.write(gson.toJson(xfriendlist));
		pw.flush();
		pw.close();
	}
}