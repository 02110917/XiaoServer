package com.flying.xiao.entity;

import java.sql.Timestamp;

public class XPraise extends Base
{
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public XUserInfo getUserInfo()
	{
		return userInfo;
	}
	public void setUserInfo(XUserInfo userInfo)
	{
		this.userInfo = userInfo;
	}
	public Long getContentId()
	{
		return contentId;
	}
	public void setContentId(Long contentId)
	{
		this.contentId = contentId;
	}
	public Timestamp getTime()
	{
		return time;
	}
	public void setTime(Timestamp time)
	{
		this.time = time;
	}
	private Long id;
	private XUserInfo userInfo;
	private Long contentId;
	private Timestamp time;
}
