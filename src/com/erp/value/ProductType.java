package com.erp.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ProductType extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

	Long id;
    
    /** persistent field */
    private String name;

    /** persistent field */
    private Integer seqNo;

    /** full constructor */
    public ProductType(String name, Integer seqNo) {
        this.name = name;
        this.seqNo = seqNo;
    }

    /** default constructor */
    public ProductType() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String toString() {    	
    	return getName();    
    }

    public String getCaption_() {
        return toString();
    }

}
