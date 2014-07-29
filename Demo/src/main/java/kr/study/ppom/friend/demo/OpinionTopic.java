package kr.study.ppom.friend.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpinionTopic {
	private int creatorOpinion;
	private OpinionUser creator;
	
	
	public OpinionUser getCreator() {
		return creator;
	}


	private Map<OpinionUser, Integer> voteMap = new HashMap<OpinionUser, Integer>();
	
	
	
	public void registCreatorOpinion(int level) {
		creatorOpinion = level;		
	}


	public void registCreator(OpinionUser user) {
		creator = user;		
	}


	public void vote(OpinionUser user, int opinionLevel) {
		voteMap.put(user, Integer.valueOf(opinionLevel));
	}


	public Set<OpinionUser> getVoter() {
		return voteMap.keySet();
	}


	public int getCreatorOpinion() {
		// TODO Auto-generated method stub
		return creatorOpinion;
	}


	public int getVoterOpinion(OpinionUser voter) {
		return voteMap.get(voter);
	}
	
}
