package com.spring.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer12n22")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String firstName; 
	private String lastName;
	@OneToMany(targetEntity=Address.class, 
			cascade = CascadeType.ALL)
	//@JoinTable(name="custAddress12022", joinColumns= {@JoinColumn(name="id")}, 
	//	inverseJoinColumns= {@JoinColumn(name="address_id")})
	List<Address> addresses;

	//@ManyToOne(cascade = CascadeType.ALL)
	//Address address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	 // public Address getAddress() { return address; }
	  
	  //public void setAddress(Address address) { this.address = address; }
	 
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addresses=" + addresses
				+ "]";
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
