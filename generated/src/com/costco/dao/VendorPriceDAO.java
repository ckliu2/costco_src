package com.costco.dao;

import com.costco.value.VendorPrice;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface VendorPriceDAO extends CommonDAO 
{
    public abstract void saveVendorPrice(VendorPrice val);

    public abstract void removeVendorPrice(VendorPrice val);

    public abstract void removeVendorPrice(Long id);

    public abstract VendorPrice findVendorPriceById(Long id);

    public abstract List<VendorPrice> findAllVendorPrice();
    public abstract List<Vendor> findVendorList();
}

