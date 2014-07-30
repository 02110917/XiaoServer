package com.flying.xiao.entity;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.ErShouGoodsType;
import com.flying.xiao.bean.ErShouType;

public class XMarketDetail extends Base{
	private Long esId;
	private ErShouType erShouType;
	private ErShouGoodsType erShouGoodsType;
	private Content content;
	private String esMiaoshu;
	private Double esPrice;
	private Double esNewPrice;
	private String esChengse;
	private String esPhone;
	private String esName;
//	private List
	public Long getEsId() {
		return esId;
	}
	public void setEsId(Long esId) {
		this.esId = esId;
	}
	public ErShouType getErShouType() {
		return erShouType;
	}
	public void setErShouType(ErShouType erShouType) {
		this.erShouType = erShouType;
	}
	public ErShouGoodsType getErShouGoodsType() {
		return erShouGoodsType;
	}
	public void setErShouGoodsType(ErShouGoodsType erShouGoodsType) {
		this.erShouGoodsType = erShouGoodsType;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public String getEsMiaoshu() {
		return esMiaoshu;
	}
	public void setEsMiaoshu(String esMiaoshu) {
		this.esMiaoshu = esMiaoshu;
	}
	public Double getEsPrice() {
		return esPrice;
	}
	public void setEsPrice(Double esPrice) {
		this.esPrice = esPrice;
	}
	public Double getEsNewPrice() {
		return esNewPrice;
	}
	public void setEsNewPrice(Double esNewPrice) {
		this.esNewPrice = esNewPrice;
	}
	public String getEsChengse() {
		return esChengse;
	}
	public void setEsChengse(String esChengse) {
		this.esChengse = esChengse;
	}
	public String getEsPhone() {
		return esPhone;
	}
	public void setEsPhone(String esPhone) {
		this.esPhone = esPhone;
	}
	public String getEsName() {
		return esName;
	}
	public void setEsName(String esName) {
		this.esName = esName;
	}
}
