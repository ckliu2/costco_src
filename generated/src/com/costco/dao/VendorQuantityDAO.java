package com.costco.dao;

import com.costco.value.VendorQuantity;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface VendorQuantityDAO extends CommonDAO 
{
    public abstract void saveVendorQuantity(VendorQuantity val);

    public abstract void removeVendorQuantity(VendorQuantity val);

    public abstract void removeVendorQuantity(Long id);

    public abstract VendorQuantity findVendorQuantityById(Long id);

    public abstract List<VendorQuantity> findAllVendorQuantity();
    public abstract List<Vendor> findVendorList();
    public abstract List<Store> findStoreList();
}

