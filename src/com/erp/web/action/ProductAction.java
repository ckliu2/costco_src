package com.erp.web.action;

import com.erp.value.*;
import com.erp.service.ERPManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

public class ProductAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Product product;
	private ProductType productType;
	private Long[] selectedProductIds;
	private java.io.File fileProductPhoto1;
	private String fileProductPhoto1ContentType, fileProductPhoto1FileName, removeProductPhoto1;
	private java.io.File fileProductPhoto2;
	private String fileProductPhoto2ContentType, fileProductPhoto2FileName, removeProductPhoto2;
	private java.io.File fileProductPhoto3;
	private String fileProductPhoto3ContentType, fileProductPhoto3FileName, removeProductPhoto3;
	private java.io.File fileProductPhoto4;
	private String fileProductPhoto4ContentType, fileProductPhoto4FileName, removeProductPhoto4;
	private java.io.File fileProductPhoto5;
	private String fileProductPhoto5ContentType, fileProductPhoto5FileName, removeProductPhoto5;
	private java.io.File fileProductPhoto6;
	private String fileProductPhoto6ContentType, fileProductPhoto6FileName, removeProductPhoto6;
	private java.io.File fileProductPhoto7;
	private String fileProductPhoto7ContentType, fileProductPhoto7FileName, removeProductPhoto7;
	private java.io.File fileProductPhoto8;
	private String fileProductPhoto8ContentType, fileProductPhoto8FileName, removeProductPhoto8;
	private java.io.File fileProductPhoto9;
	private String fileProductPhoto9ContentType, fileProductPhoto9FileName, removeProductPhoto9;
	private java.io.File fileProductPhoto10;
	private String fileProductPhoto10ContentType, fileProductPhoto10FileName, removeProductPhoto10;
	private java.io.File fileDownload1;
	private String fileDownload1ContentType, fileDownload1FileName, removeDownload1;
	private java.io.File fileDownload2;
	private String fileDownload2ContentType, fileDownload2FileName, removeDownload2;
	private java.io.File fileDownload3;
	private String fileDownload3ContentType, fileDownload3FileName, removeDownload3;
	private java.io.File fileDownload4;
	private String fileDownload4ContentType, fileDownload4FileName, removeDownload4;
	private java.io.File fileDownload5;
	private String fileDownload5ContentType, fileDownload5FileName, removeDownload5;
	private java.io.File fileDownload6;
	private String fileDownload6ContentType, fileDownload6FileName, removeDownload6;
	private java.io.File fileDownload7;
	private String fileDownload7ContentType, fileDownload7FileName, removeDownload7;
	private java.io.File fileDownload8;
	private String fileDownload8ContentType, fileDownload8FileName, removeDownload8;
	private java.io.File fileDownload9;
	private String fileDownload9ContentType, fileDownload9FileName, removeDownload9;
	private java.io.File fileDownload10;
	private String fileDownload10ContentType, fileDownload10FileName, removeDownload10;
	private java.io.File fileDiagram1;
	private String fileDiagram1ContentType, fileDiagram1FileName, removeDiagram1;
	private java.io.File fileDiagram2;
	private String fileDiagram2ContentType, fileDiagram2FileName, removeDiagram2;
	private java.io.File fileDiagram3;
	private String fileDiagram3ContentType, fileDiagram3FileName, removeDiagram3;
	private java.io.File fileDiagram4;
	private String fileDiagram4ContentType, fileDiagram4FileName, removeDiagram4;
	private java.io.File fileDiagram5;
	private String fileDiagram5ContentType, fileDiagram5FileName, removeDiagram5;
	private java.io.File fileDiagram6;
	private String fileDiagram6ContentType, fileDiagram6FileName, removeDiagram6;
	private java.io.File fileDiagram7;
	private String fileDiagram7ContentType, fileDiagram7FileName, removeDiagram7;
	private java.io.File fileDiagram8;
	private String fileDiagram8ContentType, fileDiagram8FileName, removeDiagram8;
	private java.io.File fileDiagram9;
	private String fileDiagram9ContentType, fileDiagram9FileName, removeDiagram9;
	private java.io.File fileDiagram10;
	private String fileDiagram10ContentType, fileDiagram10FileName, removeDiagram10;

	private java.io.File fileLogo1;
	private String fileLogo1ContentType, fileLogo1FileName, removeLogo1;
	private java.io.File fileLogo2;
	private String fileLogo2ContentType, fileLogo2FileName, removeLogo2;
	private java.io.File fileLogo3;
	private String fileLogo3ContentType, fileLogo3FileName, removeLogo3;
	private java.io.File fileLogo4;
	private String fileLogo4ContentType, fileLogo4FileName, removeLogo4;
	private java.io.File fileLogo5;
	private String fileLogo5ContentType, fileLogo5FileName, removeLogo5;
	private java.io.File fileLogo6;
	private String fileLogo6ContentType, fileLogo6FileName, removeLogo6;
	private java.io.File fileLogo7;
	private String fileLogo7ContentType, fileLogo7FileName, removeLogo7;
	private java.io.File fileLogo8;
	private String fileLogo8ContentType, fileLogo8FileName, removeLogo8;
	private java.io.File fileLogo9;
	private String fileLogo9ContentType, fileLogo9FileName, removeLogo9;
	private java.io.File fileLogo10;
	private String fileLogo10ContentType, fileLogo10FileName, removeLogo10;
	private java.io.File fileLogo11;
	private String fileLogo11ContentType, fileLogo11FileName, removeLogo11;
	private java.io.File fileLogo12;
	private String fileLogo12ContentType, fileLogo12FileName, removeLogo12;
	private java.io.File fileLogo13;
	private String fileLogo13ContentType, fileLogo13FileName, removeLogo13;
	private java.io.File fileLogo14;
	private String fileLogo14ContentType, fileLogo14FileName, removeLogo14;
	private java.io.File fileLogo15;
	private String fileLogo15ContentType, fileLogo15FileName, removeLogo15;
	private java.io.File fileLogo16;
	private String fileLogo16ContentType, fileLogo16FileName, removeLogo16;
	Long typesIds[];

	public ProductAction() {
		log = LogFactory.getLog(com.erp.web.action.ProductAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("PRODUCT");
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product val) {
		product = val;
	}

	public void setGenericManager(ERPManager m) {
		super.setGenericManager(m);
	}

	public ERPManager getGenericManager() {
		return (ERPManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeProduct(product.getId());
		return DELETE;
	}

	public String edit() {
		if (product == null) {
			product = new Product();
		} else if (product.getId() != null) {
			product = getGenericManager().getProductById(product.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedProductIds != null && selectedProductIds.length > 0) {
			Product obj = getGenericManager().getProductById(selectedProductIds[0]);
			obj.setId(null);
			product = obj;
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
			if (inputValidation(product) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Product val) {
		return true;
	}

	public void setFileProductPhoto1(java.io.File val) {
		fileProductPhoto1 = val;
	}

	public java.io.File getFileProductPhoto1() {
		return fileProductPhoto1;
	}

	public void setFileProductPhoto1ContentType(String val) {
		fileProductPhoto1ContentType = val;
	}

	public String getFileProductPhoto1ContentType() {
		return fileProductPhoto1ContentType;
	}

	public void setFileProductPhoto1FileName(String val) {
		fileProductPhoto1FileName = val;
	}

	public String getFileProductPhoto1FileName() {
		return fileProductPhoto1FileName;
	}

	public void setRemoveProductPhoto1(String val) {
		removeProductPhoto1 = val;
	}

	public String getRemoveProductPhoto1() {
		return removeProductPhoto1;
	}

	public void setFileProductPhoto2(java.io.File val) {
		fileProductPhoto2 = val;
	}

	public java.io.File getFileProductPhoto2() {
		return fileProductPhoto2;
	}

	public void setFileProductPhoto2ContentType(String val) {
		fileProductPhoto2ContentType = val;
	}

	public String getFileProductPhoto2ContentType() {
		return fileProductPhoto2ContentType;
	}

	public void setFileProductPhoto2FileName(String val) {
		fileProductPhoto2FileName = val;
	}

	public String getFileProductPhoto2FileName() {
		return fileProductPhoto2FileName;
	}

	public void setRemoveProductPhoto2(String val) {
		removeProductPhoto2 = val;
	}

	public String getRemoveProductPhoto2() {
		return removeProductPhoto2;
	}

	public void setFileProductPhoto3(java.io.File val) {
		fileProductPhoto3 = val;
	}

	public java.io.File getFileProductPhoto3() {
		return fileProductPhoto3;
	}

	public void setFileProductPhoto3ContentType(String val) {
		fileProductPhoto3ContentType = val;
	}

	public String getFileProductPhoto3ContentType() {
		return fileProductPhoto3ContentType;
	}

	public void setFileProductPhoto3FileName(String val) {
		fileProductPhoto3FileName = val;
	}

	public String getFileProductPhoto3FileName() {
		return fileProductPhoto3FileName;
	}

	public void setRemoveProductPhoto3(String val) {
		removeProductPhoto3 = val;
	}

	public String getRemoveProductPhoto3() {
		return removeProductPhoto3;
	}

	public void setFileProductPhoto4(java.io.File val) {
		fileProductPhoto4 = val;
	}

	public java.io.File getFileProductPhoto4() {
		return fileProductPhoto4;
	}

	public void setFileProductPhoto4ContentType(String val) {
		fileProductPhoto4ContentType = val;
	}

	public String getFileProductPhoto4ContentType() {
		return fileProductPhoto4ContentType;
	}

	public void setFileProductPhoto4FileName(String val) {
		fileProductPhoto4FileName = val;
	}

	public String getFileProductPhoto4FileName() {
		return fileProductPhoto4FileName;
	}

	public void setRemoveProductPhoto4(String val) {
		removeProductPhoto4 = val;
	}

	public String getRemoveProductPhoto4() {
		return removeProductPhoto4;
	}

	public void setFileProductPhoto5(java.io.File val) {
		fileProductPhoto5 = val;
	}

	public java.io.File getFileProductPhoto5() {
		return fileProductPhoto5;
	}

	public void setFileProductPhoto5ContentType(String val) {
		fileProductPhoto5ContentType = val;
	}

	public String getFileProductPhoto5ContentType() {
		return fileProductPhoto5ContentType;
	}

	public void setFileProductPhoto5FileName(String val) {
		fileProductPhoto5FileName = val;
	}

	public String getFileProductPhoto5FileName() {
		return fileProductPhoto5FileName;
	}

	public void setRemoveProductPhoto5(String val) {
		removeProductPhoto5 = val;
	}

	public String getRemoveProductPhoto5() {
		return removeProductPhoto5;
	}

	public void setFileProductPhoto6(java.io.File val) {
		fileProductPhoto6 = val;
	}

	public java.io.File getFileProductPhoto6() {
		return fileProductPhoto6;
	}

	public void setFileProductPhoto6ContentType(String val) {
		fileProductPhoto6ContentType = val;
	}

	public String getFileProductPhoto6ContentType() {
		return fileProductPhoto6ContentType;
	}

	public void setFileProductPhoto6FileName(String val) {
		fileProductPhoto6FileName = val;
	}

	public String getFileProductPhoto6FileName() {
		return fileProductPhoto6FileName;
	}

	public void setRemoveProductPhoto6(String val) {
		removeProductPhoto6 = val;
	}

	public String getRemoveProductPhoto6() {
		return removeProductPhoto6;
	}

	public void setFileProductPhoto7(java.io.File val) {
		fileProductPhoto7 = val;
	}

	public java.io.File getFileProductPhoto7() {
		return fileProductPhoto7;
	}

	public void setFileProductPhoto7ContentType(String val) {
		fileProductPhoto7ContentType = val;
	}

	public String getFileProductPhoto7ContentType() {
		return fileProductPhoto7ContentType;
	}

	public void setFileProductPhoto7FileName(String val) {
		fileProductPhoto7FileName = val;
	}

	public String getFileProductPhoto7FileName() {
		return fileProductPhoto7FileName;
	}

	public void setRemoveProductPhoto7(String val) {
		removeProductPhoto7 = val;
	}

	public String getRemoveProductPhoto7() {
		return removeProductPhoto7;
	}

	public void setFileProductPhoto8(java.io.File val) {
		fileProductPhoto8 = val;
	}

	public java.io.File getFileProductPhoto8() {
		return fileProductPhoto8;
	}

	public void setFileProductPhoto8ContentType(String val) {
		fileProductPhoto8ContentType = val;
	}

	public String getFileProductPhoto8ContentType() {
		return fileProductPhoto8ContentType;
	}

	public void setFileProductPhoto8FileName(String val) {
		fileProductPhoto8FileName = val;
	}

	public String getFileProductPhoto8FileName() {
		return fileProductPhoto8FileName;
	}

	public void setRemoveProductPhoto8(String val) {
		removeProductPhoto8 = val;
	}

	public String getRemoveProductPhoto8() {
		return removeProductPhoto8;
	}

	public void setFileProductPhoto9(java.io.File val) {
		fileProductPhoto9 = val;
	}

	public java.io.File getFileProductPhoto9() {
		return fileProductPhoto9;
	}

	public void setFileProductPhoto9ContentType(String val) {
		fileProductPhoto9ContentType = val;
	}

	public String getFileProductPhoto9ContentType() {
		return fileProductPhoto9ContentType;
	}

	public void setFileProductPhoto9FileName(String val) {
		fileProductPhoto9FileName = val;
	}

	public String getFileProductPhoto9FileName() {
		return fileProductPhoto9FileName;
	}

	public void setRemoveProductPhoto9(String val) {
		removeProductPhoto9 = val;
	}

	public String getRemoveProductPhoto9() {
		return removeProductPhoto9;
	}

	public void setFileProductPhoto10(java.io.File val) {
		fileProductPhoto10 = val;
	}

	public java.io.File getFileProductPhoto10() {
		return fileProductPhoto10;
	}

	public void setFileProductPhoto10ContentType(String val) {
		fileProductPhoto10ContentType = val;
	}

	public String getFileProductPhoto10ContentType() {
		return fileProductPhoto10ContentType;
	}

	public void setFileProductPhoto10FileName(String val) {
		fileProductPhoto10FileName = val;
	}

	public String getFileProductPhoto10FileName() {
		return fileProductPhoto10FileName;
	}

	public void setRemoveProductPhoto10(String val) {
		removeProductPhoto10 = val;
	}

	public String getRemoveProductPhoto10() {
		return removeProductPhoto10;
	}

	public void setFileDownload1(java.io.File val) {
		fileDownload1 = val;
	}

	public java.io.File getFileDownload1() {
		return fileDownload1;
	}

	public void setFileDownload1ContentType(String val) {
		fileDownload1ContentType = val;
	}

	public String getFileDownload1ContentType() {
		return fileDownload1ContentType;
	}

	public void setFileDownload1FileName(String val) {
		fileDownload1FileName = val;
	}

	public String getFileDownload1FileName() {
		return fileDownload1FileName;
	}

	public void setRemoveDownload1(String val) {
		removeDownload1 = val;
	}

	public String getRemoveDownload1() {
		return removeDownload1;
	}

	public void setFileDownload2(java.io.File val) {
		fileDownload2 = val;
	}

	public java.io.File getFileDownload2() {
		return fileDownload2;
	}

	public void setFileDownload2ContentType(String val) {
		fileDownload2ContentType = val;
	}

	public String getFileDownload2ContentType() {
		return fileDownload2ContentType;
	}

	public void setFileDownload2FileName(String val) {
		fileDownload2FileName = val;
	}

	public String getFileDownload2FileName() {
		return fileDownload2FileName;
	}

	public void setRemoveDownload2(String val) {
		removeDownload2 = val;
	}

	public String getRemoveDownload2() {
		return removeDownload2;
	}

	public void setFileDownload3(java.io.File val) {
		fileDownload3 = val;
	}

	public java.io.File getFileDownload3() {
		return fileDownload3;
	}

	public void setFileDownload3ContentType(String val) {
		fileDownload3ContentType = val;
	}

	public String getFileDownload3ContentType() {
		return fileDownload3ContentType;
	}

	public void setFileDownload3FileName(String val) {
		fileDownload3FileName = val;
	}

	public String getFileDownload3FileName() {
		return fileDownload3FileName;
	}

	public void setRemoveDownload3(String val) {
		removeDownload3 = val;
	}

	public String getRemoveDownload3() {
		return removeDownload3;
	}

	public void setFileDownload4(java.io.File val) {
		fileDownload4 = val;
	}

	public java.io.File getFileDownload4() {
		return fileDownload4;
	}

	public void setFileDownload4ContentType(String val) {
		fileDownload4ContentType = val;
	}

	public String getFileDownload4ContentType() {
		return fileDownload4ContentType;
	}

	public void setFileDownload4FileName(String val) {
		fileDownload4FileName = val;
	}

	public String getFileDownload4FileName() {
		return fileDownload4FileName;
	}

	public void setRemoveDownload4(String val) {
		removeDownload4 = val;
	}

	public String getRemoveDownload4() {
		return removeDownload4;
	}

	public void setFileDownload5(java.io.File val) {
		fileDownload5 = val;
	}

	public java.io.File getFileDownload5() {
		return fileDownload5;
	}

	public void setFileDownload5ContentType(String val) {
		fileDownload5ContentType = val;
	}

	public String getFileDownload5ContentType() {
		return fileDownload5ContentType;
	}

	public void setFileDownload5FileName(String val) {
		fileDownload5FileName = val;
	}

	public String getFileDownload5FileName() {
		return fileDownload5FileName;
	}

	public void setRemoveDownload5(String val) {
		removeDownload5 = val;
	}

	public String getRemoveDownload5() {
		return removeDownload5;
	}

	public void setFileDownload6(java.io.File val) {
		fileDownload6 = val;
	}

	public java.io.File getFileDownload6() {
		return fileDownload6;
	}

	public void setFileDownload6ContentType(String val) {
		fileDownload6ContentType = val;
	}

	public String getFileDownload6ContentType() {
		return fileDownload6ContentType;
	}

	public void setFileDownload6FileName(String val) {
		fileDownload6FileName = val;
	}

	public String getFileDownload6FileName() {
		return fileDownload6FileName;
	}

	public void setRemoveDownload6(String val) {
		removeDownload6 = val;
	}

	public String getRemoveDownload6() {
		return removeDownload6;
	}

	public void setFileDownload7(java.io.File val) {
		fileDownload7 = val;
	}

	public java.io.File getFileDownload7() {
		return fileDownload7;
	}

	public void setFileDownload7ContentType(String val) {
		fileDownload7ContentType = val;
	}

	public String getFileDownload7ContentType() {
		return fileDownload7ContentType;
	}

	public void setFileDownload7FileName(String val) {
		fileDownload7FileName = val;
	}

	public String getFileDownload7FileName() {
		return fileDownload7FileName;
	}

	public void setRemoveDownload7(String val) {
		removeDownload7 = val;
	}

	public String getRemoveDownload7() {
		return removeDownload7;
	}

	public void setFileDownload8(java.io.File val) {
		fileDownload8 = val;
	}

	public java.io.File getFileDownload8() {
		return fileDownload8;
	}

	public void setFileDownload8ContentType(String val) {
		fileDownload8ContentType = val;
	}

	public String getFileDownload8ContentType() {
		return fileDownload8ContentType;
	}

	public void setFileDownload8FileName(String val) {
		fileDownload8FileName = val;
	}

	public String getFileDownload8FileName() {
		return fileDownload8FileName;
	}

	public void setRemoveDownload8(String val) {
		removeDownload8 = val;
	}

	public String getRemoveDownload8() {
		return removeDownload8;
	}

	public void setFileDownload9(java.io.File val) {
		fileDownload9 = val;
	}

	public java.io.File getFileDownload9() {
		return fileDownload9;
	}

	public void setFileDownload9ContentType(String val) {
		fileDownload9ContentType = val;
	}

	public String getFileDownload9ContentType() {
		return fileDownload9ContentType;
	}

	public void setFileDownload9FileName(String val) {
		fileDownload9FileName = val;
	}

	public String getFileDownload9FileName() {
		return fileDownload9FileName;
	}

	public void setRemoveDownload9(String val) {
		removeDownload9 = val;
	}

	public String getRemoveDownload9() {
		return removeDownload9;
	}

	public void setFileDownload10(java.io.File val) {
		fileDownload10 = val;
	}

	public java.io.File getFileDownload10() {
		return fileDownload10;
	}

	public void setFileDownload10ContentType(String val) {
		fileDownload10ContentType = val;
	}

	public String getFileDownload10ContentType() {
		return fileDownload10ContentType;
	}

	public void setFileDownload10FileName(String val) {
		fileDownload10FileName = val;
	}

	public String getFileDownload10FileName() {
		return fileDownload10FileName;
	}

	public void setRemoveDownload10(String val) {
		removeDownload10 = val;
	}

	public String getRemoveDownload10() {
		return removeDownload10;
	}

	public void setFileDiagram1(java.io.File val) {
		fileDiagram1 = val;
	}

	public java.io.File getFileDiagram1() {
		return fileDiagram1;
	}

	public void setFileDiagram1ContentType(String val) {
		fileDiagram1ContentType = val;
	}

	public String getFileDiagram1ContentType() {
		return fileDiagram1ContentType;
	}

	public void setFileDiagram1FileName(String val) {
		fileDiagram1FileName = val;
	}

	public String getFileDiagram1FileName() {
		return fileDiagram1FileName;
	}

	public void setRemoveDiagram1(String val) {
		removeDiagram1 = val;
	}

	public String getRemoveDiagram1() {
		return removeDiagram1;
	}

	public void setFileDiagram2(java.io.File val) {
		fileDiagram2 = val;
	}

	public java.io.File getFileDiagram2() {
		return fileDiagram2;
	}

	public void setFileDiagram2ContentType(String val) {
		fileDiagram2ContentType = val;
	}

	public String getFileDiagram2ContentType() {
		return fileDiagram2ContentType;
	}

	public void setFileDiagram2FileName(String val) {
		fileDiagram2FileName = val;
	}

	public String getFileDiagram2FileName() {
		return fileDiagram2FileName;
	}

	public void setRemoveDiagram2(String val) {
		removeDiagram2 = val;
	}

	public String getRemoveDiagram2() {
		return removeDiagram2;
	}

	public void setFileDiagram3(java.io.File val) {
		fileDiagram3 = val;
	}

	public java.io.File getFileDiagram3() {
		return fileDiagram3;
	}

	public void setFileDiagram3ContentType(String val) {
		fileDiagram3ContentType = val;
	}

	public String getFileDiagram3ContentType() {
		return fileDiagram3ContentType;
	}

	public void setFileDiagram3FileName(String val) {
		fileDiagram3FileName = val;
	}

	public String getFileDiagram3FileName() {
		return fileDiagram3FileName;
	}

	public void setRemoveDiagram3(String val) {
		removeDiagram3 = val;
	}

	public String getRemoveDiagram3() {
		return removeDiagram3;
	}

	public void setFileDiagram4(java.io.File val) {
		fileDiagram4 = val;
	}

	public java.io.File getFileDiagram4() {
		return fileDiagram4;
	}

	public void setFileDiagram4ContentType(String val) {
		fileDiagram4ContentType = val;
	}

	public String getFileDiagram4ContentType() {
		return fileDiagram4ContentType;
	}

	public void setFileDiagram4FileName(String val) {
		fileDiagram4FileName = val;
	}

	public String getFileDiagram4FileName() {
		return fileDiagram4FileName;
	}

	public void setRemoveDiagram4(String val) {
		removeDiagram4 = val;
	}

	public String getRemoveDiagram4() {
		return removeDiagram4;
	}

	public void setFileDiagram5(java.io.File val) {
		fileDiagram5 = val;
	}

	public java.io.File getFileDiagram5() {
		return fileDiagram5;
	}

	public void setFileDiagram5ContentType(String val) {
		fileDiagram5ContentType = val;
	}

	public String getFileDiagram5ContentType() {
		return fileDiagram5ContentType;
	}

	public void setFileDiagram5FileName(String val) {
		fileDiagram5FileName = val;
	}

	public String getFileDiagram5FileName() {
		return fileDiagram5FileName;
	}

	public void setRemoveDiagram5(String val) {
		removeDiagram5 = val;
	}

	public String getRemoveDiagram5() {
		return removeDiagram5;
	}

	public void setFileDiagram6(java.io.File val) {
		fileDiagram6 = val;
	}

	public java.io.File getFileDiagram6() {
		return fileDiagram6;
	}

	public void setFileDiagram6ContentType(String val) {
		fileDiagram6ContentType = val;
	}

	public String getFileDiagram6ContentType() {
		return fileDiagram6ContentType;
	}

	public void setFileDiagram6FileName(String val) {
		fileDiagram6FileName = val;
	}

	public String getFileDiagram6FileName() {
		return fileDiagram6FileName;
	}

	public void setRemoveDiagram6(String val) {
		removeDiagram6 = val;
	}

	public String getRemoveDiagram6() {
		return removeDiagram6;
	}

	public void setFileDiagram7(java.io.File val) {
		fileDiagram7 = val;
	}

	public java.io.File getFileDiagram7() {
		return fileDiagram7;
	}

	public void setFileDiagram7ContentType(String val) {
		fileDiagram7ContentType = val;
	}

	public String getFileDiagram7ContentType() {
		return fileDiagram7ContentType;
	}

	public void setFileDiagram7FileName(String val) {
		fileDiagram7FileName = val;
	}

	public String getFileDiagram7FileName() {
		return fileDiagram7FileName;
	}

	public void setRemoveDiagram7(String val) {
		removeDiagram7 = val;
	}

	public String getRemoveDiagram7() {
		return removeDiagram7;
	}

	public void setFileDiagram8(java.io.File val) {
		fileDiagram8 = val;
	}

	public java.io.File getFileDiagram8() {
		return fileDiagram8;
	}

	public void setFileDiagram8ContentType(String val) {
		fileDiagram8ContentType = val;
	}

	public String getFileDiagram8ContentType() {
		return fileDiagram8ContentType;
	}

	public void setFileDiagram8FileName(String val) {
		fileDiagram8FileName = val;
	}

	public String getFileDiagram8FileName() {
		return fileDiagram8FileName;
	}

	public void setRemoveDiagram8(String val) {
		removeDiagram8 = val;
	}

	public String getRemoveDiagram8() {
		return removeDiagram8;
	}

	public void setFileDiagram9(java.io.File val) {
		fileDiagram9 = val;
	}

	public java.io.File getFileDiagram9() {
		return fileDiagram9;
	}

	public void setFileDiagram9ContentType(String val) {
		fileDiagram9ContentType = val;
	}

	public String getFileDiagram9ContentType() {
		return fileDiagram9ContentType;
	}

	public void setFileDiagram9FileName(String val) {
		fileDiagram9FileName = val;
	}

	public String getFileDiagram9FileName() {
		return fileDiagram9FileName;
	}

	public void setRemoveDiagram9(String val) {
		removeDiagram9 = val;
	}

	public String getRemoveDiagram9() {
		return removeDiagram9;
	}

	public void setFileDiagram10(java.io.File val) {
		fileDiagram10 = val;
	}

	public java.io.File getFileDiagram10() {
		return fileDiagram10;
	}

	public void setFileDiagram10ContentType(String val) {
		fileDiagram10ContentType = val;
	}

	public String getFileDiagram10ContentType() {
		return fileDiagram10ContentType;
	}

	public void setFileDiagram10FileName(String val) {
		fileDiagram10FileName = val;
	}

	public String getFileDiagram10FileName() {
		return fileDiagram10FileName;
	}

	public void setRemoveDiagram10(String val) {
		removeDiagram10 = val;
	}

	public String getRemoveDiagram10() {
		return removeDiagram10;
	}

	public String save() {
		log.info("entering 'save' method");
		getGenericManager().saveProduct(product);

		saveFileToLocal(fileProductPhoto1FileName, fileProductPhoto1, getTextWithArgs("product.uploadProductPhoto1.dir"), product.getId());
		saveFileToLocal(fileProductPhoto2FileName, fileProductPhoto2, getTextWithArgs("product.uploadProductPhoto2.dir"), product.getId());
		saveFileToLocal(fileProductPhoto3FileName, fileProductPhoto3, getTextWithArgs("product.uploadProductPhoto3.dir"), product.getId());
		saveFileToLocal(fileProductPhoto4FileName, fileProductPhoto4, getTextWithArgs("product.uploadProductPhoto4.dir"), product.getId());
		saveFileToLocal(fileProductPhoto5FileName, fileProductPhoto5, getTextWithArgs("product.uploadProductPhoto5.dir"), product.getId());
		saveFileToLocal(fileProductPhoto6FileName, fileProductPhoto6, getTextWithArgs("product.uploadProductPhoto6.dir"), product.getId());
		saveFileToLocal(fileProductPhoto7FileName, fileProductPhoto7, getTextWithArgs("product.uploadProductPhoto7.dir"), product.getId());
		saveFileToLocal(fileProductPhoto8FileName, fileProductPhoto8, getTextWithArgs("product.uploadProductPhoto8.dir"), product.getId());
		saveFileToLocal(fileProductPhoto9FileName, fileProductPhoto9, getTextWithArgs("product.uploadProductPhoto9.dir"), product.getId());
		saveFileToLocal(fileProductPhoto10FileName, fileProductPhoto10, getTextWithArgs("product.uploadProductPhoto10.dir"), product.getId());
		saveFileToLocal(fileDownload1FileName, fileDownload1, getTextWithArgs("product.uploadDownload1.dir"), product.getId());
		saveFileToLocal(fileDownload2FileName, fileDownload2, getTextWithArgs("product.uploadDownload2.dir"), product.getId());
		saveFileToLocal(fileDownload3FileName, fileDownload3, getTextWithArgs("product.uploadDownload3.dir"), product.getId());
		saveFileToLocal(fileDownload4FileName, fileDownload4, getTextWithArgs("product.uploadDownload4.dir"), product.getId());
		saveFileToLocal(fileDownload5FileName, fileDownload5, getTextWithArgs("product.uploadDownload5.dir"), product.getId());
		saveFileToLocal(fileDownload6FileName, fileDownload6, getTextWithArgs("product.uploadDownload6.dir"), product.getId());
		saveFileToLocal(fileDownload7FileName, fileDownload7, getTextWithArgs("product.uploadDownload7.dir"), product.getId());
		saveFileToLocal(fileDownload8FileName, fileDownload8, getTextWithArgs("product.uploadDownload8.dir"), product.getId());
		saveFileToLocal(fileDownload9FileName, fileDownload9, getTextWithArgs("product.uploadDownload9.dir"), product.getId());
		saveFileToLocal(fileDownload10FileName, fileDownload10, getTextWithArgs("product.uploadDownload10.dir"), product.getId());
		saveFileToLocal(fileDiagram1FileName, fileDiagram1, getTextWithArgs("product.uploadDiagram1.dir"), product.getId());
		saveFileToLocal(fileDiagram2FileName, fileDiagram2, getTextWithArgs("product.uploadDiagram2.dir"), product.getId());
		saveFileToLocal(fileDiagram3FileName, fileDiagram3, getTextWithArgs("product.uploadDiagram3.dir"), product.getId());
		saveFileToLocal(fileDiagram4FileName, fileDiagram4, getTextWithArgs("product.uploadDiagram4.dir"), product.getId());
		saveFileToLocal(fileDiagram5FileName, fileDiagram5, getTextWithArgs("product.uploadDiagram5.dir"), product.getId());
		saveFileToLocal(fileDiagram6FileName, fileDiagram6, getTextWithArgs("product.uploadDiagram6.dir"), product.getId());
		saveFileToLocal(fileDiagram7FileName, fileDiagram7, getTextWithArgs("product.uploadDiagram7.dir"), product.getId());
		saveFileToLocal(fileDiagram8FileName, fileDiagram8, getTextWithArgs("product.uploadDiagram8.dir"), product.getId());
		saveFileToLocal(fileDiagram9FileName, fileDiagram9, getTextWithArgs("product.uploadDiagram9.dir"), product.getId());
		saveFileToLocal(fileDiagram10FileName, fileDiagram10, getTextWithArgs("product.uploadDiagram10.dir"), product.getId());

		saveFileToLocal(fileLogo1FileName, fileLogo1, getTextWithArgs("product.uploadLogo1.dir"), product.getId());
		saveFileToLocal(fileLogo2FileName, fileLogo2, getTextWithArgs("product.uploadLogo2.dir"), product.getId());
		saveFileToLocal(fileLogo3FileName, fileLogo3, getTextWithArgs("product.uploadLogo3.dir"), product.getId());
		saveFileToLocal(fileLogo4FileName, fileLogo4, getTextWithArgs("product.uploadLogo4.dir"), product.getId());
		saveFileToLocal(fileLogo5FileName, fileLogo5, getTextWithArgs("product.uploadLogo5.dir"), product.getId());
		saveFileToLocal(fileLogo6FileName, fileLogo6, getTextWithArgs("product.uploadLogo6.dir"), product.getId());
		saveFileToLocal(fileLogo7FileName, fileLogo7, getTextWithArgs("product.uploadLogo7.dir"), product.getId());
		saveFileToLocal(fileLogo8FileName, fileLogo8, getTextWithArgs("product.uploadLogo8.dir"), product.getId());
		saveFileToLocal(fileLogo9FileName, fileLogo9, getTextWithArgs("product.uploadLogo9.dir"), product.getId());
		saveFileToLocal(fileLogo10FileName, fileLogo10, getTextWithArgs("product.uploadLogo10.dir"), product.getId());
		saveFileToLocal(fileLogo11FileName, fileLogo11, getTextWithArgs("product.uploadLogo11.dir"), product.getId());
		saveFileToLocal(fileLogo12FileName, fileLogo12, getTextWithArgs("product.uploadLogo12.dir"), product.getId());
		saveFileToLocal(fileLogo13FileName, fileLogo13, getTextWithArgs("product.uploadLogo13.dir"), product.getId());
		saveFileToLocal(fileLogo14FileName, fileLogo14, getTextWithArgs("product.uploadLogo14.dir"), product.getId());
		saveFileToLocal(fileLogo15FileName, fileLogo15, getTextWithArgs("product.uploadLogo15.dir"), product.getId());
		saveFileToLocal(fileLogo16FileName, fileLogo16, getTextWithArgs("product.uploadLogo16.dir"), product.getId());

		appendXworkParam("product.id=" + product.getId());

		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		typesIds = getGenericManager().getIdsFromProductTypeList(product.getTypes());
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		

		if (getRemoveLogo1() != null && getRemoveLogo1().length() > 0) {
			product.setLogo1(computeUploadedFile(fileLogo1FileName, fileLogo1));
			removeUploadedFile(getTextWithArgs("product.uploadLogo1.dir"), product.getLogo1Id(), product.getLogo1FileName());
		} else {
			if (product.getLogo1Id() != null)
				product.setLogo1(getGenericManager().getUploadedFileById(product.getLogo1Id()));
			else
				product.setLogo1(computeUploadedFile(fileLogo1FileName, fileLogo1));
		}
		if (getRemoveLogo2() != null && getRemoveLogo2().length() > 0) {
			product.setLogo2(computeUploadedFile(fileLogo2FileName, fileLogo2));
			removeUploadedFile(getTextWithArgs("product.uploadLogo2.dir"), product.getLogo2Id(), product.getLogo2FileName());
		} else {
			if (product.getLogo2Id() != null)
				product.setLogo2(getGenericManager().getUploadedFileById(product.getLogo2Id()));
			else
				product.setLogo2(computeUploadedFile(fileLogo2FileName, fileLogo2));
		}
		if (getRemoveLogo3() != null && getRemoveLogo3().length() > 0) {
			product.setLogo3(computeUploadedFile(fileLogo3FileName, fileLogo3));
			removeUploadedFile(getTextWithArgs("product.uploadLogo3.dir"), product.getLogo3Id(), product.getLogo3FileName());
		} else {
			if (product.getLogo3Id() != null)
				product.setLogo3(getGenericManager().getUploadedFileById(product.getLogo3Id()));
			else
				product.setLogo3(computeUploadedFile(fileLogo3FileName, fileLogo3));
		}
		if (getRemoveLogo4() != null && getRemoveLogo4().length() > 0) {
			product.setLogo4(computeUploadedFile(fileLogo4FileName, fileLogo4));
			removeUploadedFile(getTextWithArgs("product.uploadLogo4.dir"), product.getLogo4Id(), product.getLogo4FileName());
		} else {
			if (product.getLogo4Id() != null)
				product.setLogo4(getGenericManager().getUploadedFileById(product.getLogo4Id()));
			else
				product.setLogo4(computeUploadedFile(fileLogo4FileName, fileLogo4));
		}
		if (getRemoveLogo5() != null && getRemoveLogo5().length() > 0) {
			product.setLogo5(computeUploadedFile(fileLogo5FileName, fileLogo5));
			removeUploadedFile(getTextWithArgs("product.uploadLogo5.dir"), product.getLogo5Id(), product.getLogo5FileName());
		} else {
			if (product.getLogo5Id() != null)
				product.setLogo5(getGenericManager().getUploadedFileById(product.getLogo5Id()));
			else
				product.setLogo5(computeUploadedFile(fileLogo5FileName, fileLogo5));
		}
		if (getRemoveLogo6() != null && getRemoveLogo6().length() > 0) {
			product.setLogo6(computeUploadedFile(fileLogo6FileName, fileLogo6));
			removeUploadedFile(getTextWithArgs("product.uploadLogo6.dir"), product.getLogo6Id(), product.getLogo6FileName());
		} else {
			if (product.getLogo6Id() != null)
				product.setLogo6(getGenericManager().getUploadedFileById(product.getLogo6Id()));
			else
				product.setLogo6(computeUploadedFile(fileLogo6FileName, fileLogo6));
		}
		if (getRemoveLogo7() != null && getRemoveLogo7().length() > 0) {
			product.setLogo7(computeUploadedFile(fileLogo7FileName, fileLogo7));
			removeUploadedFile(getTextWithArgs("product.uploadLogo7.dir"), product.getLogo7Id(), product.getLogo7FileName());
		} else {
			if (product.getLogo7Id() != null)
				product.setLogo7(getGenericManager().getUploadedFileById(product.getLogo7Id()));
			else
				product.setLogo7(computeUploadedFile(fileLogo7FileName, fileLogo7));
		}
		if (getRemoveLogo8() != null && getRemoveLogo8().length() > 0) {
			product.setLogo8(computeUploadedFile(fileLogo8FileName, fileLogo8));
			removeUploadedFile(getTextWithArgs("product.uploadLogo8.dir"), product.getLogo8Id(), product.getLogo8FileName());
		} else {
			if (product.getLogo8Id() != null)
				product.setLogo8(getGenericManager().getUploadedFileById(product.getLogo8Id()));
			else
				product.setLogo8(computeUploadedFile(fileLogo8FileName, fileLogo8));
		}
		if (getRemoveLogo9() != null && getRemoveLogo9().length() > 0) {
			product.setLogo9(computeUploadedFile(fileLogo9FileName, fileLogo9));
			removeUploadedFile(getTextWithArgs("product.uploadLogo9.dir"), product.getLogo9Id(), product.getLogo9FileName());
		} else {
			if (product.getLogo9Id() != null)
				product.setLogo9(getGenericManager().getUploadedFileById(product.getLogo9Id()));
			else
				product.setLogo9(computeUploadedFile(fileLogo9FileName, fileLogo9));
		}
		if (getRemoveLogo10() != null && getRemoveLogo10().length() > 0) {
			product.setLogo10(computeUploadedFile(fileLogo10FileName, fileLogo10));
			removeUploadedFile(getTextWithArgs("product.uploadLogo10.dir"), product.getLogo10Id(), product.getLogo10FileName());
		} else {
			if (product.getLogo10Id() != null)
				product.setLogo10(getGenericManager().getUploadedFileById(product.getLogo10Id()));
			else
				product.setLogo10(computeUploadedFile(fileLogo10FileName, fileLogo10));
		}
		if (getRemoveLogo11() != null && getRemoveLogo11().length() > 0) {
			product.setLogo11(computeUploadedFile(fileLogo11FileName, fileLogo11));
			removeUploadedFile(getTextWithArgs("product.uploadLogo11.dir"), product.getLogo11Id(), product.getLogo11FileName());
		} else {
			if (product.getLogo11Id() != null)
				product.setLogo11(getGenericManager().getUploadedFileById(product.getLogo11Id()));
			else
				product.setLogo11(computeUploadedFile(fileLogo11FileName, fileLogo11));
		}
		if (getRemoveLogo12() != null && getRemoveLogo12().length() > 0) {
			product.setLogo12(computeUploadedFile(fileLogo12FileName, fileLogo12));
			removeUploadedFile(getTextWithArgs("product.uploadLogo12.dir"), product.getLogo12Id(), product.getLogo12FileName());
		} else {
			if (product.getLogo12Id() != null)
				product.setLogo12(getGenericManager().getUploadedFileById(product.getLogo12Id()));
			else
				product.setLogo12(computeUploadedFile(fileLogo12FileName, fileLogo12));
		}
		if (getRemoveLogo13() != null && getRemoveLogo13().length() > 0) {
			product.setLogo13(computeUploadedFile(fileLogo13FileName, fileLogo13));
			removeUploadedFile(getTextWithArgs("product.uploadLogo13.dir"), product.getLogo13Id(), product.getLogo13FileName());
		} else {
			if (product.getLogo13Id() != null)
				product.setLogo13(getGenericManager().getUploadedFileById(product.getLogo13Id()));
			else
				product.setLogo13(computeUploadedFile(fileLogo13FileName, fileLogo13));
		}
		if (getRemoveLogo14() != null && getRemoveLogo14().length() > 0) {
			product.setLogo14(computeUploadedFile(fileLogo14FileName, fileLogo14));
			removeUploadedFile(getTextWithArgs("product.uploadLogo14.dir"), product.getLogo14Id(), product.getLogo14FileName());
		} else {
			if (product.getLogo14Id() != null)
				product.setLogo14(getGenericManager().getUploadedFileById(product.getLogo14Id()));
			else
				product.setLogo14(computeUploadedFile(fileLogo14FileName, fileLogo14));
		}
		if (getRemoveLogo15() != null && getRemoveLogo15().length() > 0) {
			product.setLogo15(computeUploadedFile(fileLogo15FileName, fileLogo15));
			removeUploadedFile(getTextWithArgs("product.uploadLogo15.dir"), product.getLogo15Id(), product.getLogo15FileName());
		} else {
			if (product.getLogo15Id() != null)
				product.setLogo15(getGenericManager().getUploadedFileById(product.getLogo15Id()));
			else
				product.setLogo15(computeUploadedFile(fileLogo15FileName, fileLogo15));
		}
		if (getRemoveLogo16() != null && getRemoveLogo16().length() > 0) {
			product.setLogo16(computeUploadedFile(fileLogo16FileName, fileLogo16));
			removeUploadedFile(getTextWithArgs("product.uploadLogo16.dir"), product.getLogo16Id(), product.getLogo16FileName());
		} else {
			if (product.getLogo16Id() != null)
				product.setLogo16(getGenericManager().getUploadedFileById(product.getLogo16Id()));
			else
				product.setLogo16(computeUploadedFile(fileLogo16FileName, fileLogo16));
		}

		if (getRemoveProductPhoto1() != null && getRemoveProductPhoto1().length() > 0) {
			product.setProductPhoto1(computeUploadedFile(fileProductPhoto1FileName, fileProductPhoto1));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto1.dir"), product.getProductPhoto1Id(), product.getProductPhoto1FileName());
		} else {
			if (product.getProductPhoto1Id() != null)
				product.setProductPhoto1(getGenericManager().getUploadedFileById(product.getProductPhoto1Id()));
			else
				product.setProductPhoto1(computeUploadedFile(fileProductPhoto1FileName, fileProductPhoto1));
		}
		if (getRemoveProductPhoto2() != null && getRemoveProductPhoto2().length() > 0) {
			product.setProductPhoto2(computeUploadedFile(fileProductPhoto2FileName, fileProductPhoto2));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto2.dir"), product.getProductPhoto2Id(), product.getProductPhoto2FileName());
		} else {
			if (product.getProductPhoto2Id() != null)
				product.setProductPhoto2(getGenericManager().getUploadedFileById(product.getProductPhoto2Id()));
			else
				product.setProductPhoto2(computeUploadedFile(fileProductPhoto2FileName, fileProductPhoto2));
		}
		if (getRemoveProductPhoto3() != null && getRemoveProductPhoto3().length() > 0) {
			product.setProductPhoto3(computeUploadedFile(fileProductPhoto3FileName, fileProductPhoto3));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto3.dir"), product.getProductPhoto3Id(), product.getProductPhoto3FileName());
		} else {
			if (product.getProductPhoto3Id() != null)
				product.setProductPhoto3(getGenericManager().getUploadedFileById(product.getProductPhoto3Id()));
			else
				product.setProductPhoto3(computeUploadedFile(fileProductPhoto3FileName, fileProductPhoto3));
		}
		if (getRemoveProductPhoto4() != null && getRemoveProductPhoto4().length() > 0) {
			product.setProductPhoto4(computeUploadedFile(fileProductPhoto4FileName, fileProductPhoto4));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto4.dir"), product.getProductPhoto4Id(), product.getProductPhoto4FileName());
		} else {
			if (product.getProductPhoto4Id() != null)
				product.setProductPhoto4(getGenericManager().getUploadedFileById(product.getProductPhoto4Id()));
			else
				product.setProductPhoto4(computeUploadedFile(fileProductPhoto4FileName, fileProductPhoto4));
		}
		if (getRemoveProductPhoto5() != null && getRemoveProductPhoto5().length() > 0) {
			product.setProductPhoto5(computeUploadedFile(fileProductPhoto5FileName, fileProductPhoto5));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto5.dir"), product.getProductPhoto5Id(), product.getProductPhoto5FileName());
		} else {
			if (product.getProductPhoto5Id() != null)
				product.setProductPhoto5(getGenericManager().getUploadedFileById(product.getProductPhoto5Id()));
			else
				product.setProductPhoto5(computeUploadedFile(fileProductPhoto5FileName, fileProductPhoto5));
		}
		if (getRemoveProductPhoto6() != null && getRemoveProductPhoto6().length() > 0) {
			product.setProductPhoto6(computeUploadedFile(fileProductPhoto6FileName, fileProductPhoto6));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto6.dir"), product.getProductPhoto6Id(), product.getProductPhoto6FileName());
		} else {
			if (product.getProductPhoto6Id() != null)
				product.setProductPhoto6(getGenericManager().getUploadedFileById(product.getProductPhoto6Id()));
			else
				product.setProductPhoto6(computeUploadedFile(fileProductPhoto6FileName, fileProductPhoto6));
		}
		if (getRemoveProductPhoto7() != null && getRemoveProductPhoto7().length() > 0) {
			product.setProductPhoto7(computeUploadedFile(fileProductPhoto7FileName, fileProductPhoto7));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto7.dir"), product.getProductPhoto7Id(), product.getProductPhoto7FileName());
		} else {
			if (product.getProductPhoto7Id() != null)
				product.setProductPhoto7(getGenericManager().getUploadedFileById(product.getProductPhoto7Id()));
			else
				product.setProductPhoto7(computeUploadedFile(fileProductPhoto7FileName, fileProductPhoto7));
		}
		if (getRemoveProductPhoto8() != null && getRemoveProductPhoto8().length() > 0) {
			product.setProductPhoto8(computeUploadedFile(fileProductPhoto8FileName, fileProductPhoto8));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto8.dir"), product.getProductPhoto8Id(), product.getProductPhoto8FileName());
		} else {
			if (product.getProductPhoto8Id() != null)
				product.setProductPhoto8(getGenericManager().getUploadedFileById(product.getProductPhoto8Id()));
			else
				product.setProductPhoto8(computeUploadedFile(fileProductPhoto8FileName, fileProductPhoto8));
		}
		if (getRemoveProductPhoto9() != null && getRemoveProductPhoto9().length() > 0) {
			product.setProductPhoto9(computeUploadedFile(fileProductPhoto9FileName, fileProductPhoto9));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto9.dir"), product.getProductPhoto9Id(), product.getProductPhoto9FileName());
		} else {
			if (product.getProductPhoto9Id() != null)
				product.setProductPhoto9(getGenericManager().getUploadedFileById(product.getProductPhoto9Id()));
			else
				product.setProductPhoto9(computeUploadedFile(fileProductPhoto9FileName, fileProductPhoto9));
		}
		if (getRemoveProductPhoto10() != null && getRemoveProductPhoto10().length() > 0) {
			product.setProductPhoto10(computeUploadedFile(fileProductPhoto10FileName, fileProductPhoto10));
			removeUploadedFile(getTextWithArgs("product.uploadProductPhoto10.dir"), product.getProductPhoto10Id(), product.getProductPhoto10FileName());
		} else {
			if (product.getProductPhoto10Id() != null)
				product.setProductPhoto10(getGenericManager().getUploadedFileById(product.getProductPhoto10Id()));
			else
				product.setProductPhoto10(computeUploadedFile(fileProductPhoto10FileName, fileProductPhoto10));
		}
		if (getRemoveDownload1() != null && getRemoveDownload1().length() > 0) {
			product.setDownload1(computeUploadedFile(fileDownload1FileName, fileDownload1));
			removeUploadedFile(getTextWithArgs("product.uploadDownload1.dir"), product.getDownload1Id(), product.getDownload1FileName());
		} else {
			if (product.getDownload1Id() != null)
				product.setDownload1(getGenericManager().getUploadedFileById(product.getDownload1Id()));
			else
				product.setDownload1(computeUploadedFile(fileDownload1FileName, fileDownload1));
		}
		if (getRemoveDownload2() != null && getRemoveDownload2().length() > 0) {
			product.setDownload2(computeUploadedFile(fileDownload2FileName, fileDownload2));
			removeUploadedFile(getTextWithArgs("product.uploadDownload2.dir"), product.getDownload2Id(), product.getDownload2FileName());
		} else {
			if (product.getDownload2Id() != null)
				product.setDownload2(getGenericManager().getUploadedFileById(product.getDownload2Id()));
			else
				product.setDownload2(computeUploadedFile(fileDownload2FileName, fileDownload2));
		}
		if (getRemoveDownload3() != null && getRemoveDownload3().length() > 0) {
			product.setDownload3(computeUploadedFile(fileDownload3FileName, fileDownload3));
			removeUploadedFile(getTextWithArgs("product.uploadDownload3.dir"), product.getDownload3Id(), product.getDownload3FileName());
		} else {
			if (product.getDownload3Id() != null)
				product.setDownload3(getGenericManager().getUploadedFileById(product.getDownload3Id()));
			else
				product.setDownload3(computeUploadedFile(fileDownload3FileName, fileDownload3));
		}
		if (getRemoveDownload4() != null && getRemoveDownload4().length() > 0) {
			product.setDownload4(computeUploadedFile(fileDownload4FileName, fileDownload4));
			removeUploadedFile(getTextWithArgs("product.uploadDownload4.dir"), product.getDownload4Id(), product.getDownload4FileName());
		} else {
			if (product.getDownload4Id() != null)
				product.setDownload4(getGenericManager().getUploadedFileById(product.getDownload4Id()));
			else
				product.setDownload4(computeUploadedFile(fileDownload4FileName, fileDownload4));
		}
		if (getRemoveDownload5() != null && getRemoveDownload5().length() > 0) {
			product.setDownload5(computeUploadedFile(fileDownload5FileName, fileDownload5));
			removeUploadedFile(getTextWithArgs("product.uploadDownload5.dir"), product.getDownload5Id(), product.getDownload5FileName());
		} else {
			if (product.getDownload5Id() != null)
				product.setDownload5(getGenericManager().getUploadedFileById(product.getDownload5Id()));
			else
				product.setDownload5(computeUploadedFile(fileDownload5FileName, fileDownload5));
		}
		if (getRemoveDownload6() != null && getRemoveDownload6().length() > 0) {
			product.setDownload6(computeUploadedFile(fileDownload6FileName, fileDownload6));
			removeUploadedFile(getTextWithArgs("product.uploadDownload6.dir"), product.getDownload6Id(), product.getDownload6FileName());
		} else {
			if (product.getDownload6Id() != null)
				product.setDownload6(getGenericManager().getUploadedFileById(product.getDownload6Id()));
			else
				product.setDownload6(computeUploadedFile(fileDownload6FileName, fileDownload6));
		}
		if (getRemoveDownload7() != null && getRemoveDownload7().length() > 0) {
			product.setDownload7(computeUploadedFile(fileDownload7FileName, fileDownload7));
			removeUploadedFile(getTextWithArgs("product.uploadDownload7.dir"), product.getDownload7Id(), product.getDownload7FileName());
		} else {
			if (product.getDownload7Id() != null)
				product.setDownload7(getGenericManager().getUploadedFileById(product.getDownload7Id()));
			else
				product.setDownload7(computeUploadedFile(fileDownload7FileName, fileDownload7));
		}
		if (getRemoveDownload8() != null && getRemoveDownload8().length() > 0) {
			product.setDownload8(computeUploadedFile(fileDownload8FileName, fileDownload8));
			removeUploadedFile(getTextWithArgs("product.uploadDownload8.dir"), product.getDownload8Id(), product.getDownload8FileName());
		} else {
			if (product.getDownload8Id() != null)
				product.setDownload8(getGenericManager().getUploadedFileById(product.getDownload8Id()));
			else
				product.setDownload8(computeUploadedFile(fileDownload8FileName, fileDownload8));
		}
		if (getRemoveDownload9() != null && getRemoveDownload9().length() > 0) {
			product.setDownload9(computeUploadedFile(fileDownload9FileName, fileDownload9));
			removeUploadedFile(getTextWithArgs("product.uploadDownload9.dir"), product.getDownload9Id(), product.getDownload9FileName());
		} else {
			if (product.getDownload9Id() != null)
				product.setDownload9(getGenericManager().getUploadedFileById(product.getDownload9Id()));
			else
				product.setDownload9(computeUploadedFile(fileDownload9FileName, fileDownload9));
		}
		if (getRemoveDownload10() != null && getRemoveDownload10().length() > 0) {
			product.setDownload10(computeUploadedFile(fileDownload10FileName, fileDownload10));
			removeUploadedFile(getTextWithArgs("product.uploadDownload10.dir"), product.getDownload10Id(), product.getDownload10FileName());
		} else {
			if (product.getDownload10Id() != null)
				product.setDownload10(getGenericManager().getUploadedFileById(product.getDownload10Id()));
			else
				product.setDownload10(computeUploadedFile(fileDownload10FileName, fileDownload10));
		}
		if (getRemoveDiagram1() != null && getRemoveDiagram1().length() > 0) {
			product.setDiagram1(computeUploadedFile(fileDiagram1FileName, fileDiagram1));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram1.dir"), product.getDiagram1Id(), product.getDiagram1FileName());
		} else {
			if (product.getDiagram1Id() != null)
				product.setDiagram1(getGenericManager().getUploadedFileById(product.getDiagram1Id()));
			else
				product.setDiagram1(computeUploadedFile(fileDiagram1FileName, fileDiagram1));
		}
		if (getRemoveDiagram2() != null && getRemoveDiagram2().length() > 0) {
			product.setDiagram2(computeUploadedFile(fileDiagram2FileName, fileDiagram2));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram2.dir"), product.getDiagram2Id(), product.getDiagram2FileName());
		} else {
			if (product.getDiagram2Id() != null)
				product.setDiagram2(getGenericManager().getUploadedFileById(product.getDiagram2Id()));
			else
				product.setDiagram2(computeUploadedFile(fileDiagram2FileName, fileDiagram2));
		}
		if (getRemoveDiagram3() != null && getRemoveDiagram3().length() > 0) {
			product.setDiagram3(computeUploadedFile(fileDiagram3FileName, fileDiagram3));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram3.dir"), product.getDiagram3Id(), product.getDiagram3FileName());
		} else {
			if (product.getDiagram3Id() != null)
				product.setDiagram3(getGenericManager().getUploadedFileById(product.getDiagram3Id()));
			else
				product.setDiagram3(computeUploadedFile(fileDiagram3FileName, fileDiagram3));
		}
		if (getRemoveDiagram4() != null && getRemoveDiagram4().length() > 0) {
			product.setDiagram4(computeUploadedFile(fileDiagram4FileName, fileDiagram4));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram4.dir"), product.getDiagram4Id(), product.getDiagram4FileName());
		} else {
			if (product.getDiagram4Id() != null)
				product.setDiagram4(getGenericManager().getUploadedFileById(product.getDiagram4Id()));
			else
				product.setDiagram4(computeUploadedFile(fileDiagram4FileName, fileDiagram4));
		}
		if (getRemoveDiagram5() != null && getRemoveDiagram5().length() > 0) {
			product.setDiagram5(computeUploadedFile(fileDiagram5FileName, fileDiagram5));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram5.dir"), product.getDiagram5Id(), product.getDiagram5FileName());
		} else {
			if (product.getDiagram5Id() != null)
				product.setDiagram5(getGenericManager().getUploadedFileById(product.getDiagram5Id()));
			else
				product.setDiagram5(computeUploadedFile(fileDiagram5FileName, fileDiagram5));
		}
		if (getRemoveDiagram6() != null && getRemoveDiagram6().length() > 0) {
			product.setDiagram6(computeUploadedFile(fileDiagram6FileName, fileDiagram6));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram6.dir"), product.getDiagram6Id(), product.getDiagram6FileName());
		} else {
			if (product.getDiagram6Id() != null)
				product.setDiagram6(getGenericManager().getUploadedFileById(product.getDiagram6Id()));
			else
				product.setDiagram6(computeUploadedFile(fileDiagram6FileName, fileDiagram6));
		}
		if (getRemoveDiagram7() != null && getRemoveDiagram7().length() > 0) {
			product.setDiagram7(computeUploadedFile(fileDiagram7FileName, fileDiagram7));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram7.dir"), product.getDiagram7Id(), product.getDiagram7FileName());
		} else {
			if (product.getDiagram7Id() != null)
				product.setDiagram7(getGenericManager().getUploadedFileById(product.getDiagram7Id()));
			else
				product.setDiagram7(computeUploadedFile(fileDiagram7FileName, fileDiagram7));
		}
		if (getRemoveDiagram8() != null && getRemoveDiagram8().length() > 0) {
			product.setDiagram8(computeUploadedFile(fileDiagram8FileName, fileDiagram8));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram8.dir"), product.getDiagram8Id(), product.getDiagram8FileName());
		} else {
			if (product.getDiagram8Id() != null)
				product.setDiagram8(getGenericManager().getUploadedFileById(product.getDiagram8Id()));
			else
				product.setDiagram8(computeUploadedFile(fileDiagram8FileName, fileDiagram8));
		}
		if (getRemoveDiagram9() != null && getRemoveDiagram9().length() > 0) {
			product.setDiagram9(computeUploadedFile(fileDiagram9FileName, fileDiagram9));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram9.dir"), product.getDiagram9Id(), product.getDiagram9FileName());
		} else {
			if (product.getDiagram9Id() != null)
				product.setDiagram9(getGenericManager().getUploadedFileById(product.getDiagram9Id()));
			else
				product.setDiagram9(computeUploadedFile(fileDiagram9FileName, fileDiagram9));
		}
		if (getRemoveDiagram10() != null && getRemoveDiagram10().length() > 0) {
			product.setDiagram10(computeUploadedFile(fileDiagram10FileName, fileDiagram10));
			removeUploadedFile(getTextWithArgs("product.uploadDiagram10.dir"), product.getDiagram10Id(), product.getDiagram10FileName());
		} else {
			if (product.getDiagram10Id() != null)
				product.setDiagram10(getGenericManager().getUploadedFileById(product.getDiagram10Id()));
			else
				product.setDiagram10(computeUploadedFile(fileDiagram10FileName, fileDiagram10));
		}

		product.setTarget1(getAppPropertyById(product.getTarget1Id()));
		product.setTarget2(getAppPropertyById(product.getTarget2Id()));
		product.setTarget3(getAppPropertyById(product.getTarget3Id()));
		product.setTarget4(getAppPropertyById(product.getTarget4Id()));
		product.setTarget5(getAppPropertyById(product.getTarget5Id()));
		product.setTarget6(getAppPropertyById(product.getTarget6Id()));
		product.setTarget7(getAppPropertyById(product.getTarget7Id()));
		product.setTarget8(getAppPropertyById(product.getTarget8Id()));
		product.setTarget9(getAppPropertyById(product.getTarget9Id()));
		product.setTarget10(getAppPropertyById(product.getTarget10Id()));
		product.setTarget11(getAppPropertyById(product.getTarget11Id()));
		product.setTarget12(getAppPropertyById(product.getTarget12Id()));
		product.setTarget13(getAppPropertyById(product.getTarget13Id()));
		product.setTarget14(getAppPropertyById(product.getTarget14Id()));
		product.setTarget15(getAppPropertyById(product.getTarget15Id()));
		product.setTarget16(getAppPropertyById(product.getTarget16Id()));
		product.setTarget17(getAppPropertyById(product.getTarget17Id()));
		product.setTarget18(getAppPropertyById(product.getTarget18Id()));
		product.setTarget19(getAppPropertyById(product.getTarget19Id()));
		product.setTarget20(getAppPropertyById(product.getTarget20Id()));
		product.setTarget21(getAppPropertyById(product.getTarget21Id()));
		product.setTarget22(getAppPropertyById(product.getTarget22Id()));
		product.setTarget23(getAppPropertyById(product.getTarget23Id()));
		product.setTarget24(getAppPropertyById(product.getTarget24Id()));
		product.setTarget25(getAppPropertyById(product.getTarget25Id()));
		product.setTarget26(getAppPropertyById(product.getTarget26Id()));
		product.setTarget27(getAppPropertyById(product.getTarget27Id()));
		product.setTarget28(getAppPropertyById(product.getTarget28Id()));
		product.setTarget29(getAppPropertyById(product.getTarget29Id()));
		product.setTarget30(getAppPropertyById(product.getTarget30Id()));

		// Types
		try{
			List<ProductType> ls = new ArrayList<ProductType>();
			System.out.println("typesIds.length="+typesIds.length);
			for (int i = 0; i < typesIds.length; i++) {
				productType = getGenericManager().getProductTypeById(typesIds[i]);
				ls.add(productType);
			}
			product.setTypes(ls);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		

	}

	public List<ProductType> getProductTypeList() {
		return getGenericManager().getProductTypeList(); // TODO
	}

	public List<Product> getProductList() {
		try {
			productType = getGenericManager().getProductTypeById(productType.getId());
		} catch (Exception e) {

		}

		return getGenericManager().getProductList(productType);
	}

	public void setSelectedProductIds(Long[] val) {
		selectedProductIds = val;
	}

	public Long[] getSelectedProductIds() {
		return selectedProductIds;
	}

	public void setFileLogo1(java.io.File val) {
		fileLogo1 = val;
	}

	public java.io.File getFileLogo1() {
		return fileLogo1;
	}

	public void setFileLogo1ContentType(String val) {
		fileLogo1ContentType = val;
	}

	public String getFileLogo1ContentType() {
		return fileLogo1ContentType;
	}

	public void setFileLogo1FileName(String val) {
		fileLogo1FileName = val;
	}

	public String getFileLogo1FileName() {
		return fileLogo1FileName;
	}

	public void setRemoveLogo1(String val) {
		removeLogo1 = val;
	}

	public String getRemoveLogo1() {
		return removeLogo1;
	}

	public void setFileLogo2(java.io.File val) {
		fileLogo2 = val;
	}

	public java.io.File getFileLogo2() {
		return fileLogo2;
	}

	public void setFileLogo2ContentType(String val) {
		fileLogo2ContentType = val;
	}

	public String getFileLogo2ContentType() {
		return fileLogo2ContentType;
	}

	public void setFileLogo2FileName(String val) {
		fileLogo2FileName = val;
	}

	public String getFileLogo2FileName() {
		return fileLogo2FileName;
	}

	public void setRemoveLogo2(String val) {
		removeLogo2 = val;
	}

	public String getRemoveLogo2() {
		return removeLogo2;
	}

	public void setFileLogo3(java.io.File val) {
		fileLogo3 = val;
	}

	public java.io.File getFileLogo3() {
		return fileLogo3;
	}

	public void setFileLogo3ContentType(String val) {
		fileLogo3ContentType = val;
	}

	public String getFileLogo3ContentType() {
		return fileLogo3ContentType;
	}

	public void setFileLogo3FileName(String val) {
		fileLogo3FileName = val;
	}

	public String getFileLogo3FileName() {
		return fileLogo3FileName;
	}

	public void setRemoveLogo3(String val) {
		removeLogo3 = val;
	}

	public String getRemoveLogo3() {
		return removeLogo3;
	}

	public void setFileLogo4(java.io.File val) {
		fileLogo4 = val;
	}

	public java.io.File getFileLogo4() {
		return fileLogo4;
	}

	public void setFileLogo4ContentType(String val) {
		fileLogo4ContentType = val;
	}

	public String getFileLogo4ContentType() {
		return fileLogo4ContentType;
	}

	public void setFileLogo4FileName(String val) {
		fileLogo4FileName = val;
	}

	public String getFileLogo4FileName() {
		return fileLogo4FileName;
	}

	public void setRemoveLogo4(String val) {
		removeLogo4 = val;
	}

	public String getRemoveLogo4() {
		return removeLogo4;
	}

	public void setFileLogo5(java.io.File val) {
		fileLogo5 = val;
	}

	public java.io.File getFileLogo5() {
		return fileLogo5;
	}

	public void setFileLogo5ContentType(String val) {
		fileLogo5ContentType = val;
	}

	public String getFileLogo5ContentType() {
		return fileLogo5ContentType;
	}

	public void setFileLogo5FileName(String val) {
		fileLogo5FileName = val;
	}

	public String getFileLogo5FileName() {
		return fileLogo5FileName;
	}

	public void setRemoveLogo5(String val) {
		removeLogo5 = val;
	}

	public String getRemoveLogo5() {
		return removeLogo5;
	}

	public void setFileLogo6(java.io.File val) {
		fileLogo6 = val;
	}

	public java.io.File getFileLogo6() {
		return fileLogo6;
	}

	public void setFileLogo6ContentType(String val) {
		fileLogo6ContentType = val;
	}

	public String getFileLogo6ContentType() {
		return fileLogo6ContentType;
	}

	public void setFileLogo6FileName(String val) {
		fileLogo6FileName = val;
	}

	public String getFileLogo6FileName() {
		return fileLogo6FileName;
	}

	public void setRemoveLogo6(String val) {
		removeLogo6 = val;
	}

	public String getRemoveLogo6() {
		return removeLogo6;
	}

	public void setFileLogo7(java.io.File val) {
		fileLogo7 = val;
	}

	public java.io.File getFileLogo7() {
		return fileLogo7;
	}

	public void setFileLogo7ContentType(String val) {
		fileLogo7ContentType = val;
	}

	public String getFileLogo7ContentType() {
		return fileLogo7ContentType;
	}

	public void setFileLogo7FileName(String val) {
		fileLogo7FileName = val;
	}

	public String getFileLogo7FileName() {
		return fileLogo7FileName;
	}

	public void setRemoveLogo7(String val) {
		removeLogo7 = val;
	}

	public String getRemoveLogo7() {
		return removeLogo7;
	}

	public void setFileLogo8(java.io.File val) {
		fileLogo8 = val;
	}

	public java.io.File getFileLogo8() {
		return fileLogo8;
	}

	public void setFileLogo8ContentType(String val) {
		fileLogo8ContentType = val;
	}

	public String getFileLogo8ContentType() {
		return fileLogo8ContentType;
	}

	public void setFileLogo8FileName(String val) {
		fileLogo8FileName = val;
	}

	public String getFileLogo8FileName() {
		return fileLogo8FileName;
	}

	public void setRemoveLogo8(String val) {
		removeLogo8 = val;
	}

	public String getRemoveLogo8() {
		return removeLogo8;
	}

	public void setFileLogo9(java.io.File val) {
		fileLogo9 = val;
	}

	public java.io.File getFileLogo9() {
		return fileLogo9;
	}

	public void setFileLogo9ContentType(String val) {
		fileLogo9ContentType = val;
	}

	public String getFileLogo9ContentType() {
		return fileLogo9ContentType;
	}

	public void setFileLogo9FileName(String val) {
		fileLogo9FileName = val;
	}

	public String getFileLogo9FileName() {
		return fileLogo9FileName;
	}

	public void setRemoveLogo9(String val) {
		removeLogo9 = val;
	}

	public String getRemoveLogo9() {
		return removeLogo9;
	}

	public void setFileLogo10(java.io.File val) {
		fileLogo10 = val;
	}

	public java.io.File getFileLogo10() {
		return fileLogo10;
	}

	public void setFileLogo10ContentType(String val) {
		fileLogo10ContentType = val;
	}

	public String getFileLogo10ContentType() {
		return fileLogo10ContentType;
	}

	public void setFileLogo10FileName(String val) {
		fileLogo10FileName = val;
	}

	public String getFileLogo10FileName() {
		return fileLogo10FileName;
	}

	public void setRemoveLogo10(String val) {
		removeLogo10 = val;
	}

	public String getRemoveLogo10() {
		return removeLogo10;
	}

	public void setFileLogo11(java.io.File val) {
		fileLogo11 = val;
	}

	public java.io.File getFileLogo11() {
		return fileLogo11;
	}

	public void setFileLogo11ContentType(String val) {
		fileLogo11ContentType = val;
	}

	public String getFileLogo11ContentType() {
		return fileLogo11ContentType;
	}

	public void setFileLogo11FileName(String val) {
		fileLogo11FileName = val;
	}

	public String getFileLogo11FileName() {
		return fileLogo11FileName;
	}

	public void setRemoveLogo11(String val) {
		removeLogo11 = val;
	}

	public String getRemoveLogo11() {
		return removeLogo11;
	}

	public void setFileLogo12(java.io.File val) {
		fileLogo12 = val;
	}

	public java.io.File getFileLogo12() {
		return fileLogo12;
	}

	public void setFileLogo12ContentType(String val) {
		fileLogo12ContentType = val;
	}

	public String getFileLogo12ContentType() {
		return fileLogo12ContentType;
	}

	public void setFileLogo12FileName(String val) {
		fileLogo12FileName = val;
	}

	public String getFileLogo12FileName() {
		return fileLogo12FileName;
	}

	public void setRemoveLogo12(String val) {
		removeLogo12 = val;
	}

	public String getRemoveLogo12() {
		return removeLogo12;
	}

	public void setFileLogo13(java.io.File val) {
		fileLogo13 = val;
	}

	public java.io.File getFileLogo13() {
		return fileLogo13;
	}

	public void setFileLogo13ContentType(String val) {
		fileLogo13ContentType = val;
	}

	public String getFileLogo13ContentType() {
		return fileLogo13ContentType;
	}

	public void setFileLogo13FileName(String val) {
		fileLogo13FileName = val;
	}

	public String getFileLogo13FileName() {
		return fileLogo13FileName;
	}

	public void setRemoveLogo13(String val) {
		removeLogo13 = val;
	}

	public String getRemoveLogo13() {
		return removeLogo13;
	}

	public void setFileLogo14(java.io.File val) {
		fileLogo14 = val;
	}

	public java.io.File getFileLogo14() {
		return fileLogo14;
	}

	public void setFileLogo14ContentType(String val) {
		fileLogo14ContentType = val;
	}

	public String getFileLogo14ContentType() {
		return fileLogo14ContentType;
	}

	public void setFileLogo14FileName(String val) {
		fileLogo14FileName = val;
	}

	public String getFileLogo14FileName() {
		return fileLogo14FileName;
	}

	public void setRemoveLogo14(String val) {
		removeLogo14 = val;
	}

	public String getRemoveLogo14() {
		return removeLogo14;
	}

	public void setFileLogo15(java.io.File val) {
		fileLogo15 = val;
	}

	public java.io.File getFileLogo15() {
		return fileLogo15;
	}

	public void setFileLogo15ContentType(String val) {
		fileLogo15ContentType = val;
	}

	public String getFileLogo15ContentType() {
		return fileLogo15ContentType;
	}

	public void setFileLogo15FileName(String val) {
		fileLogo15FileName = val;
	}

	public String getFileLogo15FileName() {
		return fileLogo15FileName;
	}

	public void setRemoveLogo15(String val) {
		removeLogo15 = val;
	}

	public String getRemoveLogo15() {
		return removeLogo15;
	}

	public void setFileLogo16(java.io.File val) {
		fileLogo16 = val;
	}

	public java.io.File getFileLogo16() {
		return fileLogo16;
	}

	public void setFileLogo16ContentType(String val) {
		fileLogo16ContentType = val;
	}

	public String getFileLogo16ContentType() {
		return fileLogo16ContentType;
	}

	public void setFileLogo16FileName(String val) {
		fileLogo16FileName = val;
	}

	public String getFileLogo16FileName() {
		return fileLogo16FileName;
	}

	public void setRemoveLogo16(String val) {
		removeLogo16 = val;
	}

	public String getRemoveLogo16() {
		return removeLogo16;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Long[] getTypesIds() {
		return typesIds;
	}

	public void setTypesIds(Long[] typesIds) {
		this.typesIds = typesIds;
	}

}
