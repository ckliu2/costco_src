package com.costco.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class VendorQuantity extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String fmYear;

    /** nullable persistent field */
    private Integer quantity;

    /** persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    /** persistent field */
    private com.costco.value.Store store;
    private Long storeId;

    /** full constructor */
    public VendorQuantity(String fmYear, Integer quantity, com.costco.value.Vendor vendor, com.costco.value.Store store) {
        this.fmYear = fmYear;
        this.quantity = quantity;
        this.vendor = vendor;
        this.store = store;
    }

    /** default constructor */
    public VendorQuantity() {
    }

    /** minimal constructor */
    public VendorQuantity(com.costco.value.Vendor vendor, com.costco.value.Store store) {
        this.vendor = vendor;
        this.store = store;
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

    public com.costco.value.Store getStore() {
        return this.store;
    }

    public void setStore(com.costco.value.Store store) {
        this.store = store;
    }

    public Long getStoreId() {
        if (this.store != null && this.store.getId() != null)
            return store.getId();
        return this.storeId;
    }

    public void setStoreId(Long id) {
        this.storeId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("fmYear", getFmYear())
            .append("quantity", getQuantity())
            .append("vendor", getVendor())
            .append("store", getStore())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
