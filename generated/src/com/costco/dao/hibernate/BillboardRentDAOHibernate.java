package com.costco.dao.hibernate;

import com.costco.value.BillboardRent;
import com.costco.dao.BillboardRentDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class BillboardRentDAOHibernate extends CommonDAOHibernate implements BillboardRentDAO
{

    public BillboardRentDAOHibernate()
    {
    }

    public void saveBillboardRent(BillboardRent val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillboardRent(BillboardRent val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillboardRent(Long id)
    {
        BillboardRent obj = findBillboardRentById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillboardRent findBillboardRentById(Long id)
    {
        if (id == null)
            return null;
        BillboardRent obj = (BillboardRent)getHibernateTemplate().get(com.costco.value.BillboardRent.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.BillboardRent.class, id);
        else
            return obj;
    }

    public List<BillboardRent> findAllBillboardRent()
    {
        return getHibernateTemplate().find("from BillboardRent");
    }
    public List<Rent> findRentList()
    {
        return new ArrayList<Rent>(); // TODO
    }

    public List<Store> findStoreList()
    {
        return new ArrayList<Store>(); // TODO
    }

    public List<Billboard> findBillboardList()
    {
        return new ArrayList<Billboard>(); // TODO
    }

    public List<Vendor> findVendorList()
    {
        return new ArrayList<Vendor>(); // TODO
    }

}

