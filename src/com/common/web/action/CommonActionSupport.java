package com.common.web.action;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.NameValue;
import com.base.value.SessionUser;
import com.base.web.action.BaseActionSupport;
import com.common.service.CommonManager;
import com.common.value.*;

public abstract class CommonActionSupport extends BaseActionSupport {
	private String whichAction;
	private String submitChecking;

	public SessionUser copyToSessionUser(Member user) {
		SessionUser su = new SessionUser();
		su.setId(user.getId());
		su.setName(user.getName());
		su.setIp(getClientIP());
		su.setMember(user);
		su.setRole(user.getGroups());		
		su.setAdmin(Tools.checkGroup(user, "admin"));		
		MenuService ms = new MenuService(getContextRootPath());

		String menu = getMenu(su);
		// System.out.println("menu="+menu);
		su.setMenuStr(menu);
		return su;
	}

	public String getMenu(SessionUser su) {
		String menu = "";
		List<FunctionCategory> categorys = getGenericManager().findFunctionCategoryListBySessionUser(su);
		for (int i = 0; i < categorys.size(); i++) {
			FunctionCategory c = categorys.get(i);
			// System.out.println(c.getName());

			// <div data-options="iconCls:'icon-tip'">
			menu += "\n <div data-options=\"iconCls:'icon-tip'\"> \n";

			menu += "<span>" + c.getName() + "</span> \n";
			menu += "<div style=\"width:150px;\"> \n";

			List<Function> ls = getGenericManager().findFunctionListByFunctionCategory(c);
			for (int j = 0; j < ls.size(); j++) {
				Function f = ls.get(j);
				// System.out.println("fun="+f.getFunName());
				menu += "<div onclick=\"javascript:menuUrl('" + f.getFunUrl() + "')\" data-options=\"iconCls:'icon-menu'\"><b>" + f.getFunName() + "</b></div> \n";
				menu += "<div class=\"menu-sep\"></div> \n";
			}
			menu += "</div> \n";
			menu += "</div> \n";
			menu += "<div class=\"menu-sep\"></div> \n";
		}
		return menu;
	}

	public String getCookies(String field) {
		String value = null;
		Cookie cookies[] = getHttpServletRequest().getCookies();
		Cookie c = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				c = cookies[i];
				//System.out.println("c.getName()="+c.getName());
				if (c.getName().equals(field)) {
					value = c.getValue();
				}
			}
		}
		return value;
	}

	public String getWhichAction() {
		return whichAction;
	}

	public String getStateLabel(String state) {
		return CheckingState.getStateLabel(state);
	}

	public String toAccessName(String s) {
		if (s != null)
			return Tools.firstCharToUpperCase(toObjectName(s));

		return s;
	}

	public String toLowerCase(String s) {
		if (s != null)
			return s.toLowerCase();

		return s;
	}

	public String toObjectName(String s) {
		StringTokenizer st = new StringTokenizer(s, "_");
		int i = 0;
		String tmp = "";
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			if (i == 0) {
				tmp = str.toLowerCase();
			} else {
				tmp = tmp + Tools.firstCharToUpperCase(str.toLowerCase());
			}
			i++;
		}

		return tmp;
	}

	/**
	 * 
	 * @param orginIds
	 *            original ID array
	 * @param inserted
	 *            inserted ID Array
	 * @param deleted
	 *            deleted ID Array
	 * @return
	 */
	public static Long[] filterIdArray(Long[] orginIds, Long[] inserted, Long[] deleted) {
		java.util.LinkedHashSet hs = new java.util.LinkedHashSet();
		for (int i = 0; orginIds != null && i < orginIds.length; i++) {
			hs.add(orginIds[i]);
		}

		for (int i = 0; inserted != null && i < inserted.length; i++) {
			hs.add(inserted[i]);
		}

		for (int i = 0; deleted != null && i < deleted.length; i++) {
			hs.remove(deleted[i]);
		}

		Long[] ids = new Long[hs.size()];

		hs.toArray(ids);

		// bubbleSort(ids);

		return ids;

	}

	public static void bubbleSort(Long[] x) {
		int n = x.length;
		for (int pass = 1; pass < n; pass++) { // count how many times
			for (int i = 0; i < n - pass; i++) {
				if (x[i].longValue() > x[i + 1].longValue()) {
					Long temp = x[i];
					x[i] = x[i + 1];
					x[i + 1] = temp;
				}
			}
		}
	}

	/**
	 * 
	 * @param pdIdStr
	 *            id string with separator ",", e.g, "1,4,6,2"
	 * @return
	 */
	public static Long[] parseIdStringToIdArray(String pdIdStr) {
		if (pdIdStr == null || pdIdStr.length() == 0)
			return null;

		ArrayList<Long> al = new ArrayList<Long>();
		StringTokenizer st = new StringTokenizer(pdIdStr, ",");
		while (st.hasMoreTokens()) {
			Long id = new Long(Long.parseLong(st.nextToken()));
			al.add(id);
		}
		Long[] ret = new Long[al.size()];
		al.toArray(ret);

		return ret;
	}

	public void setWhichAction(String whichAction) {
		this.whichAction = whichAction;
	}

	public CommonActionSupport() {
		super();
	}

	public void setGenericManager(CommonManager m) {
		super.setBaseManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getBaseManager();
	}

	public Function getFunction() {
		return new Function();
	}

	public String getFunctionOpenPeriodMessage() {
		Function fun = getFunction();
		if (fun == null || fun.getEditBegin() == null && fun.getEditEnd() == null)
			return null; // open period is anytime

		String tmp = "";
		if (fun.getEditBegin() != null) {
			tmp = DateFormat.getInstance().format(fun.getEditBegin()) + " ~ ";
		}

		if (fun.getEditEnd() != null) {
			tmp = tmp + DateFormat.getInstance().format(fun.getEditEnd());
		}

		return tmp;

	}

	public boolean getRecordEditable() {
		/*
		 * Date now = new Date(); Function fun = getFunction(); if (fun == null
		 * || (fun.getEditBegin() == null && fun.getEditEnd() == null)) return
		 * true;
		 * 
		 * if (fun == null || fun.getEditBegin() != null &&
		 * now.before(fun.getEditBegin()) == true) { return false; }
		 * 
		 * if (fun == null || fun.getEditEnd() != null &&
		 * now.after(fun.getEditEnd()) == true) { return false; }
		 */

		return true;
	}

	public String getCssFile() {
		return getText("common.style.default");
	}

	public boolean checkGroup(SessionUser su, String groupKey) {
		if (su == null || su.getRole() == null || su.getRole().size() == 0) {
			return false;
		}

		Set groups = su.getRole();
		if (groups != null) {
			Iterator i = groups.iterator();
			while (i.hasNext()) {
				Group g = (Group) i.next();
				if (groupKey.equals(g.getGroupKey())) {
					return true;
				}
			}
		}

		return false;
	}

	public List getSelectList() {
		ArrayList<NameValue> al = new ArrayList<NameValue>();
		NameValue nv = null;
		for (int i = 0; i <= 10; i++) {
			nv = new NameValue(i, String.valueOf(i));
			al.add(nv);
		}
		return al;
	}

	public Long[] getIdsFromGroupList(List tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			for (int i = 0; i < tlist.size(); i++) {
				Group t = (Group) tlist.get(i);
				if (t != null)
					al.add(t.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);

		return lng;
	}

	public List getGroupListByIds(Long[] tlist) {
		ArrayList<Group> al = new ArrayList<Group>();
		if (tlist != null) {
			for (int i = 0; i < tlist.length; i++) {
				Group t = (Group) getGenericManager().getGroupById(tlist[i]);
				if (t != null)
					al.add(t);
			}
		}
		return al;
	}
	
	public Group getGroupById(String id){		
		return getGenericManager().getGroupById(Long.parseLong(id));
	}

	public String getSubmitChecking() {
		return submitChecking;
	}

	public void setSubmitChecking(String submitChecking) {
		this.submitChecking = submitChecking;
	}

	public List getSrctypeList() {
		return getAppPropertyList("quotedprice.srctype");
	}

	public List getSpecificationList() {
		return getAppPropertyList("customerPrice.unit");
	}

	public List getTextFontList() {
		return getAppPropertyList("common.textFont");
	}

	public List getContactsList() {
		return getAppPropertyList("member.contacts");
	}
	
	public List getQaList() {
		System.out.println("getQaList");
		return getAppPropertyList("qa.type");
	}

	public List removeFromList(List mainLst, List subList) {
		if (subList == null || mainLst == null)
			return mainLst;

		List al = new ArrayList();
		for (int i = 0; i < mainLst.size(); i++) {
			if (!subList.contains(mainLst.get(i))) {
				al.add(mainLst.get(i));
			}
		}

		return al;
	}

	public MyProperties getMyProperties() {
		ServletContext servletContext = getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
		return myProperties;
	}
	
	
	public Date getCurrentTimestamp() {
		return Tools.getCurrentTimestamp();
	}
	

	public List<AppProperty> getWidthUnitList() {
		return super.getAppPropertyList("specification.width");
	}

	public List<AppProperty> getHeightUnitList() {
		return super.getAppPropertyList("specification.height");
	}

	public List<AppProperty> getUnitNameList() {
		return super.getAppPropertyList("specification.unitName");
	}

	public List<AppProperty> getTaxList() {
		return super.getAppPropertyList("common.tax");
	}

	public List<AppProperty> getFilesrcList() {
		return super.getAppPropertyList("common.filesrc");
	}

	public List<AppProperty> getPickList() {
		return super.getAppPropertyList("common.pick");
	}

	public List<AppProperty> getProduceStatusList() {
		return super.getAppPropertyList("produce.status");
	}

	public List<AppProperty> getCountryList() {
		return super.getAppPropertyList("common.county");
	}
	
	public List<AppProperty> getDeliveryMethodList() {
		return super.getAppPropertyList("delivery.method");
	}
	
	public List getQuotedPricePrint() {
		return getAppPropertyList("quotedprice.print");
	}
	
	public List getServiceMode() {
		return getAppPropertyList("service.mode");
	}
	
	public List getPriceTypeList() {
		return getAppPropertyList("customerprice.type");
	}

	public List getCustomerPriceList() {
		return getAppPropertyList("quotedPrice.customerprice");
	}
	
	public List getDiscountList() {
		return getAppPropertyList("quotedprice.discount");
	}
	
	public List getHrefTarget() {
		return getAppPropertyList("href.target");
	}
	
	public List getCarouselTypes() {
		return getAppPropertyList("carousel.type");
	}
	
	
	
}
