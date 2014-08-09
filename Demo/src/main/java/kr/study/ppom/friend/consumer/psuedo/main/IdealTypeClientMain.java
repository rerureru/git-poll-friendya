package kr.study.ppom.friend.consumer.psuedo.main;

import java.util.Iterator;
import java.util.List;

import kr.study.ppom.friend.service.IdealTypeScore;
import kr.study.ppom.friend.service.IdealTypeServicePort;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdealTypeClientMain {

	public static void main(String[] args) {
		ApplicationContext context = 
		        new ClassPathXmlApplicationContext("idealtype-dummy-client.xml"); 
		System.out.println("-------" );
		IdealTypeServicePort idealTypeService = (IdealTypeServicePort)context.getBean("idealTypeService");
		System.out.println("-------" + idealTypeService);
		
		createDummyTopic( idealTypeService );	
		createDummyVote( idealTypeService );
		createDummyQuery( idealTypeService );
	}

	private static void createDummyQuery(IdealTypeServicePort idealTypeService) {
		List<IdealTypeScore> idealTypeScoreList = idealTypeService.requestIdealType("1");
		System.out.println("idealType Score !!");
		Iterator<IdealTypeScore> idealTypeScoreIterator = idealTypeScoreList.iterator();
		while(idealTypeScoreIterator.hasNext()) {
			System.out.println( idealTypeScoreIterator.next());
		}
		
	}

	private static void createDummyVote(IdealTypeServicePort idealTypeService) {
		// topicid, voteid, opinionlevel(1~5)
		// 투표자는 10명으로 한다. v0~v9
		
		// saja topic
		idealTypeService.submit("1", "v0", 2);
		idealTypeService.submit("1", "v3", 2);
		idealTypeService.submit("1", "v4", 1);
		
		idealTypeService.submit("2", "v9", 2);
		idealTypeService.submit("2", "v1", 2);
		idealTypeService.submit("2", "v2", 2);

		idealTypeService.submit("3", "v5", 2);
		idealTypeService.submit("3", "v7", 5);
		idealTypeService.submit("3", "v8", 3);
		
		idealTypeService.submit("4", "v1", 2);
		idealTypeService.submit("4", "v6", 1);
		idealTypeService.submit("4", "v9", 2);
		
		idealTypeService.submit("5", "v2", 1);
		idealTypeService.submit("5", "v3", 4);
		idealTypeService.submit("5", "v6", 5);

		// bae topic
		idealTypeService.submit("6", "v6", 3);
		idealTypeService.submit("6", "v9", 2);
		idealTypeService.submit("6", "v0", 1);
		
		idealTypeService.submit("7", "v1", 5);
		idealTypeService.submit("7", "v2", 2);
		idealTypeService.submit("7", "v3", 3);
		
		idealTypeService.submit("8", "v4", 1);
		idealTypeService.submit("8", "v5", 2);
		idealTypeService.submit("8", "v7", 5);
		
		idealTypeService.submit("9", "v6", 3);
		idealTypeService.submit("9", "v8", 2);
		idealTypeService.submit("9", "v1", 5);
		
		idealTypeService.submit("10", "v9", 1);
		idealTypeService.submit("10", "v1", 4);
		idealTypeService.submit("10", "v3", 3);
		
		// hong topic
		idealTypeService.submit("11", "v6", 5);
		idealTypeService.submit("11", "v5", 5);
		idealTypeService.submit("11", "v9", 4);
		
		idealTypeService.submit("12", "v5", 3);
		idealTypeService.submit("12", "v4", 2);
		idealTypeService.submit("12", "v2", 4);
				
		idealTypeService.submit("13", "v1", 5);
		idealTypeService.submit("13", "v7", 2);
		idealTypeService.submit("13", "v3", 1);
		
		// jang topic
		idealTypeService.submit("14", "v2", 3);
		idealTypeService.submit("14", "v0", 4);
		idealTypeService.submit("14", "v8", 1);
		
		idealTypeService.submit("15", "v7", 3);
		idealTypeService.submit("15", "v4", 5);
		idealTypeService.submit("15", "v2", 1);
		
		idealTypeService.submit("16", "v1", 1);
		idealTypeService.submit("16", "v8", 2);
		idealTypeService.submit("16", "v3", 5);
		
		// lee topic
		idealTypeService.submit("17", "v8", 2);
		idealTypeService.submit("17", "v5", 3);
		idealTypeService.submit("17", "v3", 4);
		
		idealTypeService.submit("18", "v2", 4);
		idealTypeService.submit("18", "v1", 5);
		idealTypeService.submit("18", "v7", 5);
		
		idealTypeService.submit("19", "v8", 5);
		idealTypeService.submit("19", "v9", 5);
		idealTypeService.submit("19", "v2", 5);
		
		idealTypeService.submit("20", "v2", 2);
		idealTypeService.submit("20", "v1", 4);
		idealTypeService.submit("20", "v3", 1);
	}

	private static void createDummyTopic(IdealTypeServicePort idealTypeService) {
		// creatorid, topicid, opinionlevel(1~5)
		// db상에 있는 5명이 토픽을 만든 것으로 가정한다.
		// saja(1~5),bae(6~10),hong(11~13),jang(14~16),lee(17~20)
		idealTypeService.create("saja", "1", 1 );
		idealTypeService.create("saja", "2", 1 );
		idealTypeService.create("saja", "3", 1 );
		idealTypeService.create("saja", "4", 1 );
		idealTypeService.create("saja", "5", 1 );
		idealTypeService.create("bae", "6", 3 );
		idealTypeService.create("bae", "7", 3 );
		idealTypeService.create("bae", "8", 3 );
		idealTypeService.create("bae", "9", 3 );
		idealTypeService.create("bae", "10", 3 );
		idealTypeService.create("hong", "11", 1 );
		idealTypeService.create("hong", "12", 2 );
		idealTypeService.create("hong", "13", 3 );
		idealTypeService.create("jang", "14", 5 );
		idealTypeService.create("jang", "15", 5 );
		idealTypeService.create("jang", "16", 5 );
		idealTypeService.create("lee", "17", 4 );
		idealTypeService.create("lee", "18", 1 );
		idealTypeService.create("lee", "19", 2 );
		idealTypeService.create("lee", "20", 3 );	
		
		//create API 수정해야 함.. 토픽 만드는데 topicid는 필요없고 알아서 토픽ID 생성후 리턴해주면 됨.
		// string topicId = idealTypeService.create("saja",1);
		
		System.out.println("ideal type topic Count : " + idealTypeService.requestTopicCount() );
	}
}
