package com.flying.xiao.bean;



/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Content content;
     private UserInfo userInfo;


    // Constructors

    /** default constructor */
    public Collection() {
    }

	/** minimal constructor */
    public Collection(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public Collection(Long id, Content content, UserInfo userInfo) {
        this.id = id;
        this.content = content;
        this.userInfo = userInfo;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Content getContent() {
        return this.content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
   








}