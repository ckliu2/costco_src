package com.common.web.action;

import com.base.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;

public class GroupAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Group group;
	private Long[] memberIds;
	private Set<Member> newMembers = new HashSet();

	public GroupAction() {
		log = LogFactory.getLog(com.common.web.action.GroupAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("GROUP");
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group val) {
		group = val;
	}

	public void setGenericManager(CommonManager m) {
		super.setGenericManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeGroup(group.getId());
		return DELETE;
	}

	public String edit() {
		if (group == null || group.getId() == null) {
			group = new Group();
		} else {
			group = getGenericManager().getGroupById(group.getId());
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(group) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Group val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		getGenericManager().saveGroup(group);
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		// memberIds =
		getGenericManager().getIdsFromMemberList(group.getMembers());
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		group.setMembers(getGenericManager().getMemberListByIds(memberIds));
		log.info("exit formToBean()");
	}

	public List getGroupList() {
		return getGenericManager().getGroupList();
	}

	public List<Member> getMemberList() {
		List<Member> al = getGenericManager().getMemberList();
		if (al != null) {
			Set members = group.getMembers();
			if (members != null) {
				Iterator i = group.getMembers().iterator();
				while (i.hasNext()) {
					Member m = (Member) i.next();
					al.remove(m);
				}
			}
		}
		return al;
	}

	public Set<Member> getObject_memberList() {
		Set members = group.getMembers();
		if (members != null) {
			return group.getMembers();
		} else {
			return newMembers;
		}
	}

	public Long[] getMemberIds() {
		return memberIds;
	}

	public void setMemberIds(Long[] memberIds) {
		this.memberIds = memberIds;
	}

	public String groupListJSON() {
		System.out.println("groupListJSON");
		JSONArray ja = new JSONArray();
		try {
			List ls = getGenericManager().getGroupList();
			for (int i = 0; i < ls.size(); i++) {
				Group g = (Group) ls.get(i);
				if (g.getGroupKey().indexOf("Step") != -1 && g.getGroupKey().length() == 5) {
					JSONObject jo = new JSONObject();
					jo.put("value", g.getId());
					jo.put("text", g.getGroupNameCh());
					ja.put(jo);
				}
			}
		} catch (Exception e) {
			System.out.println("groupListJSON=" + e.toString());
		}
		return ja.toString();
	}

}
