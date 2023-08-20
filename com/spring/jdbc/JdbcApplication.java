package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("employeeDao");
		
		employeeDao.updateEmployee();
		employeeDao.updateEmp(20, 1);
		employeeDao.updateEmp(50, 100);
		List<Employee> employees = employeeDao.getEmployees();
		
		System.out.println(employees);
		
		System.out.println("I am done!");
	}
}
