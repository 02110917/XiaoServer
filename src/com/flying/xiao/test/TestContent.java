package com.flying.xiao.test;

import java.util.List;

import com.flying.xiao.bean.Content;
import com.flying.xiao.dao.ContentDAO;
import com.flying.xiao.dao.ContentDaoImpl;

public class TestContent
{
public static void main(String []args){
	ContentDAO dao=new ContentDaoImpl();
	List<Content> lists= dao.findByWzTypeId(1, 0, 10);
	for(Content con:lists){
		System.out.println(con.getConTitle());
	}
	
}
}
