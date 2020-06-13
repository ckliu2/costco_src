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

public class BillboardAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Billboard billboard;
	private java.io.File fileCover;
	private String fileCoverContentType, fileCoverFileName, removeCover;
	private Long[] selectedBillboardIds;
	Store store;
	AppProperty size;
	private java.io.File fileLocation1;
	private String fileLocation1ContentType, fileLocation1FileName, removeLocation1;
	private java.io.File fileLocation2;
	private String fileLocation2ContentType, fileLocation2FileName, removeLocation2;
	private java.io.File fileLocation3;
	private String fileLocation3ContentType, fileLocation3FileName, removeLocation3;
	String fmYear;

	public BillboardAction() {
		log = LogFactory.getLog(com.costco.web.action.BillboardAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("BILLBOARD");
	}

	public Billboard getBillboard() {
		return billboard;
	}

	public void setBillboard(Billboard val) {
		billboard = val;
	}

	public AppProperty getSize() {
		return size;
	}

	public void setSize(AppProperty size) {
		this.size = size;
	}

	public String getFmYear() {
		return fmYear;
	}

	public void setFmYear(String fmYear) {
		this.fmYear = fmYear;
	}

	public void setGenericManager(CostcoManager m) {
		super.setGenericManager(m);
	}

	public CostcoManager getGenericManager() {
		return (CostcoManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeBillboard(billboard.getId());
		return DELETE;
	}

	public String edit() {
		if (billboard == null) {
			billboard = new Billboard();
			try {
				billboard.setStoreId(store.getId());
				// billboard.setStore(getGenericManager().getStoreById(store.getId()));
			} catch (Exception e) {
			}
		} else if (billboard.getId() != null) {
			billboard = getGenericManager().getBillboardById(billboard.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedBillboardIds != null && selectedBillboardIds.length > 0) {
			Billboard obj = getGenericManager().getBillboardById(selectedBillboardIds[0]);
			obj.setId(null);
			billboard = obj;
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
			if (inputValidation(billboard) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Billboard val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		getGenericManager().saveBillboard(billboard);
		saveFileToLocal(fileCoverFileName, fileCover, getTextWithArgs("billboard.uploadCover.dir"), billboard.getId());
		saveFileToLocal(fileLocation1FileName, fileLocation1, getTextWithArgs("billboard.uploadLocation1.dir"), billboard.getId());
		saveFileToLocal(fileLocation2FileName, fileLocation2, getTextWithArgs("billboard.uploadLocation2.dir"), billboard.getId());
		saveFileToLocal(fileLocation3FileName, fileLocation3, getTextWithArgs("billboard.uploadLocation3.dir"), billboard.getId());
		appendXworkParam("store.id=" + billboard.getStoreId());
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		billboard.setSize(getAppPropertyById(billboard.getSizeId()));
		if (getRemoveCover() != null && getRemoveCover().length() > 0) {
			billboard.setCover(computeUploadedFile(fileCoverFileName, fileCover));
			removeUploadedFile(getTextWithArgs("billboard.uploadCover.dir"), billboard.getCoverId(), billboard.getCoverFileName());
		} else {
			if (billboard.getCoverId() != null)
				billboard.setCover(getGenericManager().getUploadedFileById(billboard.getCoverId()));
			else
				billboard.setCover(computeUploadedFile(fileCoverFileName, fileCover));
		}
		if (getRemoveLocation1() != null && getRemoveLocation1().length() > 0) {
			billboard.setLocation1(computeUploadedFile(fileLocation1FileName, fileLocation1));
			removeUploadedFile(getTextWithArgs("billboard.uploadLocation1.dir"), billboard.getLocation1Id(), billboard.getLocation1FileName());
		} else {
			if (billboard.getLocation1Id() != null)
				billboard.setLocation1(getGenericManager().getUploadedFileById(billboard.getLocation1Id()));
			else
				billboard.setLocation1(computeUploadedFile(fileLocation1FileName, fileLocation1));
		}
		if (getRemoveLocation2() != null && getRemoveLocation2().length() > 0) {
			billboard.setLocation2(computeUploadedFile(fileLocation2FileName, fileLocation2));
			removeUploadedFile(getTextWithArgs("billboard.uploadLocation2.dir"), billboard.getLocation2Id(), billboard.getLocation2FileName());
		} else {
			if (billboard.getLocation2Id() != null)
				billboard.setLocation2(getGenericManager().getUploadedFileById(billboard.getLocation2Id()));
			else
				billboard.setLocation2(computeUploadedFile(fileLocation2FileName, fileLocation2));
		}
		if (getRemoveLocation3() != null && getRemoveLocation3().length() > 0) {
			billboard.setLocation3(computeUploadedFile(fileLocation3FileName, fileLocation3));
			removeUploadedFile(getTextWithArgs("billboard.uploadLocation3.dir"), billboard.getLocation3Id(), billboard.getLocation3FileName());
		} else {
			if (billboard.getLocation3Id() != null)
				billboard.setLocation3(getGenericManager().getUploadedFileById(billboard.getLocation3Id()));
			else
				billboard.setLocation3(computeUploadedFile(fileLocation3FileName, fileLocation3));
		}
		billboard.setStore(getGenericManager().getStoreById(billboard.getStoreId()));

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

	public void setFileLocation1(java.io.File val) {
		fileLocation1 = val;
	}

	public java.io.File getFileLocation1() {
		return fileLocation1;
	}

	public void setFileLocation1ContentType(String val) {
		fileLocation1ContentType = val;
	}

	public String getFileLocation1ContentType() {
		return fileLocation1ContentType;
	}

	public void setFileLocation1FileName(String val) {
		fileLocation1FileName = val;
	}

	public String getFileLocation1FileName() {
		return fileLocation1FileName;
	}

	public void setRemoveLocation1(String val) {
		removeLocation1 = val;
	}

	public String getRemoveLocation1() {
		return removeLocation1;
	}

	public void setFileLocation2(java.io.File val) {
		fileLocation2 = val;
	}

	public java.io.File getFileLocation2() {
		return fileLocation2;
	}

	public void setFileLocation2ContentType(String val) {
		fileLocation2ContentType = val;
	}

	public String getFileLocation2ContentType() {
		return fileLocation2ContentType;
	}

	public void setFileLocation2FileName(String val) {
		fileLocation2FileName = val;
	}

	public String getFileLocation2FileName() {
		return fileLocation2FileName;
	}

	public void setRemoveLocation2(String val) {
		removeLocation2 = val;
	}

	public String getRemoveLocation2() {
		return removeLocation2;
	}

	public void setFileLocation3(java.io.File val) {
		fileLocation3 = val;
	}

	public java.io.File getFileLocation3() {
		return fileLocation3;
	}

	public void setFileLocation3ContentType(String val) {
		fileLocation3ContentType = val;
	}

	public String getFileLocation3ContentType() {
		return fileLocation3ContentType;
	}

	public void setFileLocation3FileName(String val) {
		fileLocation3FileName = val;
	}

	public String getFileLocation3FileName() {
		return fileLocation3FileName;
	}

	public void setRemoveLocation3(String val) {
		removeLocation3 = val;
	}

	public String getRemoveLocation3() {
		return removeLocation3;
	}

	public List<Store> getStoreList() {
		return getGenericManager().getStoreList(); // TODO
	}

	public List<Billboard> getBillboardList() {
		try {
			store = getGenericManager().getStoreById(store.getId());
		} catch (Exception e) {
		}
		return getGenericManager().getBillboardList(store);
	}

	public void setSelectedBillboardIds(Long[] val) {
		selectedBillboardIds = val;
	}

	public Long[] getSelectedBillboardIds() {
		return selectedBillboardIds;
	}

	public String storeSizeJSON() {
		System.out.println("storeSizeJSON");
		JSONArray ja = new JSONArray();
		try {
			try {
				store = getGenericManager().getStoreById(store.getId());
			} catch (Exception e) {
			}

			try {
				size = getGenericManager().getAppPropertyById(size.getId());
			} catch (Exception e) {
			}

			List<Billboard> items = new ArrayList<Billboard>();
			fmYear = Tools.getCostcoYearFormat(Tools.thisYear() + 1);
			List<Rent> ls = getGenericManager().getRentList(fmYear, store, null, false);
			for (Rent rent : ls) {
				items.add(rent.getBillboard());
			}

			List<Billboard> list = getGenericManager().getBillboardList(store, size);
			for (Billboard board : list) {
				boolean r = items.contains(board);
				if (!r) {
					JSONObject jo = new JSONObject();
					jo.put("value", board.getId());
					jo.put("text", board.getNo());
					ja.put(jo);
				}
			}

		} catch (Exception e) {
			System.out.println("storeSizeJSON=" + e.toString());
		}
		return ja.toString();
	}

	public String storeSizeAllJSON() {
		System.out.println("storeSizeAllJSON");
		JSONArray ja = new JSONArray();
		try {
			try {
				store = getGenericManager().getStoreById(store.getId());
			} catch (Exception e) {
			}

			try {
				size = getGenericManager().getAppPropertyById(size.getId());
			} catch (Exception e) {
			}

			List<Billboard> list = getGenericManager().getBillboardList(store);
			for (Billboard board : list) {
				JSONObject jo = new JSONObject();
				jo.put("value", board.getId());
				jo.put("text", board.getNo());
				ja.put(jo);
			}

		} catch (Exception e) {
			System.out.println("storeSizeAllJSON=" + e.toString());
		}
		return ja.toString();
	}

}
