package com.flying.xiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.UsersDao;
import com.flying.xiao.dao.UsersDaoImpl;
import com.flying.xiao.entity.XUserInfo;

public class UserServlet extends BaseServlet
{
	private UsersDao userDao=new UsersDaoImpl() ;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		super.doGet(request, response);
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
					if(user!=null) //登陆成功
					{
						xUser.copy(user);
						request.getSession().setAttribute("user", user);
					}
					else //登陆失败
					{
						xUser.setErrorCode(Constant.ErrorCode.USER_LOGIN_ERROR);
						xUser.setErrorMsg("用户登陆失败");
					}
				}
				else{
					xUser.setErrorCode(Constant.ErrorCode.USER_LOGIN_ERROR);
					xUser.setErrorMsg("用户登陆失败_用户名密码输入不完整.");
				}
				String jsonStr=xUser.toJson();
//				XUserInfo x=new XUserInfo();
//				x=(XUserInfo) x.jsonToBase(jsonStr);
//				System.out.println(x.getUserEmail());
				pw.print(xUser.toJson());
				pw.flush();
				pw.close();
			}
			else if(type.equals("regist")){//用户注册
				String userInfoJson=request.getParameter("userinfo");
				if(userInfoJson==null){
					printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
					return ;
				}
				XUserInfo xuser=new XUserInfo();
				xuser=(XUserInfo) xuser.jsonToBase(userInfoJson);
				UsersDao userDao=new UsersDaoImpl() ;
				UserInfo userInfo=new UserInfo();
				xuser.copyToHibernateBean(userInfo);
				boolean save=userDao.save(userInfo);
				if(save){
					request.getSession().setAttribute("user", userInfo);
					pw.write(xuser.toJson());
					pw.flush();
					pw.close();
				}
				else{
					printErrorMsg(Constant.ErrorCode.USER_REGIEST_ERROR, "注册失败", pw);
				}
			}
		}		
		
	}

}
