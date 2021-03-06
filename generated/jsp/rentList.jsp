<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="rent.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editRent.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="rentList.size()"/>, 'selectedRentId', 'copyRent.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editRent.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="rentList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedRentId_<c:out value="${count}"/>" name="selectedRentId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="isUpToDate" sortable="true" titleKey="rent.isUpToDate" style="text-align:left" />
    <display:column property="screen" sortable="true" titleKey="rent.screen" style="text-align:left" />
    <display:column property="fmYear" sortable="true" titleKey="rent.fmYear" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="assign" sortable="true" titleKey="rent.assign" style="text-align:left" />
    <display:column property="memo" sortable="true" titleKey="rent.memo" style="text-align:left" />
    <display:column property="isEdited" sortable="true" titleKey="rent.isEdited" style="text-align:left" />
    <display:column property="billboard.caption_" sortable="true" titleKey="rent.billboard" style="text-align:left"/>
    <display:column property="vendor.caption_" sortable="true" titleKey="rent.vendor" style="text-align:left"/>
    <display:column property="photo.caption_" sortable="true" titleKey="rent.photo" style="text-align:left"/>
    <display:column property="cover.caption_" sortable="true" titleKey="rent.cover" style="text-align:left"/>
    <display:column property="kind.caption_" sortable="true" titleKey="rent.kind" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editRent.html?rent.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'rent.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editRent.html?rent.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editRent.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="rentList.size()"/>, 'selectedRentId', 'copyRent.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editRent.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveRent.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="rent.id" value="">
    <select name="selectedRentIds" multiple="true" style="display:none"></select>
</form>
