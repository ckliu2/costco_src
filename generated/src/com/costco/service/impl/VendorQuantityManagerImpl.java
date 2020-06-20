package com.costco.service.impl;

import com.costco.service.VendorQuantityManager;
import com.costco.dao.VendorQuantityDAO;
import com.costco.value.VendorQuantity;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public class VendorQuantityManagerImpl extends CommonManagerImpl implements VendorQuantityManager
{

    public VendorQuantityManagerImpl()
    {
    }

    public VendorQuantityDAO getGenericDAO()
    {
        return (VendorQuantityDAO)super.getGenericDAO();
    }

    public void setGenericDAO(VendorQuantityDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveVendorQuantity(VendorQuantity val)
    {
        getGenericDAO().saveVendorQuantity(val);
    }

    public void removeVendorQuantity(VendorQuantity val)
    {
        getGenericDAO().removeVendorQuantity(val);
    }

    public void removeVendorQuantity(Long id)
    {
        getGenericDAO().removeVendorQuantity(id);
    }

    public VendorQuantity getVendorQuantityById(Long id)
    {
         return getGenericDAO().findVendorQuantityById(id);
    }

    public List<VendorQuantity> getVendorQuantityList()
    {
        return getGenericDAO().findAllVendorQuantity();
    }
    public List<Vendor> getVendorList()
    {
        return getGenericDAO().findVendorList();
    }

    public List<Store> getStoreList()
    {
        return getGenericDAO().findStoreList();
    }

}

