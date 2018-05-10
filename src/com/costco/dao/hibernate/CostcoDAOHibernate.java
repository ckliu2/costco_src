package com.costco.dao.hibernate;

import com.costco.value.*;
import com.costco.dao.CostcoDAO;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.common.dao.hibernate.CommonDAOHibernate;

public class CostcoDAOHibernate extends CommonDAOHibernate implements CostcoDAO {

	public CostcoDAOHibernate() {
	}

	// Store
	public void saveStore(Store val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeStore(Store val) {
		getHibernateTemplate().delete(val);
	}

	public void removeStore(Long id) {
		Store obj = findStoreById(id);
		getHibernateTemplate().delete(obj);
	}

	public Store findStoreById(Long id) {
		if (id == null)
			return null;
		Store obj = (Store) getHibernateTemplate().get(com.costco.value.Store.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.costco.value.Store.class, id);
		else
			return obj;
	}

	public List<Store> findAllStore() {
		return getHibernateTemplate().find("from Store");
	}

	// Billboard
	public void saveBillboard(Billboard val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeBillboard(Billboard val) {
		getHibernateTemplate().delete(val);
	}

	public void removeBillboard(Long id) {
		Billboard obj = findBillboardById(id);
		getHibernateTemplate().delete(obj);
	}

	public Billboard findBillboardById(Long id) {
		if (id == null)
			return null;
		Billboard obj = (Billboard) getHibernateTemplate().get(com.costco.value.Billboard.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.costco.value.Billboard.class, id);
		else
			return obj;
	}

	public List<Billboard> findAllBillboard(Store store) {
		Criteria c = getHibernateSession().createCriteria(Billboard.class);
		if (store != null) {
			c.add(Expression.eq("store", store));
		}
		return c.list();
	}

	public List<Billboard> findAllBillboard() {
		return getHibernateTemplate().find("from Billboard");
	}

	// Rent
	public void saveRent(Rent val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeRent(Rent val) {
		getHibernateTemplate().delete(val);
	}

	public void removeRent(Long id) {
		Rent obj = findRentById(id);
		getHibernateTemplate().delete(obj);
	}

	public Rent findRentById(Long id) {
		if (id == null)
			return null;
		Rent obj = (Rent) getHibernateTemplate().get(com.costco.value.Rent.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.costco.value.Rent.class, id);
		else
			return obj;
	}

	public List<Rent> findAllRent(int year, Store store) {
		Criteria c = getHibernateSession().createCriteria(Rent.class);
		c.createCriteria("billboard", "b");
		c.add(Expression.eq("year", year));
		if (store != null) {
			c.add(Expression.eq("b.store", store));
		}
		return c.list();
	}

	// Vendor
	public void saveVendor(Vendor val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeVendor(Vendor val) {
		getHibernateTemplate().delete(val);
	}

	public void removeVendor(Long id) {
		Vendor obj = findVendorById(id);
		getHibernateTemplate().delete(obj);
	}

	public Vendor findVendorById(Long id) {
		if (id == null)
			return null;
		Vendor obj = (Vendor) getHibernateTemplate().get(com.costco.value.Vendor.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.costco.value.Vendor.class, id);
		else
			return obj;
	}

	public List<Vendor> findAllVendor() {
		return getHibernateTemplate().find("from Vendor");
	}

}
