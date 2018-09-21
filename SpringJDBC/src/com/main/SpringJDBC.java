package com.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDAOImpl;
import com.pojo.Employee;
import com.service.EmployeeService;

public class SpringJDBC 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		EmployeeService employeeService = context.getBean("employeeService",EmployeeService.class);
		
		//createEmployee(employeeService);
		
		//fetchEmployeeById(employeeService);
		
		listEmployee(employeeService);
		
		//employeeService.updateEmployeeById("brucy@gmail.com", 2);
		
		//employeeService.deleteEmployeeById(4);
		
		//context.close();
		
		
		
	}

	private static void listEmployee(EmployeeService employeeService) {
		List<Employee> list = employeeService.getAllEmployeeInfo();
		for (Employee employee : list) 
		{
			System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getEmail());
		}
	}

	private static void fetchEmployeeById(EmployeeService employeeService) {
		Employee employee= employeeService.fetchEmployeeById(2);
		
		System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getEmail());
	}

	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = new Employee();
		employee.setEmployeename("Hasan");
		employee.setEmail("Hasan@gmail.com");
		employeeService.addEmployee(employee);
	}
}
