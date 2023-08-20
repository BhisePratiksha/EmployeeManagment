package com.spring.core;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class Employee {
	String id;
	String name;
	String dept;
	@Autowired
	@Qualifier(value="address2")
	Address address2;
	Map<String, String> skills;
	
	@PreDestroy
	public void empDestroy() {
		System.out.println("empDestroy");
	}
	
	@PostConstruct
	public void empInit() {
		System.out.println("empInit...");
		this.id = "emp id";
		//this.address = new Address("Mubmai","MH");
	}
	
	public Employee() {
		super();
	}
	
	public Employee(String id, String name, String dept, Address address1) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.address2 = address1;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	public Address getAddress() {
		return address2;
	}

	public void setAddress(Address address1) {
		this.address2 = address1;
	}
	
	

	public Map<String, String>  getSkills() {
		return skills;
	}

	public void setSkills(Map<String, String>  skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", address=" + address2 + ", skills="
				+ skills + "]";
	}
}
