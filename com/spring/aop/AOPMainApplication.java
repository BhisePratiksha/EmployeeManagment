package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPMainApplication {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("BeansAOP.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AopAppConfig.class);
		Employee employee = context.getBean(Employee.class);
		
		employee.getName();
		employee.getDept();
		
	}
}
