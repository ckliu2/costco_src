package com.common.dao.hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.toplink.SessionFactory;

import com.base.dao.hibernate.BaseDAOHibernate;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.common.dao.CommonDAO;
import com.common.value.*;
import com.base.value.*;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;

public class CommonDAOHibernate extends BaseDAOHibernate implements CommonDAO {
	public Long[] getIdsFromFunctionCategoryList(List tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			for (int i = 0; i < tlist.size(); i++) {
				FunctionCategory t = (FunctionCategory) tlist.get(i);
				if (t != null)
					al.add(t.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);

		return lng;
	}

	public List getFunctionCategoryListByIds(Long[] ids) {
		ArrayList<FunctionCategory> al = new ArrayList<FunctionCategory>();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				FunctionCategory t = (FunctionCategory) findFunctionCategoryById(ids[i]);
				if (t != null)
					al.add(t);
			}
		}
		return al;
	}

	public Set getGroupListByIds(Long[] ids) {
		Set groups = new HashSet();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Group t = (Group) findGroupById(ids[i]);
				if (t != null)
					groups.add(t);
			}
		}
		return groups;
	}

	public List getGroupListByIds1(Long[] ids) {
		List groups = new ArrayList<Group>();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Group t = (Group) findGroupById(ids[i]);
				if (t != null)
					groups.add(t);
			}
		}
		return groups;
	}

	public List getSurveyGroupListByIds(Long[] ids) {
		ArrayList<Group> al = new ArrayList<Group>();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Group t = (Group) findGroupById(ids[i]);
				if (t != null)
					al.add(t);
			}
		}
		return al;
	}

	public List findAllAppProperty() {
		return getHibernateTemplate().find("select distinct app.kind from AppProperty as app order by app.kind");
	}

	public void saveAppProperty(AppProperty obj) {
		getHibernateTemplate().saveOrUpdate(obj);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuffer()).append("id set to: ").append(obj.getId()).toString());
	}

	public void removeAppProperty(Long id) {
		getHibernateTemplate().delete(findAppPropertyById(id));
	}

	public void removeAppProperty(AppProperty obj) {
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.AppProperty.class, obj);
		getHibernateTemplate().delete(obj);
	}

	public Long[] getIdsFromAppPropertyList(List tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			for (int i = 0; i < tlist.size(); i++) {
				AppProperty t = (AppProperty) tlist.get(i);
				if (t != null)
					al.add(t.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);

		return lng;
	}

	public List getMaxSeqNoOfAppPropertyByKind(String kind) {
		java.util.List result = new java.util.ArrayList();
		try {
			String hsql = "select max(app.seqNo) from AppProperty as app where app.kind=:kind";
			Query query = getHibernateSession().createQuery(hsql);
			query.setParameter("kind", kind);
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

	public List<AppProperty> findAllAppPropertyByIds(Long[] ids) {
		ArrayList<AppProperty> al = new ArrayList<AppProperty>();
		if (ids != null) {
			for (int j = 0; j < ids.length; j++) {
				AppProperty a = findAppPropertyById(ids[j]);
				al.add(a);
			}
		}
		return al;
	}

	public void saveChecking(Checking obj) {
		getHibernateTemplate().saveOrUpdate(obj);
		if (logger.isDebugEnabled())
			logger.debug((new StringBuffer()).append("id set to: ").append(obj.getId()).toString());
	}

	public Group findGroupById(Long id) {
		if (id == null)
			return null;
		Group obj = (Group) getHibernateTemplate().get(com.base.value.Group.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.Group.class, id);
		else
			return obj;
	}

	public Group findGroupByGroupKey(String GroupKey) {
		Group group = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Group.class);
			c.add(Expression.eq("groupKey", GroupKey));
			List result = c.list();
			if (result.size() > 0)
				group = (Group) result.get(0);
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}
		return group;
	}

	public void saveGroup(Group val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeGroup(Group val) {
		getHibernateTemplate().delete(val);
	}

	public void removeGroup(Long id) {
		Group obj = findGroupById(id);
		getHibernateTemplate().delete(obj);
	}

	public List findAllGroup() {
		return getHibernateTemplate().find("from Group order by id asc");
	}

	public void saveFunction(Function val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeFunction(Function val) {
		getHibernateTemplate().delete(val);
	}

	public void removeFunction(Long id) {
		Function obj = findFunctionById(id);
		getHibernateTemplate().delete(obj);
	}

	public Function findFunctionById(Long id) {
		if (id == null)
			return null;
		Function obj = (Function) getHibernateTemplate().get(com.base.value.Function.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.Function.class, id);
		else
			return obj;
	}

	public List findAllFunction() {
		return getHibernateTemplate().find("from Function order by category");
	}

	public List findOnlineFunction() {
		return getHibernateTemplate().find("from Function order by category");
	}

	public List findCategoryList() {
		return new ArrayList(); // TODO
	}

	public void saveFunctionCategory(FunctionCategory val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeFunctionCategory(FunctionCategory val) {
		getHibernateTemplate().delete(val);
	}

	public void removeFunctionCategory(Long id) {
		FunctionCategory obj = findFunctionCategoryById(id);
		getHibernateTemplate().delete(obj);
	}

	public FunctionCategory findFunctionCategoryById(Long id) {
		if (id == null)
			return null;
		FunctionCategory obj = (FunctionCategory) getHibernateTemplate().get(com.base.value.FunctionCategory.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.FunctionCategory.class, id);
		else
			return obj;
	}

	public List findAllFunctionCategory() {
		return getHibernateTemplate().find("from FunctionCategory order by seqNo");
	}

	public List findFrontFunctionCategoryList() {
		return getHibernateTemplate().find("from FunctionCategory order by seqNo ");
	}

	public void saveFunctionAuthority(FunctionAuthority val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeFunctionAuthority(FunctionAuthority val) {
		getHibernateTemplate().delete(val);
	}

	public void removeFunctionAuthority(Long id) {
		FunctionAuthority obj = findFunctionAuthorityById(id);
		getHibernateTemplate().delete(obj);
	}

	public FunctionAuthority findFunctionAuthorityById(Long id) {
		if (id == null)
			return null;
		FunctionAuthority obj = (FunctionAuthority) getHibernateTemplate().get(com.base.value.FunctionAuthority.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.base.value.FunctionAuthority.class, id);
		else
			return obj;
	}

	public List findAllFunctionAuthority() {
		return getHibernateTemplate().find("from FunctionAuthority");
	}

	public List findGroupList() {
		return findAllGroup();
	}

	public Long[] getIdsFromGroupList(Set tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			Iterator i = tlist.iterator();
			while (i.hasNext()) {
				Group g = (Group) i.next();
				// System.out.println("getIdsFromGroupList
				// g="+g.getGroupName());
				al.add(g.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);
		return lng;
	}

	public Long[] getIdsFromGroupList(List tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			for (int i = 0; i < tlist.size(); i++) {
				Group g = (Group) tlist.get(i);
				al.add(g.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);
		return lng;
	}

	public Long[] getIdsFromSurveyGroupList(List tlist) {
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

	public void saveMember(Member val) {		
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeMember(Member val) {
		getHibernateTemplate().delete(val);
	}

	public void removeMember(Long id) {
		Member obj = findMemberById(id);
		getHibernateTemplate().delete(obj);
	}

	

	public Member findMemberById(Long id) {
		if (id == null)
			return null;
		Member obj = (Member) getHibernateTemplate().get(com.common.value.Member.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.common.value.Member.class, id);
		else
			return obj;
	}

	public Member findMemberByEmail(String email) {
		System.out.println("findMemberByEmail..email=" + email);
		if (email == null)
			return null;
		Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);
		c.add(Expression.eq("email", email));
		List ll = c.list();
		if (ll.size() > 0)
			return (Member) ll.get(0);
		else
			return null;
	}

	public List<Member> findAllMember() {
		return getHibernateTemplate().find("from Member order by id asc");
	}

	public int findAllMemberSize(String keyword, String departmentId, int graduationYear, int pageSize, int pageIndex) {
		String filter = "";
		if (keyword != null && !keyword.equals("")) {
			filter += "and (id like'%" + keyword + "%' or cname like'%" + keyword + "%')";
		}

		if (graduationYear != 0) {
			filter += "and (graduationYear='" + graduationYear + "') ";
		}

		if (departmentId != null && !departmentId.equals("")) {
			filter += "and department.id = '" + departmentId + "' ";
		}

		String hsql = "from Member where admin=0 and alumnus=true and highest=true " + filter + " order by department";

		Query query = getHibernateSession().createQuery(hsql);
		return query.list().size();
	}

	public List<Member> findAllMember(String keyword, String departmentId, int graduationYear, int pageSize, int pageIndex) {
		String filter = "";
		if (keyword != null && !keyword.equals("")) {
			filter += "and (id like'%" + keyword + "%' or cname like'%" + keyword + "%')";
		}

		if (graduationYear != 0) {
			filter += "and (graduationYear='" + graduationYear + "') ";
		}

		if (departmentId != null && !departmentId.equals("")) {
			filter += "and department.id = '" + departmentId + "' ";
		}

		String hsql = "from Member where admin=0 and highest=true " + filter + " order by department";

		Query query = getHibernateSession().createQuery(hsql);
		query.setFirstResult(pageSize * pageIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<Member> findAllMember(String keyword) {
		Criteria c = getHibernateSession().createCriteria(Member.class);
		if (keyword != null) {
			c.add(Restrictions.or(Restrictions.like("name", "%" + keyword + "%"), Restrictions.like("cellphone", "%" + keyword + "%")));
		}
		c.addOrder(Order.asc("name"));
		return c.list();
	}

	public List<Member> getMemberListById(Long[] ids) {
		ArrayList<Member> al = new ArrayList<Member>();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Member m = (Member) findMemberById(ids[i]);
				al.add(m);
			}
		}
		return al;
	}

	public List<Member> findMemberByCardId(String cardId) {
		ArrayList<Member> al = new ArrayList<Member>();
		try {
			Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);

			c.add(Restrictions.or(Restrictions.like("id", "%" + cardId + "%"), Restrictions.like("name", "%" + cardId + "%")));

			List result = c.list();
			for (int i = 0; i < result.size(); i++) {
				Member m = (Member) result.get(i);
				al.add(m);

			}
			return al;
		} catch (HibernateException ex) {
			System.out.println("findMemberByCardId error!");
			return al;
		}

	}

	public List<Member> findQueryMember(String name) {

		if (name != null) {
			name.trim();
		}

		String hsql = "select m from Member as m where m.admin=false and ( m.cname like :cname or rgno like :rgno )";
		Query qry = getHibernateSession().createQuery(hsql);
		qry.setParameter("cname", "%" + name + "%");
		qry.setParameter("rgno", "%" + name + "%");

		List query = qry.list();
		ArrayList<Member> al = new ArrayList<Member>();
		for (int i = 0; i < query.size(); i++) {
			Member m = (Member) query.get(i);
			al.add(m);
			// System.out.println("¬d¸ßµ²ªG¡G"+m.getName());
		}
		return al;
	}

	public Member findMemberByLoginIdAndPassword(String loginId, String pwd) {
		Member user = null;

		try {
			Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);
			c.add(Expression.eq("cellphone", loginId));
			c.add(Expression.eq("password", pwd));
			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}
		return user;
	}

	public Member getMemberByRgnoAndIdNo(String rgno, String idNo) {
		Member user = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Member.class);
			c.add(Expression.eq("rgno", rgno));
			c.add(Expression.eq("idNo", idNo));
			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}
		return user;
	}

	public Member getMemberByIdNo(String idNo) {
		Member user = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Member.class);
			c.add(Expression.eq("idNo", idNo));
			c.addOrder(Order.desc("rgno"));
			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (HibernateException ex) {
			System.out.println(ex.toString());
		}
		return user;
	}

	public Member getMemberByIdNoAndBirthday(String idNo, String brithday) {
		Member user = null;
		try {
			Criteria c = getHibernateSession().createCriteria(Member.class);
			c.add(Expression.eq("idNo", idNo));
			Date d = Tools.convertToDate1(brithday);
			String mybrithday = d.getYear() + 1900 + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			System.out.println(mybrithday);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = (Date) format.parse(mybrithday + " 00:00:00");
			c.add(Expression.eq("birthday", date));
			c.add(Expression.eq("highest", true));
			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return user;
	}

	public List<Member> getMemberListByGroup(Group group) {
		List<Member> ls = new ArrayList<Member>();
		Set s = group.getMembers();
		Iterator members = s.iterator();
		while (members.hasNext()) {
			Member m = (Member) members.next();
			ls.add(m);
		}
		return ls;
	}

	public List<UploadedFile> findPhotoList() {
		return new ArrayList<UploadedFile>(); // TODO
	}

	public void saveMiscCode(MiscCode val) {
		getHibernateTemplate().save(val);
	}

	public void updateMiscCode(MiscCode val) {
		getHibernateTemplate().update(val);
	}

	public void removeMiscCode(MiscCode val) {
		getHibernateTemplate().delete(val);
	}

	public void removeMiscCode(Long id) {
		MiscCode obj = findMiscCodeById(id);
		getHibernateTemplate().delete(obj);
	}

	public List<MiscCode> findAllMiscCode() {
		return getHibernateTemplate().find("from MiscCode");
	}

	public Set getMemberListByIds(Long[] ids) {
		Set<Member> al = new HashSet();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Member m = (Member) findMemberById(ids[i]);
				al.add(m);
			}
		}
		return al;
	}

	public Long[] getIdsFromMemberList(Set tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			Iterator i = tlist.iterator();
			while (i.hasNext()) {
				Member m = (Member) i.next();
				al.add(m.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);
		return lng;
	}

	public Member findMemberByIdWithMD5(String id) {
		Member user = null;

		try {
			Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);
			c.add(Expression.eq("md5", id));

			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return user;
	}

	public Member getMemberByCellphone(String cellphone) {
		Member user = null;

		try {
			Criteria c = getHibernateSession().createCriteria(Member.class);
			c.add(Expression.eq("cellphone", cellphone));

			List result = c.list();
			if (result.size() > 0)
				user = (Member) result.get(0);
		} catch (HibernateException ex) {
			if (logger.isErrorEnabled()) {
				logger.error(ex.getMessage(), ex);
			}

			throw new RuntimeException(ex);
		}

		return user;
	}

	// Unit
	public void saveUnit(Unit val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeUnit(Unit val) {
		getHibernateTemplate().delete(val);
	}

	public void removeUnit(Long id) {
		Unit obj = findUnitById(id);
		getHibernateTemplate().delete(obj);
	}

	public Unit findUnitById(Long id) {
		if (id == null)
			return null;
		Unit obj = (Unit) getHibernateTemplate().get(com.common.value.Unit.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.common.value.Unit.class, id);
		else
			return obj;
	}

	public List<Unit> findAllUnit() {
		return getHibernateTemplate().find("from Unit");
	}

	public Set getUnitListByIds(Long[] ids) {
		Set units = new HashSet();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				Unit t = (Unit) findUnitById(ids[i]);
				if (t != null)
					units.add(t);
			}
		}
		return units;
	}

	public Long[] getIdsFromUnitList(Set lst) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (lst != null) {
			Iterator i = lst.iterator();
			while (i.hasNext()) {
				Unit g = (Unit) i.next();
				al.add(g.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);
		return lng;
	}

}
