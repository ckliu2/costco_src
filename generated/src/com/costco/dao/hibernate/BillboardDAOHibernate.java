package com.costco.dao.hibernate;

import com.costco.value.Billboard;
import com.costco.dao.BillboardDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class BillboardDAOHibernate extends CommonDAOHibernate implements BillboardDAO
{

    public BillboardDAOHibernate()
    {
    }

    public void saveBillboard(Billboard val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillboard(Billboard val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillboard(Long id)
    {
        Billboard obj = findBillboardById(id);
        getHibernateTemplate().delete(obj);
    }

    public Billboard findBillboardById(Long id)
    {
        if (id == null)
            return null;
        Billboard obj = (Billboard)getHibernateTemplate().get(com.costco.value.Billboard.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.Billboard.class, id);
        else
            return obj;
    }

    public List<Billboard> findAllBillboard()
    {
        return getHibernateTemplate().find("from Billboard");
    }
    public List<UploadedFile> findCoverList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<Store> findStoreList()
    {
        return new ArrayList<Store>(); // TODO
    }

    public List<UploadedFile> findLocation1List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findLocation2List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findLocation3List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

}

