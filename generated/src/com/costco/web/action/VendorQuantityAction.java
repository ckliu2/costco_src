package com.costco.web.action;

import com.costco.value.VendorQuantity;
import com.costco.service.VendorQuantityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public class VendorQuantityAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private VendorQuantity vendorQuantity;
    private Long[] selectedVendorQuantityIds;

    public VendorQuantityAction()
    {
        log = LogFactory.getLog(com.costco.web.action.VendorQuantityAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("VENDORQUANTITY");
    }

    public VendorQuantity getVendorQuantity()
    {
        return vendorQuantity;
    }

    public void setVendorQuantity(VendorQuantity val)
    {
        vendorQuantity = val;
    }

    public void setGenericManager(VendorQuantityManager m)
    {
        super.setGenericManager(m);
    }

    public VendorQuantityManager getGenericManager()
    {
        return (VendorQuantityManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeVendorQuantity(vendorQuantity.getId());
        return DELETE;
    }

    public String edit()
    {
        if (vendorQuantity == null) {
            vendorQuantity = new VendorQuantity();
        } else if (vendorQuantity.getId() != null) {
            vendorQuantity = getGenericManager().getVendorQuantityById(vendorQuantity.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedVendorQuantityIds != null && selectedVendorQuantityIds.length > 0) {
            VendorQuantity obj = getGenericManager().getVendorQuantityById(selectedVendorQuantityIds[0]);
            obj.setId(null);
            vendorQuantity = obj;
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
            if (inputValidation(vendorQuantity) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(VendorQuantity val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveVendorQuantity(vendorQuantity);
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
        vendorQuantity.setVendor(getGenericManager().getVendorById(vendorQuantity.getVendorId())); 
        vendorQuantity.setStore(getGenericManager().getStoreById(vendorQuantity.getStoreId())); 
        log.info("exit formToBean()");
    }
    public List<Vendor> getVendorList()
    {
        return getGenericManager().getVendorList(); // TODO
    }

    public List<Store> getStoreList()
    {
        return getGenericManager().getStoreList(); // TODO
    }

    public List<VendorQuantity> getVendorQuantityList()
    {
        return getGenericManager().getVendorQuantityList();
    }

    public void setSelectedVendorQuantityIds(Long[] val)
    {
        selectedVendorQuantityIds = val;
    }

    public Long[] getSelectedVendorQuantityIds()
    {
        return selectedVendorQuantityIds;
    }
}
