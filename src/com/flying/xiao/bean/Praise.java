package com.flying.xiao.bean;

import java.sql.Timestamp;


/**
 * Praise entity. @author MyEclipse Persistence Tools
 */

public class Praise  implements java.io.Serializable {


    // Fields    

     private Long id;
     private UserInfo userInfo;
     private Content content;
     private Timestamp time;


    // Constructors

    /** default constructor */
    public Praise() {
    }

	/** minimal constructor */
    public Praise(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public Praise(Long id, UserInfo userInfo, Content content, Timestamp time) {
        this.id = id;
        this.userInfo = userInfo;
        this.content = content;
        this.time = time;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Content getContent() {
        return this.content;
    }
    
    public void setContent(Content content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
   








}