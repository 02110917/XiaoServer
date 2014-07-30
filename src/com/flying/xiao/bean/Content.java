package com.flying.xiao.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Content entity. @author MyEclipse Persistence Tools
 */

public class Content  implements java.io.Serializable {


    // Fields    

     private Long id;
     private UserInfo userInfo;
     private Timestamp conPubTime;
     private Integer conZan;
     private Integer conHot;
     private String conTitle;
     private Integer conPls;
     private Integer conTypeId;
     private String conImageUrl;
     private String conSummary;
     private Set praises = new HashSet(0);
     private Set wenZhangs = new HashSet(0);
     private Set pingLuns = new HashSet(0);
     private Set erShous = new HashSet(0);
     private Set diaries = new HashSet(0);
     private Set images = new HashSet(0);
     private Set collections = new HashSet(0);


    // Constructors

    /** default constructor */
    public Content() {
    }

	/** minimal constructor */
    public Content(Long id, Integer conZan, Integer conHot, Integer conPls) {
        this.id = id;
        this.conZan = conZan;
        this.conHot = conHot;
        this.conPls = conPls;
    }
    
    /** full constructor */
    public Content(Long id, UserInfo userInfo, Timestamp conPubTime, Integer conZan, Integer conHot, String conTitle, Integer conPls, Integer conTypeId, String conImageUrl, String conSummary, Set praises, Set wenZhangs, Set pingLuns, Set erShous, Set diaries, Set images, Set collections) {
        this.id = id;
        this.userInfo = userInfo;
        this.conPubTime = conPubTime;
        this.conZan = conZan;
        this.conHot = conHot;
        this.conTitle = conTitle;
        this.conPls = conPls;
        this.conTypeId = conTypeId;
        this.conImageUrl = conImageUrl;
        this.conSummary = conSummary;
        this.praises = praises;
        this.wenZhangs = wenZhangs;
        this.pingLuns = pingLuns;
        this.erShous = erShous;
        this.diaries = diaries;
        this.images = images;
        this.collections = collections;
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

    public Timestamp getConPubTime() {
        return this.conPubTime;
    }
    
    public void setConPubTime(Timestamp conPubTime) {
        this.conPubTime = conPubTime;
    }

    public Integer getConZan() {
        return this.conZan;
    }
    
    public void setConZan(Integer conZan) {
        this.conZan = conZan;
    }

    public Integer getConHot() {
        return this.conHot;
    }
    
    public void setConHot(Integer conHot) {
        this.conHot = conHot;
    }

    public String getConTitle() {
        return this.conTitle;
    }
    
    public void setConTitle(String conTitle) {
        this.conTitle = conTitle;
    }

    public Integer getConPls() {
        return this.conPls;
    }
    
    public void setConPls(Integer conPls) {
        this.conPls = conPls;
    }

    public Integer getConTypeId() {
        return this.conTypeId;
    }
    
    public void setConTypeId(Integer conTypeId) {
        this.conTypeId = conTypeId;
    }

    public String getConImageUrl() {
        return this.conImageUrl;
    }
    
    public void setConImageUrl(String conImageUrl) {
        this.conImageUrl = conImageUrl;
    }

    public String getConSummary() {
        return this.conSummary;
    }
    
    public void setConSummary(String conSummary) {
        this.conSummary = conSummary;
    }

    public Set getPraises() {
        return this.praises;
    }
    
    public void setPraises(Set praises) {
        this.praises = praises;
    }

    public Set getWenZhangs() {
        return this.wenZhangs;
    }
    
    public void setWenZhangs(Set wenZhangs) {
        this.wenZhangs = wenZhangs;
    }

    public Set getPingLuns() {
        return this.pingLuns;
    }
    
    public void setPingLuns(Set pingLuns) {
        this.pingLuns = pingLuns;
    }

    public Set getErShous() {
        return this.erShous;
    }
    
    public void setErShous(Set erShous) {
        this.erShous = erShous;
    }

    public Set getDiaries() {
        return this.diaries;
    }
    
    public void setDiaries(Set diaries) {
        this.diaries = diaries;
    }

    public Set getImages() {
        return this.images;
    }
    
    public void setImages(Set images) {
        this.images = images;
    }

    public Set getCollections() {
        return this.collections;
    }
    
    public void setCollections(Set collections) {
        this.collections = collections;
    }
   








}