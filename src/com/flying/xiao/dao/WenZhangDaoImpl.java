package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.WenZhang;

public class WenZhangDaoImpl extends BaseHibernateDAO<WenZhang> implements WenZhangDAO 
{

	@Override
	public List<WenZhang> findAll(int firstResult, int size)
	{
		return super.findAll(firstResult, size);
	}

	@Override
	public List<WenZhang> findByHot(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "wzHot");
	}

	@Override
	public List<WenZhang> findByNew(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "wzPubTime");
	}

}
