package kr.study.ppom.friend.demo;


public class IdealTypeScore implements Comparable<IdealTypeScore>{
	private String userID;
	private int score;
	
	public IdealTypeScore() {
	}
	
	public IdealTypeScore(String userID, int score) {
		this.userID = userID;
		this.score = score;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public int compareTo(IdealTypeScore o) {
		if(score > o.getScore()) {
			return -1;
		} else if(score == o.getScore()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "IdealTypeScore [userID=" + userID + ", score=" + score + "]";
	}
	
}
