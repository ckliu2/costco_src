package com.costco.dao;

import com.costco.value.*;
import java.util.*;
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

	// Vendor
	public abstract void saveVendor(Vendor val);

	public abstract void removeVendor(Vendor val);

	public abstract void removeVendor(Long id);

	public abstract Vendor findVendorById(Long id);

	public abstract List<Vendor> findAllVendor();

	// Rent
	public abstract void saveRent(Rent val);

	public abstract void removeRent(Rent val);

	public abstract void removeRent(Long id);

	public abstract Rent findRentById(Long id);

	public abstract List<Rent> findAllRent(int year, Store store, boolean havaPhoto);
}