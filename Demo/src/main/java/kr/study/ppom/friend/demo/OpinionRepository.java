package kr.study.ppom.friend.demo;

import java.util.HashMap;
import java.util.Map;

public class OpinionRepository {
	private static Map<String, OpinionUser> users = new HashMap<String, OpinionUser>();
	private static Map<String, OpinionTopic> topics = new HashMap<String, OpinionTopic>();
	
	private OpinionRepository(){
		
	}

	public static OpinionUser queryUser(String creatorId) {
		OpinionUser user = users.get(creatorId);
		if( user == null ) {
			user = new OpinionUser( creatorId );
			users.put(creatorId, user);
		}
		return user;
	}

	public static OpinionTopic createTopic( String topicId ) {
		OpinionTopic topic = new OpinionTopic();
		if( topics.containsKey(topicId)){
			return null;
		}
		topics.put(topicId, topic);
		
		
		return topic;
	}

	public static OpinionTopic queryTopic(String topicId) {
		if( !topics.containsKey(topicId)){
			return null;
		}

		return topics.get(topicId);
	}

	public static int queryTopicCount() {
		return topics.size();
	}
	
		
}
