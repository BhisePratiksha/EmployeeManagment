package com.spring.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.model.Address;
import com.spring.hibernate.model.BlobExample;
import com.spring.hibernate.model.Customer;
import com.spring.hibernate.model.Employee;

@SuppressWarnings("unused")
public class HibernateAppRun {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration().configure();
		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		final SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setState("MH");
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setState("MH");
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		addresses.add(address2);
		
		Customer customer = new Customer();
		customer.setFirstName("Cust 1");
		customer.setLastName("Lastname");
		customer.setAddresses(addresses);
		
		session.save(customer);
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Cust 2");
		customer2.setLastName("Lastname");
		customer2.setAddresses(addresses);
		
		session.save(customer2);
		
		Employee employee = new Employee(); // Transit 
		employee.setName("Test 1");
		employee.setDept("Test Dept");
		employee.setSal(1000);
		
		//Insert record
		//session.save(employee); // Persitent
		
		//Select Records
		List<Employee> employee2 = (List<Employee>) session.createCriteria(Employee.class).list();
		
		System.out.println("Size:"+employee2.size());
		employee = (Employee) session.get(Employee.class, 1);
		//Delete record
		if(employee != null)
			session.delete(employee);
		
		Query query = (Query) session.createQuery("from Employee where emp_id=?");
		query.setParameter(0, 131072);
		List<Employee> employees = (List<Employee>) query.list(); 
		System.out.println("employees: "+ employees);
		
		//Update Record
		Query query1 = (Query) session.createQuery("update Employee set sal=2000 where emp_id=?");
		query1.setParameter(0, 131072);
		int count = query1.executeUpdate();
		System.out.println("Count  : "+count);
		
		//Blob object
				try {
					BlobExample blobExample = new BlobExample();
					File inputFile = new File("C:\\Users\\dharm\\Documents\\3RI Tech\\smile.jpg");
					FileInputStream inputStream = new FileInputStream(inputFile);
					byte[] fileBytes = new byte[(int) inputFile.length()];
					inputStream.read(fileBytes);
					inputStream.close();

					blobExample.setPhoto(fileBytes);
					
					//session.save(blobExample);
					System.out.println("Blob:"+blobExample);
					
					BlobExample example = (BlobExample)session.get(BlobExample.class, 3);
					byte[] dbFileBytes = example.getPhoto();
					FileOutputStream outputStream = new FileOutputStream("C:\\Users\\dharm\\Documents\\3RI Tech\\smile2212.jpg");
			        outputStream.write(dbFileBytes);
			        outputStream.close();
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				
		t.commit();
		session.close();
		System.out.println(employee); // Detached 
		factory.close();
	}

	/*
	One to One ->  C -> A
	One to Many -> C -> [A1, A2, A3]
	Many to One -> [C1, C2] -> A
	Many to Many -> [C1, C2] -> [(C1 :A1, A2) (C2 : A1, A3)]
	*/
}
  
		