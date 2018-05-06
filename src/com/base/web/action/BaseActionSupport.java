package com.base.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.displaytag.properties.MediaTypeEnum;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.base.except.SessionTimeoutException;
import com.base.service.BaseManager;
import com.base.value.AppProperty;
import com.base.value.MiscCode;
import com.base.value.NameValue;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;
import com.base.util.Constant;
import com.base.util.MyProperties;

import campus.tool.util.security.Util;
//圖片確認
import nl.captcha.servlet.Constants;
import nl.captcha.servlet.SimpleCaptcha;

import java.net.*;
import java.io.*;

public abstract class BaseActionSupport extends ActionSupport {
	private BaseManager mgr;
	public static final String HTTP_RESPONSE = "com.opensymphony.xwork.dispatcher.HttpServletResponse";
	public static final String HTTP_REQUEST = "com.opensymphony.xwork.dispatcher.HttpServletRequest";
	public static final String HTTP_REQUEST_HEADER_ACCEPT_LANGUAGE = "Accept-Language";
	public static final String DELETE = "delete";

	private String delete;
	private String title;
	private String viewonly; // "true" or "false" (same as "" or null)
	private String xworkParam;
	private String captcha;
	private String cd;

	public BaseActionSupport() {
		super();
	}

	public void setBaseManager(BaseManager m) {
		mgr = m;
	}

	public BaseManager getBaseManager() {
		return mgr;
	}

	public SessionUser getSessionUser() {
		HttpSession ses = getSession();
		SessionUser user = (SessionUser) ses.getAttribute("user");
		if (user == null)
			throw new SessionTimeoutException(getText("common.sessionTimeout"));

		return user;
	}

	public String getErrorMessage(String key) {
		return super.getText("inputValidation." + key);
	}

	public void appendFieldError(String key, String msgKey) {
		addFieldError(key, getErrorMessage(msgKey));
	}

	public String getTextWithArgs(String key, String arg0, String arg1) {
		String args[] = new String[] { arg0, arg1 };

		return getText(key, args);
	}

	public String getTextWithArgs(String key, String arg) {
		String args[] = new String[] { arg };

		return getText(key, args);
	}

	public String getTextWithArgs(String key) {
		String args[] = new String[] { getContextRootRealPath() };

		return getText(key, args);
	}

	public HttpSession getSession() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		HttpSession session = req.getSession();

		return session;
	}

	public String getClientIP() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		return req.getRemoteAddr();
	}

	public HttpServletRequest getHttpServletRequest() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		return req;
	}

	public HttpServletResponse getHttpServletResponse() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse req = (HttpServletResponse) ctx.get(HTTP_RESPONSE);
		return req;
	}

	public String getContextRootPath() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		return req.getContextPath();
	}

	public String getContextRootName() {
		String p = getContextRootPath();
		if (p != null && p.length() > 0)
			return p.substring(1);

		return null;
	}

	public String getClientAcceptLanguage() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		java.util.StringTokenizer st = new java.util.StringTokenizer(req.getHeader(HTTP_REQUEST_HEADER_ACCEPT_LANGUAGE), ",;");
		String al = "zh-tw";
		if (st.hasMoreTokens()) {
			al = st.nextToken();
		}
		return al;
	}

	public String getClientCountry() {
		String lan = getClientAcceptLanguage();
		if (lan.indexOf("-") > 0) {
			return lan.substring(lan.indexOf("-") + 1);
		} else {
			return "tw";
		}
	}

	public String getContextRootRealPath() {
		java.io.File f = new File(getSession().getServletContext().getRealPath("/"));
		String ff = f.getAbsolutePath();

		return ff.replace('\\', '/');
	}

	public String showHtmlErrorMessage(String field) {
		Map fieldErrors = getFieldErrors();
		if (fieldErrors == null) {
			fieldErrors = Collections.EMPTY_MAP;
		}
		if (fieldErrors.containsKey(field)) {
			Object errors = (Object) fieldErrors.get(field);
			return errors.toString();
		} else {
			return "";
		}
	}

	public List getAppPropertyListByIds(Long[] ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.length; i++) {
			if (ids[i] == null)
				continue;
			AppProperty mc = mgr.getAppPropertyById(ids[i]);
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public List getAppPropertyListByIdList(List ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.size(); i++) {
			if (ids.get(i) == null)
				continue;

			AppProperty mc = mgr.getAppPropertyById((Long) ids.get(i));
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public List getMiscCodeListByIds(Long[] ids) {
		ArrayList al = new ArrayList();
		for (int i = 0; ids != null && i < ids.length; i++) {
			if (ids[i] == null)
				continue;
			MiscCode mc = mgr.getMiscCodeById(ids[i]);
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public MiscCode getMiscCodeByCodeKeyName(String codeName, String keyName) {
		return mgr.getMiscCodeByCodeKeyName(codeName, keyName);
	}

	public AppProperty getAppPropertyById(Long id) {
		if (id != null)
			return mgr.getAppPropertyById(id);
		else
			return null;
	}

	public List getCountryList() {
		return mgr.getCountryList();
	}

	public List getWeekdayList() {
		ArrayList al = new ArrayList();
		al.add("星期一");
		al.add("星期二");
		al.add("星期三");
		al.add("星期四");
		al.add("星期五");
		al.add("星期六");
		al.add("星期日");
		return al;
	}

	public List getAppPropertyList(String kind) {
		return mgr.getAppPropertyList(kind);
	}

	public List getCountyList() {
		return mgr.getCountyList();
	}

	public List getCityList() {
		return new ArrayList(); // TODO;
	}

	public List getCityListByCountyId(Long countyId) {
		MiscCode county = getMiscCodeById(countyId);
		List ls = mgr.getMiscCodeListByCodeName(county.getCodeName() + "." + county.getKeyName());

		return ls;
	}

	public MiscCode getMiscCodeById(Long id) {
		if (id != null)
			return mgr.getMiscCodeById(id);
		else
			return null;
	}

	public List getMiscCodeListByCodeName(String codeName) {
		if (codeName != null)
			return mgr.getMiscCodeListByCodeName(codeName);
		else
			return new ArrayList();
	}

	public static Long[] getIdsFromAppPropertyList(List al) {
		if (al == null)
			return null;

		Long la[] = new Long[al.size()];

		int i = 0;
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			AppProperty item = (AppProperty) iterator.next();
			la[i++] = item.getId();
		}
		return la;
	}

	public static Long getIdFromAppProperty(AppProperty obj) {
		if (obj == null)
			return null;

		return obj.getId();
	}

	public static Long getIdFromMiscCode(MiscCode obj) {
		if (obj == null)
			return null;

		return obj.getId();
	}

	public static Long[] getIdsFromMiscCodeList(List al) {
		if (al == null)
			return null;

		Long la[] = new Long[al.size()];

		int i = 0;
		for (Iterator iterator = al.iterator(); iterator.hasNext();) {
			MiscCode item = (MiscCode) iterator.next();
			la[i++] = item.getId();
		}
		return la;
	}

	public List getYearList(int num, int offset) {
		List al = new ArrayList();
		Calendar cal = new GregorianCalendar();

		int i = 0;
		int y = cal.get(Calendar.YEAR) + offset;
		while (i < num) {
			al.add(new Integer(y));
			y--;
			i++;
		}
		return al;
	}

	public List getMonthList() {
		List al = new ArrayList();
		for (int i = 1; i <= 12; i++) {
			al.add(new Integer(i));
		}
		return al;
	}

	public List getWorkingYearsList() {
		List al = new ArrayList();
		for (int i = 1; i <= 50; i++) {
			al.add(new Integer(i));
		}
		return al;
	}

	public List getYearList() {
		return getYearList(5, 1);
	}

	public List getGraduationYearList() {
		return getRocYearList(34, -1);
	}

	public String twoDigit(int n) {
		if (n < 10)
			return "0" + n;
		else
			return "" + n;
	}

	public String twoDigit(Integer n) {
		if (n == null)
			return "";

		return twoDigit(n.intValue());
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getViewonly() {
		return viewonly;
	}

	public void setViewonly(String viewonly) {
		this.viewonly = viewonly;
	}

	public boolean removeUploadedFile(String filename) {
		File f = new File(filename);
		boolean d = f.delete();
		System.out.println("delete " + filename + " is " + d);

		return d;
	}

	public boolean removeUploadedFile(String uploadedFileDir, Long id, String filename) {
		return removeUploadedFile(computeUploadedFilePath(uploadedFileDir, id, filename));
	}

	public UploadedFile computeUploadedFile(String filename, Long size) {
		UploadedFile uf = null;
		if (filename != null && filename.length() > 0)
			uf = new UploadedFile(filename, size);

		return uf;
	}

	public UploadedFile computeUploadedFile(String filename, File file) {
		long size = 0;
		if (file != null && filename != null && filename.length() > 0)
			size = file.length();

		return computeUploadedFile(filename, new Long(size));
	}

	public String computeUploadedFilePath(String uploadedFileDir, Long id, String filename) {
		String p = getText(uploadedFileDir);

		java.io.File f = new java.io.File(p);
		if (!f.exists()) {
			f.mkdirs();
		}

		return f.getAbsolutePath() + java.io.File.separatorChar + id + java.io.File.separatorChar + filename;
	}

	public boolean saveFileToLocal(String fileName, File file, String uploadedFileDir, Long id) {
		if (fileName != null && file != null) {
			ActionContext context = ActionContext.getContext();
			context.getValueStack();

			File ff = new File(uploadedFileDir);
			ff = new File(ff.getAbsolutePath() + java.io.File.separatorChar + id.longValue());
			if (ff.exists() == false)
				ff.mkdirs();
			File target = new File(ff, fileName);
			if (target.exists()) {
				target.delete();
			}
			boolean b = file.renameTo(target);
			System.out.println("save " + fileName + " ...... " + b);
			return b;
		}
		return false;
	}

	public boolean saveFileToLocal(String fileName, File file, String uploadedFileDir, String id) {
		if (fileName != null && file != null) {
			ActionContext context = ActionContext.getContext();
			context.getValueStack();

			File ff = new File(uploadedFileDir);
			ff = new File(ff.getAbsolutePath() + java.io.File.separatorChar + id);

			if (ff.exists() == false)
				ff.mkdirs();
			File target = new File(ff, fileName);
			if (target.exists()) {
				target.delete();
			}
			boolean b = file.renameTo(target);
			System.out.println("save " + fileName + " ...... " + b);
			return b;
		}
		return false;
	}

	public boolean saveFileToLocal1(String fileName, File file, String uploadedFileDir, String id) {
		if (fileName != null && file != null) {
			ActionContext context = ActionContext.getContext();
			context.getValueStack();

			File ff = new File(uploadedFileDir);
			ff = new File(ff.getAbsolutePath() + java.io.File.separatorChar + id);
			if (ff.exists() == false)
				ff.mkdirs();
			File target = new File(ff, fileName);
			if (target.exists()) {
				target.delete();
			}
			boolean b = file.renameTo(target);
			System.out.println("save " + fileName + " ...... " + b);
			return b;
		}
		return false;
	}

	public List getSexList() {
		System.out.println("sexList..");
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.SEX_LIST_MALE, getText("common.male")));
		al.add(new NameValue(Constant.SEX_LIST_FEMALE, getText("common.female")));
		return al;
	}

	public List getLanguageList() {
		return getAppPropertyList("common.languages");
	}

	public List getYesNoList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.YES_NO_LIST_YES, getText("common.yes")));
		al.add(new NameValue(Constant.YES_NO_LIST_NO, getText("common.no")));
		return al;
	}

	public boolean isYesNo(int i) {
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public String isYesNoString(Object columnValue) {
		System.out.println("isYesNoString...");
		if (columnValue == null)
			return getText("common.no");

		if (columnValue instanceof Boolean) {
			Boolean b = (Boolean) columnValue;
			if (b.booleanValue() == true) {
				return getText("common.yes");
			} else {
				return getText("common.no");
			}
		} else if (columnValue instanceof Integer) {
			Integer b = (Integer) columnValue;
			if (b.intValue() == 1) {
				return getText("common.yes");
			} else {
				return getText("common.no");
			}
		} else {
			return "";
		}
	}

	public List getCountryLocal() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(0, "國內"));
		al.add(new NameValue(1, "國外"));
		return al;
	}

	public List getConditionList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.YES_NO_LIST_YES, getText("common.and")));
		al.add(new NameValue(Constant.YES_NO_LIST_NO, getText("common.or")));
		return al;
	}

	public List getHaveNoneList() {
		ArrayList al = new ArrayList();
		al.add(new NameValue(Constant.HAVE_NONE_LIST_HAVE, getText("common.have")));
		al.add(new NameValue(Constant.HAVE_NONE_LIST_NONE, getText("common.none")));
		return al;
	}

	public String newline2Br(String s) {
		if (s == null)
			return null;

		return campus.tool.util.Text.newlineToBr(s);
	}

	// pass parameter
	public String getXworkParam() {
		return xworkParam;
	}

	public void setXworkParam(String xworkParam) {
		this.xworkParam = xworkParam;
	}

	public void appendXworkParam(String param) {
		if (param == null)
			return;
		if (xworkParam == null) {
			xworkParam = "?" + param;
		} else {
			xworkParam = xworkParam + "&" + param;
		}
	}

	// pass parameter

	// Captcha Check
	public boolean checkCaptcha() {
		String capText = Util.decrypt(getCd());
		System.out.println("captcha answer=" + capText);
		if (getCaptcha() != null) {
			try {
				int answer = Integer.parseInt(capText);
				int userInput = Integer.parseInt(getCaptcha());
				if (answer == userInput)
					return true;
			} catch (Exception ex) {
				return false;
			}
		}
		return false;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	// Captcha Check

	//
	public String URLDecoder(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (Exception ex) {
			System.out.println("URLDecoder error..");
			return "Error";
		}
	}

	// Local
	public String getLocal() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);

		return req.getLocalName();
	}

	public int getPageSize() {
		Integer s = (Integer) getSession().getAttribute("GLOBAL_pagesize");
		return s;
	}

	public String getPageIndexName() {
		String pageIndexName = new org.displaytag.util.ParamEncoder("row").encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		return pageIndexName;
	}

	public int getPageIndex(String tableId) {
		String pageIndexName = new org.displaytag.util.ParamEncoder(tableId).encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		String page = req.getParameter(pageIndexName);
		int pageIndex;
		if (page == null) {
			pageIndex = 0;
		} else {
			pageIndex = Integer.parseInt(page) - 1;
		}
		return pageIndex;
	}

	public int getPageIndex() {
		String pageIndexName = new org.displaytag.util.ParamEncoder("row").encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get(HTTP_REQUEST);
		String page = req.getParameter(pageIndexName);
		int pageIndex;
		if (page == null) {
			pageIndex = 0;
		} else {
			pageIndex = Integer.parseInt(page) - 1;
		}
		return pageIndex;
	}

	public void fileCopy(File file, File target, String targetDirPath) {
		try {
			new File(targetDirPath).mkdirs();
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(target);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static String remainDateToString(Date startDate, Date endDate) {
		Calendar calS = Calendar.getInstance();
		calS.setTime(startDate);
		int startY = calS.get(Calendar.YEAR);
		int startM = calS.get(Calendar.MONTH);
		int startD = calS.get(Calendar.DATE);
		int startDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		calS.setTime(endDate);
		int endY = calS.get(Calendar.YEAR);
		int endM = calS.get(Calendar.MONTH);

		int endD = calS.get(Calendar.DATE) + 1;
		int endDayOfMonth = calS.getActualMaximum(Calendar.DAY_OF_MONTH);

		StringBuilder sBuilder = new StringBuilder();
		if (endDate.compareTo(startDate) < 0) {
			return sBuilder.append("過期").toString();
		}
		int lday = endD - startD;
		if (lday < 0) {
			endM = endM - 1;
			lday = startDayOfMonth + lday;
		}

		if (lday == endDayOfMonth) {
			endM = endM + 1;
			lday = 0;
		}
		int mos = (endY - startY) * 12 + (endM - startM);
		int lyear = mos / 12;
		int lmonth = mos % 12;
		if (lyear > 0) {
			sBuilder.append(lyear + "年");
		}
		if (lmonth > 0) {
			sBuilder.append(lmonth + "月");
		}
		if (lday > 0) {
			sBuilder.append(lday + "天");
		}
		return sBuilder.toString();
	}

	public static String remainDateToString(int lday) {
		StringBuilder sBuilder = new StringBuilder();

		double days = lday;

		int lyear = lday / 365;
		sBuilder.append(lyear + "年");

		double lmonth = (double) ((days / 365) - lyear) * 12.0;
		sBuilder.append((int) lmonth + "月");

		double d = lmonth - (int) lmonth;
		double d1 = d * 30;
		sBuilder.append((int) d1 + "天");

		return sBuilder.toString();
	}

	public List getRocYearList(int num, int offset) {
		List al = new ArrayList();
		Calendar cal = new GregorianCalendar();

		int i = 0;
		int y = cal.get(Calendar.YEAR) + offset;
		while (i < num) {
			al.add(new Integer(y - 1911));
			y--;
			i++;
		}
		return al;
	}

	public static String md5(String originalString) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(originalString.getBytes());
			byte[] digest = md.digest();

			final StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < digest.length; ++i) {
				final byte b = digest[i];
				final int value = (b & 0x7F) + (b < 0 ? 128 : 0);
				buffer.append(value < 16 ? "0" : "");
				buffer.append(Integer.toHexString(value));
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException cnse) {
			return null;
		}
	}

	// Email
	public void sendEmail(String email, String subject, String content) {
		try {
			ServletContext servletContext = getHttpServletRequest().getSession().getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
			Connection conn = DriverManager.getConnection(myProperties.getDburl(), myProperties.getDbuser(), myProperties.getDbuserpsd());
			CallableStatement cstmt = conn.prepareCall("{call dbo.sendMail(?,?,?)}");
			cstmt.setString(1, email);
			cstmt.setString(2, subject);
			cstmt.setString(3, content);
			cstmt.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println("sendEmail error=" + e.toString());
		}
	}
	
	
	// Email Attachments
	public void sendMailAttachments(String email, String subject, String content,String fileName) {
		try {
			ServletContext servletContext = getHttpServletRequest().getSession().getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
			Connection conn = DriverManager.getConnection(myProperties.getDburl(), myProperties.getDbuser(), myProperties.getDbuserpsd());
			CallableStatement cstmt = conn.prepareCall("{call dbo.sendMailAttachments(?,?,?,?)}");
			cstmt.setString(1, email);
			cstmt.setString(2, subject);
			cstmt.setString(3, content);
			cstmt.setString(4, fileName);
			cstmt.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println("sendEmail error=" + e.toString());
		}
	}
	
	// Email Attachments
		public void sendMailAttachments(String email, String subject, String content,String fromaddress,String fileName) {
			try {
				ServletContext servletContext = getHttpServletRequest().getSession().getServletContext();
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
				Connection conn = DriverManager.getConnection(myProperties.getDburl(), myProperties.getDbuser(), myProperties.getDbuserpsd());
				CallableStatement cstmt = conn.prepareCall("{call dbo.sendMailAttachments1(?,?,?,?,?)}");
				cstmt.setString(1, email);
				cstmt.setString(2, subject);
				cstmt.setString(3, content);
				cstmt.setString(4, fromaddress);
				cstmt.setString(5, fileName);
				cstmt.execute();
				conn.close();
			} catch (Exception e) {
				System.out.println("sendEmail error=" + e.toString());
			}
		}

	// SMS
	public void sendSMS(String cellphone, String content) {
		try {
			ServletContext servletContext = getHttpServletRequest().getSession().getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
			Connection conn = DriverManager.getConnection(myProperties.getDburl(), myProperties.getDbuser(), myProperties.getDbuserpsd());
			CallableStatement cstmt = conn.prepareCall("{call dbo.sendSMS(?,?)}");
			cstmt.setString(1, cellphone);
			cstmt.setString(2, content);
			cstmt.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println("sendSMS error=" + e.toString());
		}
	}
	
	
	
	

}
