package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;

/**
 * 获取我发布的文章内容
 * 
 * @author zhangmin
 *
 */
@WebServlet("/servlet/GetMyPubContent")
public class GetMyPubContent extends BaseServlet {
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

	private void doOperate(UserInfo userSession, PrintWriter pw) {

	}

}
