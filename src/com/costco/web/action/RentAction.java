package com.costco.web.action;

import com.costco.value.*;
import com.costco.service.CostcoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.*;

public class RentAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Rent rent, rent1;
	private java.io.File fileCover;
	private String fileCoverContentType, fileCoverFileName, removeCover;
	private java.io.File filePhoto;
	private String filePhotoContentType, filePhotoFileName, removePhoto;
	private Long[] selectedRentIds;
	int year, code;
	String fmYear;
	Store store;
	Vendor vendor;
	Billboard billboard;
	boolean havaPhoto;
	AppProperty kind;
	String assign, ids;
	MyProperties myProperties;

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

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public AppProperty getKind() {
		return kind;
	}

	public void setKind(AppProperty kind) {
		this.kind = kind;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
		if (fmYear == null) {
			fmYear = getCostcoThisYear();
		}
		System.out.println("fmYear=" + fmYear);
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
		return getGenericManager().getRentList(fmYear, store, vendor, havaPhoto);
	}

	public void setSelectedRentIds(Long[] val) {
		selectedRentIds = val;
	}

	public Long[] getSelectedRentIds() {
		return selectedRentIds;
	}

	public String deleteRentJSON() throws Exception {
		JSONObject obj = new JSONObject();
		System.out.println("deleteRentJSON rent.getId()=" + rent.getId());
		try {
			rent = getGenericManager().getRentById(rent.getId());
			getGenericManager().removeRent(rent);
			obj.put("result", true);
		} catch (Exception e) {
			System.out.println("deleteRentJSON error=" + e.toString());
			obj.put("result", false);
		}
		return obj.toString();
	}

	public String saveNewRentJSON() {
		JSONObject renewAdd = new JSONObject();
		System.out.println("saveNewRentJSON billboard.getId()=" + billboard.getId() + "  vendor.getId()=" + vendor.getId());
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
			newRent.setFmYear(Tools.getCostcoYearFormat(Tools.thisYear() + 1));

			AppProperty kindItem = getGenericManager().getAppPropertyByCode("rent.type.2");
			newRent.setKind(kindItem);

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

			System.out.println("nextYearList.size=" + nextYearList.size());
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
					jo.put("year", rent.getYear());
					jo.put("fmYear", rent.getFmYear());
					jo.put("store", rent.getBillboard().getStore().getName());
					jo.put("rentNo", rent.getBillboard().getNo());
					jo.put("size", String.format("%s (%sX%s)", rent.getBillboard().getSize().getValueTw(), rent.getBillboard().getWidth(), rent.getBillboard().getHeight()));
					jo.put("screen", rent.getScreen());
					jo.put("kind", rent.getKind() != null ? rent.getKind().getValueTw() : "");

					boolean r = items.contains(rent.getBillboard().getNo());
					if (!r) {
						ja.put(jo);
					}
				} catch (Exception ex) {
					System.out.println("changeRentJSON error=" + ex.toString());
				}
			}

			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("changeRentJSON error=" + e.toString());
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

			List<Rent> ls = getGenericManager().getRentList(fmYear, store, vendor, havaPhoto);
			System.out.println("fmYear=" + fmYear);
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
					jo.put("year", rent.getYear());
					jo.put("fmYear", rent.getFmYear());
					jo.put("store", rent.getBillboard().getStore().getName());
					jo.put("rentNo", rent.getBillboard().getNo());
					jo.put("size", rent.getBillboard().getSize().getValueTw());
					jo.put("size1", rent.getBillboard().getSize().getCode1());
					jo.put("size2", rent.getBillboard().getSize().getCode2());
					jo.put("size3", rent.getBillboard().getSize().getCode3());
					jo.put("size4", rent.getBillboard().getSize().getCode4());
					jo.put("screen", rent.getScreen());
					jo.put("kind", rent.getKind() != null ? rent.getKind().getValueTw() : "");
					jo.put("memo", rent.getMemo());
					jo.put("assign", rent.getAssign() != null ? rent.getAssign() ? "Y" : "" : "");
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
			System.out.println("rent.id=" + rent.getId() + "--rent.year=" + rent.getYear() + "--kind.code=" + kind.getCode());

			Rent newRent = new Rent();

			newRent.setBillboard(rent.getBillboard());
			newRent.setScreen(rent.getScreen());
			newRent.setVendor(rent.getVendor());
			newRent.setCreatedUser(getSessionUser().getMember());
			newRent.setCreatedDate(Tools.getCurrentTimestamp());
			AppProperty kindItem = getGenericManager().getAppPropertyByCode(kind.getCode());
			newRent.setKind(kindItem);

			if (kind.getCode().equals("rent.type.1")) {
				newRent.setYear(Tools.thisYear());
			} else {
				newRent.setYear(Tools.thisYear() + 1);
			}

			newRent.setFmYear(getCostcoYearFormat(Tools.thisYear() + 1));
			getGenericManager().saveRent(newRent);

		} catch (Exception e) {
			System.out.println("renewAddJSON error=" + e.toString());
		}
		return renewAdd.toString();
	}

	public String editRentJSON() {
		JSONObject jo = new JSONObject();
		System.out.println("editRentJSON");
		try {
			rent = getGenericManager().getRentById(rent.getId());
			jo.put("store", rent.getBillboard().getStoreId());
			jo.put("size", rent.getBillboard().getSizeId());
			jo.put("no", rent.getBillboard().getId());
			jo.put("memo", rent.getMemo());
			jo.put("screen", rent.getScreen());
			jo.put("assign", rent.getAssign());
			jo.put("vendor", rent.getVendorId());
			jo.put("kind", rent.getKindId());
			jo.put("year", rent.getYear());
			jo.put("fmYear", rent.getFmYear());
		} catch (Exception e) {
			System.out.println("editRentJSON error=" + e.toString());
		}
		return jo.toString();
	}

	public String changeRentAddJSON() {
		JSONObject renewAdd = new JSONObject();
		System.out.println("changeRentAddJSON");
		try {
			rent = getGenericManager().getRentById(rent.getId());
			rent1 = getGenericManager().getRentById(rent1.getId());
			System.out.println("rent.id=" + rent.getId() + "--rent.year=" + rent.getYear() + "--kind.code=" + kind.getCode());

			Rent newRent = new Rent();
			newRent.setYear(Tools.thisYear() + 1);
			newRent.setBillboard(rent.getBillboard());
			newRent.setScreen(rent.getScreen());
			newRent.setVendor(rent1.getVendor());
			newRent.setCreatedUser(getSessionUser().getMember());
			newRent.setCreatedDate(Tools.getCurrentTimestamp());
			newRent.setFmYear(Tools.getCostcoYearFormat(Tools.thisYear() + 1));
			AppProperty kindItem = getGenericManager().getAppPropertyByCode(kind.getCode());
			newRent.setKind(kindItem);

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

			String nextYear = getCostcoYearFormat(thisyear + 1);

			Rent rentOther = getGenericManager().getRentById(nextYear, rent.getBillboard().getStore(), rent.getBillboard().getNo());

			System.out.println("nextYear=" + nextYear);
			System.out.println("rentOther " + rentOther == null);
			System.out.println("Billboard.id " + rent.getBillboard().getId());

			if (rentOther == null) {
				System.out.println("1");
				renew.put("result", true);
				renew.put("code", 0);
				renew.put("year", nextYear);
				renew.put("vendor", rent.getVendor().getName());
				renew.put("deptNo", rent.getVendor().getDeptNo());
				renew.put("store", rent.getBillboard().getStore().getName());
				renew.put("size", rent.getBillboard().getSize().getValueTw());
				renew.put("no", rent.getBillboard().getNo());
				renew.put("screen", rent.getScreen());
				renew.put("renew", thisyear - 1 != rent.getYear());
			} else {
				System.out.println("2");
				renew.put("result", false);
				renew.put("code", -2);
				renew.put("year", nextYear);
				renew.put("vendor", rentOther.getVendor().getName());
				renew.put("deptNo", rentOther.getVendor().getDeptNo());
				renew.put("store", rentOther.getBillboard().getStore().getName());
				renew.put("size", rentOther.getBillboard().getSize().getValueTw());
				renew.put("no", rentOther.getBillboard().getNo());
				renew.put("screen", rentOther.getScreen());
				renew.put("renew", thisyear - 1 != rent.getYear());
			}

		} catch (Exception e) {
			System.out.println("renewCheckJSON error=" + e.toString());
		}
		return renew.toString();
	}

	public String checkRentJSON() {
		JSONObject mainObj = new JSONObject();
		try {
			store = getGenericManager().getStoreById(store.getId());
			billboard = getGenericManager().getBillboardByStoreAndNo(store, billboard.getNo());
			rent = getGenericManager().getRentById(Tools.getCostcoYearFormat(Tools.thisYear() + 1), billboard.getStore(), billboard.getNo());
			mainObj.put("result", rent != null);
		} catch (Exception e) {
			System.out.println("checkRentJSON error=" + e.toString());
		}
		return mainObj.toString();
	}

	public String saveRentJSON() {
		JSONObject mainObj = new JSONObject();
		try {
			store = getGenericManager().getStoreById(store.getId());
			billboard = getGenericManager().getBillboardById(billboard.getId());
			Rent rent1 = getGenericManager().getRentById(fmYear, billboard.getStore(), billboard.getNo());

			vendor = getGenericManager().getVendorById(vendor.getId());
			Rent thisRent = getGenericManager().getRentById(rent.getId());

			if (rent1 != null && thisRent == null) {
				mainObj.put("result", -1);
				return mainObj.toString();
			}

			if (rent1 != null && thisRent != null) {
				if (rent1.getBillboardId() == billboard.getId() && rent1.getId() != thisRent.getId()) {
					mainObj.put("result", -1);
					return mainObj.toString();
				}
			}

			if (thisRent == null) {
				System.out.println("saveRentJSON create");
				Rent r = new Rent();
				r.setMemo(rent.getMemo());
				r.setScreen(rent.getScreen());
				r.setAssign(assign.equals("true"));
				r.setBillboard(billboard);
				r.setVendor(vendor);
				r.setCreatedDate(Tools.getCurrentTimestamp());

				r.setCreatedUser(getGenericManager().getMemberById(2L));
				r.setCreatedUser(getSessionUser().getMember());

				r.setFmYear(fmYear);

				r.setKind(getGenericManager().getAppPropertyById(kind.getId()));
				r.setYear(rent.getYear());
				r.setIsUpToDate(false);
				getGenericManager().saveRent(r);
				mainObj.put("result", 0);
			} else {
				System.out.println("saveRentJSON edit");
				thisRent.setMemo(rent.getMemo());
				thisRent.setScreen(rent.getScreen());
				thisRent.setAssign(assign.equals("true"));
				thisRent.setBillboard(billboard);
				thisRent.setVendor(vendor);
				thisRent.setCreatedDate(Tools.getCurrentTimestamp());

				thisRent.setCreatedUser(getGenericManager().getMemberById(2L));
				thisRent.setCreatedUser(getSessionUser().getMember());

				thisRent.setFmYear(fmYear);

				thisRent.setKind(getGenericManager().getAppPropertyById(kind.getId()));
				thisRent.setYear(rent.getYear());
				thisRent.setIsUpToDate(false);
				getGenericManager().saveRent(thisRent);
				mainObj.put("result", 0);
			}
			return mainObj.toString();

		} catch (Exception e) {
			System.out.println("saveRentJSON error=" + e.toString());
		}
		return mainObj.toString();
	}

	public String vendorReportListJSON() {

		JSONObject mainObj = new JSONObject();
		try {

			List<VendorPrice> ls = getGenericManager().getVendorPriceList();

			JSONArray ja = new JSONArray();

			for (int i = 0; i < ls.size(); i++) {
				try {
					VendorPrice r = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("id", r.getId());
					jo.put("no", "[" + r.getVendor().getNo() + "]");
					jo.put("name", r.getVendor().getName());
					jo.put("price", r.getPrice());

					ja.put(jo);
				} catch (Exception ex) {
					System.out.println("vendorReportListJSON error=" + ex.toString());
				}
			}
			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("vendorReportListJSON error=" + e.toString());
		}
		return mainObj.toString();
	}

	public String vendorExcelJSON() {
		JSONObject mainObj = new JSONObject();
		try {
			myProperties = getMyProperties();
			String outFile = myProperties.getVendorExcelPath();
			System.out.println("fmYear=" + fmYear + "--outFile=" + outFile);

			jxl.write.WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(outFile));

			List<Vendor> vendors = getGenericManager().getVendorListByRent(fmYear);
			int i = 0;
			for (Vendor vendor : vendors) {
				System.out.println("vendor.no=" + vendor.getNo());
				jxl.write.WritableSheet sheet = workbook.createSheet(vendor.getNo(), i);

				// 產生基本欄位
				jxl.write.WritableFont wf = new jxl.write.WritableFont(jxl.write.WritableFont.TIMES, 10, jxl.write.WritableFont.NO_BOLD, false);
				jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf);
				sheet.addCell(new jxl.write.Label(0, 0, "店別", wcfF));
				sheet.addCell(new jxl.write.Label(1, 0, "燈箱編號", wcfF));
				sheet.addCell(new jxl.write.Label(2, 0, "燈箱名稱", wcfF));
				sheet.addCell(new jxl.write.Label(3, 0, "燈箱代碼", wcfF));
				sheet.addCell(new jxl.write.Label(4, 0, "燈箱俗稱", wcfF));
				sheet.addCell(new jxl.write.Label(5, 0, "客戶統稱", wcfF));
				sheet.addCell(new jxl.write.Label(6, 0, "燈箱尺寸", wcfF));
				sheet.addCell(new jxl.write.Label(7, 0, "客戶編號", wcfF));
				sheet.addCell(new jxl.write.Label(8, 0, "客戶", wcfF));
				sheet.addCell(new jxl.write.Label(9, 0, "上架年份", wcfF));
				sheet.addCell(new jxl.write.Label(10, 0, "製作年份", wcfF));
				sheet.addCell(new jxl.write.Label(11, 0, "備註1", wcfF));
				sheet.addCell(new jxl.write.Label(12, 0, "備註2", wcfF));
				sheet.addCell(new jxl.write.Label(13, 0, "指定", wcfF));

				int n = 0;
				List<Rent> ls = getGenericManager().getRentList(fmYear, null, vendor, havaPhoto);
				for (Rent rent : ls) {
					System.out.println("rent.id=" + rent.getId());

					sheet.addCell(new jxl.write.Label(0, n + 1, rent.getBillboard().getStore().getName()));
					sheet.addCell(new jxl.write.Label(1, n + 1, String.valueOf(rent.getBillboard().getNo())));
					sheet.addCell(new jxl.write.Label(2, n + 1, rent.getBillboard().getSize().getValueTw()));
					sheet.addCell(new jxl.write.Label(3, n + 1, rent.getBillboard().getSize().getCode1()));
					sheet.addCell(new jxl.write.Label(4, n + 1, rent.getBillboard().getSize().getCode2()));
					sheet.addCell(new jxl.write.Label(5, n + 1, rent.getBillboard().getSize().getCode3()));
					sheet.addCell(new jxl.write.Label(6, n + 1, rent.getBillboard().getSize().getCode4()));
					sheet.addCell(new jxl.write.Label(7, n + 1, rent.getVendor().getNo()));
					sheet.addCell(new jxl.write.Label(8, n + 1, rent.getVendor().getName()));
					sheet.addCell(new jxl.write.Label(9, n + 1, rent.getFmYear()));
					sheet.addCell(new jxl.write.Number(10, n + 1, rent.getYear()));
					sheet.addCell(new jxl.write.Label(11, n + 1, rent.getKind().getValueTw()));
					sheet.addCell(new jxl.write.Label(12, n + 1, rent.getMemo()));
					sheet.addCell(new jxl.write.Label(13, n + 1, rent.getAssign() != null ? rent.getAssign() ? "Y" : "" : ""));

					n++;
				}
				i++;
			}
			workbook.write();
			workbook.close();
			mainObj.put("result", true);

		} catch (Exception e) {
			System.out.println("vendorExcelJSON error=" + e.toString());
		}

		return mainObj.toString();
	}

	public String downloadPDFVendorReportListJSON() {
		JSONObject mainObj = new JSONObject();
		try {
			myProperties = getMyProperties();
			Tools.deleteAll(new File(myProperties.getOnlinepdfPath()));

			String[] tokens = ids.split(",");
			for (int i = 0; i < tokens.length; i++) {
				Long id = Long.parseLong(tokens[i]);
				VendorPrice v = getGenericManager().getVendorPriceById(id);
				System.out.println(v.getVendorId());
				String fileName = Tools.getURLEnecoder(v.getVendor().getNo());
				Tools.httpPost(myProperties.getPrintServer() + "rpt=0&fileName=" + fileName + "&fmYear=" + myProperties.getFmYear() + "&vendor=" + v.getVendorId());
			}

			Tools.zip(myProperties.getOnlinepdfPath(), myProperties.getVendorOrderPath(), false, "");

			mainObj.put("result", true);

		} catch (Exception e) {
			System.out.println("constructionFeeMasterExcelJSON error=" + e.toString());

		}

		return mainObj.toString();
	}

	public String billboardRentJSON() {

		JSONObject mainObj = new JSONObject();
		try {
			getGenericManager().executeSQL(" dbo.billboardRentGen ");
			List<BillboardRent> ls = getGenericManager().getBillboardRentList(fmYear);
			JSONArray ja = new JSONArray();
			for (int i = 0; i < ls.size(); i++) {
				try {
					BillboardRent r = ls.get(i);
					JSONObject jo = new JSONObject();
					jo.put("r", r.getId());
					jo.put("store", r.getBillboard().getStore().getName());
					jo.put("billboardNo", r.getBillboard().getNo());
					jo.put("billboard", r.getBillboard().getId());
					jo.put("size", r.getBillboard().getSize().getValueTw());
					jo.put("size1", r.getBillboard().getSize().getCode1());
					jo.put("size2", r.getBillboard().getSize().getCode2());
					jo.put("size3", r.getBillboard().getSize().getCode3());
					jo.put("size4", r.getBillboard().getSize().getCode4());
					jo.put("vendorNo", r.getVendor() != null ? "[" + r.getVendor().getNo() + "]" : "");
					jo.put("vendor", r.getVendor() != null ? r.getVendor().getName() : "");
					jo.put("kind", r.getVendor() != null ? r.getKind() : "未指定位置");
					jo.put("fmYear", r.getFmYear());
					jo.put("year", r.getRent() != null ? r.getRent().getYear() : "");
					jo.put("memo", r.getRent() != null ? r.getRent().getMemo() != null ? r.getRent().getMemo() : "" : "");
					jo.put("assign", r.getRent() != null ? r.getRent().getAssign() != null ? r.getRent().getAssign() ? "Y" : "" : "" : "");
					ja.put(jo);
				} catch (Exception ex) {
					System.out.println("billboardRentJSON error=" + ex.toString());
				}
			}
			mainObj.put("total", ls.size());
			mainObj.put("rows", ja);
		} catch (Exception e) {
			System.out.println("rentListJSON error=" + e.toString());
		}
		return mainObj.toString();
	}

}
