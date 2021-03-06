package com.costco.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Rent extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer year;

    /** nullable persistent field */
    private Boolean isUpToDate;

    /** nullable persistent field */
    private String screen;

    /** nullable persistent field */
    private String fmYear;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Boolean assign;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private Boolean isEdited;

    /** persistent field */
    private com.costco.value.Billboard billboard;
    private Long billboardId;

    /** nullable persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    /** nullable persistent field */
    private UploadedFile photo;
    private String photoFileName;
    private Long photoId;

    /** nullable persistent field */
    private UploadedFile cover;
    private String coverFileName;
    private Long coverId;

    /** persistent field */
    private AppProperty kind;
    private Long kindId;

    /** nullable persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Rent(Integer year, Boolean isUpToDate, String screen, String fmYear, Date lastModifiedDate, Date createdDate, Boolean assign, String memo, Boolean isEdited, com.costco.value.Billboard billboard, com.costco.value.Vendor vendor, UploadedFile photo, UploadedFile cover, AppProperty kind, Member lastModifiedUser, Member createdUser) {
        this.year = year;
        this.isUpToDate = isUpToDate;
        this.screen = screen;
        this.fmYear = fmYear;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.assign = assign;
        this.memo = memo;
        this.isEdited = isEdited;
        this.billboard = billboard;
        this.vendor = vendor;
        this.photo = photo;
        this.cover = cover;
        this.kind = kind;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public Rent() {
    }

    /** minimal constructor */
    public Rent(Integer year, com.costco.value.Billboard billboard, AppProperty kind, Member createdUser) {
        this.year = year;
        this.billboard = billboard;
        this.kind = kind;
        this.createdUser = createdUser;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIsUpToDate() {
        return this.isUpToDate;
    }

    public void setIsUpToDate(Boolean isUpToDate) {
        this.isUpToDate = isUpToDate;
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getFmYear() {
        return this.fmYear;
    }

    public void setFmYear(String fmYear) {
        this.fmYear = fmYear;
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

    public Boolean getAssign() {
        return this.assign;
    }

    public void setAssign(Boolean assign) {
        this.assign = assign;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getIsEdited() {
        return this.isEdited;
    }

    public void setIsEdited(Boolean isEdited) {
        this.isEdited = isEdited;
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

    public UploadedFile getPhoto() {
        return this.photo;
    }

    public void setPhoto(UploadedFile photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return this.photoFileName;
    }

    public void setPhotoFileName(String val) {
        this.photoFileName = val;
    }

    public Long getPhotoId() {
        if (this.photo != null && this.photo.getId() != null)
            return photo.getId();
        return this.photoId;
    }

    public void setPhotoId(Long id) {
        this.photoId = id;
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

    public AppProperty getKind() {
        return this.kind;
    }

    public void setKind(AppProperty kind) {
        this.kind = kind;
    }

    public Long getKindId() {
        if (this.kind != null && this.kind.getId() != null)
            return kind.getId();
        return this.kindId;
    }

    public void setKindId(Long id) {
        this.kindId = id;
    }

    public Member getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(Member lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getLastModifiedUserId() {
        if (this.lastModifiedUser != null && this.lastModifiedUser.getId() != null)
            return lastModifiedUser.getId();
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Long id) {
        this.lastModifiedUserId = id;
    }

    public Member getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
        if (this.createdUser != null && this.createdUser.getId() != null)
            return createdUser.getId();
        return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
        this.createdUserId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("year", getYear())
            .append("isUpToDate", getIsUpToDate())
            .append("screen", getScreen())
            .append("fmYear", getFmYear())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("assign", getAssign())
            .append("memo", getMemo())
            .append("isEdited", getIsEdited())
            .append("billboard", getBillboard())
            .append("vendor", getVendor())
            .append("photo", getPhoto())
            .append("cover", getCover())
            .append("kind", getKind())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
