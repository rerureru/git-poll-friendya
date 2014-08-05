package kr.study.ppom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInOutController {
	private static final Logger logger = LoggerFactory.getLogger(LogInOutController.class);

	@RequestMapping(value="/login.action", method=RequestMethod.GET)
	public String login( 
			@RequestParam(value="login_error", required=false) String errorCode ) {
		logger.info("login Called : " + errorCode );
		
		return "jsp/account/login";
		
	}
}
