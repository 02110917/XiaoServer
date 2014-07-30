package com.flying.xiao.bean;



/**
 * ContentType entity. @author MyEclipse Persistence Tools
 */

public class ContentType  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String conTypeName;


    // Constructors

    /** default constructor */
    public ContentType() {
    }

	/** minimal constructor */
    public ContentType(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public ContentType(Integer id, String conTypeName) {
        this.id = id;
        this.conTypeName = conTypeName;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getConTypeName() {
        return this.conTypeName;
    }
    
    public void setConTypeName(String conTypeName) {
        this.conTypeName = conTypeName;
    }
   








}