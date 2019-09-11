package com.costco.web.action;

import com.costco.value.*;
import com.costco.service.CostcoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class RentAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Rent rent,rent1;
	private java.io.File fileCover;
	private String fileCoverContentType, fileCoverFileName, removeCover;
	private java.io.File filePhoto;
	private String filePhotoContentType, filePhotoFileName, removePhoto;
	private Long[] selectedRentIds;
	int year;
	Store store;
	Vendor vendor;
	Billboard billboard;
	boolean havaPhoto;

	public RentAction() {
		log = LogFactory.getLog(com.costco.web.action.RentAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("RENT");
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent val) {
		rent = val;
	}
	
	public Rent getRent1() {
		return rent1;
	}

	public void setRent1(Rent rent1) {
		this.rent1 = rent1;
	}
	
	public Billboard getBillboard() {
		return billboard;
	}

	public void setBillboard(Billboard billboard) {
		this.billboard = billboard;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public void setGenericManager(CostcoManager m) {
		super.setGenericManager(m);
	}

	public CostcoManager getGenericManager() {
		return (CostcoManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeRent(rent.getId());
		return DELETE;
	}

	public String edit() {
		if (rent == null) {
			rent = new Rent();
		} else if (rent.getId() != null) {
			rent = getGenericManager().getRentById(rent.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedRentIds != null && selectedRentIds.length > 0) {
			Rent obj = getGenericManager().getRentById(selectedRentIds[0]);
			obj.setId(null);
			rent = obj;
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(rent) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Rent val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (rent.getId() == null) {
			rent.setCreatedDate(ts);
			rent.setCreatedUser(getSessionUser().getMember());
		}
		rent.setLastModifiedDate(ts);
		rent.setLastModifiedUser(getSessionUser().getMember());
		getGenericManager().saveRent(rent);
		saveFileToLocal(fileCoverFileName, fileCover, getTextWithArgs("rent.uploadCover.dir"), rent.getId());
		saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("rent.uploadPhoto.dir"), rent.getId());
		appendXworkParam("year=" + rent.getYear());
		appendXworkParam("store.id=" + rent.getBillboard().getStoreId());

		return SUCCESS;
	}

	public String list() {
		if (year == 0) {
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			year = calendar.get(Calendar.YEAR);
		}
		return SUCCESS;
	}

	public String list1() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {

		log.info("enter formToBean()");
		rent.setBillboard(getGenericManager().getBillboardById(rent.getBillboardId()));
		rent.setVendor(getGenericManager().getVendorById(rent.getVendorId()));
		if (getRemoveCover() != null && getRemoveCover().length() > 0) {
			rent.setCover(computeUploadedFile(fileCoverFileName, fileCover));
			removeUploadedFile(getTextWithArgs("rent.uploadCover.dir"), rent.getCoverId(), rent.getCoverFileName());
		} else {
			if (rent.getCoverId() != null)
				rent.setCover(getGenericManager().getUploadedFileById(rent.getCoverId()));
			else
				rent.setCover(computeUploadedFile(fileCoverFileName, fileCover));
		}
		if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
			rent.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto));
			removeUploadedFile(getTextWithArgs("rent.uploadPhoto.dir"), rent.getPhotoId(), rent.getPhotoFileName());
		} else {
			if (rent.getPhotoId() != null)
				rent.setPhoto(getGenericManager().getUploadedFileById(rent.getPhotoId()));
			else
				rent.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto));
		}
	}

	public List<Billboard> getBillboardList() {
		return getGenericManager().getBillboardList(); // TODO
	}

	public List<Vendor> getVendorList() {
		return getGenericManager().getVendorList(); // TODO
	}

	public boolean isHavaPhoto() {
		return havaPhoto;
	}

	public void setHavaPhoto(boolean havaPhoto) {
		this.havaPhoto = havaPhoto;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setFileCover(java.io.File val) {
		fileCover = val;
	}

	public java.io.File getFileCover() {
		return fileCover;
	}

	public void setFileCoverContentType(String val) {
		fileCoverContentType = val;
	}

	public String getFileCoverContentType() {
		return fileCoverContentType;
	}

	public void setFileCoverFileName(String val) {
		fileCoverFileName = val;
	}

	public String getFileCoverFileName() {
		return fileCoverFileName;
	}

	public void setRemoveCover(String val) {
		removeCover = val;
	}

	public String getRemoveCover() {
		return removeCover;
	}

	public void setFilePhoto(java.io.File val) {
		filePhoto = val;
	}

	public java.io.File getFilePhoto() {
		return filePhoto;
	}

	public void setFilePhotoContentType(String val) {
		filePhotoContentType = val;
	}

	public String getFilePhotoContentType() {
		return filePhotoContentType;
	}

	public void setFilePhotoFileName(String val) {
		filePhotoFileName = val;
	}

	public String getFilePhotoFileName() {
		return filePhotoFileName;
	}

	public void setRemovePhoto(String val) {
		removePhoto = val;
	}

	public String getRemovePhoto() {
		return removePhoto;
	}

	public List<Store> getStoreList() {
		return getGenericManager().getStoreList(); // TODO
	}

	public List<Rent> getRentList() {
		System.out.println("havaPhoto=" + havaPhoto);
		try {
			store = getGenericManager().getStoreById(store.getId());
		} catch (Exception e) {
		}
		return getGenericManager().getRentList(year, store, vendor, havaPhoto);
	}

	public void setSelectedRentIds(Long[] val) {
		selectedRentIds = val;
	}

	public Long[] getSelectedRentIds() {
		return selectedRentIds;
	}
	
	
	
	public String saveNewRentJSON() {
		JSONObject renewAdd = new JSONObject();
		System.out.println("saveNewRentJSON billboard.getId()="+billboard.getId()+"  vendor.getId()="+vendor.getId());
		try {
			billboard = getGenericManager().getBillboardById(billboard.getId());
			vendor = getGenericManager().getVendorById(vendor.getId());
			Rent newRent = new Rent();
			newRent.setYear(Tools.thisYear() + 1);
			newRent.setBillboard(billboard);
			newRent.setVendor(vendor);
			newRent.setScreen(rent.getScreen());
			newRent.setCreatedUser(getSessionUser().getMember());
			newRent.setCreatedDate(Tools.getCurrentTimestamp());
			getGenericManager().saveRent(newRent);

		} catch (Exception e) {
			System.out.println("saveNewRentJSON error=" + e.toString());
		}
		return renewAdd.toString();
	}

	public String changeRentJSON() {

		JSONObject mainObj = new JSONObject();
		try {
			rent = getGenericManager().getRentById(rent.getId());
			List<Rent> ls = getGenericManager().getSameSizeRentList(rent);
			List<Rent> nextYearList = getGenericManager().getSameSizeRentOrderList(rent);

			List<Integer> items = new ArrayList<Integer>();
			for (Rent r : nextYearList) {
				items.add(r.getBillboard().getNo());
			}

			//System.out.println("nextYearList.size=" + nextYearList.size());

			JSONArray ja = new JSONArray();

			for (int i = 0; i < ls.size(); i++) {
				try {
					rent = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("id", rent.getId());
					jo.put("vendor", rent.getVendor().getName());
					jo.put("vendorDeptNo", rent.getVendor().getDeptNo());
					jo.put("vendorNo", rent.getVendor().getNo());
					jo.put("year", String.format("FY%s", String.valueOf(rent.getYear()).substring(2, 4)));
					jo.put("store", rent.getBillboard().getStore().getName());
					jo.put("rentNo", rent.getBillboard().getNo());
					jo.put("size", String.format("%s (%sX%s)", rent.getBillboard().getSize().getValueTw(), rent.getBillboard().getWidth(), rent.getBillboard().getHeight()));
					jo.put("screen", rent.getScreen());

					boolean r = items.contains(rent.getBillboard().getNo());
					if(!r){
						ja.put(jo);
					}
				} catch (Exception ex) {
					System.out.println("rentListJSON error=" + ex.toString());
				}
			}

			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("rentListJSON error=" + e.toString());
		}
		return mainObj.toString();
	}

	public String rentListJSON() {

		JSONObject mainObj = new JSONObject();
		try {
			try {
				store = getGenericManager().getStoreById(store.getId());
			} catch (Exception e) {
			}
			try {
				vendor = getGenericManager().getVendorById(vendor.getId());
			} catch (Exception e) {
			}

			List<Rent> ls = getGenericManager().getRentList(year, store, vendor, havaPhoto);
			System.out.println("year=" + year);
			System.out.println("ls.size=" + ls.size());

			JSONArray ja = new JSONArray();

			for (int i = 0; i < ls.size(); i++) {
				try {
					rent = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("id", rent.getId());
					jo.put("vendor", rent.getVendor().getName());
					jo.put("vendorDeptNo", rent.getVendor().getDeptNo());
					jo.put("vendorNo", rent.getVendor().getNo());
					jo.put("year", String.format("FY%s", String.valueOf(rent.getYear()).substring(2, 4)));
					jo.put("store", rent.getBillboard().getStore().getName());
					jo.put("rentNo", rent.getBillboard().getNo());
					jo.put("size", String.format("%s (%sX%s)", rent.getBillboard().getSize().getValueTw(), rent.getBillboard().getWidth(), rent.getBillboard().getHeight()));
					jo.put("screen", rent.getScreen());
					ja.put(jo);
				} catch (Exception ex) {
					System.out.println("rentListJSON error=" + ex.toString());
				}
			}

			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("rentListJSON error=" + e.toString());
		}
		return mainObj.toString();
	}
	
	
	public String renewAddJSON() {
		JSONObject renewAdd = new JSONObject();
		System.out.println("renewAddJSON");
		try {
			rent = getGenericManager().getRentById(rent.getId());
			System.out.println("rent.id=" + rent.getId() + "--rent.year=" + rent.getYear());

			Rent newRent = new Rent();
			newRent.setYear(Tools.thisYear() + 1);
			newRent.setBillboard(rent.getBillboard());
			newRent.setScreen(rent.getScreen());
			newRent.setVendor(rent.getVendor());
			newRent.setCreatedUser(getSessionUser().getMember());
			newRent.setCreatedDate(Tools.getCurrentTimestamp());
			getGenericManager().saveRent(newRent);

		} catch (Exception e) {
			System.out.println("renewAddJSON error=" + e.toString());
		}
		return renewAdd.toString();
	}

	public String changeRentAddJSON() {
		JSONObject renewAdd = new JSONObject();
		System.out.println("changeRentAddJSON");
		try {
			rent = getGenericManager().getRentById(rent.getId());
			rent1 = getGenericManager().getRentById(rent1.getId());
			System.out.println("rent.id=" + rent.getId() + "--rent.year=" + rent.getYear());

			Rent newRent = new Rent();
			newRent.setYear(Tools.thisYear() + 1);
			newRent.setBillboard(rent.getBillboard());
			newRent.setScreen(rent.getScreen());
			newRent.setVendor(rent1.getVendor());
			newRent.setCreatedUser(getSessionUser().getMember());
			newRent.setCreatedDate(Tools.getCurrentTimestamp());
			getGenericManager().saveRent(newRent);

		} catch (Exception e) {
			System.out.println("changeRentAddJSON error=" + e.toString());
		}
		return renewAdd.toString();
	}

	public String renewCheckJSON() {
		JSONObject renew = new JSONObject();
		System.out.println("renewCheckJSON");
		try {
			rent = getGenericManager().getRentById(rent.getId());
			System.out.println("rent.id=" + rent.getId() + "--rent.year=" + rent.getYear());

			int thisyear = Tools.thisYear();
			String nextYear = String.format("FY%s", String.valueOf(thisyear + 1).substring(2, 4));

			if (thisyear - 1 == rent.getYear()) {
				renew.put("result", false);
				renew.put("code", -1);

			} else {
				Rent rentOther = getGenericManager().getRentById(thisyear + 1, rent.getBillboard().getStore(), rent.getBillboard().getNo());
				if (rentOther == null) {
					renew.put("result", true);
					renew.put("code", 0);
					renew.put("year", nextYear);
					renew.put("vendor", rent.getVendor().getName());
					renew.put("deptNo", rent.getVendor().getDeptNo());
					renew.put("store", rent.getBillboard().getStore().getName());
					renew.put("size", rent.getBillboard().getSize().getValueTw());
					renew.put("no", rent.getBillboard().getNo());
					renew.put("screen", rent.getScreen());
				} else {
					renew.put("result", false);
					renew.put("code", -2);
					renew.put("year", nextYear);
					renew.put("vendor", rentOther.getVendor().getName());
					renew.put("deptNo", rentOther.getVendor().getDeptNo());
					renew.put("store", rentOther.getBillboard().getStore().getName());
					renew.put("size", rentOther.getBillboard().getSize().getValueTw());
					renew.put("no", rentOther.getBillboard().getNo());
					renew.put("screen", rentOther.getScreen());
				}
			}

		} catch (Exception e) {
			System.out.println("renewCheckJSON error=" + e.toString());
		}
		return renew.toString();
	}
}
