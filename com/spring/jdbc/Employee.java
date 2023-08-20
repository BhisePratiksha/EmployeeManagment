package com.spring.jdbc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {

	private int empId;
	@Size(max=5, message="Name should not be >5")
	private String name;
	private String dept;
	@Max(value=2000, message="Please do not give me too much pay")
	@Min(value=1000, message="Please give me some good pay")
	private int sal;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", sal=" + sal + "]";
	}
	
	
}
