package com.costco.dao;

import com.costco.value.*;
import java.util.*;

import com.base.value.AppProperty;
import com.common.dao.CommonDAO;

public interface CostcoDAO extends CommonDAO {

	// Store
	public abstract void saveStore(Store val);

	public abstract void removeStore(Store val);

	public abstract void removeStore(Long id);

	public abstract Store findStoreById(Long id);

	public abstract List<Store> findAllStore();

	// Billboard
	public abstract void saveBillboard(Billboard val);

	public abstract void removeBillboard(Billboard val);

	public abstract void removeBillboard(Long id);

	public abstract Billboard findBillboardById(Long id);

	public abstract List<Billboard> findAllBillboard(Store store);

	public abstract List<Billboard> findAllBillboard();
	
	public abstract List<Billboard> findAllBillboard(Store store,AppProperty size);
	
	public abstract Billboard findBillboardByStoreAndNo(Store store,int no);
	

	// Vendor
	public abstract void saveVendor(Vendor val);

	public abstract void removeVendor(Vendor val);

	public abstract void removeVendor(Long id);

	public abstract Vendor findVendorById(Long id);

	public abstract List<Vendor> findAllVendor();
	
	public abstract List<Vendor> findAllVendorByRent(String fmYear);
	

	// Rent
	public abstract void saveRent(Rent val);

	public abstract void removeRent(Rent val);

	public abstract void removeRent(Long id);

	public abstract Rent findRentById(Long id);
	
	public abstract Rent findRentById(String fmYear, Store store,int no);

	public abstract List<Rent> findAllRent(String fmYear, Store store, Vendor vendor, boolean havaPhoto);
	
	public abstract List<Rent> findSameSizeAllRent(Rent rent);
	
	public abstract List<Rent> findSameSizeOrderAllRent(Rent rent);
	
	//BillboardRent
	public abstract List<BillboardRent> findAllBillboardRent(String fmYear);
	
	public abstract List<VendorPrice> findAllVendorPrice();
	
	public abstract VendorPrice findVendorPriceById(Long id);
	
	public abstract void saveVendorQuantity(VendorQuantity val);
	
    public abstract VendorQuantity findVendorQuantity(String fmYear,  Vendor vendor);
	
}
