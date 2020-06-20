package com.costco.web.action;

import com.costco.value.VendorPrice;
import com.costco.service.VendorPriceManager;
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

public class VendorPriceAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private VendorPrice vendorPrice;
    private Long[] selectedVendorPriceIds;

    public VendorPriceAction()
    {
        log = LogFactory.getLog(com.costco.web.action.VendorPriceAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("VENDORPRICE");
    }

    public VendorPrice getVendorPrice()
    {
        return vendorPrice;
    }

    public void setVendorPrice(VendorPrice val)
    {
        vendorPrice = val;
    }

    public void setGenericManager(VendorPriceManager m)
    {
        super.setGenericManager(m);
    }

    public VendorPriceManager getGenericManager()
    {
        return (VendorPriceManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeVendorPrice(vendorPrice.getId());
        return DELETE;
    }

    public String edit()
    {
        if (vendorPrice == null) {
            vendorPrice = new VendorPrice();
        } else if (vendorPrice.getId() != null) {
            vendorPrice = getGenericManager().getVendorPriceById(vendorPrice.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedVendorPriceIds != null && selectedVendorPriceIds.length > 0) {
            VendorPrice obj = getGenericManager().getVendorPriceById(selectedVendorPriceIds[0]);
            obj.setId(null);
            vendorPrice = obj;
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
            if (inputValidation(vendorPrice) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(VendorPrice val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveVendorPrice(vendorPrice);
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
        vendorPrice.setVendor(getGenericManager().getVendorById(vendorPrice.getVendorId())); 
        log.info("exit formToBean()");
    }
    public List<Vendor> getVendorList()
    {
        return getGenericManager().getVendorList(); // TODO
    }

    public List<VendorPrice> getVendorPriceList()
    {
        return getGenericManager().getVendorPriceList();
    }

    public void setSelectedVendorPriceIds(Long[] val)
    {
        selectedVendorPriceIds = val;
    }

    public Long[] getSelectedVendorPriceIds()
    {
        return selectedVendorPriceIds;
    }
}
