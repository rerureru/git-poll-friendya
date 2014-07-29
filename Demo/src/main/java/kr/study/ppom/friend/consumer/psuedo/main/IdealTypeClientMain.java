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
		idealTypeService.submit("10", "2", 3);
		idealTypeService.submit("10", "6", 2);
		idealTypeService.submit("10", "9", 2);
		idealTypeService.submit("10", "10", 2);
		idealTypeService.submit("10", "12", 5);
		
		idealTypeService.submit("2", "2", 2);
		idealTypeService.submit("2", "6", 2);
		idealTypeService.submit("2", "9", 2);
		idealTypeService.submit("2", "10", 3);
		idealTypeService.submit("2", "12", 1);
		
		idealTypeService.submit("27", "100", 2);
		idealTypeService.submit("27", "101", 2);
		idealTypeService.submit("27", "9", 1);
		idealTypeService.submit("17", "102", 3);
		idealTypeService.submit("17", "103", 1);
		
		idealTypeService.submit("1", "200", 2);
		idealTypeService.submit("1", "201", 2);
		idealTypeService.submit("1", "9", 1);
		idealTypeService.submit("1", "102", 3);
		idealTypeService.submit("1", "103", 1);
		
	}

	private static void createDummyTopic(IdealTypeServicePort idealTypeService) {
		// creatorid, topicid, opinionlevel(1~5)
		idealTypeService.create("1", "1", 1 );
		idealTypeService.create("1", "2", 1 );
		idealTypeService.create("1", "3", 1 );
		idealTypeService.create("1", "4", 1 );
		idealTypeService.create("1", "5", 1 );
		idealTypeService.create("1", "6", 1 );
		idealTypeService.create("1", "7", 1 );
		idealTypeService.create("1", "8", 1 );
		idealTypeService.create("1", "9", 1 );
		idealTypeService.create("1", "10", 1 );
		idealTypeService.create("1", "11", 3 );
		idealTypeService.create("1", "12", 3 );
		idealTypeService.create("1", "13", 3 );
		idealTypeService.create("1", "14", 3 );
		idealTypeService.create("1", "15", 3 );
		idealTypeService.create("1", "16", 3 );
		idealTypeService.create("1", "17", 3 );
		idealTypeService.create("1", "18", 3 );
		idealTypeService.create("1", "19", 3 );
		idealTypeService.create("1", "20", 3 );
		idealTypeService.create("2", "21", 4 );
		idealTypeService.create("2", "22", 4 );
		idealTypeService.create("2", "23", 4 );
		idealTypeService.create("2", "24", 4 );
		idealTypeService.create("2", "25", 4 );
		idealTypeService.create("2", "26", 4 );
		idealTypeService.create("2", "27", 4 );
		idealTypeService.create("2", "28", 4 );
		idealTypeService.create("2", "29", 4 );
		idealTypeService.create("2", "30", 4 );
		idealTypeService.create("3", "31", 1 );
		idealTypeService.create("3", "32", 2 );
		idealTypeService.create("3", "33", 3 );
		idealTypeService.create("3", "34", 4 );
		idealTypeService.create("3", "35", 5 );
		idealTypeService.create("3", "36", 1 );
		idealTypeService.create("3", "37", 2 );
		idealTypeService.create("3", "38", 3 );
		idealTypeService.create("3", "39", 4 );
		idealTypeService.create("3", "40", 5 );	
		
		System.out.println("ideal type topic Count : " + idealTypeService.requestTopicCount() );
	}
}
