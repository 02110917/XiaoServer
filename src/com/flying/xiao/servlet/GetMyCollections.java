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

import com.flying.xiao.bean.Collection;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.constant.Constant;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.entity.XCollection;
import com.flying.xiao.entity.XContent;
import com.google.gson.Gson;

/**
 * 获取我的收藏列表
 * @author zhangmin
 *
 */
@WebServlet("/servlet/GetMyCollections")
public class GetMyCollections extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		PrintWriter pw = response.getWriter();
		UserInfo userSession = (UserInfo) request.getSession().getAttribute("user");
		if(userSession==null){
			printErrorMsg(Constant.ErrorCode.USER_NOT_LOGIN, "用户未登陆...", pw);
			return ;
		}

		doOperate(userSession,pw);
	}

	private void doOperate(UserInfo user,PrintWriter pw){
		IBaseHibernateDAO<Collection> cc_dao=new BaseHibernateDAO<Collection>();
		List<Collection> cclist=cc_dao.findByHql("From Collection cc where cc.userInfo.id="+user.getId());
		if(cclist==null||cclist.size()==0){
			printErrorMsg(Constant.ErrorCode.GET_COLLECTION_ERROR,"没有数据...", pw);
			return ;
		}
		List<XCollection> xcclist=new ArrayList<XCollection>();
		for(Collection cc:cclist){
			XCollection xcc=new XCollection() ;
			xcc.setId(cc.getId());
			XContent xcon=new XContent();
			xcon.copy(cc.getContent());
			xcon.setUserId(cc.getContent().getUserInfo().getId());
			if (xcon.getConImageUrl() == null)
				xcon.setConImageUrl(cc.getContent().getUserInfo().getUserHeadImageUrl());
			xcon.setUserRealNama(cc.getContent().getUserInfo().getUserRealName());
			xcc.setContent(xcon);
			xcclist.add(xcc);
		}
		Gson gson=new Gson();
		pw.write(gson.toJson(xcclist));
		pw.flush();
		pw.close();
	}

}
