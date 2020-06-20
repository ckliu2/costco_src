package com.costco.web.action;

import com.costco.value.BillboardRent;
import com.costco.service.BillboardRentManager;
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

public class BillboardRentAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BillboardRent billboardRent;
    private Long[] selectedBillboardRentIds;

    public BillboardRentAction()
    {
        log = LogFactory.getLog(com.costco.web.action.BillboardRentAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLBOARDRENT");
    }

    public BillboardRent getBillboardRent()
    {
        return billboardRent;
    }

    public void setBillboardRent(BillboardRent val)
    {
        billboardRent = val;
    }

    public void setGenericManager(BillboardRentManager m)
    {
        super.setGenericManager(m);
    }

    public BillboardRentManager getGenericManager()
    {
        return (BillboardRentManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBillboardRent(billboardRent.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billboardRent == null) {
            billboardRent = new BillboardRent();
        } else if (billboardRent.getId() != null) {
            billboardRent = getGenericManager().getBillboardRentById(billboardRent.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillboardRentIds != null && selectedBillboardRentIds.length > 0) {
            BillboardRent obj = getGenericManager().getBillboardRentById(selectedBillboardRentIds[0]);
            obj.setId(null);
            billboardRent = obj;
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
            if (inputValidation(billboardRent) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BillboardRent val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillboardRent(billboardRent);
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
        billboardRent.setRent(getGenericManager().getRentById(billboardRent.getRentId())); 
        billboardRent.setStore(getGenericManager().getStoreById(billboardRent.getStoreId())); 
        billboardRent.setBillboard(getGenericManager().getBillboardById(billboardRent.getBillboardId())); 
        billboardRent.setVendor(getGenericManager().getVendorById(billboardRent.getVendorId())); 
        log.info("exit formToBean()");
    }
    public List<Rent> getRentList()
    {
        return getGenericManager().getRentList(); // TODO
    }

    public List<Store> getStoreList()
    {
        return getGenericManager().getStoreList(); // TODO
    }

    public List<Billboard> getBillboardList()
    {
        return getGenericManager().getBillboardList(); // TODO
    }

    public List<Vendor> getVendorList()
    {
        return getGenericManager().getVendorList(); // TODO
    }

    public List<BillboardRent> getBillboardRentList()
    {
        return getGenericManager().getBillboardRentList();
    }

    public void setSelectedBillboardRentIds(Long[] val)
    {
        selectedBillboardRentIds = val;
    }

    public Long[] getSelectedBillboardRentIds()
    {
        return selectedBillboardRentIds;
    }
}
