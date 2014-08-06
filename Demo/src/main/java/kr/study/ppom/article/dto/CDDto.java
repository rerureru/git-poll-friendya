package kr.study.ppom.article.dto;

import java.io.Serializable;

public class CDDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int cDKindID; 
	private String cDVal; 
	private String cDName;
	
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
	@Override
	public String toString() {
		return "CDDto [cDKindID=" + cDKindID + ", cDVal=" + cDVal + ", cDName="
				+ cDName + "]";
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

	
	
}
