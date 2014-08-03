package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.bean.WenZhang;
import com.flying.xiao.bean.WenZhangType;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.WenZhangDAO;
import com.flying.xiao.dao.WenZhangDaoImpl;
import com.flying.xiao.entity.Base;
import com.flying.xiao.entity.XContent;
import com.flying.xiao.entity.XContentDetail;
import com.flying.xiao.entity.XContentType;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class PubContent
 */
@WebServlet("/servlet/PubContent")
public class PubContent extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PubContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String contentJson=request.getParameter("content");
		if(userSession==null){
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return ;
		}
		if(/*typeStr==null||*/contentJson==null){
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR,"参数出错...",pw);
			return ;
		}
		doOperate(contentJson,userSession,pw);
	}

	private ContentDAO conDao=new ContentDaoImpl();
	private void doOperate(String json,UserInfo user,PrintWriter pw ){
		
			XContentDetail xconDetail=new XContentDetail();
			try
			{
				xconDetail=(XContentDetail) xconDetail.jsonToBase(json);
				WenZhang wz=new WenZhang();
				xconDetail.copyToHibernateBean(wz);
				Content con=new Content();
				XContent xcon=xconDetail.getContent();
				xcon.copyToHibernateBean(con);
				con.setConPubTime(new Timestamp(System.currentTimeMillis()));
				con.setUserInfo(user);
				//先保存content
				boolean save=conDao.add(con);
				if(!save){
					printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR,"保存出错...",pw);
					return ;
				}
				wz.setContent(con);
				XContentType contentType=xconDetail.getContentType() ;
				WenZhangType wz_type=new WenZhangType();
				contentType.copyToHibernateBean(wz_type);
//				IBaseHibernateDAO<WenZhangType> dao_type=new BaseHibernateDAO<WenZhangType>();
//				WenZhangType wz_type=(WenZhangType) dao_type.findByHql("from WenZhangType where wzTypeId="+type);
//				if(wz_type==null){
//					printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR,"保存出错...",pw);
//					return ;
//				}
				wz.setWenZhangType(wz_type);
				WenZhangDAO dao_wz=new WenZhangDaoImpl() ;
				save=dao_wz.save(wz);
				if(!save){
					printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR,"保存出错...",pw);
					return ;
				}
				printSuccessMsg(pw);
			}
			catch(JsonSyntaxException e){
				e.printStackTrace();
				printErrorMsg(Constant.ErrorCode.PARAM_ERROR,"参数出错...",pw);
			}
			
	}
	
	
}
