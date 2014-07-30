package com.flying.xiao.bean;

import java.sql.Timestamp;


/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message  implements java.io.Serializable {


    // Fields    

     private Integer msgId;
     private UserInfo userInfoByMsgFromUserId;
     private UserInfo userInfoByMsgUserId;
     private String msgInfo;
     private Timestamp msgSendTime;


    // Constructors

    /** default constructor */
    public Message() {
    }

	/** minimal constructor */
    public Message(Integer msgId) {
        this.msgId = msgId;
    }
    
    /** full constructor */
    public Message(Integer msgId, UserInfo userInfoByMsgFromUserId, UserInfo userInfoByMsgUserId, String msgInfo, Timestamp msgSendTime) {
        this.msgId = msgId;
        this.userInfoByMsgFromUserId = userInfoByMsgFromUserId;
        this.userInfoByMsgUserId = userInfoByMsgUserId;
        this.msgInfo = msgInfo;
        this.msgSendTime = msgSendTime;
    }

   
    // Property accessors

    public Integer getMsgId() {
        return this.msgId;
    }
    
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public UserInfo getUserInfoByMsgFromUserId() {
        return this.userInfoByMsgFromUserId;
    }
    
    public void setUserInfoByMsgFromUserId(UserInfo userInfoByMsgFromUserId) {
        this.userInfoByMsgFromUserId = userInfoByMsgFromUserId;
    }

    public UserInfo getUserInfoByMsgUserId() {
        return this.userInfoByMsgUserId;
    }
    
    public void setUserInfoByMsgUserId(UserInfo userInfoByMsgUserId) {
        this.userInfoByMsgUserId = userInfoByMsgUserId;
    }

    public String getMsgInfo() {
        return this.msgInfo;
    }
    
    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public Timestamp getMsgSendTime() {
        return this.msgSendTime;
    }
    
    public void setMsgSendTime(Timestamp msgSendTime) {
        this.msgSendTime = msgSendTime;
    }
   








}