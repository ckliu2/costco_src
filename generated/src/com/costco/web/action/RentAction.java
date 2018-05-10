package com.costco.web.action;

import com.costco.value.Rent;
import com.costco.service.RentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 07 22:10:24 CST 2018
*/

public class RentAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Rent rent;
    private java.io.File fileCover;
    private String fileCoverContentType, fileCoverFileName, removeCover;
    private Long[] selectedRentIds;

    public RentAction()
    {
        log = LogFactory.getLog(com.costco.web.action.RentAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("RENT");
    }

    public Rent getRent()
    {
        return rent;
    }

    public void setRent(Rent val)
    {
        rent = val;
    }

    public void setGenericManager(RentManager m)
    {
        super.setGenericManager(m);
    }

    public RentManager getGenericManager()
    {
        return (RentManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeRent(rent.getId());
        return DELETE;
    }

    public String edit()
    {
        if (rent == null) {
            rent = new Rent();
        } else if (rent.getId() != null) {
            rent = getGenericManager().getRentById(rent.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRentIds != null && selectedRentIds.length > 0) {
            Rent obj = getGenericManager().getRentById(selectedRentIds[0]);
            obj.setId(null);
            rent = obj;
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
            if (inputValidation(rent) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Rent val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (rent.getId() == null) {
            rent.setCreatedDate(ts);
            rent.setCreatedUser(getSessionUser().getLoginId());
        }
        rent.setLastModifiedDate(ts);
        rent.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveRent(rent);
        saveFileToLocal(fileCoverFileName, fileCover, getTextWithArgs("rent.uploadCover.dir"), rent.getId());
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
        rent.setBillboard(getGenericManager().getBillboardById(rent.getBillboardId())); 
        rent.setVendor(getGenericManager().getVendorById(rent.getVendorId())); 
        if (getRemoveCover() != null && getRemoveCover().length() > 0) {
            rent.setCover(computeUploadedFile(fileCoverFileName, fileCover)); 
            removeUploadedFile(getTextWithArgs("rent.uploadCover.dir"), rent.getCoverId(), rent.getCoverFileName());
        } else {
            if (rent.getCoverId() != null)
                rent.setCover(getGenericManager().getUploadedFileById(rent.getCoverId())); 
            else
                rent.setCover(computeUploadedFile(fileCoverFileName, fileCover)); 
        }
        log.info("exit formToBean()");
    }
    public List<Billboard> getBillboardList()
    {
        return getGenericManager().getBillboardList(); // TODO
    }

    public List<Vendor> getVendorList()
    {
        return getGenericManager().getVendorList(); // TODO
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

    public List<Rent> getRentList()
    {
        return getGenericManager().getRentList();
    }

    public void setSelectedRentIds(Long[] val)
    {
        selectedRentIds = val;
    }

    public Long[] getSelectedRentIds()
    {
        return selectedRentIds;
    }
}
