package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pojo.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	private DataSource dataSource; 
	private JdbcTemplate  jdbctemplate;
	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createEmployee(Employee employee) 
	{
		String sql = "insert into springjdbc (employeename,email) values (?,?)";
		int x = jdbctemplate.update(sql, new Object[] {employee.getEmployeename(),employee.getEmail()});
		/*String sql = "insert into springjdbc (employeename,email) values (?,?)";
		int x = jdbctemplate.update(sql,employee.getEmployeename(),employee.getEmail());*/
		if (x > 0)
		{
			System.out.println("Data Inserted Succesfully");
		}
		else
		{
			System.out.println("Data Not inserted");
		}
	}
	
	@Override
	public Employee getEmployeeById(int employeeid) 
	{
		String sql = "select * from springjdbc where id=?";
		Employee employee = jdbctemplate.queryForObject(sql, new EmployeeRowMapper(), employeeid);
		
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeid)
	{
		String sql = "Delete from springjdbc where id=?";
		int update = jdbctemplate.update(sql,employeeid);
		 if(update>0)
		 {
			 System.out.println("Employee Deleted");
		 }
	}

	@Override
	public void updateEmployeeById(String email, int employeeid) 
	{
		String sql = "Update springjdbc set email = ? where id=?";
		int update = jdbctemplate.update(sql, email,employeeid);
		 if(update>0)
		 {
			 System.out.println("Employee Updated");
		 }
	}

	@Override
	public List<Employee> getAllEmployeeDetails() 
	{
		String sql = "select * from springjdbc";
		List<Employee> list = jdbctemplate.query(sql, new EmployeeRowMapper());
		return list;
	}

	/*@Override
	public void createEmployee(Employee employee) 
	{
		Connection connect=null;
		PreparedStatement ps = null;
		try {
			System.out.println("Hello");
			connect = dataSource.getConnection();
			System.out.println("Connection created");
			ps = connect.prepareStatement("insert into springjdbc (employeename,email) values (?,?)");
			System.out.println("Query executing");
			ps.setString(1, employee.getEmployeename());
			ps.setString(1, employee.getEmail());
			
			int x = ps.executeUpdate();
			if (x > 0)
			{
				System.out.println("Data Inserted Succesfully");
			}
			else
			{
				System.out.println("Data Not inserted");
			}
		} 
		catch (Exception e)
		{
			
		}
		finally 
		{
			if(connect != null)
			{
				try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}*/
	

}
