package kr.study.ppom.controller;

import java.util.List;

import javax.annotation.Resource;

import kr.study.ppom.friend.service.IdealTypeScore;
import kr.study.ppom.friend.service.IdealTypeServicePort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/friend")
public class FriendController {
	private static final Logger logger = LoggerFactory.getLogger(FriendController.class);
	
	@Resource(name="idealTypeServiceClient")
	private IdealTypeServicePort idealTypeService;
	
	@RequestMapping(value="/users/{userId}/idealtype", method=RequestMethod.GET)
	public @ResponseBody 
	List<IdealTypeScore> queryUserIdealType(@PathVariable String userId ) {
		logger.info("idealType Score start!! : " + userId);
		List<IdealTypeScore> idealTypeScoreList = null;
		try {
			idealTypeScoreList =  idealTypeService.requestIdealType(userId);
		} catch( Exception ee) {	
			logger.info("idealType request exception");
		}
		logger.info("idealType Score end!!");
		
		return idealTypeScoreList;		
	}
}
