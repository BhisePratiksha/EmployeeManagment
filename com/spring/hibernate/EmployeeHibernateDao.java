package com.spring.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.model.Employee;

@Repository
public class EmployeeHibernateDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee e) {
		System.out.println("Before commit:"+e);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(e);
		transaction.commit();
		
		System.out.println("After commit:"+e);
	}

	public Employee getEmployee(int id) {
		Session session = sessionFactory.openSession();
								//select * from emp where empId=?
		Query query = session.createQuery("from Employee where emp_id=?");
		query.setParameter(0, id);
		List<Employee> list = query.list();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public void updateEmployee(Employee e) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		System.out.println("update: "+e);
		//session.update(e);
		Query query = session.createQuery("update Employee set dept=:dept where emp_id=:id");
		query.setParameter("dept", e.getDept());
		query.setParameter("id", e.getEmp_id());
		query.executeUpdate();
		
		transaction.commit();
	}

	public void deleteEmployee(Employee e) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.delete(e);
		transaction.commit();
	}

	@Cacheable(value="employee")
	public List<Employee> listEmployee() {
		Session session = sessionFactory.openSession();
		//return session.createQuery("from Employee").list();
		
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("sal"));
		criteria.setMaxResults(3);
		return criteria.list();
		
	}

}
