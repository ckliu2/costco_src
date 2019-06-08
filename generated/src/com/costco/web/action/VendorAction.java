package com.costco.web.action;

import com.costco.value.Vendor;
import com.costco.service.VendorManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 08 17:31:21 CST 2019
*/

public class VendorAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Vendor vendor;
    private Long[] selectedVendorIds;

    public VendorAction()
    {
        log = LogFactory.getLog(com.costco.web.action.VendorAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("VENDOR");
    }

    public Vendor getVendor()
    {
        return vendor;
    }

    public void setVendor(Vendor val)
    {
        vendor = val;
    }

    public void setGenericManager(VendorManager m)
    {
        super.setGenericManager(m);
    }

    public VendorManager getGenericManager()
    {
        return (VendorManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeVendor(vendor.getId());
        return DELETE;
    }

    public String edit()
    {
        if (vendor == null) {
            vendor = new Vendor();
        } else if (vendor.getId() != null) {
            vendor = getGenericManager().getVendorById(vendor.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedVendorIds != null && selectedVendorIds.length > 0) {
            Vendor obj = getGenericManager().getVendorById(selectedVendorIds[0]);
            obj.setId(null);
            vendor = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(vendor) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Vendor val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (vendor.getId() == null) {
            vendor.setCreatedDate(ts);
            vendor.setCreatedUser(getSessionUser().getLoginId());
        }
        vendor.setLastModifiedDate(ts);
        vendor.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveVendor(vendor);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        log.info("exit formToBean()");
    }
    public List<Vendor> getVendorList()
    {
        return getGenericManager().getVendorList();
    }

    public void setSelectedVendorIds(Long[] val)
    {
        selectedVendorIds = val;
    }

    public Long[] getSelectedVendorIds()
    {
        return selectedVendorIds;
    }
}
