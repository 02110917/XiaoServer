package com.flying.xiao.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.Praise;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.UsersDaoImpl;
import com.flying.xiao.entity.XPraise;
import com.flying.xiao.entity.XUserInfo;

public class PraiseOperate extends BaseServlet
{


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		super.doGet(request, response);
		String contentIdStr = request.getParameter("contentid");
		String userIdStr = request.getParameter("userId");
		String isCancelStr=request.getParameter("isCancel");
		XPraise base=new XPraise();
		if (userSession== null)
		{
			base.setErrorCode(Constant.ErrorCode.USER_NOT_LOGIN);
			base.setErrorMsg("未登陆，请重新登陆...");
		} else
		{
			if (contentIdStr != null && userIdStr != null && isCancelStr != null)
			{
				try
				{
					long contentId = Long.parseLong(contentIdStr);
					long userId = Long.parseLong(userIdStr);
					boolean isCancel=Boolean.parseBoolean(isCancelStr);
					ContentDAO dao = new ContentDaoImpl();
					Content con=dao.findById(contentId);
					if(con==null){
						base.setErrorCode(Constant.ErrorCode.PRAISE_OPERATE_ERROR);
						base.setErrorMsg("操作失败,还没找到该内容，可能是已被删除...");
					}
					else{
						UserInfo user=new UsersDaoImpl().findById(userId);
						IBaseHibernateDAO<Praise> praise_dao=new BaseHibernateDAO<Praise>();
						boolean result=true ;
						if(isCancel){
							Praise praise=praise_dao.findByHql("from Praise p where p.userInfo.id="+userId).get(0);
							result=praise_dao.delete(praise);
						}
						else{
							Praise praise=new Praise();
							praise.setContent(con);
							praise.setUserInfo(user);
							praise.setTime(new Timestamp(System.currentTimeMillis()));
							result=praise_dao.save(praise);
							base.copy(praise);
							XUserInfo xu=new XUserInfo();
							xu.copy(user);
							base.setUserInfo(xu);
							base.setContentId(contentId);
						}
						if (!result)
						{
							base.setErrorCode(Constant.ErrorCode.PRAISE_OPERATE_ERROR);
							base.setErrorMsg("操作失败...");
						}
					}
					
					
				} catch (NumberFormatException e)
				{
					e.printStackTrace();
					base.setErrorCode(Constant.ErrorCode.PARAM_ERROR);
					base.setErrorMsg("参数错误!!");
				}
			} else
			{
				base.setErrorCode(Constant.ErrorCode.PARAM_ERROR);
				base.setErrorMsg("参数错误!!");
			}
		}
		pw.write(base.toJson());
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
