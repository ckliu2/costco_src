package com.costco.service.impl;

import com.costco.service.CostcoManager;
import com.costco.dao.CostcoDAO;
import com.costco.value.*;
import java.util.*;

import com.base.value.AppProperty;
import com.common.service.impl.CommonManagerImpl;

public class CostcoManagerImpl extends CommonManagerImpl implements CostcoManager {

	public CostcoManagerImpl() {
	}

	public CostcoDAO getGenericDAO() {
		return (CostcoDAO) super.getGenericDAO();
	}

	public void setGenericDAO(CostcoDAO dao) {
		super.setGenericDAO(dao);
	}

	// Store

	public void saveStore(Store val) {
		getGenericDAO().saveStore(val);
	}

	public void removeStore(Store val) {
		getGenericDAO().removeStore(val);
	}

	public void removeStore(Long id) {
		getGenericDAO().removeStore(id);
	}

	public Store getStoreById(Long id) {
		return getGenericDAO().findStoreById(id);
	}

	public List<Store> getStoreList() {
		return getGenericDAO().findAllStore();
	}

	// Billboard
	public void saveBillboard(Billboard val) {
		getGenericDAO().saveBillboard(val);
	}

	public void removeBillboard(Billboard val) {
		getGenericDAO().removeBillboard(val);
	}

	public void removeBillboard(Long id) {
		getGenericDAO().removeBillboard(id);
	}

	public Billboard getBillboardById(Long id) {
		return getGenericDAO().findBillboardById(id);
	}

	public List<Billboard> getBillboardList(Store store) {
		return getGenericDAO().findAllBillboard(store);
	}

	public List<Billboard> getBillboardList() {
		return getGenericDAO().findAllBillboard();
	}
	
	public List<Billboard> getBillboardList(Store store,AppProperty size) {
		return getGenericDAO().findAllBillboard(store,size);
	}
	

	// Rent
	public void saveRent(Rent val) {
		getGenericDAO().saveRent(val);
	}

	public void removeRent(Rent val) {
		getGenericDAO().removeRent(val);
	}

	public void removeRent(Long id) {
		getGenericDAO().removeRent(id);
	}

	public Rent getRentById(Long id) {
		return getGenericDAO().findRentById(id);
	}
	
	public Rent getRentById(int year, Store store,int no){
		return getGenericDAO().findRentById(year,store,no);
	}

	public List<Rent> getRentList(int year, Store store, Vendor vendor, boolean havaPhoto) {
		return getGenericDAO().findAllRent(year, store, vendor, havaPhoto);
	}
	
	public List<Rent> getSameSizeRentList(Rent rent){
		return getGenericDAO().findSameSizeAllRent(rent);
	}
	
	
	public List<Rent> getSameSizeRentOrderList(Rent rent){
		return getGenericDAO().findSameSizeOrderAllRent(rent);
	}

	// Vendor
	public void saveVendor(Vendor val) {
		getGenericDAO().saveVendor(val);
	}

	public void removeVendor(Vendor val) {
		getGenericDAO().removeVendor(val);
	}

	public void removeVendor(Long id) {
		getGenericDAO().removeVendor(id);
	}

	public Vendor getVendorById(Long id) {
		return getGenericDAO().findVendorById(id);
	}

	public List<Vendor> getVendorList() {
		return getGenericDAO().findAllVendor();
	}

}
