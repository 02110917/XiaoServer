package com.flying.xiao.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * PingLun entity. @author MyEclipse Persistence Tools
 */

public class PingLun implements java.io.Serializable
{

	// Fields

	private Long plId;
	private Content content;
	private PingLun pingLun;
	private UserInfo userInfo;
	private String plInfo;
	private Timestamp plTime;
	private Set pingLuns = new HashSet(0);

	// Constructors

	/** default constructor */
	public PingLun()
	{
	}

	/** minimal constructor */
	public PingLun(Long plId)
	{
		this.plId = plId;
	}

	/** full constructor */
	public PingLun(Long plId, Content content, PingLun pingLun, UserInfo userInfo, String plInfo,
			Timestamp plTime, Set pingLuns)
	{
		this.plId = plId;
		this.content = content;
		this.pingLun = pingLun;
		this.userInfo = userInfo;
		this.plInfo = plInfo;
		this.plTime = plTime;
		this.pingLuns = pingLuns;
	}

	// Property accessors

	public Long getPlId()
	{
		return this.plId;
	}

	public void setPlId(Long plId)
	{
		this.plId = plId;
	}

	public Content getContent()
	{
		return this.content;
	}

	public void setContent(Content content)
	{
		this.content = content;
	}

	public PingLun getPingLun()
	{
		return this.pingLun;
	}

	public void setPingLun(PingLun pingLun)
	{
		this.pingLun = pingLun;
	}

	public UserInfo getUserInfo()
	{
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}

	public String getPlInfo()
	{
		return this.plInfo;
	}

	public void setPlInfo(String plInfo)
	{
		this.plInfo = plInfo;
	}

	public Timestamp getPlTime()
	{
		return this.plTime;
	}

	public void setPlTime(Timestamp plTime)
	{
		this.plTime = plTime;
	}

	public Set getPingLuns()
	{
		return this.pingLuns;
	}

	public void setPingLuns(Set pingLuns)
	{
		this.pingLuns = pingLuns;
	}

}