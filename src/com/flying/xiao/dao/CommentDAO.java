package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.PingLun;

public interface CommentDAO
{
	List<PingLun> findAll(int firstResult,int size) ;
	public PingLun findById(long id);
	public PingLun findOneByExample(PingLun pl);
	public boolean save(PingLun pl);
	public boolean  update(PingLun pl);
}
