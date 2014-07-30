package com.flying.xiao.bean;



/**
 * ErShou entity. @author MyEclipse Persistence Tools
 */

public class ErShou  implements java.io.Serializable {


    // Fields    

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


    // Constructors

    /** default constructor */
    public ErShou() {
    }

	/** minimal constructor */
    public ErShou(Long esId) {
        this.esId = esId;
    }
    
    /** full constructor */
    public ErShou(Long esId, ErShouType erShouType, ErShouGoodsType erShouGoodsType, Content content, String esMiaoshu, Double esPrice, Double esNewPrice, String esChengse, String esPhone, String esName) {
        this.esId = esId;
        this.erShouType = erShouType;
        this.erShouGoodsType = erShouGoodsType;
        this.content = content;
        this.esMiaoshu = esMiaoshu;
        this.esPrice = esPrice;
        this.esNewPrice = esNewPrice;
        this.esChengse = esChengse;
        this.esPhone = esPhone;
        this.esName = esName;
    }

   
    // Property accessors

    public Long getEsId() {
        return this.esId;
    }
    
    public void setEsId(Long esId) {
        this.esId = esId;
    }

    public ErShouType getErShouType() {
        return this.erShouType;
    }
    
    public void setErShouType(ErShouType erShouType) {
        this.erShouType = erShouType;
    }

    public ErShouGoodsType getErShouGoodsType() {
        return this.erShouGoodsType;
    }
    
    public void setErShouGoodsType(ErShouGoodsType erShouGoodsType) {
        this.erShouGoodsType = erShouGoodsType;
    }

    public Content getContent() {
        return this.content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }

    public String getEsMiaoshu() {
        return this.esMiaoshu;
    }
    
    public void setEsMiaoshu(String esMiaoshu) {
        this.esMiaoshu = esMiaoshu;
    }

    public Double getEsPrice() {
        return this.esPrice;
    }
    
    public void setEsPrice(Double esPrice) {
        this.esPrice = esPrice;
    }

    public Double getEsNewPrice() {
        return this.esNewPrice;
    }
    
    public void setEsNewPrice(Double esNewPrice) {
        this.esNewPrice = esNewPrice;
    }

    public String getEsChengse() {
        return this.esChengse;
    }
    
    public void setEsChengse(String esChengse) {
        this.esChengse = esChengse;
    }

    public String getEsPhone() {
        return this.esPhone;
    }
    
    public void setEsPhone(String esPhone) {
        this.esPhone = esPhone;
    }

    public String getEsName() {
        return this.esName;
    }
    
    public void setEsName(String esName) {
        this.esName = esName;
    }
   








}