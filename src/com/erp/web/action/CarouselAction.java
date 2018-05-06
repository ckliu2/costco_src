package com.erp.web.action;

import com.erp.value.*;
import com.erp.service.ERPManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;


public class CarouselAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Carousel carousel;
    private Long[] selectedCarouselIds;
    private java.io.File filePhoto;
    private String filePhotoContentType, filePhotoFileName, removePhoto;

    public CarouselAction()
    {
        log = LogFactory.getLog(com.erp.web.action.CarouselAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CAROUSEL");
    }

    public Carousel getCarousel()
    {
        return carousel;
    }

    public void setCarousel(Carousel val)
    {
        carousel = val;
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
        getGenericManager().removeCarousel(carousel.getId());
        return DELETE;
    }

    public String edit()
    {
        if (carousel == null) {
            carousel = new Carousel();
        } else if (carousel.getId() != null) {
            carousel = getGenericManager().getCarouselById(carousel.getId());
        } else { // TODO
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
            if (inputValidation(carousel) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Carousel val)
    {
        return true;
    }

    public String save()
    {      
        getGenericManager().saveCarousel(carousel);
        saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("carousel.uploadPhoto.dir"), carousel.getId());
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
        if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
            carousel.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
            removeUploadedFile(getTextWithArgs("carousel.uploadPhoto.dir"), carousel.getPhotoId(), carousel.getPhotoFileName());
        } else {
            if (carousel.getPhotoId() != null)
                carousel.setPhoto(getGenericManager().getUploadedFileById(carousel.getPhotoId())); 
            else
                carousel.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
        }
        carousel.setType(getAppPropertyById(carousel.getTypeId())); 
        log.info("exit formToBean()");
    }
    
    public void setFilePhoto(java.io.File val)
    {
        filePhoto = val;
    }

    public java.io.File getFilePhoto()
    {
        return filePhoto;
    }

    public void setFilePhotoContentType(String val)
    {
        filePhotoContentType = val;
    }

    public String getFilePhotoContentType()
    {
        return filePhotoContentType;
    }

    public void setFilePhotoFileName(String val)
    {
        filePhotoFileName = val;
    }

    public String getFilePhotoFileName()
    {
        return filePhotoFileName;
    }

    public void setRemovePhoto(String val)
    {
        removePhoto = val;
    }

    public String getRemovePhoto()
    {
        return removePhoto;
    }
    
    public List<Carousel> getList()
    {
    	AppProperty type = null;
        return getGenericManager().getCarouselList(type);
    }
    
       

    public void setSelectedCarouselIds(Long[] val)
    {
        selectedCarouselIds = val;
    }

    public Long[] getSelectedCarouselIds()
    {
        return selectedCarouselIds;
    }
}
