package com.costco.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Store extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String address;

    /** nullable persistent field */
    private String contact;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String phone;

    /** nullable persistent field */
    private String no;

    /** nullable persistent field */
    private String deptNo;

    /** nullable persistent field */
    private String product1;

    /** nullable persistent field */
    private String product2;

    /** nullable persistent field */
    private String product3;

    /** nullable persistent field */
    private String product4;

    /** nullable persistent field */
    private String product5;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** full constructor */
    public Store(String name, String address, String contact, String title, String phone, String no, String deptNo, String product1, String product2, String product3, String product4, String product5, Date lastModifiedDate, Date createdDate) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.title = title;
        this.phone = phone;
        this.no = no;
        this.deptNo = deptNo;
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
        this.product4 = product4;
        this.product5 = product5;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    /** default constructor */
    public Store() {
    }

    /** minimal constructor */
    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDeptNo() {
        return this.deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getProduct1() {
        return this.product1;
    }

    public void setProduct1(String product1) {
        this.product1 = product1;
    }

    public String getProduct2() {
        return this.product2;
    }

    public void setProduct2(String product2) {
        this.product2 = product2;
    }

    public String getProduct3() {
        return this.product3;
    }

    public void setProduct3(String product3) {
        this.product3 = product3;
    }

    public String getProduct4() {
        return this.product4;
    }

    public void setProduct4(String product4) {
        this.product4 = product4;
    }

    public String getProduct5() {
        return this.product5;
    }

    public void setProduct5(String product5) {
        this.product5 = product5;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("address", getAddress())
            .append("contact", getContact())
            .append("title", getTitle())
            .append("phone", getPhone())
            .append("no", getNo())
            .append("deptNo", getDeptNo())
            .append("product1", getProduct1())
            .append("product2", getProduct2())
            .append("product3", getProduct3())
            .append("product4", getProduct4())
            .append("product5", getProduct5())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
