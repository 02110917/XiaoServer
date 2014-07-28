package com.flying.xiao.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * WenZhangType entity. @author MyEclipse Persistence Tools
 */

public class WenZhangType implements java.io.Serializable
{

	// Fields

	private Integer wzTypeId;
	private String wzTypeName;
	private Set wenZhangs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WenZhangType()
	{
	}

	/** minimal constructor */
	public WenZhangType(Integer wzTypeId)
	{
		this.wzTypeId = wzTypeId;
	}

	/** full constructor */
	public WenZhangType(Integer wzTypeId, String wzTypeName, Set wenZhangs)
	{
		this.wzTypeId = wzTypeId;
		this.wzTypeName = wzTypeName;
		this.wenZhangs = wenZhangs;
	}

	// Property accessors

	public Integer getWzTypeId()
	{
		return this.wzTypeId;
	}

	public void setWzTypeId(Integer wzTypeId)
	{
		this.wzTypeId = wzTypeId;
	}

	public String getWzTypeName()
	{
		return this.wzTypeName;
	}

	public void setWzTypeName(String wzTypeName)
	{
		this.wzTypeName = wzTypeName;
	}

	public Set getWenZhangs()
	{
		return this.wenZhangs;
	}

	public void setWenZhangs(Set wenZhangs)
	{
		this.wenZhangs = wenZhangs;
	}

}