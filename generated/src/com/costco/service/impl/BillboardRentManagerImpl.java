package com.costco.service.impl;

import com.costco.service.BillboardRentManager;
import com.costco.dao.BillboardRentDAO;
import com.costco.value.BillboardRent;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public class BillboardRentManagerImpl extends CommonManagerImpl implements BillboardRentManager
{

    public BillboardRentManagerImpl()
    {
    }

    public BillboardRentDAO getGenericDAO()
    {
        return (BillboardRentDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillboardRentDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillboardRent(BillboardRent val)
    {
        getGenericDAO().saveBillboardRent(val);
    }

    public void removeBillboardRent(BillboardRent val)
    {
        getGenericDAO().removeBillboardRent(val);
    }

    public void removeBillboardRent(Long id)
    {
        getGenericDAO().removeBillboardRent(id);
    }

    public BillboardRent getBillboardRentById(Long id)
    {
         return getGenericDAO().findBillboardRentById(id);
    }

    public List<BillboardRent> getBillboardRentList()
    {
        return getGenericDAO().findAllBillboardRent();
    }
    public List<Rent> getRentList()
    {
        return getGenericDAO().findRentList();
    }

    public List<Store> getStoreList()
    {
        return getGenericDAO().findStoreList();
    }

    public List<Billboard> getBillboardList()
    {
        return getGenericDAO().findBillboardList();
    }

    public List<Vendor> getVendorList()
    {
        return getGenericDAO().findVendorList();
    }

}

