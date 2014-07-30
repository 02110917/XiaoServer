package com.flying.xiao.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String userName;
     private String userPsd;
     private String userGerenshuoming;
     private String userRealName;
     private Boolean userSex;
     private String userHeadImageUrl;
     private String userQq;
     private String userEmail;
     private Integer userTypeId;
     private Integer userJifen;
     private Integer userFuns;
     private Boolean userIsQiandao;
     private String userPhone;
     private Set messagesForMsgUserId = new HashSet(0);
     private Set friendsForUserFriendBelongUserId = new HashSet(0);
     private Set contents = new HashSet(0);
     private Set friendsForUserId = new HashSet(0);
     private Set collections = new HashSet(0);
     private Set praises = new HashSet(0);
     private Set messagesForMsgFromUserId = new HashSet(0);
     private Set pingLuns = new HashSet(0);


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

	/** minimal constructor */
    public UserInfo(Long id, Integer userTypeId, Integer userJifen, Integer userFuns, Boolean userIsQiandao) {
        this.id = id;
        this.userTypeId = userTypeId;
        this.userJifen = userJifen;
        this.userFuns = userFuns;
        this.userIsQiandao = userIsQiandao;
    }
    
    /** full constructor */
    public UserInfo(Long id, String userName, String userPsd, String userGerenshuoming, String userRealName, Boolean userSex, String userHeadImageUrl, String userQq, String userEmail, Integer userTypeId, Integer userJifen, Integer userFuns, Boolean userIsQiandao, String userPhone, Set messagesForMsgUserId, Set friendsForUserFriendBelongUserId, Set contents, Set friendsForUserId, Set collections, Set praises, Set messagesForMsgFromUserId, Set pingLuns) {
        this.id = id;
        this.userName = userName;
        this.userPsd = userPsd;
        this.userGerenshuoming = userGerenshuoming;
        this.userRealName = userRealName;
        this.userSex = userSex;
        this.userHeadImageUrl = userHeadImageUrl;
        this.userQq = userQq;
        this.userEmail = userEmail;
        this.userTypeId = userTypeId;
        this.userJifen = userJifen;
        this.userFuns = userFuns;
        this.userIsQiandao = userIsQiandao;
        this.userPhone = userPhone;
        this.messagesForMsgUserId = messagesForMsgUserId;
        this.friendsForUserFriendBelongUserId = friendsForUserFriendBelongUserId;
        this.contents = contents;
        this.friendsForUserId = friendsForUserId;
        this.collections = collections;
        this.praises = praises;
        this.messagesForMsgFromUserId = messagesForMsgFromUserId;
        this.pingLuns = pingLuns;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return this.userPsd;
    }
    
    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserGerenshuoming() {
        return this.userGerenshuoming;
    }
    
    public void setUserGerenshuoming(String userGerenshuoming) {
        this.userGerenshuoming = userGerenshuoming;
    }

    public String getUserRealName() {
        return this.userRealName;
    }
    
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public Boolean getUserSex() {
        return this.userSex;
    }
    
    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public String getUserHeadImageUrl() {
        return this.userHeadImageUrl;
    }
    
    public void setUserHeadImageUrl(String userHeadImageUrl) {
        this.userHeadImageUrl = userHeadImageUrl;
    }

    public String getUserQq() {
        return this.userQq;
    }
    
    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserTypeId() {
        return this.userTypeId;
    }
    
    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getUserJifen() {
        return this.userJifen;
    }
    
    public void setUserJifen(Integer userJifen) {
        this.userJifen = userJifen;
    }

    public Integer getUserFuns() {
        return this.userFuns;
    }
    
    public void setUserFuns(Integer userFuns) {
        this.userFuns = userFuns;
    }

    public Boolean getUserIsQiandao() {
        return this.userIsQiandao;
    }
    
    public void setUserIsQiandao(Boolean userIsQiandao) {
        this.userIsQiandao = userIsQiandao;
    }

    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Set getMessagesForMsgUserId() {
        return this.messagesForMsgUserId;
    }
    
    public void setMessagesForMsgUserId(Set messagesForMsgUserId) {
        this.messagesForMsgUserId = messagesForMsgUserId;
    }

    public Set getFriendsForUserFriendBelongUserId() {
        return this.friendsForUserFriendBelongUserId;
    }
    
    public void setFriendsForUserFriendBelongUserId(Set friendsForUserFriendBelongUserId) {
        this.friendsForUserFriendBelongUserId = friendsForUserFriendBelongUserId;
    }

    public Set getContents() {
        return this.contents;
    }
    
    public void setContents(Set contents) {
        this.contents = contents;
    }

    public Set getFriendsForUserId() {
        return this.friendsForUserId;
    }
    
    public void setFriendsForUserId(Set friendsForUserId) {
        this.friendsForUserId = friendsForUserId;
    }

    public Set getCollections() {
        return this.collections;
    }
    
    public void setCollections(Set collections) {
        this.collections = collections;
    }

    public Set getPraises() {
        return this.praises;
    }
    
    public void setPraises(Set praises) {
        this.praises = praises;
    }

    public Set getMessagesForMsgFromUserId() {
        return this.messagesForMsgFromUserId;
    }
    
    public void setMessagesForMsgFromUserId(Set messagesForMsgFromUserId) {
        this.messagesForMsgFromUserId = messagesForMsgFromUserId;
    }

    public Set getPingLuns() {
        return this.pingLuns;
    }
    
    public void setPingLuns(Set pingLuns) {
        this.pingLuns = pingLuns;
    }
   








}