package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.hibernate.model.Address;
import com.spring.hibernate.model.Customer;
import com.spring.hibernate.model.Employee;

public class SpringHibernateAppRun {


	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

		SessionFactory sessionFactory = context.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		System.out.println("ID:1 -> "+session.get(Customer.class, 1));
		
		Address address = new Address();
		address.setCity("navi Mumbai");
		address.setState("MH");
		
		Address address2 = new Address();
		address2.setCity("Solapur");
		address2.setState("MH");
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		addresses.add(address2);
		
		Customer customer = new Customer();
		customer.setFirstName("Cust 4");
		customer.setLastName("Last name");
		customer.setAddresses(addresses);
		
		session.save(customer);
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Cust 3");
		customer2.setLastName("Lastname");
		customer2.setAddresses(addresses);
		
		//session.save(customer2);
		
		//System.out.println(session.get(Customer.class, 1));
		transaction.commit();
		
		context.close();	
	}

}
