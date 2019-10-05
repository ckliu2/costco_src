package com.costco.dao.hibernate;

import com.costco.value.Vendor;
import com.costco.dao.VendorDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class VendorDAOHibernate extends CommonDAOHibernate implements VendorDAO
{

    public VendorDAOHibernate()
    {
    }

    public void saveVendor(Vendor val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeVendor(Vendor val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeVendor(Long id)
    {
        Vendor obj = findVendorById(id);
        getHibernateTemplate().delete(obj);
    }

    public Vendor findVendorById(Long id)
    {
        if (id == null)
            return null;
        Vendor obj = (Vendor)getHibernateTemplate().get(com.costco.value.Vendor.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.Vendor.class, id);
        else
            return obj;
    }

    public List<Vendor> findAllVendor()
    {
        return getHibernateTemplate().find("from Vendor");
    }
}

