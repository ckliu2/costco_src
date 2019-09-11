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

import com.base.value.AppProperty;
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
		return getHibernateTemplate().find("from Store order by name");
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
	
	public List<Billboard> findAllBillboard(Store store,AppProperty size) {
		Criteria c = getHibernateSession().createCriteria(Billboard.class);
		c.add(Expression.eq("store", store));
		c.add(Expression.eq("size", size));
		c.addOrder(Order.asc("no"));
		return c.list();
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

	public Rent findRentById(int year, Store store, int no) {
		Criteria c = getHibernateSession().createCriteria(Rent.class);
		c.createCriteria("billboard", "b");
		c.add(Expression.eq("b.store", store));
		c.add(Expression.eq("b.no", no));
		c.add(Expression.eq("year", year));
		List ls = c.list();
		if (ls.size() > 0) {
			return (Rent) ls.get(0);
		} else {
			return null;
		}
	}

	public List<Rent> findAllRent(int year, Store store, Vendor vendor, boolean havaPhoto) {
		Criteria c = getHibernateSession().createCriteria(Rent.class);
		c.createCriteria("billboard", "b");

		Integer[] years = new Integer[2];
		years[0] = year;
		years[1] = year - 1;
		c.add(Restrictions.in("year", years));
		// c.add(Restrictions.in("year", new Integer[]{2019,2018}));

		c.addOrder(Order.asc("b.store"));
		c.addOrder(Order.asc("b.no"));

		if (store != null) {
			c.add(Expression.eq("b.store", store));
		}
		if (vendor != null) {
			c.add(Expression.eq("vendor", vendor));
		}
		if (havaPhoto) {
			c.add(Restrictions.isNotNull("photo"));
		} else {
			c.add(Restrictions.isNull("photo"));
		}
		return c.list();
	}

	public List<Rent> findSameSizeAllRent(Rent rent) {
		Criteria c = getHibernateSession().createCriteria(Rent.class);
		c.createCriteria("billboard", "b");
		
		Integer[] years = new Integer[2];
		years[0] = rent.getYear();
		years[1] = rent.getYear() - 1;
		c.add(Restrictions.in("year", years));

		//c.add(Restrictions.not(Expression.eq("year", rent.getYear() + 1)));

		c.add(Restrictions.not(Expression.eq("b.no", rent.getBillboard().getNo())));

		c.add(Expression.eq("b.store", rent.getBillboard().getStore()));
		c.add(Expression.eq("b.size", rent.getBillboard().getSize()));
		c.addOrder(Order.asc("b.no"));
		return c.list();
	}
	
	public List<Rent> findSameSizeOrderAllRent(Rent rent) {
		Criteria c = getHibernateSession().createCriteria(Rent.class);
		c.createCriteria("billboard", "b");
		c.add(Expression.eq("year", rent.getYear()+1));
		c.add(Expression.eq("b.store", rent.getBillboard().getStore()));
		c.add(Expression.eq("b.size", rent.getBillboard().getSize()));
		c.addOrder(Order.asc("b.no"));
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
