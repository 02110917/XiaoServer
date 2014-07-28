package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.bean.ErShouGoodsType;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.entity.XGoodType;
import com.google.gson.Gson;

public class GetMarketType extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		BaseHibernateDAO<ErShouGoodsType> dao=new BaseHibernateDAO<ErShouGoodsType>();
		List<ErShouGoodsType>types=dao.findByHql("from ErShouGoodsType");
		List<XGoodType> xtypes=new ArrayList<XGoodType>();
		for(ErShouGoodsType type:types){
			XGoodType xtype=new XGoodType();
			xtype.copy(type);
			xtypes.add(xtype);
		}
		Gson gson=new Gson();
		out.write(gson.toJson(xtypes));
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException
	{

		this.doGet(request, response);
	}

}
