package com.costco.dao;

import com.costco.value.Billboard;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon May 07 22:10:24 CST 2018
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
}

