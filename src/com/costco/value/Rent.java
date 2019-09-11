package com.costco.value;

import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Rent extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Long id;
    
    /** persistent field */
    private Integer year;

    /** nullable persistent field */
    private Boolean isUpToDate;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** persistent field */
    private com.costco.value.Billboard billboard;
    private Long billboardId;

    /** persistent field */
    private com.costco.value.Vendor vendor;
    private Long vendorId;

    /** nullable persistent field */
    private UploadedFile cover;
    private String coverFileName;
    private Long coverId;

    /** nullable persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;
    
    /** nullable persistent field */
    private UploadedFile photo;
    private String photoFileName;
    private Long photoId;
    
    String screen,yearCode;

	/** full constructor */
    public Rent(Integer year, Boolean isUpToDate, Date lastModifiedDate, Date createdDate, com.costco.value.Billboard billboard, com.costco.value.Vendor vendor, UploadedFile cover, Member lastModifiedUser, Member createdUser) {
        this.year = year;
        this.isUpToDate = isUpToDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.billboard = billboard;
        this.vendor = vendor;
        this.cover = cover;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public Rent() {
    }

    /** minimal constructor */
    public Rent(Integer year, com.costco.value.Billboard billboard, com.costco.value.Vendor vendor, Member createdUser) {
        this.year = year;
        this.billboard = billboard;
        this.vendor = vendor;
        this.createdUser = createdUser;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}
	
	public String getYearCode() {
		String y="";
		
		try{
			String year=String.valueOf(getYear());
			y="FY"+year.substring(2,4);
		}catch(Exception e){}
		return y; 
	}

	public void setYearCode(String yearCode) {
		this.yearCode = yearCode;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("year", getYear())
            .append("isUpToDate", getIsUpToDate())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("billboard", getBillboard())
            .append("vendor", getVendor())
            .append("cover", getCover())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
