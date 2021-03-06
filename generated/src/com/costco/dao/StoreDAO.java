package com.costco.dao;

import com.costco.value.Store;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface StoreDAO extends CommonDAO 
{
    public abstract void saveStore(Store val);

    public abstract void removeStore(Store val);

    public abstract void removeStore(Long id);

    public abstract Store findStoreById(Long id);

    public abstract List<Store> findAllStore();
}

