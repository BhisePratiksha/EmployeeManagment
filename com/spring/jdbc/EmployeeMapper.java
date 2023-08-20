package com.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet arg0, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(arg0.getInt(1));
		employee.setName(arg0.getString(2));
		employee.setDept(arg0.getString(3));
		employee.setSal(arg0.getInt(4));
		
		return employee;
	}

}
