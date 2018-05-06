package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class MemberAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Member member;
	private Long[] groupIds, unitsIds;
	private Set<Group> newGroups = new HashSet();
	private Set<Unit> newUnits = new HashSet();
	String keyword;
	private java.io.File fileSignfile;
	private String fileSignfileContentType, fileSignfileFileName, removeSignfile;
	Group group;

	public MemberAction() {
		log = LogFactory.getLog(com.common.web.action.MemberAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("MEMBER");
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member val) {
		member = val;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setGenericManager(CommonManager m) {
		super.setGenericManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeMember(member.getId());
		return DELETE;
	}

	public String edit() {
		if (member == null) {
			member = new Member();
		} else if (member.getId() != null) {
			member = getGenericManager().getMemberById(member.getId());
		} else { // TODO
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
			if (inputValidation(member) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Member val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (member.getId() == null) {
			member.setCreatedDate(ts);
		}
		member.setLastModifiedDate(ts);
		getGenericManager().saveMember(member);
		saveFileToLocal(fileSignfileFileName, fileSignfile, getTextWithArgs("member.uploadSignfile.dir"), member.getId());
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		groupIds = getGenericManager().getIdsFromGroupList(member.getGroups());
		unitsIds = getGenericManager().getIdsFromUnitList(member.getUnits());
		System.out.println("beanToForm() groupIds=" + groupIds.length);
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		member.setGroups(getGenericManager().getGroupListByIds(groupIds));
		member.setUnits(getGenericManager().getUnitListByIds(unitsIds));
		
		System.out.println("getRemoveSignfile()=" + getRemoveSignfile());
		
		if (getRemoveSignfile() != null && getRemoveSignfile().length() > 0) {
			member.setSignfile(computeUploadedFile(fileSignfileFileName, fileSignfile));
			removeUploadedFile(getTextWithArgs("member.uploadSignfile.dir"), member.getSignfileId(), member.getSignfileFileName());
		} else {
			if (member.getSignfileId() != null)
				member.setSignfile(getGenericManager().getUploadedFileById(member.getSignfileId()));
			else
				member.setSignfile(computeUploadedFile(fileSignfileFileName, fileSignfile));
		}
	}

	public String memberListByGroupJSON() {
		System.out.println("memberListByGroupJSON");
		JSONArray ja = new JSONArray();
		try {
			group=getGenericManager().getGroupById(group.getId());
			List<Member> ls = getGenericManager().getMemberListByGroup(group);
			for (int i = 0; i < ls.size(); i++) {
				Member m = (Member) ls.get(i);
				JSONObject jo = new JSONObject();
				jo.put("value", m.getId());
				jo.put("text", m.getName());
				ja.put(jo);
			}
		} catch (Exception e) {
			System.out.println("memberListByGroupJSON=" + e.toString());
		}
		return ja.toString();
	}

	public Long[] getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(Long[] groupIds) {
		this.groupIds = groupIds;
	}

	public void setUnitsIds(Long[] val) {
		unitsIds = val;
	}

	public Long[] getUnitsIds() {
		return unitsIds;
	}

	public Set<Group> getNewGroups() {
		return newGroups;
	}

	public void setNewGroups(Set<Group> newGroups) {
		this.newGroups = newGroups;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setFileSignfileContentType(String val) {
		fileSignfileContentType = val;
	}

	public String getFileSignfileContentType() {
		return fileSignfileContentType;
	}

	public void setFileSignfileFileName(String val) {
		fileSignfileFileName = val;
	}

	public String getFileSignfileFileName() {
		return fileSignfileFileName;
	}

	public void setRemoveSignfile(String val) {
		removeSignfile = val;
	}

	public String getRemoveSignfile() {
		return removeSignfile;
	}

	public java.io.File getFileSignfile() {
		return fileSignfile;
	}

	public void setFileSignfile(java.io.File fileSignfile) {
		this.fileSignfile = fileSignfile;
	}

	public List<Member> getMemberList() {
		return getGenericManager().getMemberList();
	}

	public List<Group> getGroupList() {
		List<Group> al = getGenericManager().getGroupList();
		if (al != null) {
			Set groups = member.getGroups();
			if (groups != null) {
				Iterator i = member.getGroups().iterator();
				while (i.hasNext()) {
					Group g = (Group) i.next();
					al.remove(g);
				}
			}
		}
		return al;
	}

	public Set<Group> getObject_groupList() {
		Set groups = member.getGroups();
		if (groups != null) {
			return member.getGroups();
		} else {
			return newGroups;
		}
	}

	public Set<Unit> getObject_unitList() {
		Set s = member.getUnits();
		if (s != null) {
			return member.getUnits();
		} else {
			return newUnits;
		}
	}

}
