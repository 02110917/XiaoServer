package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.Content;

public interface ContentDAO
{
	public static String USER_ID="id";
	List<Content> findAll(int firstResult,int size) ;
	public List<Content> findByHot(int firstResult,int size);
	public List<Content> findByNew(int firstResult,int size);
	public Content findById(long id);
	/**
	 * 根据内容类型ID 获取内容列表 
	 * @param conTypeId 1:资讯 2:失物 3:diary 4:二手市场 5:问答
	 * @param firstResult 开始查询的位置
	 * @param size  查询的条数
	 * @return
	 */
	public List<Content> findByTypeId(int conTypeId,int firstResult,int size);
	
	public List<Content> findByWzTypeId(int wzTypeId,int firstResult,int size);
	
	public boolean  update(Content content);
}
