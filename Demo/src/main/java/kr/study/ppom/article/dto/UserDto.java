package kr.study.ppom.article.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userID; 
	private String userName; 
	private String userPW; 
	private String nickName; 
	private String email; 
	private String phnNumber; 
	private String address; 
	private Date createDate; 
	private Date updteDate;  
	private Date joinDate;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(String phnNumber) {
		this.phnNumber = phnNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdteDate() {
		return updteDate;
	}
	public void setUpdteDate(Date updteDate) {
		this.updteDate = updteDate;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
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
		UserDto other = (UserDto) obj;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDto [userID=" + userID + ", userName=" + userName
				+ ", userPW=" + userPW + ", nickName=" + nickName + ", email="
				+ email + ", phnNumber=" + phnNumber + ", address=" + address
				+ ", createDate=" + createDate + ", updteDate=" + updteDate
				+ ", joinDate=" + joinDate + "]";
	} 
	
	
}
