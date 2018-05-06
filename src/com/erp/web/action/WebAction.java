package com.erp.web.action;

import com.erp.value.*;
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
    Created Date: Sat Aug 12 13:27:19 CST 2017
*/

public class WebAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Web web;
    private Long[] selectedWebIds;

    public WebAction()
    {
        log = LogFactory.getLog(com.erp.web.action.WebAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEB");
    }

    public Web getWeb()
    {
        return web;
    }

    public void setWeb(Web val)
    {
        web = val;
    }

    public void setGenericManager(ERPManager m)
    {
        super.setGenericManager(m);
    }

    public ERPManager getGenericManager()
    {
        return (ERPManager) super.getGenericManager();
    }

   
    public String edit()
    {
        if (web == null) {
            web = new Web();
        } else if (web.getId() != null) {
            web = getGenericManager().getWebById(web.getId());
        } else { // TODO
        }
        return SUCCESS;
    }

    

    public String execute()
    {
    	
        return SUCCESS;
    }

    
    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWeb(web);
        appendXworkParam("web.id="+web.getId());
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

   
    public Web getWebById()
    {
        return getGenericManager().getWebById(web.getId());
    }

    public void setSelectedWebIds(Long[] val)
    {
        selectedWebIds = val;
    }

    public Long[] getSelectedWebIds()
    {
        return selectedWebIds;
    }
}
