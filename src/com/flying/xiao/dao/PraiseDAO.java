package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.Praise;

public interface PraiseDAO
{
	List<Praise> findByContentId(long id) ;
	public boolean save(Praise praise);
}
