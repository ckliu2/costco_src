package com.base.dao.hibernate;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import javax.servlet.ServletContext;

import com.base.dao.BaseDAO;
import com.base.util.MyProperties;
import com.base.value.AppProperty;
import com.base.value.FunctionCategory;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;
import com.base.value.Function;
import com.base.value.Group;
import com.mysql.jdbc.Statement;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import java.io.*;
import java.sql.*;
import com.opensymphony.xwork.ActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class BaseDAOHibernate extends HibernateDaoSupport implements BaseDAO {
	static List countryList;
	static List countyList;
	static HashMap functionMap;
	static HashMap functionKeyMap;
	static long preTimeMillis;
	static long DURATION_TIME = 1000 * 60 * 10; // 10 minute

	static Map<String, List<MiscCode>> cityMap;
	static {
		cityMap = new HashMap<String, List<MiscCode>>();
		functionMap = new LinkedHashMap<Long, Function>();
		functionKeyMap = new LinkedHashMap<String, Function>();
	}

	public BaseDAOHibernate() {
		super();
	}

	public SessionFactory getHibernateSessionFactory() {
		return getSessionFactory();
	}

	public Session getHibernateSession() {
		return SessionFactoryUtils.getSession(getSessionFactory(), false);
	}

	public List findCountryList() {
		if (countryList == null) {
			countryList = findMiscCodeKeys("country");
		}
		return countryList;
	}

	public List findCountyList() {
		if (countyList == null) {
			countyList = findMiscCodeKeys("county");
		}
		return countyList;
	}

	public List<MiscCode> findCityList(String county) {
		List<MiscCode> lst = (List<MiscCode>) cityMap.get(county);
		if (lst == null) {
			lst = findMiscCodeKeys(county);
			cityMap.put(county, lst);
		}
		return lst;
	}

	public List<AppProperty> findAppPropertyList(String kind) {
		return findAppPropertyListByKind(kind);
	}

	public List<AppProperty> findAppPropertyListBySubKind(String subkind) {
		Criteria c = getHibernateSession().createCriteria(AppProperty.class)
				.add(Expression.eq("subKind", subkind));
		return c.list();
	}

	public MiscCode findMiscCodeById(Long id) {
		if (id == null)
			return null;

		MiscCode miscCode = (MiscCode) getHibernateTemplate().get(com.base.value.MiscCode.class, id);
		if (miscCode == null)
			throw new ObjectRetrievalFailureException(com.base.value.MiscCode.class, id);
		else
			return miscCode;
	}

	/**
	 * findMiscCodeKey
	 */
	public List<MiscCode> findMiscCodeKey(String codeName, String keyName) {
		return findMiscCodeKey(codeName, keyName, -1, -1);
	}

	public List<MiscCode> findMiscCodeListByCodeName(String codeName) {
		return findMiscCodeKey(codeName, null);
	}

	public MiscCode findMiscCodeByCodeKeyName(String codeName, String keyName) {
		List<MiscCode> al = findMiscCodeKey(codeName, keyName);
		if (al.size() > 0)
			return (MiscCode) al.get(0);
		else
			return null;
	}

	/**
	 * findMiscCodeKey Overloading method for paging
	 */
	public List<MiscCode> findMiscCodeKey(String codeName, String keyName, int first, int max) {
		List<MiscCode> result = new ArrayList<MiscCode>();

		try {
			String hsql = "select MiscCode from com.base.value.MiscCode as MiscCode";

			boolean whr = true, and = false;
			if (keyName != null && !"".equals(keyName)) {
				hsql += (whr ? " where " : "");
				hsql += (and ? " and " : " ") + "MiscCode.keyName = :keyName";
				whr = false;
				and = true;
			}

			if (codeName != null && !"".equals(codeName)) {
				hsql += (whr ? " where " : "");
				hsql += (and ? " and " : " ") + "MiscCode.codeName = :codeName";
				whr = false;
				and = true;
			}

			hsql += "";
			Query query = getHibernateSession().createQuery(hsql);

			if (keyName != null && !"".equals(keyName))
				query.setParameter("keyName", keyName);
			if (codeName != null && !"".equals(codeName))
				query.setParameter("codeName", codeName);

			if (first > 0)
				query = query.setFirstResult(first);
			if (max > 0)
				query = query.setMaxResults(max);

			result = query.list();
			logger.debug(query.getQueryString());
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return result;
	}

	/**
	 * findMiscCodeKey Overloading method for paging
	 */
	public Function findFunctionByKey(String funKey) {
		if (funKey == null)
			return null;

		if (functionKeyMap.size() == 0 || (System.currentTimeMillis() - preTimeMillis) >= DURATION_TIME) {
			findAllFunction(true);
		}

		return (Function) functionKeyMap.get(funKey);
	}

	public AppProperty findAppPropertyById(Long id) {
		if (id == null)
			return null;

		AppProperty obj = (AppProperty) getHibernateTemplate().get(com.base.value.AppProperty.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.AppProperty.class,
					id);
		else
			return obj;
	}

	public AppProperty findAppPropertyByCode(String code) {
		Criteria c = getHibernateSession().createCriteria(AppProperty.class);
		c.add(Expression.eq("code", code));
		if (c.list().size() > 0) {
			return (AppProperty) c.list().get(0);
		} else {
			return null;
		}
	}

	/**
	 * findMiscCodeKeys
	 */
	public List<MiscCode> findMiscCodeKeys(String codeName) {
		return findMiscCodeKeys(codeName, -1, -1);
	}

	/**
	 * findMiscCodeKeys Overloading method for paging
	 */
	public List<MiscCode> findMiscCodeKeys(String codeName,
			int first, int max) {
		List<MiscCode> result = new ArrayList<MiscCode>();

		try {
			String hsql = "select MiscCode from com.base.value.MiscCode as MiscCode";

			boolean whr = true, and = false;
			if (codeName != null && !"".equals(codeName)) {
				hsql += (whr ? " where " : "");
				hsql += (and ? " and " : " ") + "MiscCode.codeName = :codeName";
				whr = false;
				and = true;
			}

			hsql += " order by MiscCode.keyName asc";
			Query query = getHibernateSession().createQuery(hsql);

			if (codeName != null && !"".equals(codeName))
				query.setParameter("codeName", codeName);

			if (first > 0)
				query = query.setFirstResult(first);
			if (max > 0)
				query = query.setMaxResults(max);

			result = query.list();

			for (int i = 0; i < result.size(); i++) {
				MiscCode row = result.get(i);
				result.set(i, row);
			}
			logger.debug(query.getQueryString());
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return result;
	}

	/**
	 * findAppPropertyListByKind
	 */
	public List<AppProperty> findAppPropertyListByKind(String kind) {
		return findAppPropertyListByKind(kind, -1, -1);
	}

	/**
	 * findAppPropertyListByKind Overloading method for paging
	 */
	public List<AppProperty> findAppPropertyListByKind(java.lang.String kind, int first, int max) {
		java.util.List<AppProperty> result = new java.util.ArrayList<AppProperty>();

		try {
			String hsql = "select AppProperty from com.base.value.AppProperty as AppProperty";

			boolean whr = true, and = false;
			if (kind != null && !"".equals(kind)) {
				hsql += (whr ? " where " : "");
				hsql += (and ? " and " : " ") + "AppProperty.kind = :kind";
				whr = false;
				and = true;
			}

			hsql += " order by AppProperty.seqNo asc";
			Query query = getHibernateSession().createQuery(hsql);

			if (kind != null && !"".equals(kind))
				query.setParameter("kind", kind);

			if (first > 0)
				query = query.setFirstResult(first);
			if (max > 0)
				query = query.setMaxResults(max);

			result = query.list();
			logger.debug(query.getQueryString());
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return result;
	}

	public List<AppProperty> findAppPropertyListByIdList(List<Long> ids) {
		ArrayList<AppProperty> al = new ArrayList<AppProperty>();
		for (int i = 0; ids != null && i < ids.size(); i++) {
			if (ids.get(i) == null)
				continue;
			AppProperty mc = findAppPropertyById((Long) ids.get(i));
			if (mc != null)
				al.add(mc);
		}
		return al;
	}

	public boolean isNormalString(String s) {
		if (s != null && s.trim().length() > 0)
			return true;
		return false;
	}

	public UploadedFile findUploadedFileById(Long id) {
		if (id == null)
			return null;

		UploadedFile obj = (UploadedFile) getHibernateTemplate().get(com.base.value.UploadedFile.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.UploadedFile.class, id);
		else
			return obj;
	}
	
	public Long[] getIdsFromUploadedFileList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                UploadedFile t = (UploadedFile) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getUploadedFileListByIds(Long[] ids)
    {
        ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                UploadedFile t = (UploadedFile) findUploadedFileById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }

	public void removeUploadedFile(UploadedFile obj) {
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.UploadedFile.class, obj);

		getHibernateTemplate().delete(obj);
	}

	public void saveUploadedFile(UploadedFile obj) {
		getHibernateTemplate().save(obj);
	}

	public void removeUploadedFile(Long id) {
		UploadedFile obj = findUploadedFileById(id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.UploadedFile.class, obj);
		getHibernateTemplate().delete(obj);
	}

	public SessionUser findSessionUserByLoginIdAndPassword(String uid, String pwd) {
		SessionUser su = new SessionUser();
		su.setLoginId("Demo");
		su.setName("Demo");
		return su;
	}

	public List<Function> findAllFunction() {
		return findAllFunction(false);
	}

	public List<Function> findAllFunction(boolean refresh) {
		if (refresh == true) {
			functionMap = new LinkedHashMap<Long, Function>();
			functionKeyMap = new LinkedHashMap<String, Function>();
		}

		if (functionMap != null && functionMap.size() > 0) {
			return new ArrayList(functionMap.values());
		}
		preTimeMillis = System.currentTimeMillis();
		java.util.List<Function> result = new java.util.ArrayList<Function>();

		try {
			String hsql = "select f from com.base.value.Function as f where f.disabled = :disabled order by f.category.seqNo, f.seqNo";

			Query query = getHibernateSession().createQuery(hsql);

			query.setParameter("disabled", new Boolean(false));

			result = query.list();

			Function fun;
			for (int i = 0; i < result.size(); i++) {
				fun = (Function) result.get(i);
				// System.out.println("=======>" + fun.getFunName() + ">>" +
				// fun.getCategory().getSeqNo());
				functionMap.put(fun.getId(), fun);
				functionKeyMap.put(fun.getFunKey(), fun);
			}
			logger.debug(query.getQueryString());
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return result;
	}

	public List<FunctionCategory> findFunctionCategoryListBySessionUser(SessionUser su) {
		List<FunctionCategory> al = new ArrayList<FunctionCategory>();

		String hsql = "select f from com.base.value.FunctionCategory as f order by f.seqNo";
		Query query = getHibernateSession().createQuery(hsql);
		List result = query.list();
		List<Function> ls = findFunctionListBySessionUser(su);
		for (int i = 0; i < ls.size(); i++) {
			Function fun = (Function) ls.get(i);
			FunctionCategory c = fun.getCategory();
			if (al.contains(c) == false) {
				al.add(c);
			}
		}
		return al;
	}

	public List<Function> findFunctionListByFunctionCategory(FunctionCategory c) {
		Criteria ca = getHibernateSession().createCriteria(Function.class);
		ca.add(Expression.eq("category", c));
		ca.addOrder(Order.asc("seqNo"));
		return ca.list();
	}

	public List<Function> findFunctionListBySessionUser(SessionUser su) {
		// System.out.println("hiber findFunctionListBySessionUser");

		List<Function> lst = findAllFunction(true);
		Function ff = null;
		List<Function> result = new ArrayList<Function>();

		for (int i = 0; i < lst.size(); i++) {
			ff = (Function) lst.get(i);
			// System.out.println("2可以授權使用的Menu>>"
			// +ff.getCategory().getName()+"/Item="+ ff.getFunName() );
			Iterator group = su.getRole().iterator();
			while (group.hasNext()) {
				Group g = (Group) group.next();
				// System.out.println("1可以授權使用的Menu>>"
				// +ff.getCategory().getName()+"/Item="+ ff.getFunName() + ">>"
				// + g.getGroupNameCh());
				if (ff.containGroup(g) == true) {

					if (result.contains(ff) == false) {
						// System.out.println("可以授權使用的Menu>>"
						// +ff.getCategory().getName()+"/Item="+ ff.getFunName()
						// + ">>" + g.getGroupNameCh());
						result.add(ff);
					}
					// continue;
				}
			}
		}

		return result;
	}

	public Function findFunctionById(Long id) {
		if (id == null)
			return null;

		if (functionMap.size() == 0 || (System.currentTimeMillis() - preTimeMillis) >= DURATION_TIME) {
			findAllFunction(true);
		}

		return (Function) functionMap.get(id);

	}

	public List<Group> findAllGroup() {
		return getHibernateTemplate().find("from Group");
	}

	public Group findGroupByKey(String key) {
		Criteria c = getHibernateSession().createCriteria(Group.class)
				.add(Expression.eq("groupKey", key));

		List al = c.list();

		if (al.size() > 0)
			return (Group) al.get(0);

		return null;
	}

	public List getOnlineUserFunctionListByFunctionCategoryList(List al) {
		if (al == null)
			return new ArrayList();

		Criteria c = getHibernateSession().createCriteria(Function.class)
				.add(Expression.in("category", al));
		Criteria co = c.createCriteria("category");
		co.addOrder(Order.asc("seqNo"));

		List tmp = c.list();
		Function f;
		Group g = findGroupByKey(Group.GROUP_GUEST);
		List result = new ArrayList();
		for (int i = 0; i < tmp.size(); i++) {
			f = (Function) tmp.get(i);

			if (f.containGroup(g) == true) {
				result.add(f);
			}
		}
		return result;
	}

	public List getAllOnlineUserFunctionList() {
		Criteria c = getHibernateSession().createCriteria(Function.class);
		c.add(Expression.not(Expression.eq("disabled", new Boolean(true))));

		List tmp = c.list();
		Function f;
		Group g = findGroupByKey(Group.GROUP_GUEST);
		List result = new ArrayList();
		for (int i = 0; i < tmp.size(); i++) {
			f = (Function) tmp.get(i);

			if (f.containGroup(g) == true) {
				result.add(f);
			}
		}
		return result;
	}

	public HttpSession getHttpSessionSession() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get("com.opensymphony.xwork.dispatcher.HttpServletRequest");
		HttpSession session = req.getSession();
		return session;
	}

	public void exportExcel(String sql, String outFile) {
		try {
			ServletContext servletContext = getHttpSessionSession().getServletContext();
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");

			jxl.write.WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(outFile));
			Connection conn = getHibernateSession().connection();
			java.sql.Statement Stmt = conn.createStatement();
			ResultSet rs = Stmt.executeQuery(sql);
			jxl.write.WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			// 產生基本欄位
			jxl.write.WritableFont wf = new jxl.write.WritableFont(jxl.write.WritableFont.TIMES, 10, jxl.write.WritableFont.NO_BOLD, false);
			jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf);
			Vector v = new Vector();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String ColumnName = rsmd.getColumnName(i);
				v.add(ColumnName); // 加入欄位
				jxl.write.Label title = new jxl.write.Label(i - 1, 0, ColumnName, wcfF);
				sheet.addCell(title);

			}
			int j = 0;
			while (rs.next()) {
				for (int i = 0; i < v.size(); i++) {
					String cname = (String) v.get(i);
					String value = rs.getString(cname);
					if (value != null) {
						if (value.length() > 0) {
							value.trim();
						}
					}
					jxl.write.Label mv = new jxl.write.Label(i, j + 1, value);
					sheet.addCell(mv);
				}
				j++;
			}

			rs.close();
			conn.close();
			workbook.write();
			workbook.close();
			System.out.println("exportExcel() successful!!");
		} catch (Exception e) {
			System.out.println("exportExcel() fail!! e=" + e.toString());
		}
	}

	public void executeSQL(String sql) {
		try {
			System.out.println("executeSQL sql="+sql);
			Connection conn = getHibernateSession().connection();
			java.sql.Statement smt = conn.createStatement();
			smt.execute(sql);
			conn.close();
		} catch (Exception e) {
			System.out.println("executeSQL sql error=" + e.toString());
		}
	}
	
	
	public void sendEmail(String email, String subject, String content) {
		try {
			Connection conn = getHibernateSession().connection();
			java.sql.Statement Stmt = conn.createStatement();
			String sql = " dbo.sendMail '" + email + "','" + subject + "','" + content + "' ";
			Stmt.executeQuery(sql);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}


}
