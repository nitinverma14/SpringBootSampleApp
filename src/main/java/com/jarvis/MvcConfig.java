package com.jarvis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jarvis.interceptor.CommonInterceptor;


@SuppressWarnings("deprecation")
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	CommonInterceptor commonInterceptor;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
    }
}
