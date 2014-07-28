package com.flying.xiao.bean;

/**
 * ErShouImage entity. @author MyEclipse Persistence Tools
 */

public class ErShouImage implements java.io.Serializable
{

	// Fields

	private Long esImageId;
	private ErShou erShou;
	private String esImageUrl;

	// Constructors

	/** default constructor */
	public ErShouImage()
	{
	}

	/** minimal constructor */
	public ErShouImage(Long esImageId)
	{
		this.esImageId = esImageId;
	}

	/** full constructor */
	public ErShouImage(Long esImageId, ErShou erShou, String esImageUrl)
	{
		this.esImageId = esImageId;
		this.erShou = erShou;
		this.esImageUrl = esImageUrl;
	}

	// Property accessors

	public Long getEsImageId()
	{
		return this.esImageId;
	}

	public void setEsImageId(Long esImageId)
	{
		this.esImageId = esImageId;
	}

	public ErShou getErShou()
	{
		return this.erShou;
	}

	public void setErShou(ErShou erShou)
	{
		this.erShou = erShou;
	}

	public String getEsImageUrl()
	{
		return this.esImageUrl;
	}

	public void setEsImageUrl(String esImageUrl)
	{
		this.esImageUrl = esImageUrl;
	}

}