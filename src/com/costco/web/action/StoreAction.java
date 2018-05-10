package com.costco.web.action;

import com.costco.value.*;
import com.costco.service.CostcoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;


public class StoreAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Store store;
    private Long[] selectedStoreIds;

    public StoreAction()
    {
        log = LogFactory.getLog(com.costco.web.action.StoreAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("STORE");
    }

    public Store getStore()
    {
        return store;
    }

    public void setStore(Store val)
    {
        store = val;
    }

    public void setGenericManager(CostcoManager m)
    {
        super.setGenericManager(m);
    }

    public CostcoManager getGenericManager()
    {
        return (CostcoManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeStore(store.getId());
        return DELETE;
    }

    public String edit()
    {
        if (store == null) {
            store = new Store();
        } else if (store.getId() != null) {
            store = getGenericManager().getStoreById(store.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedStoreIds != null && selectedStoreIds.length > 0) {
            Store obj = getGenericManager().getStoreById(selectedStoreIds[0]);
            obj.setId(null);
            store = obj;
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
            if (inputValidation(store) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Store val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (store.getId() == null) {
            store.setCreatedDate(ts);
        }
        store.setLastModifiedDate(ts);
        getGenericManager().saveStore(store);
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
    public List<Store> getStoreList()
    {
        return getGenericManager().getStoreList();
    }

    public void setSelectedStoreIds(Long[] val)
    {
        selectedStoreIds = val;
    }

    public Long[] getSelectedStoreIds()
    {
        return selectedStoreIds;
    }
}
