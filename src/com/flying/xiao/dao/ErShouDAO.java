package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.ErShou;

public interface ErShouDAO extends IBaseHibernateDAO<ErShou>
{
	public static String USER_ID="id";
	List<ErShou> findAll(int firstResult,int size) ;
	public List<ErShou> findByHot(int firstResult,int size);
	public List<ErShou> findByNew(int firstResult,int size);
}
