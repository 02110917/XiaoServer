package com.flying.xiao.test;

import java.util.List;

import com.flying.xiao.bean.ErShou;
import com.flying.xiao.dao.ErShouDAO;
import com.flying.xiao.dao.ErShouDaoImpl;

public class TestEs
{
public static void main(String []args){
	ErShouDAO dao=new ErShouDaoImpl();
//	List<ErShou> lists= dao.findAll();
//	for(ErShou es: lists){
//		System.out.println(es.getEsTitle());
//	}
//	List<ErShou> lists= dao.findAll(3, 8);
//	for(ErShou es: lists){
//		System.out.println(es.getEsTitle());
//	}
//	List<ErShou> lists= dao.findByHot(3, 8);
//	for(ErShou es: lists){
//		System.out.println(es.getEsTitle()+"  "+es.getEsHot());
//	}
	
	List<ErShou> lists= dao.findByNew(3, 8);
	for(ErShou es: lists){
//		System.out.println(es.getEsTitle()+"  "+es.getEsPubTime().toLocaleString());
	}
}
}
