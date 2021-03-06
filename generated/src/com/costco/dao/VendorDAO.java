package com.costco.dao;

import com.costco.value.Vendor;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface VendorDAO extends CommonDAO 
{
    public abstract void saveVendor(Vendor val);

    public abstract void removeVendor(Vendor val);

    public abstract void removeVendor(Long id);

    public abstract Vendor findVendorById(Long id);

    public abstract List<Vendor> findAllVendor();
}

