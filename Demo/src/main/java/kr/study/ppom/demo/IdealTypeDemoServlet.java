package kr.study.ppom.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import kr.study.ppom.controller.BoardPageController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdealTypeDemoServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(IdealTypeDemoServlet.class);
	
	@Override
	public void init() throws ServletException {
		ApplicationContext context = 
		        new ClassPathXmlApplicationContext("idealtype-demoservice.xml");
		logger.info( "IdealType Service Started..." );
	}
	
	
}
