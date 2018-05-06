package com.erp.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Web extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Long id;
    
    /** nullable persistent field */
    private String home;

    /** full constructor */
    public Web(String home) {
        this.home = home;
    }

    /** default constructor */
    public Web() {
    }
    
    public Long getId() {
  		return id;
  	}

  	public void setId(Long id) {
  		this.id = id;
  	}

    public String getHome() {
        return this.home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("home", getHome())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
