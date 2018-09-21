package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.pojo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Employee employee = new Employee();
		employee.setEmployeeid(rs.getInt("id"));
		employee.setEmployeename(rs.getString("employeename"));
		employee.setEmail(rs.getString("email"));
		
		return employee;
	}

	

	
}
