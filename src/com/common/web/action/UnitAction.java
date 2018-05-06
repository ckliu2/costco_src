package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;


public class UnitAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Unit unit;
	private Long[] membersIds;
    private Long[] selectedUnitIds;
    private Set<Member> newMembers = new HashSet();

    public UnitAction()
    {
        log = LogFactory.getLog(com.common.web.action.UnitAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("UNIT");
    }

    public Unit getUnit()
    {
        return unit;
    }

    public void setUnit(Unit val)
    {
        unit = val;
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeUnit(unit.getId());
        return DELETE;
    }

    public String edit()
    {
        if (unit == null) {
            unit = new Unit();
        } else if (unit.getId() != null) {
            unit = getGenericManager().getUnitById(unit.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedUnitIds != null && selectedUnitIds.length > 0) {
            Unit obj = getGenericManager().getUnitById(selectedUnitIds[0]);
            obj.setId(null);
            unit = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(unit) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Unit val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveUnit(unit);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }
    
    
    public List<Unit> getUnitList()
    {
        return getGenericManager().getUnitList();
    }
    
    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList();
    }
    

	public Set<Member> getObject_memberList(){		 
     	Set s=unit.getMembers();
          if(s!=null){
            return unit.getMembers();
          }else{
              return  newMembers;
          }
	}
    

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(unit.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        unit.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
        log.info("exit formToBean()");
    }
    
    public Long[] getMembersIds() {
		return membersIds;
	}

	public void setMembersIds(Long[] membersIds) {
		this.membersIds = membersIds;
	}


    public void setSelectedUnitIds(Long[] val)
    {
        selectedUnitIds = val;
    }

    public Long[] getSelectedUnitIds()
    {
        return selectedUnitIds;
    }
}
