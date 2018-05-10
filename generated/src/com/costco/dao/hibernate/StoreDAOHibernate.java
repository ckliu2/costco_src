package com.costco.dao.hibernate;

import com.costco.value.Store;
import com.costco.dao.StoreDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 07 22:10:24 CST 2018
*/

public class StoreDAOHibernate extends CommonDAOHibernate implements StoreDAO
{

    public StoreDAOHibernate()
    {
    }

    public void saveStore(Store val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeStore(Store val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeStore(Long id)
    {
        Store obj = findStoreById(id);
        getHibernateTemplate().delete(obj);
    }

    public Store findStoreById(Long id)
    {
        if (id == null)
            return null;
        Store obj = (Store)getHibernateTemplate().get(com.costco.value.Store.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.costco.value.Store.class, id);
        else
            return obj;
    }

    public List<Store> findAllStore()
    {
        return getHibernateTemplate().find("from Store");
    }
}

