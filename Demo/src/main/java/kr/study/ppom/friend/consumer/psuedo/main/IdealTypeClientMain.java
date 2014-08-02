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
		idealTypeService.submit("1", "ppe", 2);
		idealTypeService.submit("1", "ppp", 2);
		idealTypeService.submit("1", "gae", 1);
		idealTypeService.submit("1", "han", 3);
		idealTypeService.submit("1", "kal", 1);
		
		idealTypeService.submit("2", "gom", 2);
		idealTypeService.submit("2", "hak", 2);
		idealTypeService.submit("2", "gae", 2);
		idealTypeService.submit("2", "kim", 3);
		idealTypeService.submit("2", "lee", 1);
		
		idealTypeService.submit("10", "gom", 3);
		idealTypeService.submit("10", "hak", 2);
		idealTypeService.submit("10", "gae", 2);
		idealTypeService.submit("10", "kim", 2);
		idealTypeService.submit("10", "lee", 5);
				
		idealTypeService.submit("27", "lov", 2);
		idealTypeService.submit("27", "ahn", 2);
		idealTypeService.submit("27", "gae", 1);
		idealTypeService.submit("17", "han", 3);
		idealTypeService.submit("17", "kal", 1);		
	}

	private static void createDummyTopic(IdealTypeServicePort idealTypeService) {
		// creatorid, topicid, opinionlevel(1~5)
		idealTypeService.create("saja", "1", 1 );
		idealTypeService.create("saja", "2", 1 );
		idealTypeService.create("saja", "3", 1 );
		idealTypeService.create("saja", "4", 1 );
		idealTypeService.create("saja", "5", 1 );
		idealTypeService.create("saja", "6", 1 );
		idealTypeService.create("saja", "7", 1 );
		idealTypeService.create("saja", "8", 1 );
		idealTypeService.create("saja", "9", 1 );
		idealTypeService.create("saja", "10", 1 );
		idealTypeService.create("saja", "11", 3 );
		idealTypeService.create("saja", "12", 3 );
		idealTypeService.create("saja", "13", 3 );
		idealTypeService.create("saja", "14", 3 );
		idealTypeService.create("saja", "15", 3 );
		idealTypeService.create("saja", "16", 3 );
		idealTypeService.create("saja", "17", 3 );
		idealTypeService.create("saja", "18", 3 );
		idealTypeService.create("saja", "19", 3 );
		idealTypeService.create("saja", "20", 3 );
		idealTypeService.create("gom", "21", 4 );
		idealTypeService.create("gom", "22", 4 );
		idealTypeService.create("gom", "23", 4 );
		idealTypeService.create("gom", "24", 4 );
		idealTypeService.create("gom", "25", 4 );
		idealTypeService.create("gom", "26", 4 );
		idealTypeService.create("gom", "27", 4 );
		idealTypeService.create("gom", "28", 4 );
		idealTypeService.create("gom", "29", 4 );
		idealTypeService.create("gom", "30", 4 );
		idealTypeService.create("yang", "31", 1 );
		idealTypeService.create("yang", "32", 2 );
		idealTypeService.create("yang", "33", 3 );
		idealTypeService.create("yang", "34", 4 );
		idealTypeService.create("yang", "35", 5 );
		idealTypeService.create("yang", "36", 1 );
		idealTypeService.create("yang", "37", 2 );
		idealTypeService.create("yang", "38", 3 );
		idealTypeService.create("yang", "39", 4 );
		idealTypeService.create("yang", "40", 5 );	
		
		System.out.println("ideal type topic Count : " + idealTypeService.requestTopicCount() );
	}
}
