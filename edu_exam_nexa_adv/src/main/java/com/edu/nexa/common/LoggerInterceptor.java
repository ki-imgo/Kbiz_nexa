package com.edu.nexa.common;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter { 
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { 
	
		if (logger.isDebugEnabled()) { 
			
			logger.debug(" ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼ START ▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼"); 
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  JSP and Controller 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
			logger.debug("\t■ Request URI \t: " + request.getRequestURI()); 
			
			
			@SuppressWarnings({ "unchecked", "unused" })
			SortedMap<String, String[]> sMap = Collections.synchronizedSortedMap(new TreeMap<String, String[]>(request.getParameterMap()));
			
			synchronized (sMap) {
				
				for(String key : sMap.keySet()) {
			
					String[] value = sMap.get(key);
					
					for(int i=0; i<value.length; i++) {
						logger.debug("\t■ Request Param : " + key + " = " + value[i]);
					}
					
				}
			}
			
			logger.debug("\t〓〓〓〓〓〓〓〓〓〓〓〓〓  JSP and Controller 〓〓〓〓〓〓〓〓〓〓〓〓〓");	
			
		} 

		return super.preHandle(request, response, handler); 
	}
	
	@Override 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { 
		
		if (logger.isDebugEnabled()) { 
		
			logger.debug("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲  END  ▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲\n"); 
		} 
	} 
}


