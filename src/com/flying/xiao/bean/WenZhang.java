package com.flying.xiao.bean;

/**
 * WenZhang entity. @author MyEclipse Persistence Tools
 */

public class WenZhang implements java.io.Serializable
{

	// Fields

	private Long wzId;
	private WenZhangType wenZhangType;
	private Content content;
	private String wzInfo;

	// Constructors

	/** default constructor */
	public WenZhang()
	{
	}

	/** minimal constructor */
	public WenZhang(Long wzId)
	{
		this.wzId = wzId;
	}

	/** full constructor */
	public WenZhang(Long wzId, WenZhangType wenZhangType, Content content, String wzInfo)
	{
		this.wzId = wzId;
		this.wenZhangType = wenZhangType;
		this.content = content;
		this.wzInfo = wzInfo;
	}

	// Property accessors

	public Long getWzId()
	{
		return this.wzId;
	}

	public void setWzId(Long wzId)
	{
		this.wzId = wzId;
	}

	public WenZhangType getWenZhangType()
	{
		return this.wenZhangType;
	}

	public void setWenZhangType(WenZhangType wenZhangType)
	{
		this.wenZhangType = wenZhangType;
	}

	public Content getContent()
	{
		return this.content;
	}

	public void setContent(Content content)
	{
		this.content = content;
	}

	public String getWzInfo()
	{
		return this.wzInfo;
	}

	public void setWzInfo(String wzInfo)
	{
		this.wzInfo = wzInfo;
	}

}