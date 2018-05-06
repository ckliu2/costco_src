package com.common.dao;

import java.util.*;

import com.base.dao.BaseDAO;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.common.value.*;
import com.base.value.*;

public interface CommonDAO extends BaseDAO {
	public abstract Long[] getIdsFromAppPropertyList(List<AppProperty> lst);

	public abstract List<AppProperty> findAllAppPropertyByIds(Long[] ids);

	public abstract void saveAppProperty(AppProperty val);

	public abstract void removeAppProperty(AppProperty val);

	public abstract void removeAppProperty(Long id);

	public abstract AppProperty findAppPropertyById(Long id);

	public abstract List findAllAppProperty();

	public abstract List getMaxSeqNoOfAppPropertyByKind(String kind);

	public abstract Group findGroupById(Long id);

	public abstract Group findGroupByGroupKey(String GroupKey);

	public abstract void saveChecking(Checking obj);

	public abstract void saveGroup(Group val);

	public abstract void removeGroup(Group val);

	public abstract void removeGroup(Long id);

	public abstract List findAllGroup();

	public abstract void saveFunction(Function val);

	public abstract void removeFunction(Function val);

	public abstract void removeFunction(Long id);

	public abstract Function findFunctionById(Long id);

	public abstract List findAllFunction();

	public abstract List findOnlineFunction();

	public abstract List findCategoryList();

	public abstract void saveFunctionCategory(FunctionCategory val);

	public abstract void removeFunctionCategory(FunctionCategory val);

	public abstract void removeFunctionCategory(Long id);

	public abstract FunctionCategory findFunctionCategoryById(Long id);

	public abstract List findAllFunctionCategory();

	public abstract List findFrontFunctionCategoryList();

	public abstract void saveFunctionAuthority(FunctionAuthority val);

	public abstract void removeFunctionAuthority(FunctionAuthority val);

	public abstract void removeFunctionAuthority(Long id);

	public abstract FunctionAuthority findFunctionAuthorityById(Long id);

	public abstract List findAllFunctionAuthority();

	public abstract List findGroupList();

	public abstract Set getGroupListByIds(Long[] ids);

	public abstract List getGroupListByIds1(Long[] ids);

	public abstract Long[] getIdsFromSurveyGroupList(List ids);

	public abstract List getSurveyGroupListByIds(Long[] ids);

	public abstract Long[] getIdsFromGroupList(Set ids);

	public abstract Long[] getIdsFromGroupList(List ids);

	public abstract Long[] getIdsFromFunctionCategoryList(List al);

	public abstract List getFunctionCategoryListByIds(Long[] ids);

	public abstract List getOnlineUserFunctionListByFunctionCategoryList(List al);

	public abstract List getAllOnlineUserFunctionList();

	public abstract void saveMiscCode(MiscCode val);

	public abstract void updateMiscCode(MiscCode val);

	public abstract void removeMiscCode(MiscCode val);

	public abstract void removeMiscCode(Long id);

	public abstract MiscCode findMiscCodeById(Long id);

	public abstract List<MiscCode> findAllMiscCode();

	/*
	 * *********************** ¤H­û***********************
	 */
	public abstract void saveMember(Member val);

	public abstract void removeMember(Member val);

	public abstract void removeMember(Long id);

	public abstract Member findMemberById(Long id);

	public abstract Member findMemberByEmail(String email);

	public abstract Member findMemberByLoginIdAndPassword(String loginId,String password);

	public abstract Member getMemberByRgnoAndIdNo(String rgno, String idNo);

	public abstract Member getMemberByIdNo(String idNo);

	public abstract Member getMemberByIdNoAndBirthday(String idNo, String brithday);

	public abstract List<Member> getMemberListByGroup(Group group);

	public abstract List<UploadedFile> findPhotoList();

	public abstract List<Member> findAllMember();

	public abstract int findAllMemberSize(String keyword, String departmentId,int graduationYear, int pageSize, int pageIndex);

	public abstract List<Member> findAllMember(String keyword,String departmentId, int graduationYear, int pageSize, int pageIndex);

	public abstract List<Member> findAllMember(String keyword);

	public abstract List<Member> findMemberByCardId(String cardId);

	public abstract Member findMemberByIdWithMD5(String id);

	public abstract List<Member> findQueryMember(String name);

	public abstract Set getMemberListByIds(Long[] ids);

	public abstract Long[] getIdsFromMemberList(Set ids);

	public abstract List<Member> getMemberListById(Long[] ids);

	public abstract Member getMemberByCellphone(String cellphone);

	// Unit
	public abstract void saveUnit(Unit val);

	public abstract void removeUnit(Unit val);

	public abstract void removeUnit(Long id);

	public abstract Unit findUnitById(Long id);

	public abstract List<Unit> findAllUnit();

	public abstract Set getUnitListByIds(Long[] ids);

	public abstract Long[] getIdsFromUnitList(Set lst);

}