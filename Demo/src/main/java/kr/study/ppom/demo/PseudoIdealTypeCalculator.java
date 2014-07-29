package kr.study.ppom.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.stereotype.Component;

@Component
public class PseudoIdealTypeCalculator implements IdealTypeCalculator {
	private int maxScore = 10;
	private int weightedIdex = 2; 
	
	@Override
	public List<IdealTypeScore> calculteIdealType(OpinionUser user) {
		Map<String, IdealTypeScore> tMap = new HashMap<String, IdealTypeScore>();
		List<OpinionTopic> topics = user.getTopics();
		Iterator<OpinionTopic> topicIterator = topics.iterator();
		while(topicIterator.hasNext()) {
			OpinionTopic topic = topicIterator.next();
			int creatorOpinion = topic.getCreatorOpinion();
			Set<OpinionUser> users = topic.getVoter();
			Iterator<OpinionUser> userIterator = users.iterator();
			while(userIterator.hasNext()) {
				OpinionUser voter = userIterator.next();
				int voterOpinion = topic.getVoterOpinion( voter );
				String voterId = voter.getId();
				
				int opinionWeightedValue = calcaulateOpinionValue( creatorOpinion, voterOpinion);
				if( tMap.containsKey(voterId) ) {
					IdealTypeScore idealTypeScore = tMap.get(voterId);
					idealTypeScore.setScore( idealTypeScore.getScore() + opinionWeightedValue );
					tMap.replace(voterId, idealTypeScore);
				} else {
					tMap.put(voterId, new IdealTypeScore(voterId,opinionWeightedValue));
				}
			}
		}
		
		
		List<IdealTypeScore> idealTypeList = new ArrayList<IdealTypeScore>(tMap .values());
		Collections.sort(idealTypeList);
		int idealTypeCount = idealTypeList.size();
		List<IdealTypeScore> idealTypeCutList = idealTypeList.subList(0, Math.min(idealTypeCount,9));
		
		
		return idealTypeCutList;
	}
	

	private int calcaulateOpinionValue(int creatorOpinion, int voterOpinion) {
		int opinionValue = Math.abs(voterOpinion - creatorOpinion);
		int opinionWeightedValue = maxScore - (opinionValue * weightedIdex); 
		return opinionWeightedValue;
	}

}
