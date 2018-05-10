package com.costco.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Billboard extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer no;

    /** persistent field */
    private AppProperty size;
    private Long sizeId;

    /** nullable persistent field */
    private UploadedFile cover;
    private String coverFileName;
    private Long coverId;

    /** persistent field */
    private com.costco.value.Store store;
    private Long storeId;

    /** full constructor */
    public Billboard(Integer no, AppProperty size, UploadedFile cover, com.costco.value.Store store) {
        this.no = no;
        this.size = size;
        this.cover = cover;
        this.store = store;
    }

    /** default constructor */
    public Billboard() {
    }

    /** minimal constructor */
    public Billboard(Integer no, AppProperty size, com.costco.value.Store store) {
        this.no = no;
        this.size = size;
        this.store = store;
    }

    public Integer getNo() {
        return this.no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public AppProperty getSize() {
        return this.size;
    }

    public void setSize(AppProperty size) {
        this.size = size;
    }

    public Long getSizeId() {
        if (this.size != null && this.size.getId() != null)
            return size.getId();
        return this.sizeId;
    }

    public void setSizeId(Long id) {
        this.sizeId = id;
    }

    public UploadedFile getCover() {
        return this.cover;
    }

    public void setCover(UploadedFile cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return this.coverFileName;
    }

    public void setCoverFileName(String val) {
        this.coverFileName = val;
    }

    public Long getCoverId() {
        if (this.cover != null && this.cover.getId() != null)
            return cover.getId();
        return this.coverId;
    }

    public void setCoverId(Long id) {
        this.coverId = id;
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
            .append("no", getNo())
            .append("size", getSize())
            .append("cover", getCover())
            .append("store", getStore())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
