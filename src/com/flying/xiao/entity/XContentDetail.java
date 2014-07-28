package com.flying.xiao.entity;

import java.util.List;

public class XContentDetail extends Base
{
	private long id ;
	private String contentInfo ;
	private List<XComment> comments ;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getContentInfo()
	{
		return contentInfo;
	}
	public void setContentInfo(String contentInfo)
	{
		this.contentInfo = contentInfo;
	}
	public List<XComment> getComments()
	{
		return comments;
	}
	public void setComments(List<XComment> comments)
	{
		this.comments = comments;
	}
}
