package com.flying.xiao.bean;

import java.util.HashSet;
import java.util.Set;


/**
 * ErShouType entity. @author MyEclipse Persistence Tools
 */

public class ErShouType  implements java.io.Serializable {


    // Fields    

     private Integer esTypeId;
     private String esTypeName;
     private Set erShous = new HashSet(0);


    // Constructors

    /** default constructor */
    public ErShouType() {
    }

	/** minimal constructor */
    public ErShouType(Integer esTypeId) {
        this.esTypeId = esTypeId;
    }
    
    /** full constructor */
    public ErShouType(Integer esTypeId, String esTypeName, Set erShous) {
        this.esTypeId = esTypeId;
        this.esTypeName = esTypeName;
        this.erShous = erShous;
    }

   
    // Property accessors

    public Integer getEsTypeId() {
        return this.esTypeId;
    }
    
    public void setEsTypeId(Integer esTypeId) {
        this.esTypeId = esTypeId;
    }

    public String getEsTypeName() {
        return this.esTypeName;
    }
    
    public void setEsTypeName(String esTypeName) {
        this.esTypeName = esTypeName;
    }

    public Set getErShous() {
        return this.erShous;
    }
    
    public void setErShous(Set erShous) {
        this.erShous = erShous;
    }
   








}