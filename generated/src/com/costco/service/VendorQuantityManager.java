package com.costco.service;

import com.costco.value.VendorQuantity;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface VendorQuantityManager extends CommonManager 
{
    public abstract void saveVendorQuantity(VendorQuantity val);

    public abstract void removeVendorQuantity(VendorQuantity val);

    public abstract void removeVendorQuantity(Long id);

    public abstract VendorQuantity getVendorQuantityById(Long id);

    public abstract List<VendorQuantity> getVendorQuantityList();
    public abstract List<Vendor> getVendorList();
    public abstract List<Store> getStoreList();
}

