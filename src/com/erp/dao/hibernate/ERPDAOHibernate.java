package com.erp.dao.hibernate;

import com.erp.value.*;
import com.erp.dao.ERPDAO;
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

public class ERPDAOHibernate extends CommonDAOHibernate implements ERPDAO {

	public ERPDAOHibernate() {
	}

	// ProductType
	public void saveProductType(ProductType val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeProductType(ProductType val) {
		getHibernateTemplate().delete(val);
	}

	public void removeProductType(Long id) {
		ProductType obj = findProductTypeById(id);
		getHibernateTemplate().delete(obj);
	}

	public ProductType findProductTypeById(Long id) {
		if (id == null)
			return null;
		ProductType obj = (ProductType) getHibernateTemplate().get(com.erp.value.ProductType.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.erp.value.ProductType.class, id);
		else
			return obj;
	}

	public List<ProductType> findAllProductType() {
		return getHibernateTemplate().find("from ProductType order by seqNo asc");
	}

	// Product
	public void saveProduct(Product val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeProduct(Product val) {
		getHibernateTemplate().delete(val);
	}

	public void removeProduct(Long id) {
		Product obj = findProductById(id);
		getHibernateTemplate().delete(obj);
	}

	public Product findProductById(Long id) {
		if (id == null)
			return null;
		Product obj = (Product) getHibernateTemplate().get(com.erp.value.Product.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.erp.value.Product.class, id);
		else
			return obj;
	}

	public List<Product> findAllProduct(ProductType type) {
		List<Product> al = new ArrayList<Product>();
		Criteria c = getHibernateSession().createCriteria(Product.class);
		if (type != null) {
			List ls = c.list();
			for (int i = 0; i < ls.size(); i++) {
				Product product = (Product) ls.get(i);
				boolean r = product.getTypes().contains(type);
				//System.out.println(product.getNo() + "--" + type.getName() + "--" + r);
				if (r) {
					al.add(product);
				}				
			}
			
			Collections.sort(al, new ProductComparator());		
			
			return al;
		} else {
			c.addOrder(Order.asc("seqNo"));
			return c.list();
		}

	}

	public Long[] getIdsFromProductTypeList(List tlist) {
		ArrayList<Long> al = new ArrayList<Long>();
		if (tlist != null) {
			for (int i = 0; i < tlist.size(); i++) {
				ProductType t = (ProductType) tlist.get(i);
				if (t != null)
					al.add(t.getId());
			}
		}
		Long lng[] = new Long[al.size()];
		al.toArray(lng);

		return lng;
	}
	
	public List<Product> findAllProduct(String keyword) {		
		Criteria c = getHibernateSession().createCriteria(Product.class);
		Disjunction disjunction = Restrictions.disjunction();
		Criterion c1 = Restrictions.like("no", "%" + keyword + "%");
		Criterion c2 = Restrictions.like("overview", "%" + keyword + "%");		
		disjunction.add(c1);
		disjunction.add(c2);
		c.add(disjunction);
		return c.list();
	}
	
	
	//Carousel
	public void saveCarousel(Carousel val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCarousel(Carousel val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCarousel(Long id)
    {
        Carousel obj = findCarouselById(id);
        getHibernateTemplate().delete(obj);
    }

    public Carousel findCarouselById(Long id)
    {
        if (id == null)
            return null;
        Carousel obj = (Carousel)getHibernateTemplate().get(com.erp.value.Carousel.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.erp.value.Carousel.class, id);
        else
            return obj;
    }

    public List<Carousel> findAllCarousel(AppProperty type)
    {
        Criteria c = getHibernateSession().createCriteria(Carousel.class);				
		if (type != null) {
			c.add(Expression.eq("type", type));
		}
		c.addOrder(Order.asc("type"));
		c.addOrder(Order.asc("seqNo"));
		return c.list();
    }
    
    //Web
    public void saveWeb(Web val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }
    
    public Web findWebById(Long id)
    {
        if (id == null)
            return null;
        Web obj = (Web)getHibernateTemplate().get(com.erp.value.Web.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.erp.value.Web.class, id);
        else
            return obj;
    }
	
	
}
