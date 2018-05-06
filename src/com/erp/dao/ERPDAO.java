package com.erp.dao;

import com.erp.value.*;
import java.util.*;

import com.base.value.AppProperty;
import com.common.dao.CommonDAO;


public interface ERPDAO extends CommonDAO 
{
	
	//ProductType
    public abstract void saveProductType(ProductType val);

    public abstract void removeProductType(ProductType val);

    public abstract void removeProductType(Long id);

    public abstract ProductType findProductTypeById(Long id);

    public abstract List<ProductType> findAllProductType();
    
    public abstract Long[] getIdsFromProductTypeList(List<ProductType> lst);
    
    //Product
    public abstract void saveProduct(Product val);

    public abstract void removeProduct(Product val);

    public abstract void removeProduct(Long id);

    public abstract Product findProductById(Long id);

    public abstract List<Product> findAllProduct(ProductType type);
    
    public abstract List<Product> findAllProduct(String keyword);
    
    //Carousel
    public abstract void saveCarousel(Carousel val);

    public abstract void removeCarousel(Carousel val);

    public abstract void removeCarousel(Long id);

    public abstract Carousel findCarouselById(Long id);

    public abstract List<Carousel> findAllCarousel(AppProperty type);
    
    //Web
    public abstract void saveWeb(Web val);
    
    public abstract Web findWebById(Long id);
    
}

