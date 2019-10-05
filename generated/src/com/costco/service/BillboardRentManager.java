package com.costco.service;

import com.costco.value.BillboardRent;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface BillboardRentManager extends CommonManager 
{
    public abstract void saveBillboardRent(BillboardRent val);

    public abstract void removeBillboardRent(BillboardRent val);

    public abstract void removeBillboardRent(Long id);

    public abstract BillboardRent getBillboardRentById(Long id);

    public abstract List<BillboardRent> getBillboardRentList();
    public abstract List<Rent> getRentList();
    public abstract List<Store> getStoreList();
    public abstract List<Billboard> getBillboardList();
    public abstract List<Vendor> getVendorList();
}

