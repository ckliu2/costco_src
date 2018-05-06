package com.common.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Unit extends BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;

	/** persistent field */
	private String name;

	/** nullable persistent field */
	private Set members;

	
	/** default constructor */
	public Unit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/** minimal constructor */
	public Unit(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getMembers() {
		return this.members;
	}

	public void setMembers(Set members) {
		this.members = members;
	}

	public String toString() {
		return getName();
	}

	public String getCaption_() {
		return toString();
	}

}
