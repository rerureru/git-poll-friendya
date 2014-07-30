package kr.study.ppom.article.dto;

import java.io.Serializable;
import java.util.Date;

public class CDDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int cDKindID; 
	private String cDVal; 
	private String cDName;
	private String cDDesc; 
	private String cDValOPT1; 
	private String cDValOPT2; 
	private String cDValOPT3; 
	private String cDValOPT4; 
	private String creator; 
	private String updater; 
	private Date createDate; 
	private Date updateDate; 
	private String cdStat;
	public int getcDKindID() {
		return cDKindID;
	}
	public void setcDKindID(int cDKindID) {
		this.cDKindID = cDKindID;
	}
	public String getcDVal() {
		return cDVal;
	}
	public void setcDVal(String cDVal) {
		this.cDVal = cDVal;
	}
	public String getcDName() {
		return cDName;
	}
	public void setcDName(String cDName) {
		this.cDName = cDName;
	}
	public String getcDDesc() {
		return cDDesc;
	}
	public void setcDDesc(String cDDesc) {
		this.cDDesc = cDDesc;
	}
	public String getcDValOPT1() {
		return cDValOPT1;
	}
	public void setcDValOPT1(String cDValOPT1) {
		this.cDValOPT1 = cDValOPT1;
	}
	public String getcDValOPT2() {
		return cDValOPT2;
	}
	public void setcDValOPT2(String cDValOPT2) {
		this.cDValOPT2 = cDValOPT2;
	}
	public String getcDValOPT3() {
		return cDValOPT3;
	}
	public void setcDValOPT3(String cDValOPT3) {
		this.cDValOPT3 = cDValOPT3;
	}
	public String getcDValOPT4() {
		return cDValOPT4;
	}
	public void setcDValOPT4(String cDValOPT4) {
		this.cDValOPT4 = cDValOPT4;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCdStat() {
		return cdStat;
	}
	public void setCdStat(String cdStat) {
		this.cdStat = cdStat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cDKindID;
		result = prime * result + ((cDVal == null) ? 0 : cDVal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDDto other = (CDDto) obj;
		if (cDKindID != other.cDKindID)
			return false;
		if (cDVal == null) {
			if (other.cDVal != null)
				return false;
		} else if (!cDVal.equals(other.cDVal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CDDto [CDKindID=" + cDKindID + ", cDVal=" + cDVal + ", cDName="
				+ cDName + ", cDDesc=" + cDDesc + ", creator=" + creator
				+ ", createDate=" + createDate + "]";
	}
}
