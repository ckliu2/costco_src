package com.costco.dao.hibernate;

import com.costco.value.Rent;
import com.costco.dao.RentDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 08 17:31:21 CST 2019
*/

public class RentDAOHibernate extends CommonDAOHibernate implements RentDAO
{

    public RentDAOHibernate()
    {
    }

    public void saveRent(Rent val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRent(Rent val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRent(Long id)
    {
        Rent obj = findRentById(id);
        getHibernateTemplate().delete(obj);
    }

    public Rent findRentById(Long id)
    {
        if (id == null)
            return null;
        Rent obj = (Rent)getHibernateTemplate().get(com.costco.value.Rent.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.Rent.class, id);
        else
            return obj;
    }

    public List<Rent> findAllRent()
    {
        return getHibernateTemplate().find("from Rent");
    }
    public List<Billboard> findBillboardList()
    {
        return new ArrayList<Billboard>(); // TODO
    }

    public List<Vendor> findVendorList()
    {
        return new ArrayList<Vendor>(); // TODO
    }

    public List<UploadedFile> findPhotoList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findCoverList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

