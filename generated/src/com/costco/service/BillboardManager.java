package com.costco.service;

import com.costco.value.Billboard;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 07 22:10:24 CST 2018
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
}

