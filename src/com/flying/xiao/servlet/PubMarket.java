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
import com.flying.xiao.bean.ErShou;
import com.flying.xiao.bean.ErShouGoodsType;
import com.flying.xiao.bean.ErShouType;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.ErShouDAO;
import com.flying.xiao.dao.ErShouDaoImpl;
import com.flying.xiao.entity.XContent;
import com.flying.xiao.entity.XGoodType;
import com.flying.xiao.entity.XMarketDetail;
import com.flying.xiao.entity.XMarketType;
import com.google.gson.JsonSyntaxException;

/**
 * Servlet implementation class PubMarket
 */
@WebServlet("/servlet/PubMarket")
public class PubMarket extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String contentJson = request.getParameter("content");
		if (userSession == null) {
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return;
		}
		if (contentJson == null) {
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数出错...", pw);
			return;
		}
		doOperate(contentJson,userSession, pw);
	}

	private void doOperate(String json,UserInfo user, PrintWriter pw) {
		XMarketDetail xmarketDetail=new XMarketDetail() ;
		try
		{
			xmarketDetail=(XMarketDetail) xmarketDetail.jsonToBase(json);
			ErShou ershou=new ErShou() ;
			xmarketDetail.copyToHibernateBean(ershou);
			XContent xcon=xmarketDetail.getContent() ;
			Content con=new Content();
			xcon.copyToHibernateBean(con);
			con.setUserInfo(user);
			con.setConPubTime(new Timestamp(System.currentTimeMillis()));
			ershou.setContent(con);
			XMarketType xmarkeType=xmarketDetail.getErShouType() ;
			ErShouType esType=new ErShouType() ;
			xmarkeType.copyToHibernateBean(esType);
			ershou.setErShouType(esType);
			XGoodType xgoodType=xmarketDetail.getErShouGoodsType() ;
			ErShouGoodsType esgoodType=new ErShouGoodsType() ;
			xgoodType.copyToHibernateBean(esgoodType);
			ershou.setErShouGoodsType(esgoodType);
			ErShouDAO dao=new ErShouDaoImpl() ;
			boolean save=dao.save(ershou);
			if(save)
				printSuccessMsg(pw);
			else
				printErrorMsg(Constant.ErrorCode.SAVE_CONTENT_ERROR, "保存出错...", pw);
		}catch(JsonSyntaxException e){
			e.printStackTrace();
			printErrorMsg(Constant.ErrorCode.PARAM_ERROR, "参数有错...", pw);
		}
	}

}
