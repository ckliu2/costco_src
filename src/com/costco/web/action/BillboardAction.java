package com.costco.web.action;

import com.costco.value.*;
import com.costco.service.CostcoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class BillboardAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Billboard billboard;
    private java.io.File fileCover;
    private String fileCoverContentType, fileCoverFileName, removeCover;
    private Long[] selectedBillboardIds;
    Store store;

	public BillboardAction()
    {
        log = LogFactory.getLog(com.costco.web.action.BillboardAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BILLBOARD");
    }

    public Billboard getBillboard()
    {
        return billboard;
    }

    public void setBillboard(Billboard val)
    {
        billboard = val;
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
        getGenericManager().removeBillboard(billboard.getId());
        return DELETE;
    }

    public String edit()
    {
        if (billboard == null) {
            billboard = new Billboard();
        } else if (billboard.getId() != null) {
            billboard = getGenericManager().getBillboardById(billboard.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBillboardIds != null && selectedBillboardIds.length > 0) {
            Billboard obj = getGenericManager().getBillboardById(selectedBillboardIds[0]);
            obj.setId(null);
            billboard = obj;
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
            if (inputValidation(billboard) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Billboard val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBillboard(billboard);
        saveFileToLocal(fileCoverFileName, fileCover, getTextWithArgs("billboard.uploadCover.dir"), billboard.getId());
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
        billboard.setSize(getAppPropertyById(billboard.getSizeId())); 
        if (getRemoveCover() != null && getRemoveCover().length() > 0) {
            billboard.setCover(computeUploadedFile(fileCoverFileName, fileCover)); 
            removeUploadedFile(getTextWithArgs("billboard.uploadCover.dir"), billboard.getCoverId(), billboard.getCoverFileName());
        } else {
            if (billboard.getCoverId() != null)
                billboard.setCover(getGenericManager().getUploadedFileById(billboard.getCoverId())); 
            else
                billboard.setCover(computeUploadedFile(fileCoverFileName, fileCover)); 
        }
        billboard.setStore(getGenericManager().getStoreById(billboard.getStoreId())); 
        log.info("exit formToBean()");
    }
    
    public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
    public void setFileCover(java.io.File val)
    {
        fileCover = val;
    }

    public java.io.File getFileCover()
    {
        return fileCover;
    }

    public void setFileCoverContentType(String val)
    {
        fileCoverContentType = val;
    }

    public String getFileCoverContentType()
    {
        return fileCoverContentType;
    }

    public void setFileCoverFileName(String val)
    {
        fileCoverFileName = val;
    }

    public String getFileCoverFileName()
    {
        return fileCoverFileName;
    }

    public void setRemoveCover(String val)
    {
        removeCover = val;
    }

    public String getRemoveCover()
    {
        return removeCover;
    }

    public List<Store> getStoreList()
    {
        return getGenericManager().getStoreList(); // TODO
    }

    public List<Billboard> getBillboardList()
    {
    	store = getGenericManager().getStoreById(store.getId());
        return getGenericManager().getBillboardList(store);
    }

    public void setSelectedBillboardIds(Long[] val)
    {
        selectedBillboardIds = val;
    }

    public Long[] getSelectedBillboardIds()
    {
        return selectedBillboardIds;
    }
}
