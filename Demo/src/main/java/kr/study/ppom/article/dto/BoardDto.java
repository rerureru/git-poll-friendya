package kr.study.ppom.article.dto;

import java.io.Serializable;
import java.util.Date;

public class BoardDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int boardID; 
	private String catetoryID; 
	private String subject; 
	private String content; 
	private int hitCNT; 
	private int recommendCNT; 
	private String creator; 
	private Date createDate; 
	private Date updateDate;
	
	private CDDto gnb;
	private CDDto lnb;
	
	public CDDto getLnb() {
		return lnb;
	}
	public void setLnb(CDDto lnb) {
		this.lnb = lnb;
	}
	public int getBoardID() {
		return boardID;
	}
	
	public void setCategoryID(String categoryID) {
		this.catetoryID = categoryID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitCNT() {
		return hitCNT;
	}
	public void setHitCNT(int hitCNT) {
		this.hitCNT = hitCNT;
	}
	public int getRecommendCNT() {
		return recommendCNT;
	}
	public void setRecommendCNT(int recommendCNT) {
		this.recommendCNT = recommendCNT;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
	
	
	public String getCatetoryID() {
		return catetoryID;
	}
	public void setCatetoryID(String catetoryID) {
		this.catetoryID = catetoryID;
	}
	public CDDto getGnb() {
		return gnb;
	}
	public void setGnb(CDDto gnb) {
		this.gnb = gnb;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardID;
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
		BoardDto other = (BoardDto) obj;
		if (boardID != other.boardID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardDto [boardID=" + boardID + ", catetoryID=" + catetoryID
				+ ", subject=" + subject + ", content=" + content + ", hitCNT="
				+ hitCNT + ", recommendCNT=" + recommendCNT + ", creator="
				+ creator + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", gnb=" + gnb + ", lnb=" + lnb + "]";
	}	
}
