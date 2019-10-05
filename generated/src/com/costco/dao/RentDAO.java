package com.costco.dao;

import com.costco.value.Rent;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface RentDAO extends CommonDAO 
{
    public abstract void saveRent(Rent val);

    public abstract void removeRent(Rent val);

    public abstract void removeRent(Long id);

    public abstract Rent findRentById(Long id);

    public abstract List<Rent> findAllRent();
    public abstract List<Billboard> findBillboardList();
    public abstract List<Vendor> findVendorList();
    public abstract List<UploadedFile> findPhotoList();
    public abstract List<UploadedFile> findCoverList();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

