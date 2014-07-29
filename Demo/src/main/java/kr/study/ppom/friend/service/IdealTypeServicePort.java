package kr.study.ppom.friend.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="IdealTypeServicePort", targetNamespace="http://demo.friend.ppom.study.kr/")
public interface IdealTypeServicePort {
	//create() {CreatorId, TopicId} : {success or fail}
	@WebMethod
	boolean create( String creatorId, String topicId, int level  );
	
	//submit() {TopicId, VoterId, Opinion(yes or no)} : {success or fail}
	@WebMethod
	boolean submit( String topicId, String voterId, int opinionLevel  );
	
	//requestIdealType() {UserId} : {UserId[]}
	@WebMethod
	List<IdealTypeScore> requestIdealType( String userId  );
	
	@WebMethod
	int requestTopicCount();
}
