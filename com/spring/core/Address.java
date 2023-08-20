package com.spring.core;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

public class Address {
	String city;
	String state;
	String zipCode;
	
	@PostConstruct
	public void initAddress() {
		
	}
	
	public Address() {
		super();
	}
	
	public Address(String city, String state, String zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
}
