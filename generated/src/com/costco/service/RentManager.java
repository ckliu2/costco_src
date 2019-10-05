package com.costco.service;

import com.costco.value.Rent;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
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

