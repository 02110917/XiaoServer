package com.flying.xiao.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * ErShouGoodsType entity. @author MyEclipse Persistence Tools
 */

public class ErShouGoodsType implements java.io.Serializable
{

	// Fields

	private Integer esGoodsTypeId;
	private String esGoodsTypeName;
	private Set erShous = new HashSet(0);

	// Constructors

	/** default constructor */
	public ErShouGoodsType()
	{
	}

	/** minimal constructor */
	public ErShouGoodsType(Integer esGoodsTypeId)
	{
		this.esGoodsTypeId = esGoodsTypeId;
	}

	/** full constructor */
	public ErShouGoodsType(Integer esGoodsTypeId, String esGoodsTypeName, Set erShous)
	{
		this.esGoodsTypeId = esGoodsTypeId;
		this.esGoodsTypeName = esGoodsTypeName;
		this.erShous = erShous;
	}

	// Property accessors

	public Integer getEsGoodsTypeId()
	{
		return this.esGoodsTypeId;
	}

	public void setEsGoodsTypeId(Integer esGoodsTypeId)
	{
		this.esGoodsTypeId = esGoodsTypeId;
	}

	public String getEsGoodsTypeName()
	{
		return this.esGoodsTypeName;
	}

	public void setEsGoodsTypeName(String esGoodsTypeName)
	{
		this.esGoodsTypeName = esGoodsTypeName;
	}

	public Set getErShous()
	{
		return this.erShous;
	}

	public void setErShous(Set erShous)
	{
		this.erShous = erShous;
	}

}