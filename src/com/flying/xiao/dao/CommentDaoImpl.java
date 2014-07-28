package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.PingLun;

public class CommentDaoImpl extends BaseHibernateDAO<PingLun> implements CommentDAO
{
	public List<PingLun> findAll(int firstResult, int size)
	{
		return super.findAll(firstResult, size);
	}

	public PingLun findById(long id)
	{
		return super.findById(id);
	}

	public PingLun findOneByExample(PingLun pl)
	{
		List<PingLun> list= super.findByExample(pl);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public boolean save(PingLun pl)
	{
		return super.save(pl);
	}

	public boolean update(PingLun pl)
	{
		return super.update(pl);
	}

}
