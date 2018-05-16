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
    private Float width;

    /** persistent field */
    private Float height;

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

    /** nullable persistent field */
    private UploadedFile location1;
    private String location1FileName;
    private Long location1Id;

    /** nullable persistent field */
    private UploadedFile location2;
    private String location2FileName;
    private Long location2Id;

    /** nullable persistent field */
    private UploadedFile location3;
    private String location3FileName;
    private Long location3Id;

    /** full constructor */
    public Billboard(Integer no, Float width, Float height, AppProperty size, UploadedFile cover, com.costco.value.Store store, UploadedFile location1, UploadedFile location2, UploadedFile location3) {
        this.no = no;
        this.width = width;
        this.height = height;
        this.size = size;
        this.cover = cover;
        this.store = store;
        this.location1 = location1;
        this.location2 = location2;
        this.location3 = location3;
    }

    /** default constructor */
    public Billboard() {
    }

    /** minimal constructor */
    public Billboard(Integer no, Float width, Float height, AppProperty size, com.costco.value.Store store) {
        this.no = no;
        this.width = width;
        this.height = height;
        this.size = size;
        this.store = store;
    }

    public Integer getNo() {
        return this.no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Float getWidth() {
        return this.width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float height) {
        this.height = height;
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

    public UploadedFile getLocation1() {
        return this.location1;
    }

    public void setLocation1(UploadedFile location1) {
        this.location1 = location1;
    }

    public String getLocation1FileName() {
        return this.location1FileName;
    }

    public void setLocation1FileName(String val) {
        this.location1FileName = val;
    }

    public Long getLocation1Id() {
        if (this.location1 != null && this.location1.getId() != null)
            return location1.getId();
        return this.location1Id;
    }

    public void setLocation1Id(Long id) {
        this.location1Id = id;
    }

    public UploadedFile getLocation2() {
        return this.location2;
    }

    public void setLocation2(UploadedFile location2) {
        this.location2 = location2;
    }

    public String getLocation2FileName() {
        return this.location2FileName;
    }

    public void setLocation2FileName(String val) {
        this.location2FileName = val;
    }

    public Long getLocation2Id() {
        if (this.location2 != null && this.location2.getId() != null)
            return location2.getId();
        return this.location2Id;
    }

    public void setLocation2Id(Long id) {
        this.location2Id = id;
    }

    public UploadedFile getLocation3() {
        return this.location3;
    }

    public void setLocation3(UploadedFile location3) {
        this.location3 = location3;
    }

    public String getLocation3FileName() {
        return this.location3FileName;
    }

    public void setLocation3FileName(String val) {
        this.location3FileName = val;
    }

    public Long getLocation3Id() {
        if (this.location3 != null && this.location3.getId() != null)
            return location3.getId();
        return this.location3Id;
    }

    public void setLocation3Id(Long id) {
        this.location3Id = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("no", getNo())
            .append("width", getWidth())
            .append("height", getHeight())
            .append("size", getSize())
            .append("cover", getCover())
            .append("store", getStore())
            .append("location1", getLocation1())
            .append("location2", getLocation2())
            .append("location3", getLocation3())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
