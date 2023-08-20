package com.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyAnnotationConfig.class);
		for(String bean : context.getBeanDefinitionNames()) {
			System.out.println("Bean name : "+bean);
		}
		Employee employee2 = (Employee) context.getBean("getEmployee");
		Address address = (Address) context.getBean("address1");
		
		System.out.println("Before GetName");
		String name= employee2.getName();
		System.out.println("After Returning from GetName");
		System.out.println("After GetName");
		
		System.out.println(employee2);
		System.out.println(address);
		
		context.registerShutdownHook();
	}

}
