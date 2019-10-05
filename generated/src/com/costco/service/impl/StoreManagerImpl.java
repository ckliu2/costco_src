package com.costco.service.impl;

import com.costco.service.StoreManager;
import com.costco.dao.StoreDAO;
import com.costco.value.Store;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public class StoreManagerImpl extends CommonManagerImpl implements StoreManager
{

    public StoreManagerImpl()
    {
    }

    public StoreDAO getGenericDAO()
    {
        return (StoreDAO)super.getGenericDAO();
    }

    public void setGenericDAO(StoreDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveStore(Store val)
    {
        getGenericDAO().saveStore(val);
    }

    public void removeStore(Store val)
    {
        getGenericDAO().removeStore(val);
    }

    public void removeStore(Long id)
    {
        getGenericDAO().removeStore(id);
    }

    public Store getStoreById(Long id)
    {
         return getGenericDAO().findStoreById(id);
    }

    public List<Store> getStoreList()
    {
        return getGenericDAO().findAllStore();
    }
}

