package com.costco.service.impl;

import com.costco.service.RentManager;
import com.costco.dao.RentDAO;
import com.costco.value.Rent;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 07 22:10:24 CST 2018
*/

public class RentManagerImpl extends CommonManagerImpl implements RentManager
{

    public RentManagerImpl()
    {
    }

    public RentDAO getGenericDAO()
    {
        return (RentDAO)super.getGenericDAO();
    }

    public void setGenericDAO(RentDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveRent(Rent val)
    {
        getGenericDAO().saveRent(val);
    }

    public void removeRent(Rent val)
    {
        getGenericDAO().removeRent(val);
    }

    public void removeRent(Long id)
    {
        getGenericDAO().removeRent(id);
    }

    public Rent getRentById(Long id)
    {
         return getGenericDAO().findRentById(id);
    }

    public List<Rent> getRentList()
    {
        return getGenericDAO().findAllRent();
    }
    public List<Billboard> getBillboardList()
    {
        return getGenericDAO().findBillboardList();
    }

    public List<Vendor> getVendorList()
    {
        return getGenericDAO().findVendorList();
    }

    public List<UploadedFile> getCoverList()
    {
        return getGenericDAO().findCoverList();
    }

    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

