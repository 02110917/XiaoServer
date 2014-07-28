package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.Praise;

public class PraiseDaoImpl extends BaseHibernateDAO<Praise> implements PraiseDAO
{

	@Override
	public List<Praise> findByContentId(long id)
	{
		return super.findByProperty("content.id", id);
	}
	

}
