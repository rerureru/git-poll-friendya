package net.nice19.smboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// check variable
		Object userId = request.getSession().getAttribute("userId");
		//
		logger.info("request context path : " + request.getContextPath() + ", userId : " + userId);
		// pass through when access login.do, join.do
		if(request.getRequestURI().equals(request.getContextPath()+"/login.do") || request.getRequestURI().equals(request.getContextPath()+"/member/join.do")){	//test
		//if(request.getRequestURI().equals("/login.do") || request.getRequestURI().equals("/member/join.do")){	//server
			if(userId != null){
				response.sendRedirect(request.getContextPath() + "/board/list.do");
				return true;
			} else {
				return true;
			}
		}
		//
		// where other pages		
		if(userId == null){
			response.sendRedirect(request.getContextPath() + "/login.do");
			return false;
		} else {
			return true;
		}
		//		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
