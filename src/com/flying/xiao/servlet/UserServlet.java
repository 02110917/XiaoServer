package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.UsersDao;
import com.flying.xiao.dao.UsersDaoImpl;
import com.flying.xiao.entity.XUserInfo;

public class UserServlet extends HttpServlet
{
	private UsersDao userDao=new UsersDaoImpl() ;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if (type != null)
		{
			if (type.equals("login"))
			{
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				XUserInfo xUser=new XUserInfo() ;
				if (username != null && password != null)
				{
					UserInfo user=userDao.findByUserNameAndPassword(username, password);
					if(user!=null) //��½�ɹ�
					{
						xUser.copy(user);
						request.getSession().setAttribute("user", user);
					}
					else //��½ʧ��
					{
						xUser.setErrorCode(Constant.ErrorCode.USER_LOGIN_ERROR);
						xUser.setErrorMsg("�û���½ʧ��");
					}
				}
				else{
					xUser.setErrorCode(Constant.ErrorCode.USER_LOGIN_ERROR);
					xUser.setErrorMsg("�û���½ʧ��_�û����������벻����.");
				}
				String jsonStr=xUser.toJson();
//				XUserInfo x=new XUserInfo();
//				x=(XUserInfo) x.jsonToBase(jsonStr);
//				System.out.println(x.getUserEmail());
				out.print(xUser.toJson());
				out.flush();
				out.close();
			}
			else if(type.equals("regist")){//�û�ע��
				
			}
		}		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
