package com.common.web.action;

import java.util.List;
import com.base.value.*;
import com.common.value.*;

public class MenuService
{
    private String contextRoot;
    public static final String IDENT = "    ";
    
    public MenuService(String contextRoot)
    {
        super();
        this.contextRoot = contextRoot;
    }
    
    public String renderMenu1(SessionUser su)
    {       
        StringBuffer sb = new StringBuffer();
        
        /*
        sb.append(makeMenuBegin1(su));
        
        int cnt = 0; 
        System.out.println("flist.size()="+flist.size());
        for (int i = 0; i < flist.size(); i++) {
            fun = (Function) flist.get(i);
            //System.out.println("renderMenu=>"+fun.getFunName() + ">>" + fun.getCategory().getSeqNo());
            if (fun.getCategory() != null && fun.getCategory().getId() != null) 
            {
                if (catId != fun.getCategory().getId().longValue()) {
                    if (cnt == 0) {
                        sb.append(makeMenuCategoryBeginFirst(fun));
                    } else {
                        sb.append(makeMenuCategoryBegin(fun));
                    }
                    cnt++;
                    catId = fun.getCategory().getId().longValue();
                }
            }
            sb.append(makeMenuItem(fun));
        }       
        if (cnt > 0){
            sb.append(makeMenuCategoryEnd());
        }else{
            sb.append("<div style=\"height:100px\" ><a href=\"#\">沒有相關權限的功能項目</a></div>");
        }
        
        sb.append(makeMenuEnd1());
        */
        
        return sb.toString();
    }
    
    

    public String renderMenu(List flist, SessionUser su)
    {
        long catId = 0;
        Function fun = null;
        StringBuffer sb = new StringBuffer();
        sb.append(makeMenuBegin(su));
        int cnt = 0; 
        System.out.println("flist.size()="+flist.size());
        for (int i = 0; i < flist.size(); i++) {
            fun = (Function) flist.get(i);
            //System.out.println("renderMenu=>"+fun.getFunName() + ">>" + fun.getCategory().getSeqNo());
            if (fun.getCategory() != null && fun.getCategory().getId() != null) 
            {
                if (catId != fun.getCategory().getId().longValue()) {
                    if (cnt == 0) {
                        sb.append(makeMenuCategoryBeginFirst(fun));
                    } else {
                        sb.append(makeMenuCategoryBegin(fun));
                    }
                    cnt++;
                    catId = fun.getCategory().getId().longValue();
                }
            }
            sb.append(makeMenuItem(fun));
        }       
        if (cnt > 0){
            sb.append(makeMenuCategoryEnd());
        }else{
            sb.append("<div style=\"height:100px\" ><a href=\"#\">沒有相關權限的功能項目</a></div>");
        }
        
        sb.append(makeMenuEnd());
        
        return sb.toString();
    }
    
    public String makeMenuCategoryBegin(Function fun)
    {
        
        String menu = IDENT + "  </div>\n" +
                      IDENT + "  <span class=\"title\"><img src=\"" + getContextRoot() + "/images/expanded.gif\" class=\"arrow\" alt=\"" + fun.getCategory().getName() + "\" />" + fun.getCategory().getName() + "</span>\n" +
                      IDENT + "  <div class=\"submenu\">\n";


        return menu;
    }

    public String makeMenuCategoryBeginFirst(Function fun)
    {
        String menu = IDENT + "  <span class=\"title\" id=\"top\"><img src=\"" + getContextRoot() + "/images/expanded.gif\" class=\"arrow\" alt=\"" + fun.getCategory().getName() + "\" />" + fun.getCategory().getName() + "</span>\n" +
                      IDENT + "  <div class=\"submenu\">\n";
        
        return menu;
    }

    
    public String makeMenuCategoryBeginFirst(SessionUser su)
    {
        String menu = IDENT + "  <span class=\"title\" id=\"top\"><img src=\"" + getContextRoot() + "/images/expanded.gif\" class=\"arrow\" alt=\"" + su.getName() + "\" />" + su.getName() + "</span>\n" +
                      IDENT + "  <div class=\"submenu\">\n";
        
        return menu;
    }

    public static String makeMenuCategoryEnd()
    {
        return IDENT + "  </div>\n";
    }

    public static String makeMenuItem(Function fun)
    {
        return IDENT + "    <a href=\"" + fun.getFunUrl() + "\">" + fun.getFunName() + "</a>\n";
    }

    public static String makeMenuBegin(SessionUser su)
    {
        return IDENT + "<div class=\"sdmenu\">\n";
    }

    public static String makeMenuEnd()
    {
        return IDENT + "</div>\n";
    }
    
    public static String makeMenuBegin1(SessionUser su)
    {
        return IDENT + "<div class=\"easyui-menu\" data-options=\"inline:true\" style=\"width:100%\">\n";
    }

    public static String makeMenuEnd1()
    {
        return IDENT + "</div>\n<div class=\"menu-sep\"></div>";
    }

    public String getContextRoot()
    {
        return contextRoot;
    }

    public void setContextRoot(String contextRoot)
    {
        this.contextRoot = contextRoot;
    }

}
