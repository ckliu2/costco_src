package com.common.service;

import java.util.*;

import com.base.service.BaseManager;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.common.value.*;
import com.base.value.*;

public interface CommonManager extends BaseManager {
	public abstract Long[] getIdsFromAppPropertyList(List<AppProperty> lst);

	public abstract List<AppProperty> getAppPropertyListByIds(Long[] ids);

	public abstract AppProperty getAppPropertyById(Long id);

	public abstract Function getFunctionById(Long id);

	public abstract FunctionAuthority getFunctionAuthorityById(Long id);

	public abstract FunctionCategory getFunctionCategoryById(Long id);

	public abstract Group getGroupById(Long id);

	public abstract Group getGroupByGroupKey(String GroupKey);

	public abstract List getAppPropertyList();

	public abstract List getCategoryList();

	public abstract List getFunctionAuthorityList();

	public abstract List getFunctionCategoryList();

	public abstract List getFrontFunctionCategoryList();

	public abstract List getFunctionList();

	public abstract List getOnlineFunctionList();

	public abstract List getGroupList();

	public abstract Set getGroupListByIds(Long[] ids);

	public abstract List getGroupListByIds1(Long[] ids);

	public abstract List getSurveyGroupListByIds(Long[] ids);

	public abstract Long[] getIdsFromSurveyGroupList(List lst);

	public abstract Long[] getIdsFromGroupList(Set lst);

	public abstract Long[] getIdsFromGroupList(List lst);

	public abstract List getMaxSeqNoOfAppPropertyByKind(String kind);

	public abstract void removeAppProperty(AppProperty val);

	public abstract void removeAppProperty(Long id);

	public abstract void removeFunction(Function val);

	public abstract void removeFunction(Long id);

	public abstract void removeFunctionAuthority(FunctionAuthority val);

	public abstract void removeFunctionAuthority(Long id);

	public abstract void removeFunctionCategory(FunctionCategory val);

	public abstract void removeFunctionCategory(Long id);

	public abstract void removeGroup(Group val);

	public abstract void removeGroup(Long id);

	public abstract void saveAppProperty(AppProperty val);

	public abstract void saveChecking(Checking obj);

	public abstract void saveFunction(Function val);

	public abstract void saveFunctionAuthority(FunctionAuthority val);

	public abstract void saveFunctionCategory(FunctionCategory val);

	public abstract void saveGroup(Group val);

	public abstract Long[] getIdsFromFunctionCategoryList(List al);

	public abstract List getFunctionCategoryListByIds(Long[] ids);

	public abstract List getOnlineUserFunctionListByFunctionCategoryList(List al);

	public abstract List getAllOnlineUserFunctionList();

	public abstract void saveMiscCode(MiscCode val);

	public abstract void updateMiscCode(MiscCode val);

	public abstract void removeMiscCode(MiscCode val);

	public abstract void removeMiscCode(Long id);

	public abstract MiscCode getMiscCodeById(Long id);

	public abstract List<MiscCode> getMiscCodeList();

	/*
	 * *********************** ¤H­û***********************
	 */
	public abstract void saveMember(Member val);

	public abstract void removeMember(Member val);

	public abstract void removeMember(Long id);

	public abstract Member getMemberById(Long id);

	public abstract List<Member> getMemberList();

	public abstract List<Member> getMemberList(String keyword);

	public abstract List<Member> getMemberList(String keyword, String departmentId, int graduationYear, int pageSize, int pageIndex);

	public abstract int getMemberListSize(String keyword, String departmentId, int graduationYear, int pageSize, int pageIndex);

	public abstract Member getMemberByIdWithMD5(String id);

	public abstract List<Member> getQueryMemberList(String name);

	public abstract Member getMemberByEmail(String email);

	public abstract List<UploadedFile> getPhotoList();

	public abstract List<Member> getMemberListById(Long[] ids);

	public abstract Set getMemberListByIds(Long[] ids);

	public abstract Long[] getIdsFromMemberList(Set lst);

	public abstract Member getMemberByCellphone(String cellphone);

	public abstract Member getMemberByLoginIdAndPassword(String loginId, String password);

	public abstract Member getMemberByRgnoAndIdNo(String rgno, String idNo);

	public abstract List<Member> getMemberByCardId(String cardId);

	public abstract Member getMemberByIdNo(String idNo);

	public abstract Member getMemberByIdNoAndBirthday(String idNo, String brithday);
	
	public abstract List<Member> getMemberListByGroup(Group group);

	// Unit
	public abstract void saveUnit(Unit val);

	public abstract void removeUnit(Unit val);

	public abstract void removeUnit(Long id);

	public abstract Unit getUnitById(Long id);

	public abstract List<Unit> getUnitList();
	
	public abstract Set getUnitListByIds(Long[] ids);
	
	public abstract Long[] getIdsFromUnitList(Set lst);

}
