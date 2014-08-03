package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Collection;
import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.ErShou;
import com.flying.xiao.bean.Image;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.Praise;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.CommentDaoImpl;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.PraiseDAO;
import com.flying.xiao.dao.PraiseDaoImpl;
import com.flying.xiao.entity.Base;
import com.flying.xiao.entity.XComment;
import com.flying.xiao.entity.XContent;
import com.flying.xiao.entity.XImage;
import com.flying.xiao.entity.XPraise;
import com.flying.xiao.entity.XUserInfo;
import com.google.gson.Gson;

public class GetContent extends BaseServlet
{
	private ContentDAO conDao = new ContentDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
		// response.setContentType("text/json;charset=UTF-8");
		// response.setCharacterEncoding("UTF-8");
		super.doGet(request, response);
		String type = request.getParameter("type");
		if (type != null)
		{
			String p = request.getParameter("page");
			int page = (p == null ? 0 : Integer.parseInt(request.getParameter("page")));
			try
			{
				doOperator(pw, userSession, Integer.parseInt(type), page);
			} catch (NumberFormatException e)
			{
				e.printStackTrace();
				printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误。。", pw);
			}
		} else
		{
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误", pw);
		}
	}

	/**
	 * 根据请求参数 返回结果
	 * 
	 * @param pw
	 * @param type
	 * @param page
	 */
	private void doOperator(PrintWriter pw, UserInfo userSession, int type, int page)
	{
		List<Content> conList = conDao.findByTypeId(type, Constant.MAX_PAGE_COUNT * page, Constant.MAX_PAGE_COUNT);
		List<XContent> xConList = new ArrayList<XContent>();
		if (conList == null || conList.size() <= 0)
		{
			Base base = new Base();
			base.setErrorCode(2);
			base.setErrorMsg("没有找到数据///");
			pw.write(base.toJson());
			pw.flush();
			pw.close();
		}
		for (Content con : conList)
		{
			XContent xcon = new XContent();
			xcon.copy(con);
			if (userSession != null)
			{ // 如果session不为null 返回isMeCollecte 、isMeIsPraise
				IBaseHibernateDAO<Collection> cc_dao = new BaseHibernateDAO<Collection>();
				if (type == Constant.ContentType.CONTENT_TYPE_ASK
						|| type == Constant.ContentType.CONTENT_TYPE_NEWS
						|| type == Constant.ContentType.CONTENT_TYPE_MARKET)
				{
					List list = cc_dao.findByHql("from Collection as cc where cc.content.id=" + con.getId()
							+ " and cc.userInfo.id=" + userSession.getId());
					if (list != null && list.size() > 0)
					{ // 已经收藏过
						xcon.setMeCollecte(true);
					} else
					{
						xcon.setMeCollecte(false);
					}
				}
				if (type == Constant.ContentType.CONTENT_TYPE_DIARY)
				{
					IBaseHibernateDAO<Praise> pr_dao = new BaseHibernateDAO<Praise>();
					List list = cc_dao.findByHql("from Praise as p where p.content.id=" + con.getId()
							+ " and p.userInfo.id=" + userSession.getId());
					if (list != null && list.size() > 0)
					{ // 已经赞过
						xcon.setMeIsPraise(true);
						// System.out.println("已经赞啦........");
					} else
					{
						xcon.setMeIsPraise(false);
					}
				}
			}
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

			} if (type == Constant.ContentType.CONTENT_TYPE_MARKET)
			{// 如果是获取市场信息 还需要返回价格
				IBaseHibernateDAO<ErShou> dao = new BaseHibernateDAO<ErShou>();
				ErShou es = dao.findByHql("from ErShou es where es.content.id=" + con.getId()).get(0);
				xcon.setPrice(es.getEsPrice());

			}
			if(type==Constant.ContentType.CONTENT_TYPE_LOST||type==Constant.ContentType.CONTENT_TYPE_MARKET){
				IBaseHibernateDAO<Image> image_dao = new BaseHibernateDAO<Image>();
				List<Image> images = image_dao.findByHql("from Image image where image.content.id="
						+ con.getId());
				List<XImage> ximages = new ArrayList<XImage>();
				if (images != null && images.size() > 0)
				{
					for (Image image : images)
					{
						XImage ximage = new XImage();
						ximage.copy(image);
						ximage.setContentId(con.getId());
						ximages.add(ximage);
					}
				}
				xcon.setImages(ximages);
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
