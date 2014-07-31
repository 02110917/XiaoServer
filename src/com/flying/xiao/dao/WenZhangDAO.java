package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.WenZhang;

public interface WenZhangDAO extends IBaseHibernateDAO<WenZhang>
{
	public static String USER_ID="id";
	List<WenZhang> findAll(int firstResult,int size) ;
	public List<WenZhang> findByHot(int firstResult,int size);
	public List<WenZhang> findByNew(int firstResult,int size);
}
