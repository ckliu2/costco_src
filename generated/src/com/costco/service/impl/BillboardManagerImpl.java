package com.costco.service.impl;

import com.costco.service.BillboardManager;
import com.costco.dao.BillboardDAO;
import com.costco.value.Billboard;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public class BillboardManagerImpl extends CommonManagerImpl implements BillboardManager
{

    public BillboardManagerImpl()
    {
    }

    public BillboardDAO getGenericDAO()
    {
        return (BillboardDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillboardDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillboard(Billboard val)
    {
        getGenericDAO().saveBillboard(val);
    }

    public void removeBillboard(Billboard val)
    {
        getGenericDAO().removeBillboard(val);
    }

    public void removeBillboard(Long id)
    {
        getGenericDAO().removeBillboard(id);
    }

    public Billboard getBillboardById(Long id)
    {
         return getGenericDAO().findBillboardById(id);
    }

    public List<Billboard> getBillboardList()
    {
        return getGenericDAO().findAllBillboard();
    }
    public List<UploadedFile> getCoverList()
    {
        return getGenericDAO().findCoverList();
    }

    public List<Store> getStoreList()
    {
        return getGenericDAO().findStoreList();
    }

    public List<UploadedFile> getLocation1List()
    {
        return getGenericDAO().findLocation1List();
    }

    public List<UploadedFile> getLocation2List()
    {
        return getGenericDAO().findLocation2List();
    }

    public List<UploadedFile> getLocation3List()
    {
        return getGenericDAO().findLocation3List();
    }

}

