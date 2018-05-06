package com.base.value;

import java.io.Serializable;
import java.util.*;

import com.common.value.*;

import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SessionUser implements Serializable {
	private static final long serialVersionUID = 100L;

	/** nullable persistent field */
	private Long id;

	/** nullable persistent field */
	private String loginId;

	/** nullable persistent field */
	private String name;

	/** nullable persistent field */
	private String cellphone;

	/** nullable persistent field */
	private Boolean enabled;

	boolean admin;

	private String picture;

	private Date lastLoginTime;

	private String menuStr;

	private String misc;

	private Set<Group> role;

	private Long unitId;

	/** nullable persistent field */
	private String ip;

	/** nullable persistent field */
	private Member member;

	public SessionUser(Long id, String id2, String name, String picture,
			Boolean enabled, List role) {
		super();
		this.id = id;
		this.loginId = id2;
		this.name = name;
		this.enabled = enabled;
		this.picture = picture;
	}

	public SessionUser(Long id, String id2, String name, String picture,
			Boolean enabled) {
		super();
		this.id = id;
		this.loginId = id2;
		this.name = name;
		this.enabled = enabled;
		this.picture = picture;
	}

	public SessionUser(String id2, String name, String picture, Boolean enabled) {
		super();
		this.loginId = id2;
		this.name = name;
		this.enabled = enabled;
		this.picture = picture;
	}

	public SessionUser() {

	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMenuStr() {
		return menuStr;
	}

	public void setMenuStr(String menuStr) {
		this.menuStr = menuStr;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId())
				.append("loginId", getLoginId()).append("name", getName())
				.append("picture", getPicture())
				.append("lastLoginTime", getLastLoginTime()).toString();
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public Set<Group> getRole() {
		return role;
	}

	public void setRole(Set<Group> role) {
		this.role = role;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
