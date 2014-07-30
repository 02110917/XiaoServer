package com.flying.xiao.bean;



/**
 * Diary entity. @author MyEclipse Persistence Tools
 */

public class Diary  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Content content;


    // Constructors

    /** default constructor */
    public Diary() {
    }

	/** minimal constructor */
    public Diary(Long id) {
        this.id = id;
    }
    
    /** full constructor */
    public Diary(Long id, Content content) {
        this.id = id;
        this.content = content;
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
   








}