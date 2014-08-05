package kr.study.ppom.friend.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PseudoIdealTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PseudoIdealTypeServlet.class);
	@Override
	public void init() throws ServletException {
		new ClassPathXmlApplicationContext("/kr/study/ppom/friend/demo/idealtype-demoservice.xml");
		logger.info( "IdealType Service Started..." );
	}

}
