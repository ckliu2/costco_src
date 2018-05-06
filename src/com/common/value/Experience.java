package com.common.value;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Experience {

    
    /** nullable persistent field */
    private String description;
    
    private String description1;

    /** full constructor */
    public Experience(String description) {
        this.description = description;
    }

    /** default constructor */
    public Experience() {
    }
    
    
    public String getDescription1() {
        return description;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description =  description.replaceAll("\r|\n", "&#13;"); 
    }
    
}
