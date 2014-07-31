package com.flying.xiao.entity;

import java.util.List;

public class XMarketDetail extends Base
{
	private Long esId;
	private XMarketType erShouType;
	private XGoodType erShouGoodsType;
	private long contentId;
	private XContent content;
	private String esMiaoshu;
	private Double esPrice;
	private Double esNewPrice;
	private String esChengse;
	private String esPhone;
	private String esName;
	private List<XImage> images;
	private List<XComment> comments ;
	
	public List<XComment> getComments() {
		return comments;
	}

	public void setComments(List<XComment> comments) {
		this.comments = comments;
	}

	public List<XImage> getImages()
	{
		return images;
	}

	public void setImages(List<XImage> images)
	{
		this.images = images;
	}

	public Long getEsId()
	{
		return esId;
	}

	public void setEsId(Long esId)
	{
		this.esId = esId;
	}

	public XMarketType getErShouType()
	{
		return erShouType;
	}

	public long getContentId()
	{
		return contentId;
	}

	public void setContentId(long contentId)
	{
		this.contentId = contentId;
	}

	public void setErShouType(XMarketType erShouType)
	{
		this.erShouType = erShouType;
	}

	public XContent getContent() {
		return content;
	}

	public void setContent(XContent content) {
		this.content = content;
	}

	public XGoodType getErShouGoodsType()
	{
		return erShouGoodsType;
	}

	public void setErShouGoodsType(XGoodType erShouGoodsType)
	{
		this.erShouGoodsType = erShouGoodsType;
	}

	public String getEsMiaoshu()
	{
		return esMiaoshu;
	}

	public void setEsMiaoshu(String esMiaoshu)
	{
		this.esMiaoshu = esMiaoshu;
	}

	public Double getEsPrice()
	{
		return esPrice;
	}

	public void setEsPrice(Double esPrice)
	{
		this.esPrice = esPrice;
	}

	public Double getEsNewPrice()
	{
		return esNewPrice;
	}

	public void setEsNewPrice(Double esNewPrice)
	{
		this.esNewPrice = esNewPrice;
	}

	public String getEsChengse()
	{
		return esChengse;
	}

	public void setEsChengse(String esChengse)
	{
		this.esChengse = esChengse;
	}

	public String getEsPhone()
	{
		return esPhone;
	}

	public void setEsPhone(String esPhone)
	{
		this.esPhone = esPhone;
	}

	public String getEsName()
	{
		return esName;
	}

	public void setEsName(String esName)
	{
		this.esName = esName;
	}
}
