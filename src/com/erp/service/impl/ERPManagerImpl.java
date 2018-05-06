package com.erp.service.impl;

import com.erp.service.ERPManager;
import com.erp.dao.ERPDAO;
import com.erp.value.*;
import java.util.*;

import com.base.value.AppProperty;
import com.common.service.impl.CommonManagerImpl;


public class ERPManagerImpl extends CommonManagerImpl implements ERPManager
{

    public ERPManagerImpl()
    {
    }

    public ERPDAO getGenericDAO()
    {
        return (ERPDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ERPDAO dao)
    {
        super.setGenericDAO(dao);
    }

    
    //ProductType
    public void saveProductType(ProductType val)
    {
        getGenericDAO().saveProductType(val);
    }

    public void removeProductType(ProductType val)
    {
        getGenericDAO().removeProductType(val);
    }

    public void removeProductType(Long id)
    {
        getGenericDAO().removeProductType(id);
    }

    public ProductType getProductTypeById(Long id)
    {
         return getGenericDAO().findProductTypeById(id);
    }

    public List<ProductType> getProductTypeList()
    {
        return getGenericDAO().findAllProductType();
    }
    
    public Long[] getIdsFromProductTypeList(List<ProductType> lst)
    {
        return getGenericDAO().getIdsFromProductTypeList(lst);
    }
    
    //Product
    public void saveProduct(Product val)
    {
        getGenericDAO().saveProduct(val);
    }

    public void removeProduct(Product val)
    {
        getGenericDAO().removeProduct(val);
    }

    public void removeProduct(Long id)
    {
        getGenericDAO().removeProduct(id);
    }

    public Product getProductById(Long id)
    {
         return getGenericDAO().findProductById(id);
    }

    public List<Product> getProductList(ProductType type)
    {
        return getGenericDAO().findAllProduct(type);
    }
    
    public List<Product> getProductList(String keyword)
    {
        return getGenericDAO().findAllProduct(keyword);
    }
    
    //Carousel
    public void saveCarousel(Carousel val)
    {
        getGenericDAO().saveCarousel(val);
    }

    public void removeCarousel(Carousel val)
    {
        getGenericDAO().removeCarousel(val);
    }

    public void removeCarousel(Long id)
    {
        getGenericDAO().removeCarousel(id);
    }

    public Carousel getCarouselById(Long id)
    {
         return getGenericDAO().findCarouselById(id);
    }

    public List<Carousel> getCarouselList(AppProperty type)
    {
        return getGenericDAO().findAllCarousel(type);
    }
    
    //Web
    public void saveWeb(Web val)
    {
        getGenericDAO().saveWeb(val);
    }
    
    public Web getWebById(Long id)
    {
         return getGenericDAO().findWebById(id);
    }
    
}

