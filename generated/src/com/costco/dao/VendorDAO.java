package com.costco.dao;

import com.costco.value.Vendor;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 08 17:31:21 CST 2019
*/

public interface VendorDAO extends CommonDAO 
{
    public abstract void saveVendor(Vendor val);

    public abstract void removeVendor(Vendor val);

    public abstract void removeVendor(Long id);

    public abstract Vendor findVendorById(Long id);

    public abstract List<Vendor> findAllVendor();
}

