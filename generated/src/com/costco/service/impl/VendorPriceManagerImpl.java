package com.costco.service.impl;

import com.costco.service.VendorPriceManager;
import com.costco.dao.VendorPriceDAO;
import com.costco.value.VendorPrice;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class VendorPriceManagerImpl extends CommonManagerImpl implements VendorPriceManager
{

    public VendorPriceManagerImpl()
    {
    }

    public VendorPriceDAO getGenericDAO()
    {
        return (VendorPriceDAO)super.getGenericDAO();
    }

    public void setGenericDAO(VendorPriceDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveVendorPrice(VendorPrice val)
    {
        getGenericDAO().saveVendorPrice(val);
    }

    public void removeVendorPrice(VendorPrice val)
    {
        getGenericDAO().removeVendorPrice(val);
    }

    public void removeVendorPrice(Long id)
    {
        getGenericDAO().removeVendorPrice(id);
    }

    public VendorPrice getVendorPriceById(Long id)
    {
         return getGenericDAO().findVendorPriceById(id);
    }

    public List<VendorPrice> getVendorPriceList()
    {
        return getGenericDAO().findAllVendorPrice();
    }
    public List<Vendor> getVendorList()
    {
        return getGenericDAO().findVendorList();
    }

}

