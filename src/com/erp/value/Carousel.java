package com.erp.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.*;

/** @author Hibernate CodeGenerator */
public class Carousel extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

	Long id;    
    
    /** persistent field */
    private Integer seqNo;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private String url;
    
    private UploadedFile photo;
    private String photoFileName;
    private Long photoId;
    
    private AppProperty type;
    private Long typeId;

    /** full constructor */
    public Carousel(Integer seqNo, String name, String content, String url) {
        this.seqNo = seqNo;
        this.name = name;
        this.content = content;
        this.url = url;
    }

    /** default constructor */
    public Carousel() {
    }

    /** minimal constructor */
    public Carousel(Integer seqNo) {
        this.seqNo = seqNo;
    }
    
    public Long getId() {
  		return id;
  	}

  	public void setId(Long id) {
  		this.id = id;
  	}

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    
    public AppProperty getType() {
        return this.type;
    }

    public void setType(AppProperty type) {
        this.type = type;
    }

    public Long getTypeId() {
        if (this.type != null && this.type.getId() != null)
            return type.getId();
        return this.typeId;
    }

    public void setTypeId(Long id) {
        this.typeId = id;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("seqNo", getSeqNo())
            .append("name", getName())
            .append("content", getContent())
            .append("url", getUrl())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
