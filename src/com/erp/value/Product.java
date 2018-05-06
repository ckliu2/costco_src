package com.erp.value;

import com.base.value.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Product extends BaseObject implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;

	/** persistent field */
	private String no;

	/** persistent field */
	private String name;

	String description;

	/** nullable persistent field */
	private String overview;

	/** nullable persistent field */
	private String specification;



	/** nullable persistent field */
	private UploadedFile logo1;
	private String logo1FileName;
	private Long logo1Id;

	/** nullable persistent field */
	private UploadedFile logo2;
	private String logo2FileName;
	private Long logo2Id;

	/** nullable persistent field */
	private UploadedFile logo3;
	private String logo3FileName;
	private Long logo3Id;

	/** nullable persistent field */
	private UploadedFile logo4;
	private String logo4FileName;
	private Long logo4Id;

	/** nullable persistent field */
	private UploadedFile logo5;
	private String logo5FileName;
	private Long logo5Id;

	/** nullable persistent field */
	private UploadedFile logo6;
	private String logo6FileName;
	private Long logo6Id;

	/** nullable persistent field */
	private UploadedFile logo7;
	private String logo7FileName;
	private Long logo7Id;

	/** nullable persistent field */
	private UploadedFile logo8;
	private String logo8FileName;
	private Long logo8Id;

	/** nullable persistent field */
	private UploadedFile logo9;
	private String logo9FileName;
	private Long logo9Id;

	/** nullable persistent field */
	private UploadedFile logo10;
	private String logo10FileName;
	private Long logo10Id;

	/** nullable persistent field */
    private UploadedFile logo11;
    private String logo11FileName;
    private Long logo11Id;

    /** nullable persistent field */
    private UploadedFile logo12;
    private String logo12FileName;
    private Long logo12Id;

    /** nullable persistent field */
    private UploadedFile logo13;
    private String logo13FileName;
    private Long logo13Id;

    /** nullable persistent field */
    private UploadedFile logo14;
    private String logo14FileName;
    private Long logo14Id;

    /** nullable persistent field */
    private UploadedFile logo15;
    private String logo15FileName;
    private Long logo15Id;

    /** nullable persistent field */
    private UploadedFile logo16;
    private String logo16FileName;
    private Long logo16Id;

    
	/** nullable persistent field */
	private UploadedFile productPhoto1;
	private String productPhoto1FileName;
	private Long productPhoto1Id;

	/** nullable persistent field */
	private UploadedFile productPhoto2;
	private String productPhoto2FileName;
	private Long productPhoto2Id;

	/** nullable persistent field */
	private UploadedFile productPhoto3;
	private String productPhoto3FileName;
	private Long productPhoto3Id;

	/** nullable persistent field */
	private UploadedFile productPhoto4;
	private String productPhoto4FileName;
	private Long productPhoto4Id;

	/** nullable persistent field */
	private UploadedFile productPhoto5;
	private String productPhoto5FileName;
	private Long productPhoto5Id;

	/** nullable persistent field */
	private UploadedFile productPhoto6;
	private String productPhoto6FileName;
	private Long productPhoto6Id;

	/** nullable persistent field */
	private UploadedFile productPhoto7;
	private String productPhoto7FileName;
	private Long productPhoto7Id;

	/** nullable persistent field */
	private UploadedFile productPhoto8;
	private String productPhoto8FileName;
	private Long productPhoto8Id;

	/** nullable persistent field */
	private UploadedFile productPhoto9;
	private String productPhoto9FileName;
	private Long productPhoto9Id;

	/** nullable persistent field */
	private UploadedFile productPhoto10;
	private String productPhoto10FileName;
	private Long productPhoto10Id;

	/** nullable persistent field */
	private UploadedFile download1;
	private String download1FileName;
	private Long download1Id;

	/** nullable persistent field */
	private UploadedFile download2;
	private String download2FileName;
	private Long download2Id;

	/** nullable persistent field */
	private UploadedFile download3;
	private String download3FileName;
	private Long download3Id;

	/** nullable persistent field */
	private UploadedFile download4;
	private String download4FileName;
	private Long download4Id;

	/** nullable persistent field */
	private UploadedFile download5;
	private String download5FileName;
	private Long download5Id;

	/** nullable persistent field */
	private UploadedFile download6;
	private String download6FileName;
	private Long download6Id;

	/** nullable persistent field */
	private UploadedFile download7;
	private String download7FileName;
	private Long download7Id;

	/** nullable persistent field */
	private UploadedFile download8;
	private String download8FileName;
	private Long download8Id;

	/** nullable persistent field */
	private UploadedFile download9;
	private String download9FileName;
	private Long download9Id;

	/** nullable persistent field */
	private UploadedFile download10;
	private String download10FileName;
	private Long download10Id;

	/** nullable persistent field */
	private UploadedFile diagram1;
	private String diagram1FileName;
	private Long diagram1Id;

	/** nullable persistent field */
	private UploadedFile diagram2;
	private String diagram2FileName;
	private Long diagram2Id;

	/** nullable persistent field */
	private UploadedFile diagram3;
	private String diagram3FileName;
	private Long diagram3Id;

	/** nullable persistent field */
	private UploadedFile diagram4;
	private String diagram4FileName;
	private Long diagram4Id;

	/** nullable persistent field */
	private UploadedFile diagram5;
	private String diagram5FileName;
	private Long diagram5Id;

	/** nullable persistent field */
	private UploadedFile diagram6;
	private String diagram6FileName;
	private Long diagram6Id;

	/** nullable persistent field */
	private UploadedFile diagram7;
	private String diagram7FileName;
	private Long diagram7Id;

	/** nullable persistent field */
	private UploadedFile diagram8;
	private String diagram8FileName;
	private Long diagram8Id;

	/** nullable persistent field */
	private UploadedFile diagram9;
	private String diagram9FileName;
	private Long diagram9Id;

	/** nullable persistent field */
	private UploadedFile diagram10;
	private String diagram10FileName;
	private Long diagram10Id;

	/** nullable persistent field */
	private AppProperty target1;
	private Long target1Id;

	/** nullable persistent field */
	private AppProperty target2;
	private Long target2Id;

	/** nullable persistent field */
	private AppProperty target3;
	private Long target3Id;

	/** nullable persistent field */
	private AppProperty target4;
	private Long target4Id;

	/** nullable persistent field */
	private AppProperty target5;
	private Long target5Id;

	/** nullable persistent field */
	private AppProperty target6;
	private Long target6Id;

	/** nullable persistent field */
	private AppProperty target7;
	private Long target7Id;

	/** nullable persistent field */
	private AppProperty target8;
	private Long target8Id;

	/** nullable persistent field */
	private AppProperty target9;
	private Long target9Id;

	/** nullable persistent field */
	private AppProperty target10;
	private Long target10Id;

	/** nullable persistent field */
	private AppProperty target11;
	private Long target11Id;

	/** nullable persistent field */
	private AppProperty target12;
	private Long target12Id;

	/** nullable persistent field */
	private AppProperty target13;
	private Long target13Id;

	/** nullable persistent field */
	private AppProperty target14;
	private Long target14Id;

	/** nullable persistent field */
	private AppProperty target15;
	private Long target15Id;

	/** nullable persistent field */
	private AppProperty target16;
	private Long target16Id;

	/** nullable persistent field */
	private AppProperty target17;
	private Long target17Id;

	/** nullable persistent field */
	private AppProperty target18;
	private Long target18Id;

	/** nullable persistent field */
	private AppProperty target19;
	private Long target19Id;

	/** nullable persistent field */
	private AppProperty target20;
	private Long target20Id;

	/** nullable persistent field */
	private AppProperty target21;
	private Long target21Id;

	/** nullable persistent field */
	private AppProperty target22;
	private Long target22Id;

	/** nullable persistent field */
	private String link1;

	/** nullable persistent field */
	private String linkName1;

	/** nullable persistent field */
	private String link2;

	/** nullable persistent field */
	private String linkName2;

	/** nullable persistent field */
	private String link3;

	/** nullable persistent field */
	private String linkName3;

	/** nullable persistent field */
	private String link4;

	/** nullable persistent field */
	private String linkName4;

	/** nullable persistent field */
	private String link5;

	/** nullable persistent field */
	private String linkName5;

	/** nullable persistent field */
	private String link6;

	/** nullable persistent field */
	private String linkName6;

	/** nullable persistent field */
	private String link7;

	/** nullable persistent field */
	private String linkName7;

	/** nullable persistent field */
	private String link8;

	/** nullable persistent field */
	private String linkName8;

	/** nullable persistent field */
	private String link9;

	/** nullable persistent field */
	private String linkName9;

	/** nullable persistent field */
	private String link10;

	/** nullable persistent field */
	private String linkName10;

	/** nullable persistent field */
	private String link11;

	/** nullable persistent field */
	private String linkName11;

	/** nullable persistent field */
	private String link12;

	/** nullable persistent field */
	private String linkName12;

	/** nullable persistent field */
	private String link13;

	/** nullable persistent field */
	private String linkName13;

	/** nullable persistent field */
	private String link14;

	/** nullable persistent field */
	private String linkName14;

	/** nullable persistent field */
	private String link15;

	/** nullable persistent field */
	private String linkName15;

	/** nullable persistent field */
	private String link16;

	/** nullable persistent field */
	private String linkName16;

	/** nullable persistent field */
	private String link17;

	/** nullable persistent field */
	private String linkName17;

	/** nullable persistent field */
	private String link18;

	/** nullable persistent field */
	private String linkName18;

	/** nullable persistent field */
	private String link19;

	/** nullable persistent field */
	private String linkName19;

	/** nullable persistent field */
	private String link20;

	/** nullable persistent field */
	private String linkName20;

	/** nullable persistent field */
	private String link21;

	/** nullable persistent field */
	private String linkName21;

	/** nullable persistent field */
	private String link22;

	/** nullable persistent field */
	private String linkName22;

	/** nullable persistent field */
	private String link23;

	/** nullable persistent field */
	private String linkName23;

	/** nullable persistent field */
	private String link24;

	/** nullable persistent field */
	private String linkName24;

	/** nullable persistent field */
	private String link25;

	/** nullable persistent field */
	private String linkName25;

	/** nullable persistent field */
	private String link26;

	/** nullable persistent field */
	private String linkName26;

	/** nullable persistent field */
	private String link27;

	/** nullable persistent field */
	private String linkName27;

	/** nullable persistent field */
	private String link28;

	/** nullable persistent field */
	private String linkName28;

	/** nullable persistent field */
	private String link29;

	/** nullable persistent field */
	private String linkName29;

	/** nullable persistent field */
	private String link30;

	/** nullable persistent field */
	private String linkName30;

	/** nullable persistent field */
	private AppProperty target23;
	private Long target23Id;

	/** nullable persistent field */
	private AppProperty target24;
	private Long target24Id;

	/** nullable persistent field */
	private AppProperty target25;
	private Long target25Id;

	/** nullable persistent field */
	private AppProperty target26;
	private Long target26Id;

	/** nullable persistent field */
	private AppProperty target27;
	private Long target27Id;

	/** nullable persistent field */
	private AppProperty target28;
	private Long target28Id;

	/** nullable persistent field */
	private AppProperty target29;
	private Long target29Id;

	/** nullable persistent field */
	private AppProperty target30;
	private Long target30Id;

	/** nullable persistent field */
	private Boolean disabled;
	
	int seqNo; 
	
	List types;

	List<UploadedFile> productPhotos,logos,downloads,diagrams;
	
	/** minimal constructor */
	public Product(String no, String name) {
		this.no = no;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}


	public UploadedFile getProductPhoto1() {
		return this.productPhoto1;
	}

	public void setProductPhoto1(UploadedFile productPhoto1) {
		this.productPhoto1 = productPhoto1;
	}

	public String getProductPhoto1FileName() {
		return this.productPhoto1FileName;
	}

	public void setProductPhoto1FileName(String val) {
		this.productPhoto1FileName = val;
	}

	public Long getProductPhoto1Id() {
		if (this.productPhoto1 != null && this.productPhoto1.getId() != null)
			return productPhoto1.getId();
		return this.productPhoto1Id;
	}

	public void setProductPhoto1Id(Long id) {
		this.productPhoto1Id = id;
	}

	public UploadedFile getProductPhoto2() {
		return this.productPhoto2;
	}

	public void setProductPhoto2(UploadedFile productPhoto2) {
		this.productPhoto2 = productPhoto2;
	}

	public String getProductPhoto2FileName() {
		return this.productPhoto2FileName;
	}

	public void setProductPhoto2FileName(String val) {
		this.productPhoto2FileName = val;
	}

	public Long getProductPhoto2Id() {
		if (this.productPhoto2 != null && this.productPhoto2.getId() != null)
			return productPhoto2.getId();
		return this.productPhoto2Id;
	}

	public void setProductPhoto2Id(Long id) {
		this.productPhoto2Id = id;
	}

	public UploadedFile getProductPhoto3() {
		return this.productPhoto3;
	}

	public void setProductPhoto3(UploadedFile productPhoto3) {
		this.productPhoto3 = productPhoto3;
	}

	public String getProductPhoto3FileName() {
		return this.productPhoto3FileName;
	}

	public void setProductPhoto3FileName(String val) {
		this.productPhoto3FileName = val;
	}

	public Long getProductPhoto3Id() {
		if (this.productPhoto3 != null && this.productPhoto3.getId() != null)
			return productPhoto3.getId();
		return this.productPhoto3Id;
	}

	public void setProductPhoto3Id(Long id) {
		this.productPhoto3Id = id;
	}

	public UploadedFile getProductPhoto4() {
		return this.productPhoto4;
	}

	public void setProductPhoto4(UploadedFile productPhoto4) {
		this.productPhoto4 = productPhoto4;
	}

	public String getProductPhoto4FileName() {
		return this.productPhoto4FileName;
	}

	public void setProductPhoto4FileName(String val) {
		this.productPhoto4FileName = val;
	}

	public Long getProductPhoto4Id() {
		if (this.productPhoto4 != null && this.productPhoto4.getId() != null)
			return productPhoto4.getId();
		return this.productPhoto4Id;
	}

	public void setProductPhoto4Id(Long id) {
		this.productPhoto4Id = id;
	}

	public UploadedFile getProductPhoto5() {
		return this.productPhoto5;
	}

	public void setProductPhoto5(UploadedFile productPhoto5) {
		this.productPhoto5 = productPhoto5;
	}

	public String getProductPhoto5FileName() {
		return this.productPhoto5FileName;
	}

	public void setProductPhoto5FileName(String val) {
		this.productPhoto5FileName = val;
	}

	public Long getProductPhoto5Id() {
		if (this.productPhoto5 != null && this.productPhoto5.getId() != null)
			return productPhoto5.getId();
		return this.productPhoto5Id;
	}

	public void setProductPhoto5Id(Long id) {
		this.productPhoto5Id = id;
	}

	public UploadedFile getProductPhoto6() {
		return this.productPhoto6;
	}

	public void setProductPhoto6(UploadedFile productPhoto6) {
		this.productPhoto6 = productPhoto6;
	}

	public String getProductPhoto6FileName() {
		return this.productPhoto6FileName;
	}

	public void setProductPhoto6FileName(String val) {
		this.productPhoto6FileName = val;
	}

	public Long getProductPhoto6Id() {
		if (this.productPhoto6 != null && this.productPhoto6.getId() != null)
			return productPhoto6.getId();
		return this.productPhoto6Id;
	}

	public void setProductPhoto6Id(Long id) {
		this.productPhoto6Id = id;
	}

	public UploadedFile getProductPhoto7() {
		return this.productPhoto7;
	}

	public void setProductPhoto7(UploadedFile productPhoto7) {
		this.productPhoto7 = productPhoto7;
	}

	public String getProductPhoto7FileName() {
		return this.productPhoto7FileName;
	}

	public void setProductPhoto7FileName(String val) {
		this.productPhoto7FileName = val;
	}

	public Long getProductPhoto7Id() {
		if (this.productPhoto7 != null && this.productPhoto7.getId() != null)
			return productPhoto7.getId();
		return this.productPhoto7Id;
	}

	public void setProductPhoto7Id(Long id) {
		this.productPhoto7Id = id;
	}

	public UploadedFile getProductPhoto8() {
		return this.productPhoto8;
	}

	public void setProductPhoto8(UploadedFile productPhoto8) {
		this.productPhoto8 = productPhoto8;
	}

	public String getProductPhoto8FileName() {
		return this.productPhoto8FileName;
	}

	public void setProductPhoto8FileName(String val) {
		this.productPhoto8FileName = val;
	}

	public Long getProductPhoto8Id() {
		if (this.productPhoto8 != null && this.productPhoto8.getId() != null)
			return productPhoto8.getId();
		return this.productPhoto8Id;
	}

	public void setProductPhoto8Id(Long id) {
		this.productPhoto8Id = id;
	}

	public UploadedFile getProductPhoto9() {
		return this.productPhoto9;
	}

	public void setProductPhoto9(UploadedFile productPhoto9) {
		this.productPhoto9 = productPhoto9;
	}

	public String getProductPhoto9FileName() {
		return this.productPhoto9FileName;
	}

	public void setProductPhoto9FileName(String val) {
		this.productPhoto9FileName = val;
	}

	public Long getProductPhoto9Id() {
		if (this.productPhoto9 != null && this.productPhoto9.getId() != null)
			return productPhoto9.getId();
		return this.productPhoto9Id;
	}

	public void setProductPhoto9Id(Long id) {
		this.productPhoto9Id = id;
	}

	public UploadedFile getProductPhoto10() {
		return this.productPhoto10;
	}

	public void setProductPhoto10(UploadedFile productPhoto10) {
		this.productPhoto10 = productPhoto10;
	}

	public String getProductPhoto10FileName() {
		return this.productPhoto10FileName;
	}

	public void setProductPhoto10FileName(String val) {
		this.productPhoto10FileName = val;
	}

	public Long getProductPhoto10Id() {
		if (this.productPhoto10 != null && this.productPhoto10.getId() != null)
			return productPhoto10.getId();
		return this.productPhoto10Id;
	}

	public void setProductPhoto10Id(Long id) {
		this.productPhoto10Id = id;
	}

	public UploadedFile getDownload1() {
		return this.download1;
	}

	public void setDownload1(UploadedFile download1) {
		this.download1 = download1;
	}

	public String getDownload1FileName() {
		return this.download1FileName;
	}

	public void setDownload1FileName(String val) {
		this.download1FileName = val;
	}

	public Long getDownload1Id() {
		if (this.download1 != null && this.download1.getId() != null)
			return download1.getId();
		return this.download1Id;
	}

	public void setDownload1Id(Long id) {
		this.download1Id = id;
	}

	public UploadedFile getDownload2() {
		return this.download2;
	}

	public void setDownload2(UploadedFile download2) {
		this.download2 = download2;
	}

	public String getDownload2FileName() {
		return this.download2FileName;
	}

	public void setDownload2FileName(String val) {
		this.download2FileName = val;
	}

	public Long getDownload2Id() {
		if (this.download2 != null && this.download2.getId() != null)
			return download2.getId();
		return this.download2Id;
	}

	public void setDownload2Id(Long id) {
		this.download2Id = id;
	}

	public UploadedFile getDownload3() {
		return this.download3;
	}

	public void setDownload3(UploadedFile download3) {
		this.download3 = download3;
	}

	public String getDownload3FileName() {
		return this.download3FileName;
	}

	public void setDownload3FileName(String val) {
		this.download3FileName = val;
	}

	public Long getDownload3Id() {
		if (this.download3 != null && this.download3.getId() != null)
			return download3.getId();
		return this.download3Id;
	}

	public void setDownload3Id(Long id) {
		this.download3Id = id;
	}

	public UploadedFile getDownload4() {
		return this.download4;
	}

	public void setDownload4(UploadedFile download4) {
		this.download4 = download4;
	}

	public String getDownload4FileName() {
		return this.download4FileName;
	}

	public void setDownload4FileName(String val) {
		this.download4FileName = val;
	}

	public Long getDownload4Id() {
		if (this.download4 != null && this.download4.getId() != null)
			return download4.getId();
		return this.download4Id;
	}

	public void setDownload4Id(Long id) {
		this.download4Id = id;
	}

	public UploadedFile getDownload5() {
		return this.download5;
	}

	public void setDownload5(UploadedFile download5) {
		this.download5 = download5;
	}

	public String getDownload5FileName() {
		return this.download5FileName;
	}

	public void setDownload5FileName(String val) {
		this.download5FileName = val;
	}

	public Long getDownload5Id() {
		if (this.download5 != null && this.download5.getId() != null)
			return download5.getId();
		return this.download5Id;
	}

	public void setDownload5Id(Long id) {
		this.download5Id = id;
	}

	public UploadedFile getDownload6() {
		return this.download6;
	}

	public void setDownload6(UploadedFile download6) {
		this.download6 = download6;
	}

	public String getDownload6FileName() {
		return this.download6FileName;
	}

	public void setDownload6FileName(String val) {
		this.download6FileName = val;
	}

	public Long getDownload6Id() {
		if (this.download6 != null && this.download6.getId() != null)
			return download6.getId();
		return this.download6Id;
	}

	public void setDownload6Id(Long id) {
		this.download6Id = id;
	}

	public UploadedFile getDownload7() {
		return this.download7;
	}

	public void setDownload7(UploadedFile download7) {
		this.download7 = download7;
	}

	public String getDownload7FileName() {
		return this.download7FileName;
	}

	public void setDownload7FileName(String val) {
		this.download7FileName = val;
	}

	public Long getDownload7Id() {
		if (this.download7 != null && this.download7.getId() != null)
			return download7.getId();
		return this.download7Id;
	}

	public void setDownload7Id(Long id) {
		this.download7Id = id;
	}

	public UploadedFile getDownload8() {
		return this.download8;
	}

	public void setDownload8(UploadedFile download8) {
		this.download8 = download8;
	}

	public String getDownload8FileName() {
		return this.download8FileName;
	}

	public void setDownload8FileName(String val) {
		this.download8FileName = val;
	}

	public Long getDownload8Id() {
		if (this.download8 != null && this.download8.getId() != null)
			return download8.getId();
		return this.download8Id;
	}

	public void setDownload8Id(Long id) {
		this.download8Id = id;
	}

	public UploadedFile getDownload9() {
		return this.download9;
	}

	public void setDownload9(UploadedFile download9) {
		this.download9 = download9;
	}

	public String getDownload9FileName() {
		return this.download9FileName;
	}

	public void setDownload9FileName(String val) {
		this.download9FileName = val;
	}

	public Long getDownload9Id() {
		if (this.download9 != null && this.download9.getId() != null)
			return download9.getId();
		return this.download9Id;
	}

	public void setDownload9Id(Long id) {
		this.download9Id = id;
	}

	public UploadedFile getDownload10() {
		return this.download10;
	}

	public void setDownload10(UploadedFile download10) {
		this.download10 = download10;
	}

	public String getDownload10FileName() {
		return this.download10FileName;
	}

	public void setDownload10FileName(String val) {
		this.download10FileName = val;
	}

	public Long getDownload10Id() {
		if (this.download10 != null && this.download10.getId() != null)
			return download10.getId();
		return this.download10Id;
	}

	public void setDownload10Id(Long id) {
		this.download10Id = id;
	}

	public UploadedFile getDiagram1() {
		return this.diagram1;
	}

	public void setDiagram1(UploadedFile diagram1) {
		this.diagram1 = diagram1;
	}

	public String getDiagram1FileName() {
		return this.diagram1FileName;
	}

	public void setDiagram1FileName(String val) {
		this.diagram1FileName = val;
	}

	public Long getDiagram1Id() {
		if (this.diagram1 != null && this.diagram1.getId() != null)
			return diagram1.getId();
		return this.diagram1Id;
	}

	public void setDiagram1Id(Long id) {
		this.diagram1Id = id;
	}

	public UploadedFile getDiagram2() {
		return this.diagram2;
	}

	public void setDiagram2(UploadedFile diagram2) {
		this.diagram2 = diagram2;
	}

	public String getDiagram2FileName() {
		return this.diagram2FileName;
	}

	public void setDiagram2FileName(String val) {
		this.diagram2FileName = val;
	}

	public Long getDiagram2Id() {
		if (this.diagram2 != null && this.diagram2.getId() != null)
			return diagram2.getId();
		return this.diagram2Id;
	}

	public void setDiagram2Id(Long id) {
		this.diagram2Id = id;
	}

	public UploadedFile getDiagram3() {
		return this.diagram3;
	}

	public void setDiagram3(UploadedFile diagram3) {
		this.diagram3 = diagram3;
	}

	public String getDiagram3FileName() {
		return this.diagram3FileName;
	}

	public void setDiagram3FileName(String val) {
		this.diagram3FileName = val;
	}

	public Long getDiagram3Id() {
		if (this.diagram3 != null && this.diagram3.getId() != null)
			return diagram3.getId();
		return this.diagram3Id;
	}

	public void setDiagram3Id(Long id) {
		this.diagram3Id = id;
	}

	public UploadedFile getDiagram4() {
		return this.diagram4;
	}

	public void setDiagram4(UploadedFile diagram4) {
		this.diagram4 = diagram4;
	}

	public String getDiagram4FileName() {
		return this.diagram4FileName;
	}

	public void setDiagram4FileName(String val) {
		this.diagram4FileName = val;
	}

	public Long getDiagram4Id() {
		if (this.diagram4 != null && this.diagram4.getId() != null)
			return diagram4.getId();
		return this.diagram4Id;
	}

	public void setDiagram4Id(Long id) {
		this.diagram4Id = id;
	}

	public UploadedFile getDiagram5() {
		return this.diagram5;
	}

	public void setDiagram5(UploadedFile diagram5) {
		this.diagram5 = diagram5;
	}

	public String getDiagram5FileName() {
		return this.diagram5FileName;
	}

	public void setDiagram5FileName(String val) {
		this.diagram5FileName = val;
	}

	public Long getDiagram5Id() {
		if (this.diagram5 != null && this.diagram5.getId() != null)
			return diagram5.getId();
		return this.diagram5Id;
	}

	public void setDiagram5Id(Long id) {
		this.diagram5Id = id;
	}

	public UploadedFile getDiagram6() {
		return this.diagram6;
	}

	public void setDiagram6(UploadedFile diagram6) {
		this.diagram6 = diagram6;
	}

	public String getDiagram6FileName() {
		return this.diagram6FileName;
	}

	public void setDiagram6FileName(String val) {
		this.diagram6FileName = val;
	}

	public Long getDiagram6Id() {
		if (this.diagram6 != null && this.diagram6.getId() != null)
			return diagram6.getId();
		return this.diagram6Id;
	}

	public void setDiagram6Id(Long id) {
		this.diagram6Id = id;
	}

	public UploadedFile getDiagram7() {
		return this.diagram7;
	}

	public void setDiagram7(UploadedFile diagram7) {
		this.diagram7 = diagram7;
	}

	public String getDiagram7FileName() {
		return this.diagram7FileName;
	}

	public void setDiagram7FileName(String val) {
		this.diagram7FileName = val;
	}

	public Long getDiagram7Id() {
		if (this.diagram7 != null && this.diagram7.getId() != null)
			return diagram7.getId();
		return this.diagram7Id;
	}

	public void setDiagram7Id(Long id) {
		this.diagram7Id = id;
	}

	public UploadedFile getDiagram8() {
		return this.diagram8;
	}

	public void setDiagram8(UploadedFile diagram8) {
		this.diagram8 = diagram8;
	}

	public String getDiagram8FileName() {
		return this.diagram8FileName;
	}

	public void setDiagram8FileName(String val) {
		this.diagram8FileName = val;
	}

	public Long getDiagram8Id() {
		if (this.diagram8 != null && this.diagram8.getId() != null)
			return diagram8.getId();
		return this.diagram8Id;
	}

	public void setDiagram8Id(Long id) {
		this.diagram8Id = id;
	}

	public UploadedFile getDiagram9() {
		return this.diagram9;
	}

	public void setDiagram9(UploadedFile diagram9) {
		this.diagram9 = diagram9;
	}

	public String getDiagram9FileName() {
		return this.diagram9FileName;
	}

	public void setDiagram9FileName(String val) {
		this.diagram9FileName = val;
	}

	public Long getDiagram9Id() {
		if (this.diagram9 != null && this.diagram9.getId() != null)
			return diagram9.getId();
		return this.diagram9Id;
	}

	public void setDiagram9Id(Long id) {
		this.diagram9Id = id;
	}

	public UploadedFile getDiagram10() {
		return this.diagram10;
	}

	public void setDiagram10(UploadedFile diagram10) {
		this.diagram10 = diagram10;
	}

	public String getDiagram10FileName() {
		return this.diagram10FileName;
	}

	public void setDiagram10FileName(String val) {
		this.diagram10FileName = val;
	}

	public Long getDiagram10Id() {
		if (this.diagram10 != null && this.diagram10.getId() != null)
			return diagram10.getId();
		return this.diagram10Id;
	}

	public void setDiagram10Id(Long id) {
		this.diagram10Id = id;
	}

	public AppProperty getTarget1() {
		return this.target1;
	}

	public void setTarget1(AppProperty target1) {
		this.target1 = target1;
	}

	public Long getTarget1Id() {
		if (this.target1 != null && this.target1.getId() != null)
			return target1.getId();
		return this.target1Id;
	}

	public void setTarget1Id(Long id) {
		this.target1Id = id;
	}

	public AppProperty getTarget2() {
		return this.target2;
	}

	public void setTarget2(AppProperty target2) {
		this.target2 = target2;
	}

	public Long getTarget2Id() {
		if (this.target2 != null && this.target2.getId() != null)
			return target2.getId();
		return this.target2Id;
	}

	public void setTarget2Id(Long id) {
		this.target2Id = id;
	}

	public AppProperty getTarget3() {
		return this.target3;
	}

	public void setTarget3(AppProperty target3) {
		this.target3 = target3;
	}

	public Long getTarget3Id() {
		if (this.target3 != null && this.target3.getId() != null)
			return target3.getId();
		return this.target3Id;
	}

	public void setTarget3Id(Long id) {
		this.target3Id = id;
	}

	public AppProperty getTarget4() {
		return this.target4;
	}

	public void setTarget4(AppProperty target4) {
		this.target4 = target4;
	}

	public Long getTarget4Id() {
		if (this.target4 != null && this.target4.getId() != null)
			return target4.getId();
		return this.target4Id;
	}

	public void setTarget4Id(Long id) {
		this.target4Id = id;
	}

	public AppProperty getTarget5() {
		return this.target5;
	}

	public void setTarget5(AppProperty target5) {
		this.target5 = target5;
	}

	public Long getTarget5Id() {
		if (this.target5 != null && this.target5.getId() != null)
			return target5.getId();
		return this.target5Id;
	}

	public void setTarget5Id(Long id) {
		this.target5Id = id;
	}

	public AppProperty getTarget6() {
		return this.target6;
	}

	public void setTarget6(AppProperty target6) {
		this.target6 = target6;
	}

	public Long getTarget6Id() {
		if (this.target6 != null && this.target6.getId() != null)
			return target6.getId();
		return this.target6Id;
	}

	public void setTarget6Id(Long id) {
		this.target6Id = id;
	}

	public AppProperty getTarget7() {
		return this.target7;
	}

	public void setTarget7(AppProperty target7) {
		this.target7 = target7;
	}

	public Long getTarget7Id() {
		if (this.target7 != null && this.target7.getId() != null)
			return target7.getId();
		return this.target7Id;
	}

	public void setTarget7Id(Long id) {
		this.target7Id = id;
	}

	public AppProperty getTarget8() {
		return this.target8;
	}

	public void setTarget8(AppProperty target8) {
		this.target8 = target8;
	}

	public Long getTarget8Id() {
		if (this.target8 != null && this.target8.getId() != null)
			return target8.getId();
		return this.target8Id;
	}

	public void setTarget8Id(Long id) {
		this.target8Id = id;
	}

	public AppProperty getTarget9() {
		return this.target9;
	}

	public void setTarget9(AppProperty target9) {
		this.target9 = target9;
	}

	public Long getTarget9Id() {
		if (this.target9 != null && this.target9.getId() != null)
			return target9.getId();
		return this.target9Id;
	}

	public void setTarget9Id(Long id) {
		this.target9Id = id;
	}

	public AppProperty getTarget10() {
		return this.target10;
	}

	public void setTarget10(AppProperty target10) {
		this.target10 = target10;
	}

	public Long getTarget10Id() {
		if (this.target10 != null && this.target10.getId() != null)
			return target10.getId();
		return this.target10Id;
	}

	public void setTarget10Id(Long id) {
		this.target10Id = id;
	}

	public AppProperty getTarget11() {
		return this.target11;
	}

	public void setTarget11(AppProperty target11) {
		this.target11 = target11;
	}

	public Long getTarget11Id() {
		if (this.target11 != null && this.target11.getId() != null)
			return target11.getId();
		return this.target11Id;
	}

	public void setTarget11Id(Long id) {
		this.target11Id = id;
	}

	public AppProperty getTarget12() {
		return this.target12;
	}

	public void setTarget12(AppProperty target12) {
		this.target12 = target12;
	}

	public Long getTarget12Id() {
		if (this.target12 != null && this.target12.getId() != null)
			return target12.getId();
		return this.target12Id;
	}

	public void setTarget12Id(Long id) {
		this.target12Id = id;
	}

	public AppProperty getTarget13() {
		return this.target13;
	}

	public void setTarget13(AppProperty target13) {
		this.target13 = target13;
	}

	public Long getTarget13Id() {
		if (this.target13 != null && this.target13.getId() != null)
			return target13.getId();
		return this.target13Id;
	}

	public void setTarget13Id(Long id) {
		this.target13Id = id;
	}

	public AppProperty getTarget14() {
		return this.target14;
	}

	public void setTarget14(AppProperty target14) {
		this.target14 = target14;
	}

	public Long getTarget14Id() {
		if (this.target14 != null && this.target14.getId() != null)
			return target14.getId();
		return this.target14Id;
	}

	public void setTarget14Id(Long id) {
		this.target14Id = id;
	}

	public AppProperty getTarget15() {
		return this.target15;
	}

	public void setTarget15(AppProperty target15) {
		this.target15 = target15;
	}

	public Long getTarget15Id() {
		if (this.target15 != null && this.target15.getId() != null)
			return target15.getId();
		return this.target15Id;
	}

	public void setTarget15Id(Long id) {
		this.target15Id = id;
	}

	public AppProperty getTarget16() {
		return this.target16;
	}

	public void setTarget16(AppProperty target16) {
		this.target16 = target16;
	}

	public Long getTarget16Id() {
		if (this.target16 != null && this.target16.getId() != null)
			return target16.getId();
		return this.target16Id;
	}

	public void setTarget16Id(Long id) {
		this.target16Id = id;
	}

	public AppProperty getTarget17() {
		return this.target17;
	}

	public void setTarget17(AppProperty target17) {
		this.target17 = target17;
	}

	public Long getTarget17Id() {
		if (this.target17 != null && this.target17.getId() != null)
			return target17.getId();
		return this.target17Id;
	}

	public void setTarget17Id(Long id) {
		this.target17Id = id;
	}

	public AppProperty getTarget18() {
		return this.target18;
	}

	public void setTarget18(AppProperty target18) {
		this.target18 = target18;
	}

	public Long getTarget18Id() {
		if (this.target18 != null && this.target18.getId() != null)
			return target18.getId();
		return this.target18Id;
	}

	public void setTarget18Id(Long id) {
		this.target18Id = id;
	}

	public AppProperty getTarget19() {
		return this.target19;
	}

	public void setTarget19(AppProperty target19) {
		this.target19 = target19;
	}

	public Long getTarget19Id() {
		if (this.target19 != null && this.target19.getId() != null)
			return target19.getId();
		return this.target19Id;
	}

	public void setTarget19Id(Long id) {
		this.target19Id = id;
	}

	public AppProperty getTarget20() {
		return this.target20;
	}

	public void setTarget20(AppProperty target20) {
		this.target20 = target20;
	}

	public Long getTarget20Id() {
		if (this.target20 != null && this.target20.getId() != null)
			return target20.getId();
		return this.target20Id;
	}

	public void setTarget20Id(Long id) {
		this.target20Id = id;
	}

	public AppProperty getTarget21() {
		return this.target21;
	}

	public void setTarget21(AppProperty target21) {
		this.target21 = target21;
	}

	public Long getTarget21Id() {
		if (this.target21 != null && this.target21.getId() != null)
			return target21.getId();
		return this.target21Id;
	}

	public void setTarget21Id(Long id) {
		this.target21Id = id;
	}

	public AppProperty getTarget22() {
		return this.target22;
	}

	public void setTarget22(AppProperty target22) {
		this.target22 = target22;
	}

	public Long getTarget22Id() {
		if (this.target22 != null && this.target22.getId() != null)
			return target22.getId();
		return this.target22Id;
	}

	public void setTarget22Id(Long id) {
		this.target22Id = id;
	}

	public AppProperty getTarget23() {
		return this.target23;
	}

	public void setTarget23(AppProperty target23) {
		this.target23 = target23;
	}

	public Long getTarget23Id() {
		if (this.target23 != null && this.target23.getId() != null)
			return target23.getId();
		return this.target23Id;
	}

	public void setTarget23Id(Long id) {
		this.target23Id = id;
	}

	public AppProperty getTarget24() {
		return this.target24;
	}

	public void setTarget24(AppProperty target24) {
		this.target24 = target24;
	}

	public Long getTarget24Id() {
		if (this.target24 != null && this.target24.getId() != null)
			return target24.getId();
		return this.target24Id;
	}

	public void setTarget24Id(Long id) {
		this.target24Id = id;
	}

	public AppProperty getTarget25() {
		return this.target25;
	}

	public void setTarget25(AppProperty target25) {
		this.target25 = target25;
	}

	public Long getTarget25Id() {
		if (this.target25 != null && this.target25.getId() != null)
			return target25.getId();
		return this.target25Id;
	}

	public void setTarget25Id(Long id) {
		this.target25Id = id;
	}

	public AppProperty getTarget26() {
		return this.target26;
	}

	public void setTarget26(AppProperty target26) {
		this.target26 = target26;
	}

	public Long getTarget26Id() {
		if (this.target26 != null && this.target26.getId() != null)
			return target26.getId();
		return this.target26Id;
	}

	public void setTarget26Id(Long id) {
		this.target26Id = id;
	}

	public AppProperty getTarget27() {
		return this.target27;
	}

	public void setTarget27(AppProperty target27) {
		this.target27 = target27;
	}

	public Long getTarget27Id() {
		if (this.target27 != null && this.target27.getId() != null)
			return target27.getId();
		return this.target27Id;
	}

	public void setTarget27Id(Long id) {
		this.target27Id = id;
	}

	public AppProperty getTarget28() {
		return this.target28;
	}

	public void setTarget28(AppProperty target28) {
		this.target28 = target28;
	}

	public Long getTarget28Id() {
		if (this.target28 != null && this.target28.getId() != null)
			return target28.getId();
		return this.target28Id;
	}

	public void setTarget28Id(Long id) {
		this.target28Id = id;
	}

	public AppProperty getTarget29() {
		return this.target29;
	}

	public void setTarget29(AppProperty target29) {
		this.target29 = target29;
	}

	public Long getTarget29Id() {
		if (this.target29 != null && this.target29.getId() != null)
			return target29.getId();
		return this.target29Id;
	}

	public void setTarget29Id(Long id) {
		this.target29Id = id;
	}

	public AppProperty getTarget30() {
		return this.target30;
	}

	public void setTarget30(AppProperty target30) {
		this.target30 = target30;
	}

	public Long getTarget30Id() {
		if (this.target30 != null && this.target30.getId() != null)
			return target30.getId();
		return this.target30Id;
	}

	public void setTarget30Id(Long id) {
		this.target30Id = id;
	}

	public String getLink1() {
		return this.link1;
	}

	public void setLink1(String link1) {
		this.link1 = link1;
	}

	public String getLinkName1() {
		return this.linkName1;
	}

	public void setLinkName1(String linkName1) {
		this.linkName1 = linkName1;
	}

	public String getLink2() {
		return this.link2;
	}

	public void setLink2(String link2) {
		this.link2 = link2;
	}

	public String getLinkName2() {
		return this.linkName2;
	}

	public void setLinkName2(String linkName2) {
		this.linkName2 = linkName2;
	}

	public String getLink3() {
		return this.link3;
	}

	public void setLink3(String link3) {
		this.link3 = link3;
	}

	public String getLinkName3() {
		return this.linkName3;
	}

	public void setLinkName3(String linkName3) {
		this.linkName3 = linkName3;
	}

	public String getLink4() {
		return this.link4;
	}

	public void setLink4(String link4) {
		this.link4 = link4;
	}

	public String getLinkName4() {
		return this.linkName4;
	}

	public void setLinkName4(String linkName4) {
		this.linkName4 = linkName4;
	}

	public String getLink5() {
		return this.link5;
	}

	public void setLink5(String link5) {
		this.link5 = link5;
	}

	public String getLinkName5() {
		return this.linkName5;
	}

	public void setLinkName5(String linkName5) {
		this.linkName5 = linkName5;
	}

	public String getLink6() {
		return this.link6;
	}

	public void setLink6(String link6) {
		this.link6 = link6;
	}

	public String getLinkName6() {
		return this.linkName6;
	}

	public void setLinkName6(String linkName6) {
		this.linkName6 = linkName6;
	}

	public String getLink7() {
		return this.link7;
	}

	public void setLink7(String link7) {
		this.link7 = link7;
	}

	public String getLinkName7() {
		return this.linkName7;
	}

	public void setLinkName7(String linkName7) {
		this.linkName7 = linkName7;
	}

	public String getLink8() {
		return this.link8;
	}

	public void setLink8(String link8) {
		this.link8 = link8;
	}

	public String getLinkName8() {
		return this.linkName8;
	}

	public void setLinkName8(String linkName8) {
		this.linkName8 = linkName8;
	}

	public String getLink9() {
		return this.link9;
	}

	public void setLink9(String link9) {
		this.link9 = link9;
	}

	public String getLinkName9() {
		return this.linkName9;
	}

	public void setLinkName9(String linkName9) {
		this.linkName9 = linkName9;
	}

	public String getLink10() {
		return this.link10;
	}

	public void setLink10(String link10) {
		this.link10 = link10;
	}

	public String getLinkName10() {
		return this.linkName10;
	}

	public void setLinkName10(String linkName10) {
		this.linkName10 = linkName10;
	}

	public String getLink11() {
		return this.link11;
	}

	public void setLink11(String link11) {
		this.link11 = link11;
	}

	public String getLinkName11() {
		return this.linkName11;
	}

	public void setLinkName11(String linkName11) {
		this.linkName11 = linkName11;
	}

	public String getLink12() {
		return this.link12;
	}

	public void setLink12(String link12) {
		this.link12 = link12;
	}

	public String getLinkName12() {
		return this.linkName12;
	}

	public void setLinkName12(String linkName12) {
		this.linkName12 = linkName12;
	}

	public String getLink13() {
		return this.link13;
	}

	public void setLink13(String link13) {
		this.link13 = link13;
	}

	public String getLinkName13() {
		return this.linkName13;
	}

	public void setLinkName13(String linkName13) {
		this.linkName13 = linkName13;
	}

	public String getLink14() {
		return this.link14;
	}

	public void setLink14(String link14) {
		this.link14 = link14;
	}

	public String getLinkName14() {
		return this.linkName14;
	}

	public void setLinkName14(String linkName14) {
		this.linkName14 = linkName14;
	}

	public String getLink15() {
		return this.link15;
	}

	public void setLink15(String link15) {
		this.link15 = link15;
	}

	public String getLinkName15() {
		return this.linkName15;
	}

	public void setLinkName15(String linkName15) {
		this.linkName15 = linkName15;
	}

	public String getLink16() {
		return this.link16;
	}

	public void setLink16(String link16) {
		this.link16 = link16;
	}

	public String getLinkName16() {
		return this.linkName16;
	}

	public void setLinkName16(String linkName16) {
		this.linkName16 = linkName16;
	}

	public String getLink17() {
		return this.link17;
	}

	public void setLink17(String link17) {
		this.link17 = link17;
	}

	public String getLinkName17() {
		return this.linkName17;
	}

	public void setLinkName17(String linkName17) {
		this.linkName17 = linkName17;
	}

	public String getLink18() {
		return this.link18;
	}

	public void setLink18(String link18) {
		this.link18 = link18;
	}

	public String getLinkName18() {
		return this.linkName18;
	}

	public void setLinkName18(String linkName18) {
		this.linkName18 = linkName18;
	}

	public String getLink19() {
		return this.link19;
	}

	public void setLink19(String link19) {
		this.link19 = link19;
	}

	public String getLinkName19() {
		return this.linkName19;
	}

	public void setLinkName19(String linkName19) {
		this.linkName19 = linkName19;
	}

	public String getLink20() {
		return this.link20;
	}

	public void setLink20(String link20) {
		this.link20 = link20;
	}

	public String getLinkName20() {
		return this.linkName20;
	}

	public void setLinkName20(String linkName20) {
		this.linkName20 = linkName20;
	}

	public String getLink21() {
		return this.link21;
	}

	public void setLink21(String link21) {
		this.link21 = link21;
	}

	public String getLinkName21() {
		return this.linkName21;
	}

	public void setLinkName21(String linkName21) {
		this.linkName21 = linkName21;
	}

	public String getLink22() {
		return this.link22;
	}

	public void setLink22(String link22) {
		this.link22 = link22;
	}

	public String getLinkName22() {
		return this.linkName22;
	}

	public void setLinkName22(String linkName22) {
		this.linkName22 = linkName22;
	}

	public String getLink23() {
		return this.link23;
	}

	public void setLink23(String link23) {
		this.link23 = link23;
	}

	public String getLinkName23() {
		return this.linkName23;
	}

	public void setLinkName23(String linkName23) {
		this.linkName23 = linkName23;
	}

	public String getLink24() {
		return this.link24;
	}

	public void setLink24(String link24) {
		this.link24 = link24;
	}

	public String getLinkName24() {
		return this.linkName24;
	}

	public void setLinkName24(String linkName24) {
		this.linkName24 = linkName24;
	}

	public String getLink25() {
		return this.link25;
	}

	public void setLink25(String link25) {
		this.link25 = link25;
	}

	public String getLinkName25() {
		return this.linkName25;
	}

	public void setLinkName25(String linkName25) {
		this.linkName25 = linkName25;
	}

	public String getLink26() {
		return this.link26;
	}

	public void setLink26(String link26) {
		this.link26 = link26;
	}

	public String getLinkName26() {
		return this.linkName26;
	}

	public void setLinkName26(String linkName26) {
		this.linkName26 = linkName26;
	}

	public String getLink27() {
		return this.link27;
	}

	public void setLink27(String link27) {
		this.link27 = link27;
	}

	public String getLinkName27() {
		return this.linkName27;
	}

	public void setLinkName27(String linkName27) {
		this.linkName27 = linkName27;
	}

	public String getLink28() {
		return this.link28;
	}

	public void setLink28(String link28) {
		this.link28 = link28;
	}

	public String getLinkName28() {
		return this.linkName28;
	}

	public void setLinkName28(String linkName28) {
		this.linkName28 = linkName28;
	}

	public String getLink29() {
		return this.link29;
	}

	public void setLink29(String link29) {
		this.link29 = link29;
	}

	public String getLinkName29() {
		return this.linkName29;
	}

	public void setLinkName29(String linkName29) {
		this.linkName29 = linkName29;
	}

	public String getLink30() {
		return this.link30;
	}

	public void setLink30(String link30) {
		this.link30 = link30;
	}

	public String getLinkName30() {
		return this.linkName30;
	}

	public void setLinkName30(String linkName30) {
		this.linkName30 = linkName30;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public UploadedFile getLogo1() {
		return this.logo1;
	}

	public void setLogo1(UploadedFile logo1) {
		this.logo1 = logo1;
	}

	public String getLogo1FileName() {
		return this.logo1FileName;
	}

	public void setLogo1FileName(String val) {
		this.logo1FileName = val;
	}

	public Long getLogo1Id() {
		if (this.logo1 != null && this.logo1.getId() != null)
			return logo1.getId();
		return this.logo1Id;
	}

	public void setLogo1Id(Long id) {
		this.logo1Id = id;
	}

	public UploadedFile getLogo2() {
		return this.logo2;
	}

	public void setLogo2(UploadedFile logo2) {
		this.logo2 = logo2;
	}

	public String getLogo2FileName() {
		return this.logo2FileName;
	}

	public void setLogo2FileName(String val) {
		this.logo2FileName = val;
	}

	public Long getLogo2Id() {
		if (this.logo2 != null && this.logo2.getId() != null)
			return logo2.getId();
		return this.logo2Id;
	}

	public void setLogo2Id(Long id) {
		this.logo2Id = id;
	}

	public UploadedFile getLogo3() {
		return this.logo3;
	}

	public void setLogo3(UploadedFile logo3) {
		this.logo3 = logo3;
	}

	public String getLogo3FileName() {
		return this.logo3FileName;
	}

	public void setLogo3FileName(String val) {
		this.logo3FileName = val;
	}

	public Long getLogo3Id() {
		if (this.logo3 != null && this.logo3.getId() != null)
			return logo3.getId();
		return this.logo3Id;
	}

	public void setLogo3Id(Long id) {
		this.logo3Id = id;
	}

	public UploadedFile getLogo4() {
		return this.logo4;
	}

	public void setLogo4(UploadedFile logo4) {
		this.logo4 = logo4;
	}

	public String getLogo4FileName() {
		return this.logo4FileName;
	}

	public void setLogo4FileName(String val) {
		this.logo4FileName = val;
	}

	public Long getLogo4Id() {
		if (this.logo4 != null && this.logo4.getId() != null)
			return logo4.getId();
		return this.logo4Id;
	}

	public void setLogo4Id(Long id) {
		this.logo4Id = id;
	}

	public UploadedFile getLogo5() {
		return this.logo5;
	}

	public void setLogo5(UploadedFile logo5) {
		this.logo5 = logo5;
	}

	public String getLogo5FileName() {
		return this.logo5FileName;
	}

	public void setLogo5FileName(String val) {
		this.logo5FileName = val;
	}

	public Long getLogo5Id() {
		if (this.logo5 != null && this.logo5.getId() != null)
			return logo5.getId();
		return this.logo5Id;
	}

	public void setLogo5Id(Long id) {
		this.logo5Id = id;
	}

	public UploadedFile getLogo6() {
		return this.logo6;
	}

	public void setLogo6(UploadedFile logo6) {
		this.logo6 = logo6;
	}

	public String getLogo6FileName() {
		return this.logo6FileName;
	}

	public void setLogo6FileName(String val) {
		this.logo6FileName = val;
	}

	public Long getLogo6Id() {
		if (this.logo6 != null && this.logo6.getId() != null)
			return logo6.getId();
		return this.logo6Id;
	}

	public void setLogo6Id(Long id) {
		this.logo6Id = id;
	}

	public UploadedFile getLogo7() {
		return this.logo7;
	}

	public void setLogo7(UploadedFile logo7) {
		this.logo7 = logo7;
	}

	public String getLogo7FileName() {
		return this.logo7FileName;
	}

	public void setLogo7FileName(String val) {
		this.logo7FileName = val;
	}

	public Long getLogo7Id() {
		if (this.logo7 != null && this.logo7.getId() != null)
			return logo7.getId();
		return this.logo7Id;
	}

	public void setLogo7Id(Long id) {
		this.logo7Id = id;
	}

	public UploadedFile getLogo8() {
		return this.logo8;
	}

	public void setLogo8(UploadedFile logo8) {
		this.logo8 = logo8;
	}

	public String getLogo8FileName() {
		return this.logo8FileName;
	}

	public void setLogo8FileName(String val) {
		this.logo8FileName = val;
	}

	public Long getLogo8Id() {
		if (this.logo8 != null && this.logo8.getId() != null)
			return logo8.getId();
		return this.logo8Id;
	}

	public void setLogo8Id(Long id) {
		this.logo8Id = id;
	}

	public UploadedFile getLogo9() {
		return this.logo9;
	}

	public void setLogo9(UploadedFile logo9) {
		this.logo9 = logo9;
	}

	public String getLogo9FileName() {
		return this.logo9FileName;
	}

	public void setLogo9FileName(String val) {
		this.logo9FileName = val;
	}

	public Long getLogo9Id() {
		if (this.logo9 != null && this.logo9.getId() != null)
			return logo9.getId();
		return this.logo9Id;
	}

	public void setLogo9Id(Long id) {
		this.logo9Id = id;
	}

	public UploadedFile getLogo10() {
		return this.logo10;
	}

	public void setLogo10(UploadedFile logo10) {
		this.logo10 = logo10;
	}

	public String getLogo10FileName() {
		return this.logo10FileName;
	}

	public void setLogo10FileName(String val) {
		this.logo10FileName = val;
	}

	public Long getLogo10Id() {
		if (this.logo10 != null && this.logo10.getId() != null)
			return logo10.getId();
		return this.logo10Id;
	}

	public void setLogo10Id(Long id) {
		this.logo10Id = id;
	}
	
	public UploadedFile getLogo11() {
        return this.logo11;
    }

    public void setLogo11(UploadedFile logo11) {
        this.logo11 = logo11;
    }

    public String getLogo11FileName() {
        return this.logo11FileName;
    }

    public void setLogo11FileName(String val) {
        this.logo11FileName = val;
    }

    public Long getLogo11Id() {
        if (this.logo11 != null && this.logo11.getId() != null)
            return logo11.getId();
        return this.logo11Id;
    }

    public void setLogo11Id(Long id) {
        this.logo11Id = id;
    }

    public UploadedFile getLogo12() {
        return this.logo12;
    }

    public void setLogo12(UploadedFile logo12) {
        this.logo12 = logo12;
    }

    public String getLogo12FileName() {
        return this.logo12FileName;
    }

    public void setLogo12FileName(String val) {
        this.logo12FileName = val;
    }

    public Long getLogo12Id() {
        if (this.logo12 != null && this.logo12.getId() != null)
            return logo12.getId();
        return this.logo12Id;
    }

    public void setLogo12Id(Long id) {
        this.logo12Id = id;
    }

    public UploadedFile getLogo13() {
        return this.logo13;
    }

    public void setLogo13(UploadedFile logo13) {
        this.logo13 = logo13;
    }

    public String getLogo13FileName() {
        return this.logo13FileName;
    }

    public void setLogo13FileName(String val) {
        this.logo13FileName = val;
    }

    public Long getLogo13Id() {
        if (this.logo13 != null && this.logo13.getId() != null)
            return logo13.getId();
        return this.logo13Id;
    }

    public void setLogo13Id(Long id) {
        this.logo13Id = id;
    }

    public UploadedFile getLogo14() {
        return this.logo14;
    }

    public void setLogo14(UploadedFile logo14) {
        this.logo14 = logo14;
    }

    public String getLogo14FileName() {
        return this.logo14FileName;
    }

    public void setLogo14FileName(String val) {
        this.logo14FileName = val;
    }

    public Long getLogo14Id() {
        if (this.logo14 != null && this.logo14.getId() != null)
            return logo14.getId();
        return this.logo14Id;
    }

    public void setLogo14Id(Long id) {
        this.logo14Id = id;
    }

    public UploadedFile getLogo15() {
        return this.logo15;
    }

    public void setLogo15(UploadedFile logo15) {
        this.logo15 = logo15;
    }

    public String getLogo15FileName() {
        return this.logo15FileName;
    }

    public void setLogo15FileName(String val) {
        this.logo15FileName = val;
    }

    public Long getLogo15Id() {
        if (this.logo15 != null && this.logo15.getId() != null)
            return logo15.getId();
        return this.logo15Id;
    }

    public void setLogo15Id(Long id) {
        this.logo15Id = id;
    }

    public UploadedFile getLogo16() {
        return this.logo16;
    }

    public void setLogo16(UploadedFile logo16) {
        this.logo16 = logo16;
    }

    public String getLogo16FileName() {
        return this.logo16FileName;
    }

    public void setLogo16FileName(String val) {
        this.logo16FileName = val;
    }

    public Long getLogo16Id() {
        if (this.logo16 != null && this.logo16.getId() != null)
            return logo16.getId();
        return this.logo16Id;
    }

    public void setLogo16Id(Long id) {
        this.logo16Id = id;
    }


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	public List getTypes() {
		return types;
	}

	public void setTypes(List types) {
		this.types = types;
	}
	
	public Product() {
	}

	public List<UploadedFile> getProductPhotos() {
		ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
		if (productPhoto1 != null) {
			al.add(productPhoto1);
		}
		if (productPhoto2 != null) {
			al.add(productPhoto2);
		}
		if (productPhoto3 != null) {
			al.add(productPhoto3);
		}
		if (productPhoto4 != null) {
			al.add(productPhoto4);
		}
		if (productPhoto5 != null) {
			al.add(productPhoto5);
		}
		if (productPhoto6 != null) {
			al.add(productPhoto6);
		}
		if (productPhoto7 != null) {
			al.add(productPhoto7);
		}
		if (productPhoto8 != null) {
			al.add(productPhoto8);
		}
		if (productPhoto9 != null) {
			al.add(productPhoto9);
		}
		if (productPhoto10 != null) {
			al.add(productPhoto10);
		}
		return al;
	}
	
	public List<UploadedFile> getLogos() {
		ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
		if (logo1 != null) {
			al.add(logo1);
		}
		if (logo2 != null) {
			al.add(logo2);
		}
		if (logo3 != null) {
			al.add(logo3);
		}
		if (logo4 != null) {
			al.add(logo4);
		}
		if (logo5 != null) {
			al.add(logo5);
		}
		if (logo6 != null) {
			al.add(logo6);
		}
		if (logo7 != null) {
			al.add(logo7);
		}
		if (logo8 != null) {
			al.add(logo8);
		}
		if (logo9 != null) {
			al.add(logo9);
		}
		if (logo10 != null) {
			al.add(logo10);
		}
		if (logo11 != null) {
			al.add(logo11);
		}
		if (logo12 != null) {
			al.add(logo12);
		}
		if (logo13 != null) {
			al.add(logo13);
		}
		if (logo14 != null) {
			al.add(logo14);
		}
		if (logo15 != null) {
			al.add(logo15);
		}
		if (logo16 != null) {
			al.add(logo16);
		}		
		return al;
	}
	
	public List<UploadedFile> getDownloads() {
		ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
		if (download1 != null) {
			al.add(download1);
		}
		if (download2 != null) {
			al.add(download2);
		}
		if (download3 != null) {
			al.add(download3);
		}
		if (download4 != null) {
			al.add(download4);
		}
		if (download5 != null) {
			al.add(download5);
		}
		if (download6 != null) {
			al.add(download6);
		}
		if (download7 != null) {
			al.add(download7);
		}
		if (download8 != null) {
			al.add(download8);
		}
		if (download9 != null) {
			al.add(download9);
		}
		if (download10 != null) {
			al.add(download10);
		}
		return al;
	}


	public List<UploadedFile> getDiagrams() {
		ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
		if (diagram1 != null) {
			al.add(diagram1);
		}
		if (diagram2 != null) {
			al.add(diagram2);
		}
		if (diagram3 != null) {
			al.add(diagram3);
		}
		if (diagram4 != null) {
			al.add(diagram4);
		}
		if (diagram5 != null) {
			al.add(diagram5);
		}
		if (diagram6 != null) {
			al.add(diagram6);
		}
		if (diagram7 != null) {
			al.add(diagram7);
		}
		if (diagram8 != null) {
			al.add(diagram8);
		}
		if (diagram9 != null) {
			al.add(diagram9);
		}
		if (diagram10 != null) {
			al.add(diagram10);
		}
		return al;		
	}

	public String toString() {
		return new ToStringBuilder(this)
				.append("no", getNo())
				.append("name", getName())
				.append("overview", getOverview())
				.append("specification", getSpecification())				
				.append("productPhoto1", getProductPhoto1())
				.append("productPhoto2", getProductPhoto2())
				.append("productPhoto3", getProductPhoto3())
				.append("productPhoto4", getProductPhoto4())
				.append("productPhoto5", getProductPhoto5())
				.append("productPhoto6", getProductPhoto6())
				.append("productPhoto7", getProductPhoto7())
				.append("productPhoto8", getProductPhoto8())
				.append("productPhoto9", getProductPhoto9())
				.append("productPhoto10", getProductPhoto10())
				.append("download1", getDownload1())
				.append("download2", getDownload2())
				.append("download3", getDownload3())
				.append("download4", getDownload4())
				.append("download5", getDownload5())
				.append("download6", getDownload6())
				.append("download7", getDownload7())
				.append("download8", getDownload8())
				.append("download9", getDownload9())
				.append("download10", getDownload10())
				.append("diagram1", getDiagram1())
				.append("diagram2", getDiagram2())
				.append("diagram3", getDiagram3())
				.append("diagram4", getDiagram4())
				.append("diagram5", getDiagram5())
				.append("diagram6", getDiagram6())
				.append("diagram7", getDiagram7())
				.append("diagram8", getDiagram8())
				.append("diagram9", getDiagram9())
				.append("diagram10", getDiagram10())
				.toString();
	}

	public String getCaption_() {
		return toString();
	}

}
