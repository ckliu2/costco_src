package com.costco.service;

import com.costco.value.Rent;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface RentManager extends CommonManager 
{
    public abstract void saveRent(Rent val);

    public abstract void removeRent(Rent val);

    public abstract void removeRent(Long id);

    public abstract Rent getRentById(Long id);

    public abstract List<Rent> getRentList();
    public abstract List<Billboard> getBillboardList();
    public abstract List<Vendor> getVendorList();
    public abstract List<UploadedFile> getPhotoList();
    public abstract List<UploadedFile> getCoverList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

