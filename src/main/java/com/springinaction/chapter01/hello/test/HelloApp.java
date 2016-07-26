package com.springinaction.chapter01.hello.test;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springinaction.chapter01.hello.GreetingService;

public class HelloApp {
	
	private static Logger logger = Logger.getLogger(HelloApp.class);  
	
  public static void main(String[] args) throws Exception {
    BeanFactory factory = 
        new XmlBeanFactory(new ClassPathResource("hello.xml"));
    
    // 记录debug级别的信息  
    logger.debug("This is debug message.");  
    // 记录info级别的信息  
    logger.info("This is info message.");  
    // 记录error级别的信息  
    logger.error("This is error message.");  
    
    GreetingService greetingService = 
        (GreetingService) factory.getBean("greetingService");

    greetingService.sayGreeting();
  }
}
