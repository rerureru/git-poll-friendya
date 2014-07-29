package kr.study.ppom.demo;

import java.util.List;

public interface IdealTypeService {
	//create() {CreatorId, TopicId} : {success or fail}
	boolean create( String creatorId, String topicId, int level );
	
	//submit() {TopicId, VoterId, Opinion(yes or no)} : {success or fail}
	boolean submit( String topicId, String voterId, int opinionLevel );
	
	//requestIdealType() {UserId} : {UserId[]}
	List<IdealTypeScore> requestIdealType( String userId );
	
	int requestTopicCount();
}
