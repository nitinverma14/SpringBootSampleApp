package com.jarvis.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jarvis.util.DateTimeUtil;


@Component
public class CommonInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	DateTimeUtil dateTimeUtil;
	
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
   		Object object, ModelAndView model)
   		throws Exception {
   	response.setHeader("server-time", dateTimeUtil.dateToString(new Date()));
   	response.setHeader("ms", System.currentTimeMillis()+"");
    }
}