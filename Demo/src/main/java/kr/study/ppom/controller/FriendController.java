package kr.study.ppom.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import kr.study.ppom.friend.service.IdealTypeScore;
import kr.study.ppom.friend.service.IdealTypeServicePort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/friend")
public class FriendController {
	@Resource(name="idealTypeServiceClient")
	private IdealTypeServicePort idealTypeService;
	
	@RequestMapping(value="/users/{userId}/idealtype", method=RequestMethod.GET)
	public @ResponseBody 
	List<IdealTypeScore> queryUserIdealType(@PathVariable String userId ) {
		System.out.println("idealType Score start!! : " + userId);
		List<IdealTypeScore> idealTypeScoreList = null;
		try {
			idealTypeScoreList =  idealTypeService.requestIdealType(userId);
		} catch( Exception ee) {			
		}
		System.out.println("idealType Score end!!");
		if(idealTypeScoreList !=null) {
			Iterator<IdealTypeScore> idealTypeScoreIterator = idealTypeScoreList.iterator();
			while(idealTypeScoreIterator.hasNext()) {
				System.out.println( idealTypeScoreIterator.next());
			}
		}
		return idealTypeScoreList;		
	}
}
