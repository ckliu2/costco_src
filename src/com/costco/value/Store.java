package com.costco.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Store extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Long id;
    
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String contact;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String phone;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;
    


	String no;

    /** default constructor */
    public Store() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
    /** minimal constructor */
    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("address", getAddress())
            .append("contact", getContact())
            .append("title", getTitle())
            .append("phone", getPhone())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
