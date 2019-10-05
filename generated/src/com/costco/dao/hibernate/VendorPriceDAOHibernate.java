package com.costco.dao.hibernate;

import com.costco.value.VendorPrice;
import com.costco.dao.VendorPriceDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class VendorPriceDAOHibernate extends CommonDAOHibernate implements VendorPriceDAO
{

    public VendorPriceDAOHibernate()
    {
    }

    public void saveVendorPrice(VendorPrice val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeVendorPrice(VendorPrice val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeVendorPrice(Long id)
    {
        VendorPrice obj = findVendorPriceById(id);
        getHibernateTemplate().delete(obj);
    }

    public VendorPrice findVendorPriceById(Long id)
    {
        if (id == null)
            return null;
        VendorPrice obj = (VendorPrice)getHibernateTemplate().get(com.costco.value.VendorPrice.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.VendorPrice.class, id);
        else
            return obj;
    }

    public List<VendorPrice> findAllVendorPrice()
    {
        return getHibernateTemplate().find("from VendorPrice");
    }
    public List<Vendor> findVendorList()
    {
        return new ArrayList<Vendor>(); // TODO
    }

}

