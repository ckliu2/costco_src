package com.common.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.BaseObject;


public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String school;

    private String department;
   
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



   
}
