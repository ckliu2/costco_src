package com.erp.value;

import java.util.*;
public class ProductComparator implements Comparator<Product> {

    public int compare(Product e1, Product e2) {
        //return e1.getId().compareTo(e2.getId());
    	
    	Integer a=e1.getSeqNo();
    	Integer b=e2.getSeqNo();
    	
    	return a.compareTo(b);
    	
    	
    	//return e1.getSeqNo().compareTo(e2.getSeqNo());
    }

}
