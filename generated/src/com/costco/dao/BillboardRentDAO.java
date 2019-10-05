package com.costco.dao;

import com.costco.value.BillboardRent;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface BillboardRentDAO extends CommonDAO 
{
    public abstract void saveBillboardRent(BillboardRent val);

    public abstract void removeBillboardRent(BillboardRent val);

    public abstract void removeBillboardRent(Long id);

    public abstract BillboardRent findBillboardRentById(Long id);

    public abstract List<BillboardRent> findAllBillboardRent();
    public abstract List<Rent> findRentList();
    public abstract List<Store> findStoreList();
    public abstract List<Billboard> findBillboardList();
    public abstract List<Vendor> findVendorList();
}

