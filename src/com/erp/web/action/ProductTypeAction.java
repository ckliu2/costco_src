package com.erp.web.action;

import com.erp.value.ProductType;
import com.erp.service.ERPManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue May 23 23:20:29 CST 2017
*/

public class ProductTypeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ProductType productType;
    private Long[] selectedProductTypeIds;

    public ProductTypeAction()
    {
        log = LogFactory.getLog(com.erp.web.action.ProductTypeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRODUCTTYPE");
    }

    public ProductType getProductType()
    {
        return productType;
    }

    public void setProductType(ProductType val)
    {
        productType = val;
    }

    public void setGenericManager(ERPManager m)
    {
        super.setGenericManager(m);
    }

    public ERPManager getGenericManager()
    {
        return (ERPManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeProductType(productType.getId());
        return DELETE;
    }

    public String edit()
    {
        if (productType == null) {
            productType = new ProductType();
        } else if (productType.getId() != null) {
            productType = getGenericManager().getProductTypeById(productType.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedProductTypeIds != null && selectedProductTypeIds.length > 0) {
            ProductType obj = getGenericManager().getProductTypeById(selectedProductTypeIds[0]);
            obj.setId(null);
            productType = obj;
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
            if (inputValidation(productType) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ProductType val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveProductType(productType);
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
    public List<ProductType> getProductTypeList()
    {
        return getGenericManager().getProductTypeList();
    }

    public void setSelectedProductTypeIds(Long[] val)
    {
        selectedProductTypeIds = val;
    }

    public Long[] getSelectedProductTypeIds()
    {
        return selectedProductTypeIds;
    }
}
