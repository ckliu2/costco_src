package com.costco.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class VendorPrice extends BaseObject implements Serializable {

  

	Long id;
    
    /** nullable persistent field */
    private Integer price;

    /** nullable persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    /** full constructor */
    public VendorPrice(Integer price, com.costco.value.Vendor vendor) {
        this.price = price;
        this.vendor = vendor;
    }

    /** default constructor */
    public VendorPrice() {
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
            .append("price", getPrice())
            .append("vendor", getVendor())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
