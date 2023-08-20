package com.spring.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApplication {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		Employee employee1 = (Employee) beanFactory.getBean("employee");
		System.out.println(employee1);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans1.xml", "Beans.xml");
		System.out.println("context is loaded...");
		Employee employee2 = (Employee) context.getBean("employee");
		System.out.println(employee2);
		
		Address address = (Address)context.getBean("address");
		System.out.println(address);
		
	}

}
