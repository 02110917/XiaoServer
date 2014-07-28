package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.ErShou;

public class ErShouDaoImpl extends BaseHibernateDAO<ErShou> implements ErShouDAO 
{

	@Override
	public List<ErShou> findAll(int firstResult, int size)
	{
		return super.findAll(firstResult, size);
	}

	@Override
	public List<ErShou> findByHot(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "esHot");
	}

	@Override
	public List<ErShou> findByNew(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "esPubTime");
	}

}
