package kr.study.ppom.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PseudoIdealTypeServiceImpl implements IdealTypeService {
	@Autowired
	private IdealTypeCalculator calculator;
	
	@Override
	public boolean create(String creatorId, String topicId, int level ) {
		OpinionUser user = OpinionFactory.queryUser(creatorId);
		OpinionTopic topic = OpinionFactory.createTopic( topicId );
		if( topic == null ){
			return false;
		}
		topic.registCreator( user );
		topic.registCreatorOpinion( level );
		user.registTopic( topic );
		
		return true;
	}

	@Override
	public boolean submit(String topicId, String voterId, int opinionLevel ) {
		OpinionUser user = OpinionFactory.queryUser(voterId);
		OpinionTopic topic = OpinionFactory.queryTopic( topicId );
		
		if(topic == null) {
			return false;
		}
		
		if( topic.getCreator().equals(user) ) {
			return false;
		}
		
		topic.vote( user, opinionLevel );
		return true;
	}

	@Override
	public List<IdealTypeScore> requestIdealType(String userId ) {
		OpinionUser user = OpinionFactory.queryUser(userId);
		return  calculator.calculteIdealType( user );
	}

	@Override
	public int requestTopicCount() {
		return OpinionFactory.queryTopicCount();
	}

}
