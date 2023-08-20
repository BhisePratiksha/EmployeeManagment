package com.spring.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	public void updateEmployee() {
		jdbcTemplate.execute("update emp set sal=10 where emp_id=1");
		
	}
	
	public void updateEmp(int sal, int empId) {
		TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
		Map< String, Integer> map = new HashMap<String, Integer>();
		map.put("sal", sal);
		map.put("empId", empId);
		int count = namedParameterJdbcTemplate.execute("update emp set sal=:sal where emp_id=:empId",
				map, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement arg0) throws SQLException, DataAccessException {

				return arg0.executeUpdate();
			}
		});
		
		System.out.println("Update count:"+count);
		try {
			if(empId == 1) {
				int a= 1/0;
			}
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			transactionManager.rollback(transactionStatus);
		}
		
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = jdbcTemplate.query("select * from emp", new EmployeeMapper());
		
		return employees;
	}
	
	public Employee getEmployee(String empId) {
		List<Employee> employees = jdbcTemplate.query("select * from emp where emp_id="+empId, new EmployeeMapper());
		if(employees.isEmpty()) {
			return null;
		}
		
		return employees.get(0);
	}
	
	public int deleteEmployee(String empId) {
		int count = jdbcTemplate.update("delete from emp where emp_id="+empId);
		
		return count;
	}
}
