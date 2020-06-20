package com.costco.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BillboardRent extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String kind;

    /** nullable persistent field */
    private String fmYear;

    /** persistent field */
    private com.costco.value.Rent rent;
    private Long rentId;

    /** persistent field */
    private com.costco.value.Store store;
    private Long storeId;

    /** persistent field */
    private com.costco.value.Billboard billboard;
    private Long billboardId;

    /** nullable persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    /** full constructor */
    public BillboardRent(String kind, String fmYear, com.costco.value.Rent rent, com.costco.value.Store store, com.costco.value.Billboard billboard, com.costco.value.Vendor vendor) {
        this.kind = kind;
        this.fmYear = fmYear;
        this.rent = rent;
        this.store = store;
        this.billboard = billboard;
        this.vendor = vendor;
    }

    /** default constructor */
    public BillboardRent() {
    }

    /** minimal constructor */
    public BillboardRent(com.costco.value.Rent rent, com.costco.value.Store store, com.costco.value.Billboard billboard) {
        this.rent = rent;
        this.store = store;
        this.billboard = billboard;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFmYear() {
        return this.fmYear;
    }

    public void setFmYear(String fmYear) {
        this.fmYear = fmYear;
    }

    public com.costco.value.Rent getRent() {
        return this.rent;
    }

    public void setRent(com.costco.value.Rent rent) {
        this.rent = rent;
    }

    public Long getRentId() {
        if (this.rent != null && this.rent.getId() != null)
            return rent.getId();
        return this.rentId;
    }

    public void setRentId(Long id) {
        this.rentId = id;
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

    public com.costco.value.Billboard getBillboard() {
        return this.billboard;
    }

    public void setBillboard(com.costco.value.Billboard billboard) {
        this.billboard = billboard;
    }

    public Long getBillboardId() {
        if (this.billboard != null && this.billboard.getId() != null)
            return billboard.getId();
        return this.billboardId;
    }

    public void setBillboardId(Long id) {
        this.billboardId = id;
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
            .append("kind", getKind())
            .append("fmYear", getFmYear())
            .append("rent", getRent())
            .append("store", getStore())
            .append("billboard", getBillboard())
            .append("vendor", getVendor())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
