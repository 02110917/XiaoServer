package com.flying.xiao.bean;

import java.sql.Timestamp;

/**
 * Lost entity. @author MyEclipse Persistence Tools
 */

public class Lost implements java.io.Serializable
{

	// Fields

	private Long id;
	private Content content;
	private Boolean lostType;
	private String lostInfo;
	private String lostPlace;
	private String lostPhone;
	private String lostName;
	private Timestamp lostTime;

	// Constructors

	/** default constructor */
	public Lost()
	{
	}

	/** minimal constructor */
	public Lost(Long id)
	{
		this.id = id;
	}

	/** full constructor */
	public Lost(Long id, Content content, Boolean lostType, String lostInfo, String lostPlace,
			Timestamp lostTime)
	{
		this.id = id;
		this.content = content;
		this.lostType = lostType;
		this.lostInfo = lostInfo;
		this.lostPlace = lostPlace;
		this.lostTime = lostTime;
	}

	// Property accessors

	public Long getId()
	{
		return this.id;
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

	public Content getContent()
	{
		return this.content;
	}

	public void setContent(Content content)
	{
		this.content = content;
	}

	public Boolean getLostType()
	{
		return this.lostType;
	}

	public void setLostType(Boolean lostType)
	{
		this.lostType = lostType;
	}

	public String getLostInfo()
	{
		return this.lostInfo;
	}

	public void setLostInfo(String lostInfo)
	{
		this.lostInfo = lostInfo;
	}

	public String getLostPlace()
	{
		return this.lostPlace;
	}

	public void setLostPlace(String lostPlace)
	{
		this.lostPlace = lostPlace;
	}

	public Timestamp getLostTime()
	{
		return this.lostTime;
	}

	public void setLostTime(Timestamp lostTime)
	{
		this.lostTime = lostTime;
	}

}