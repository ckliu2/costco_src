package com.costco.dao.hibernate;

import com.costco.value.VendorQuantity;
import com.costco.dao.VendorQuantityDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public class VendorQuantityDAOHibernate extends CommonDAOHibernate implements VendorQuantityDAO
{

    public VendorQuantityDAOHibernate()
    {
    }

    public void saveVendorQuantity(VendorQuantity val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeVendorQuantity(VendorQuantity val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeVendorQuantity(Long id)
    {
        VendorQuantity obj = findVendorQuantityById(id);
        getHibernateTemplate().delete(obj);
    }

    public VendorQuantity findVendorQuantityById(Long id)
    {
        if (id == null)
            return null;
        VendorQuantity obj = (VendorQuantity)getHibernateTemplate().get(com.costco.value.VendorQuantity.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.VendorQuantity.class, id);
        else
            return obj;
    }

    public List<VendorQuantity> findAllVendorQuantity()
    {
        return getHibernateTemplate().find("from VendorQuantity");
    }
    public List<Vendor> findVendorList()
    {
        return new ArrayList<Vendor>(); // TODO
    }

    public List<Store> findStoreList()
    {
        return new ArrayList<Store>(); // TODO
    }

}

