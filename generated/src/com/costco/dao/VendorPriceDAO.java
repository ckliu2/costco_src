package com.costco.dao;

import com.costco.value.VendorPrice;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
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

