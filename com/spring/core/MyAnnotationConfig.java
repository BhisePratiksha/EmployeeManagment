package com.spring.core;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.core")
public class MyAnnotationConfig {

	
	@Bean(autowire=Autowire.BY_NAME)
	public Employee getEmployee() {
		return new Employee();
	}
	
	@Bean
	@Qualifier(value="address1")
	public Address address1() {
		return new Address("Pune", "MH", "411000");
	}
	
	@Bean
	@Qualifier(value="address2")
	public Address getAddress2() {
		return new Address("Mumbai", "MH", "411000");
	}
}
