package com.flying.xiao.bean;



/**
 * ErShouGoodsTypeSecond entity. @author MyEclipse Persistence Tools
 */

public class ErShouGoodsTypeSecond  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private ErShouGoodsType erShouGoodsType;
     private String typeName;


    // Constructors

    /** default constructor */
    public ErShouGoodsTypeSecond() {
    }

	/** minimal constructor */
    public ErShouGoodsTypeSecond(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ErShouGoodsTypeSecond(Integer id, ErShouGoodsType erShouGoodsType, String typeName) {
        this.id = id;
        this.erShouGoodsType = erShouGoodsType;
        this.typeName = typeName;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public ErShouGoodsType getErShouGoodsType() {
        return this.erShouGoodsType;
    }
    
    public void setErShouGoodsType(ErShouGoodsType erShouGoodsType) {
        this.erShouGoodsType = erShouGoodsType;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
   








}