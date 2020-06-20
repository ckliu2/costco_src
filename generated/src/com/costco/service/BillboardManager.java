package com.costco.service;

import com.costco.value.Billboard;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jun 20 10:47:17 CST 2020
*/

public interface BillboardManager extends CommonManager 
{
    public abstract void saveBillboard(Billboard val);

    public abstract void removeBillboard(Billboard val);

    public abstract void removeBillboard(Long id);

    public abstract Billboard getBillboardById(Long id);

    public abstract List<Billboard> getBillboardList();
    public abstract List<UploadedFile> getCoverList();
    public abstract List<Store> getStoreList();
    public abstract List<UploadedFile> getLocation1List();
    public abstract List<UploadedFile> getLocation2List();
    public abstract List<UploadedFile> getLocation3List();
}

