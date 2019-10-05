package com.costco.service;

import com.costco.value.VendorPrice;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface VendorPriceManager extends CommonManager 
{
    public abstract void saveVendorPrice(VendorPrice val);

    public abstract void removeVendorPrice(VendorPrice val);

    public abstract void removeVendorPrice(Long id);

    public abstract VendorPrice getVendorPriceById(Long id);

    public abstract List<VendorPrice> getVendorPriceList();
    public abstract List<Vendor> getVendorList();
}

