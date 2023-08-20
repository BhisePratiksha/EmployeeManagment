package com.spring.aop;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name;
	private String dept;
	private int sal;
	private List<String> friends;
	
	public Employee() {
		super();
		this.name = "Employee One";
		this.dept = "Dept One";
	}	
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public String getName() {
		
		System.out.println("Name:"+name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		System.out.println("dept:"+dept);
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
