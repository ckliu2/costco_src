package com.costco.dao;

import com.costco.value.Billboard;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Oct 05 13:03:22 CST 2019
*/

public interface BillboardDAO extends CommonDAO 
{
    public abstract void saveBillboard(Billboard val);

    public abstract void removeBillboard(Billboard val);

    public abstract void removeBillboard(Long id);

    public abstract Billboard findBillboardById(Long id);

    public abstract List<Billboard> findAllBillboard();
    public abstract List<UploadedFile> findCoverList();
    public abstract List<Store> findStoreList();
    public abstract List<UploadedFile> findLocation1List();
    public abstract List<UploadedFile> findLocation2List();
    public abstract List<UploadedFile> findLocation3List();
}

