package com.flying.xiao.entity;

import java.sql.Timestamp;

public class XLostDetail extends Base
{
	private static final long serialVersionUID = 1L;
	private Long id;
	private XContent content;
	private Boolean lostType;
	private String lostInfo;
	private String lostPlace;
	private String lostPhone;
	private String lostName;
	private Timestamp lostTime;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getLostPhone()
	{
		return lostPhone;
	}
	public void setLostPhone(String lostPhone)
	{
		this.lostPhone = lostPhone;
	}
	public String getLostName()
	{
		return lostName;
	}
	public void setLostName(String lostName)
	{
		this.lostName = lostName;
	}
	public XContent getContent()
	{
		return content;
	}
	public void setContent(XContent content)
	{
		this.content = content;
	}
	public Boolean getLostType()
	{
		return lostType;
	}
	public void setLostType(Boolean lostType)
	{
		this.lostType = lostType;
	}
	public String getLostInfo()
	{
		return lostInfo;
	}
	public void setLostInfo(String lostInfo)
	{
		this.lostInfo = lostInfo;
	}
	public String getLostPlace()
	{
		return lostPlace;
	}
	public void setLostPlace(String lostPlace)
	{
		this.lostPlace = lostPlace;
	}
	public Timestamp getLostTime()
	{
		return lostTime;
	}
	public void setLostTime(Timestamp lostTime)
	{
		this.lostTime = lostTime;
	}
	
}
