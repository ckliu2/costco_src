<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billboardForm" action="saveBillboard" method="POST" enctype="multipart/form-data">
  <ww:hidden name="billboard.id" value="${billboard.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billboard.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billboard.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billboard.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="billboard.no"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="billboard.no" value="%{billboard.no}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboard.no')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboard.size"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="billboard.sizeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="sizeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboard.sizeId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboard.cover"/></td>
        <td class="cInputColumn">
        <ww:if test="billboard.cover != null">
            <input type="checkbox" name="removeCover" onclick="if (this.checked == true) document.billboardForm.fileCover.style.display='inline'; else document.billboardForm.fileCover.style.display='none';" value="<ww:property value="billboard.cover.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billboard.uploadCover.relativeUrl"/>/<ww:property value="billboard.id"/>/<ww:property value="billboard.cover.fileName"/>"><ww:property value="billboard.cover.fileName" /> (<ww:property value="billboard.cover.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCover" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billboard.coverId" value="${billboard.cover.id}"/>
            <ww:hidden name="billboard.coverFileName" value="${billboard.cover.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCover" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billboard.store"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="billboard.storeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="storeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billboard.storeId')"/></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billboard.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billboard.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
