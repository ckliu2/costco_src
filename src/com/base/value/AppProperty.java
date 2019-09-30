package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class AppProperty extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    
    /** persistent field */
    private Integer seqNo;

    /** persistent field */
    private String kind;

    /** nullable persistent field */
    private String subKind;

    /** nullable persistent field */
    private String valueTw;

    /** nullable persistent field */
    private String valueUs;

    String code,code1,code2,code3,code4;
    
    
	/** full constructor */
    public AppProperty(Integer seqNo, String kind, String subKind, String valueTw, String valueUs) {
        this.seqNo = seqNo;
        this.kind = kind;
        this.subKind = subKind;
        this.valueTw = valueTw;
        this.valueUs = valueUs;
    }

    /** default constructor */
    public AppProperty() {
    }

    /** minimal constructor */
    public AppProperty(Integer seqNo, String kind) {
        this.seqNo = seqNo;
        this.kind = kind;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSubKind() {
        return this.subKind;
    }

    public void setSubKind(String subKind) {
        this.subKind = subKind;
    }

    public String getValueTw() {
        return this.valueTw;
    }

    public void setValueTw(String valueTw) {
        this.valueTw = valueTw;
    }

    public String getValueUs() {
        return this.valueUs;
    }

    public void setValueUs(String valueUs) {
        this.valueUs = valueUs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public String getCode4() {
		return code4;
	}

	public void setCode4(String code4) {
		this.code4 = code4;
	}

    
    public String toString() {
        return new ToStringBuilder(this)
            .append("seqNo", getSeqNo())
            .append("kind", getKind())
            .append("subKind", getSubKind())
            .append("valueTw", getValueTw())
            .append("valueUs", getValueUs())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
