package com.costco.service;

import com.costco.value.Vendor;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 14 20:54:08 CST 2018
*/

public interface VendorManager extends CommonManager 
{
    public abstract void saveVendor(Vendor val);

    public abstract void removeVendor(Vendor val);

    public abstract void removeVendor(Long id);

    public abstract Vendor getVendorById(Long id);

    public abstract List<Vendor> getVendorList();
}
