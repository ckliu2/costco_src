<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billboardRentForm" action="saveBillboardRent" method="POST">
  <ww:hidden name="billboardRent.id" value="${billboardRent.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billboardRent.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billboardRent.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billboardRent.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="billboardRent.kind"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billboardRent.kind" value="%{billboardRent.kind}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboardRent.fmYear"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billboardRent.fmYear" value="%{billboardRent.fmYear}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboardRent.rent"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="billboardRent.rentId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="rentList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboardRent.rentId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboardRent.store"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="billboardRent.storeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="storeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboardRent.storeId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboardRent.billboard"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="billboardRent.billboardId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billboardList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboardRent.billboardId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboardRent.vendor"/></td>
        <td class="cInputColumn">
            <ww:select name="billboardRent.vendorId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="vendorList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billboardRent.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billboardRent.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
