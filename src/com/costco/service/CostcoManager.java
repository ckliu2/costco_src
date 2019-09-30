package com.costco.service;

import com.costco.value.*;
import java.util.*;

import com.base.value.AppProperty;
import com.common.service.CommonManager;

public interface CostcoManager extends CommonManager {
	// Store
	public abstract void saveStore(Store val);

	public abstract void removeStore(Store val);

	public abstract void removeStore(Long id);

	public abstract Store getStoreById(Long id);

	public abstract List<Store> getStoreList();

	// Billboard
	public abstract void saveBillboard(Billboard val);

	public abstract void removeBillboard(Billboard val);

	public abstract void removeBillboard(Long id);

	public abstract Billboard getBillboardById(Long id);
	
	public abstract Billboard getBillboardByStoreAndNo(Store store,int no);

	public abstract List<Billboard> getBillboardList(Store store);

	public abstract List<Billboard> getBillboardList();
	
	public abstract List<Billboard> getBillboardList(Store store,AppProperty size);

	// Rent
	public abstract void saveRent(Rent val);

	public abstract void removeRent(Rent val);

	public abstract void removeRent(Long id);

	public abstract Rent getRentById(Long id);
	
	public abstract Rent getRentById(String fmYear, Store store,int no);

	public abstract List<Rent> getRentList(String fmYear, Store store, Vendor vendor, boolean havaPhoto);
	
	
	
	public abstract List<Rent> getSameSizeRentList(Rent rent);
	
	public abstract List<Rent> getSameSizeRentOrderList(Rent rent);

	// Vendor
	public abstract void saveVendor(Vendor val);

	public abstract void removeVendor(Vendor val);

	public abstract void removeVendor(Long id);

	public abstract Vendor getVendorById(Long id);

	public abstract List<Vendor> getVendorList();
	
	//BillboardRent
	public abstract List<BillboardRent> getBillboardRentList();
}
