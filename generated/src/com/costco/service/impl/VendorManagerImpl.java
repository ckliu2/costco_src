package com.costco.service.impl;

import com.costco.service.VendorManager;
import com.costco.dao.VendorDAO;
import com.costco.value.Vendor;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 14 20:54:08 CST 2018
*/

public class VendorManagerImpl extends CommonManagerImpl implements VendorManager
{

    public VendorManagerImpl()
    {
    }

    public VendorDAO getGenericDAO()
    {
        return (VendorDAO)super.getGenericDAO();
    }

    public void setGenericDAO(VendorDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveVendor(Vendor val)
    {
        getGenericDAO().saveVendor(val);
    }

    public void removeVendor(Vendor val)
    {
        getGenericDAO().removeVendor(val);
    }

    public void removeVendor(Long id)
    {
        getGenericDAO().removeVendor(id);
    }

    public Vendor getVendorById(Long id)
    {
         return getGenericDAO().findVendorById(id);
    }

    public List<Vendor> getVendorList()
    {
        return getGenericDAO().findAllVendor();
    }
}

