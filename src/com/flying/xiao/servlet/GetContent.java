package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.Praise;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.CommentDaoImpl;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.PraiseDAO;
import com.flying.xiao.dao.PraiseDaoImpl;
import com.flying.xiao.entity.XComment;
import com.flying.xiao.entity.XContent;
import com.flying.xiao.entity.XPraise;
import com.flying.xiao.entity.XUserInfo;
import com.google.gson.Gson;

public class GetContent extends HttpServlet
{
	private ContentDAO conDao = new ContentDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		if (type != null)
		{
			String p = request.getParameter("page");
			int page = (p == null ? 0 : Integer.parseInt(request.getParameter("page")));
			PrintWriter pw = response.getWriter();
			if (type.equalsIgnoreCase("news"))
			{
				doOperator(pw, Constant.ContentType.CONTENT_TYPE_NEWS, page);

			} else if (type.equalsIgnoreCase("lost"))
			{
				doOperator(pw, Constant.ContentType.CONTENT_TYPE_LOST, page);

			} else if (type.equalsIgnoreCase("diary"))
			{
				doOperator(pw, Constant.ContentType.CONTENT_TYPE_DIARY, page);
			} else if (type.equalsIgnoreCase("market"))
			{
				doOperator(pw, Constant.ContentType.CONTENT_TYPE_MARKET, page);
			} else if (type.equalsIgnoreCase("ask"))
			{
				doOperator(pw, Constant.ContentType.CONTENT_TYPE_ASK, page);
			}
		}
	}

	/**
	 * 根据请求参数 返回结果
	 * 
	 * @param pw
	 * @param type
	 * @param page
	 */
	private void doOperator(PrintWriter pw, int type, int page)
	{
		List<Content> conList = conDao.findByTypeId(type, 20 * page, 20);
		List<XContent> xConList = new ArrayList<XContent>();
		for (Content con : conList)
		{
			XContent xcon = new XContent();
			xcon.copy(con);
			xcon.setUserId(con.getUserInfo().getId());
			if (xcon.getConImageUrl() == null)
				xcon.setConImageUrl(con.getUserInfo().getUserHeadImageUrl());
			xcon.setUserRealNama(con.getUserInfo().getUserRealName());
			if (type == Constant.ContentType.CONTENT_TYPE_DIARY)
			{// 如果是获取新鲜事 把评论信息也返回
				IBaseHibernateDAO<PingLun> dao_pl = new CommentDaoImpl();
				List<PingLun> pls = dao_pl.findByHql("from PingLun pl where pl.content.id=" + xcon.getId());
				List<XComment> comments = new ArrayList<XComment>();
				for (PingLun pl : pls)
				{
					XComment com = new XComment();
					com.copy(pl);
					com.setContentId(xcon.getId());
					XUserInfo user = new XUserInfo();
					user.copy(pl.getUserInfo());
					com.setXuserInfo(user);
					if (pl.getPingLun() != null)
					{
						com.setReplyCommentId(pl.getPingLun().getPlId());
					}
					comments.add(com);
				}
				xcon.setComments(comments);
				PraiseDAO praiseDao = new PraiseDaoImpl();
				List<Praise> praises = praiseDao.findByContentId(xcon.getId());
				if (praises != null && praises.size() > 0)
				{
					List<XPraise> xpraises = new ArrayList<XPraise>();
					for (Praise p : praises)
					{
						XPraise xp = new XPraise();
						xp.copy(p);
						xp.setContentId(xcon.getId());
						XUserInfo user = new XUserInfo();
						user.copy(p.getUserInfo());
						xp.setUserInfo(user);
						xpraises.add(xp);
					}
					xcon.setPraiseList(xpraises);
				}

			} 
			xConList.add(xcon);
		}
		Gson gson = new Gson();
		String json = gson.toJson(xConList);
		pw.write(json);
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
