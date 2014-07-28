package com.flying.xiao.test;

import java.util.List;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.Praise;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.PraiseDAO;
import com.flying.xiao.dao.PraiseDaoImpl;

public class TestContentPraise
{
public static void main(String []args){
	PraiseDAO dao=new PraiseDaoImpl();
	List<Praise> lists= dao.findByContentId(23l);
	for(Praise con:lists){
		System.out.println(con.getUserInfo().getUserEmail());
	}
	
}
}
