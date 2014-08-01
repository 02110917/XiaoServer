package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.ErShou;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.WenZhang;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.CommentDaoImpl;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.entity.XComment;
import com.flying.xiao.entity.XContentDetail;
import com.flying.xiao.entity.XGoodType;
import com.flying.xiao.entity.XMarketDetail;
import com.flying.xiao.entity.XMarketType;
import com.flying.xiao.entity.XUserInfo;

public class GetContentDetail extends BaseServlet
{
	private ContentDAO conDao = new ContentDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{
//		response.setContentType("text/json;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
		super.doGet(request, response);
		try
		{
			long id = Long.parseLong(request.getParameter("id"));
			String type = request.getParameter("type");
			if(type==null){
				printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
				return ;
			}
			doOperator(pw,id,type);
			
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数错误...", pw);
		}

	}

	/**
	 * 根据id 返回文章内容
	 * @param pw
	 * @param id
	 */
	private void doOperator(PrintWriter pw, long id,String type)
	{
		if (type.equalsIgnoreCase(Constant.ContentType.CONTENT_TYPE_ASK + "")
				|| type.equalsIgnoreCase(Constant.ContentType.CONTENT_TYPE_NEWS + ""))
		{
			 XContentDetail xcon=new XContentDetail();
			 IBaseHibernateDAO<WenZhang> dao=new BaseHibernateDAO<WenZhang>();
			 List<WenZhang> lists=dao.findByHql("from WenZhang wz where wz.content.id="+id);
			 if(lists!=null&&lists.size()>0){
				 ContentDAO contentDao=new ContentDaoImpl();
				 Content c=contentDao.findById(id);
				 c.setConHot(c.getConHot()+1);
				 contentDao.update(c);
				 xcon.setId(id);
				 xcon.setContentInfo(lists.get(0).getWzInfo());
				 IBaseHibernateDAO<PingLun> dao_pl=new CommentDaoImpl();
				 List<PingLun> pls=dao_pl.findByHql("from PingLun pl where pl.content.id="+id);
				 List<XComment> comments=new ArrayList<XComment>();
				 for(PingLun pl:pls){
					XComment com=new XComment();
					com.copy(pl);
					com.setContentId(id);
					XUserInfo user=new XUserInfo() ;
					user.copy(pl.getUserInfo());
					com.setXuserInfo(user);
					if(pl.getPingLun()!=null)
					{
						com.setReplyCommentId(pl.getPingLun().getPlId());
					}
					comments.add(com);
				 }
				 xcon.setComments(comments);
				 
			 }
			 else{
				 xcon.setErrorCode(Constant.ErrorCode.GET_CONTENT_DETAIL_NO_CONTENT);
				 xcon.setErrorMsg("没有该项目,可能已被删除");
			 }
			pw.write(xcon.toJson());
		} else if (type.equalsIgnoreCase(Constant.ContentType.CONTENT_TYPE_LOST + ""))
		{

		} else if (type.equalsIgnoreCase(Constant.ContentType.CONTENT_TYPE_MARKET + ""))
		{
			XMarketDetail xMarket=new XMarketDetail() ;
			IBaseHibernateDAO<ErShou> es_dao=new BaseHibernateDAO<ErShou>();
			List<ErShou> markets=es_dao.findByHql("from ErShou es where es.content.id="+id);
			if(markets==null||markets.size()<=0){
				xMarket.setErrorCode(Constant.ErrorCode.GET_MARKET_DETAIL_NO_MARKET);
				xMarket.setErrorMsg("没有该项目,可能已被删除");
			}else{
				ErShou market=markets.get(0);
				xMarket.copy(market);
				XMarketType marketType=new XMarketType();
				marketType.copy(market.getErShouType());
				xMarket.setErShouType(marketType);
				XGoodType goodType=new XGoodType();
				goodType.copy(market.getErShouGoodsType());
				xMarket.setErShouGoodsType(goodType);
				xMarket.setContentId(id);
//				IBaseHibernateDAO<Image> image_dao=new BaseHibernateDAO<Image>();
//				List<Image> images= image_dao.findByHql("from Image image where image.content.id="+id);
//				List<XImage> ximages=new ArrayList<XImage>();
//				if(images!=null&&images.size()>0){
//					for(Image image:images){
//						XImage ximage=new XImage();
//						ximage.copy(image);
//						ximage.setContentId(id);
//						ximages.add(ximage);
//					}
//				}
//				xMarket.setImages(ximages);
			}
			pw.write(xMarket.toJson());
		} else if (type.equalsIgnoreCase("market"))
		{
		}
		pw.flush();
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
