package com.costco.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class VendorQuantity extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Long id;

	/** nullable persistent field */
    private String fmYear;

    /** nullable persistent field */
    private Integer quantity;

    /** persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    

    /** full constructor */
    public VendorQuantity(String fmYear, Integer quantity, com.costco.value.Vendor vendor ) {
        this.fmYear = fmYear;
        this.quantity = quantity;
        this.vendor = vendor; 
    }

    /** default constructor */
    public VendorQuantity() {
    }

    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getFmYear() {
        return this.fmYear;
    }

    public void setFmYear(String fmYear) {
        this.fmYear = fmYear;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public com.costco.value.Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(com.costco.value.Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getVendorId() {
        if (this.vendor != null && this.vendor.getId() != null)
            return vendor.getId();
        return this.vendorId;
    }

    public void setVendorId(Long id) {
        this.vendorId = id;
    }

    
    public String toString() {
        return new ToStringBuilder(this)
            .append("fmYear", getFmYear())
            .append("quantity", getQuantity())
            .append("vendor", getVendor())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
