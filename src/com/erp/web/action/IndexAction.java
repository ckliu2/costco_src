package com.erp.web.action;

import com.erp.value.*;
import com.erp.service.ERPManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;

public class IndexAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private ProductType productType;
	Product product;
	String keyword, subject, content;
	Web web;

	public IndexAction() {
		log = LogFactory.getLog(com.erp.web.action.IndexAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("PRODUCTTYPE");
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType val) {
		productType = val;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Web getWeb() {
		return web;
	}

	public void setWeb(Web web) {
		this.web = web;
	}

	public void setGenericManager(ERPManager m) {
		super.setGenericManager(m);
	}

	public ERPManager getGenericManager() {
		return (ERPManager) super.getGenericManager();
	}

	public String list() {
		return SUCCESS;
	}

	public List<ProductType> getProductTypeList() {
		System.out.println("getProductTypeList");
		return getGenericManager().getProductTypeList();
	}

	public ProductType getProductTypeById() {
		return getGenericManager().getProductTypeById(productType.getId());
	}

	public List<Product> getProductClassByCategory() {
		productType = getProductTypeById();
		return getGenericManager().getProductList(productType);
	}

	public Product getProductById() {
		product = getGenericManager().getProductById(product.getId());
		System.out.println("getProductById product.Overview=" + product.getOverview());
		return product;
	}

	public List<Product> getProductSearch() {
		System.out.println("getProductSearch keyword=" + keyword);
		return getGenericManager().getProductList(keyword);
	}

	public List<Carousel> getCarouselList() {
		AppProperty type = getGenericManager().getAppPropertyByCode("carousel.type.index");
        return getGenericManager().getCarouselList(type);
	}
	
	public List<Carousel> getSolutionlList()
    {
    	AppProperty type = getGenericManager().getAppPropertyByCode("carousel.type.solution");
        return getGenericManager().getCarouselList(type);
    }

	public Web getWebById(Long id) {
		System.out.println("getWebById id=" + id);
		// System.out.println("getWebById web.id="+web.getId());
		return getGenericManager().getWebById(id);
	}

	public String sendMailJSON() {

		String sql = " dbo.sendMail 'jeffrey@sanyuh.com','" + subject + "','" + content + "' ";
		getGenericManager().executeSQL(sql);

		String sql1 = " dbo.sendMail 'cindy@sanyuh.com','" + subject + "','" + content + "' ";
		getGenericManager().executeSQL(sql1);

		String sql2 = " dbo.sendMail 'kai4067@yahoo.com.tw','" + subject + "','" + content + "' ";
		getGenericManager().executeSQL(sql2);

		return SUCCESS;
	}
}
