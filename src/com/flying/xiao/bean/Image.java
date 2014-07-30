package com.flying.xiao.bean;



/**
 * Image entity. @author MyEclipse Persistence Tools
 */

public class Image  implements java.io.Serializable {


    // Fields    

     private Long imageId;
     private Content content;
     private String imageUrl;


    // Constructors

    /** default constructor */
    public Image() {
    }

	/** minimal constructor */
    public Image(Long imageId) {
        this.imageId = imageId;
    }
    
    /** full constructor */
    public Image(Long imageId, Content content, String imageUrl) {
        this.imageId = imageId;
        this.content = content;
        this.imageUrl = imageUrl;
    }

   
    // Property accessors

    public Long getImageId() {
        return this.imageId;
    }
    
    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Content getContent() {
        return this.content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
   








}