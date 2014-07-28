package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.Content;

public class ContentDaoImpl extends BaseHibernateDAO<Content> implements ContentDAO 
{
	@Override
	public List<Content> findAll(int firstResult, int size)
	{
		return super.findAll(firstResult, size);
	}

	@Override
	public List<Content> findByHot(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "conHot");
	}

	@Override
	public List<Content> findByNew(int firstResult, int size)
	{
		return super.findAllDesc(firstResult, size, "conPubTime");
	}
	
	@Override
	public List<Content> findByTypeId(int conTypeId, int firstResult, int size)
	{
		// TODO Auto-generated method stub
		return super.findByPropertyAndDesc("conTypeId", conTypeId, firstResult, size, "conPubTime");
	}

	@Override
	public List<Content> findByWzTypeId(int wzTypeId, int firstResult, int size)
	{
		String hql="select con from Content con inner join con.wenZhangs wz where wz.wenZhangType.wzTypeId="+wzTypeId;
		return super.findByHql(hql, firstResult, size);
	}

	@Override
	public Content findById(long id)
	{
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public boolean update(Content instance)
	{
		return super.update(instance);
	}

}
