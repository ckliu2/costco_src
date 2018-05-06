package com.common.value;

import com.base.value.UploadedFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;


/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;

	/** persistent field */
	private String name;

	String sname;

	String cellphone;

	String password;

	String email;

	/** nullable persistent field */
	private Date lastModifiedDate;

	/** nullable persistent field */
	private Date createdDate;
	
	private Set groups,units;

	
	/** nullable persistent field */
    private UploadedFile signfile;
    private String signfileFileName;
    private Long signfileId;
    
    /** nullable persistent field */
    private String ip;

    /** nullable persistent field */
    private String mondayStartTime;

    /** nullable persistent field */
    private String mondayEndTime;

    /** nullable persistent field */
    private String tuesdayStartTime;

    /** nullable persistent field */
    private String tuesdayEndTime;

    /** nullable persistent field */
    private String wednesdayStartTime;

    /** nullable persistent field */
    private String wednesdayEndTime;

    /** nullable persistent field */
    private String thursdayStartTime;

    /** nullable persistent field */
    private String thursdayEndTime;

    /** nullable persistent field */
    private String fridayStartTime;

    /** nullable persistent field */
    private String fridayEndTime;

    /** nullable persistent field */
    private String saturdayStartTime;

    /** nullable persistent field */
    private String saturdayEndTime;

    /** nullable persistent field */
    private String sundayStartTime;

    /** nullable persistent field */
    private String sundayEndTime;

	String officePhone;

	/** default constructor */
	public Member() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set getGroups() {
		return groups;
	}

	public void setGroups(Set groups) {
		this.groups = groups;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public UploadedFile getSignfile() {
        return this.signfile;
    }

    public void setSignfile(UploadedFile signfile) {
        this.signfile = signfile;
    }

    public String getSignfileFileName() {
        return this.signfileFileName;
    }

    public void setSignfileFileName(String val) {
        this.signfileFileName = val;
    }

    public Long getSignfileId() {
        if (this.signfile != null && this.signfile.getId() != null)
            return signfile.getId();
        return this.signfileId;
    }

    public void setSignfileId(Long id) {
        this.signfileId = id;
    }

	public Set getUnits() {
		return units;
	}

	public void setUnits(Set units) {
		this.units = units;
	}
	
	public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMondayStartTime() {
        return this.mondayStartTime;
    }

    public void setMondayStartTime(String mondayStartTime) {
        this.mondayStartTime = mondayStartTime;
    }

    public String getMondayEndTime() {
        return this.mondayEndTime;
    }

    public void setMondayEndTime(String mondayEndTime) {
        this.mondayEndTime = mondayEndTime;
    }

    public String getTuesdayStartTime() {
        return this.tuesdayStartTime;
    }

    public void setTuesdayStartTime(String tuesdayStartTime) {
        this.tuesdayStartTime = tuesdayStartTime;
    }

    public String getTuesdayEndTime() {
        return this.tuesdayEndTime;
    }

    public void setTuesdayEndTime(String tuesdayEndTime) {
        this.tuesdayEndTime = tuesdayEndTime;
    }

    public String getWednesdayStartTime() {
        return this.wednesdayStartTime;
    }

    public void setWednesdayStartTime(String wednesdayStartTime) {
        this.wednesdayStartTime = wednesdayStartTime;
    }

    public String getWednesdayEndTime() {
        return this.wednesdayEndTime;
    }

    public void setWednesdayEndTime(String wednesdayEndTime) {
        this.wednesdayEndTime = wednesdayEndTime;
    }

    public String getThursdayStartTime() {
        return this.thursdayStartTime;
    }

    public void setThursdayStartTime(String thursdayStartTime) {
        this.thursdayStartTime = thursdayStartTime;
    }

    public String getThursdayEndTime() {
        return this.thursdayEndTime;
    }

    public void setThursdayEndTime(String thursdayEndTime) {
        this.thursdayEndTime = thursdayEndTime;
    }

    public String getFridayStartTime() {
        return this.fridayStartTime;
    }

    public void setFridayStartTime(String fridayStartTime) {
        this.fridayStartTime = fridayStartTime;
    }

    public String getFridayEndTime() {
        return this.fridayEndTime;
    }

    public void setFridayEndTime(String fridayEndTime) {
        this.fridayEndTime = fridayEndTime;
    }

    public String getSaturdayStartTime() {
        return this.saturdayStartTime;
    }

    public void setSaturdayStartTime(String saturdayStartTime) {
        this.saturdayStartTime = saturdayStartTime;
    }

    public String getSaturdayEndTime() {
        return this.saturdayEndTime;
    }

    public void setSaturdayEndTime(String saturdayEndTime) {
        this.saturdayEndTime = saturdayEndTime;
    }

    public String getSundayStartTime() {
        return this.sundayStartTime;
    }

    public void setSundayStartTime(String sundayStartTime) {
        this.sundayStartTime = sundayStartTime;
    }

    public String getSundayEndTime() {
        return this.sundayEndTime;
    }

    public void setSundayEndTime(String sundayEndTime) {
        this.sundayEndTime = sundayEndTime;
    }
	
	public String toString() {
		return getName();
	}

	public String getCaption_() {
		return toString();
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
}
