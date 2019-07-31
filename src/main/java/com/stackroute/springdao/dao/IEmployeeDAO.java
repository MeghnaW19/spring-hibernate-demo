package com.stackroute.springdao.dao;

import java.util.List;

import com.stackroute.springdao.model.Employee;

public interface IEmployeeDAO {
	
	public boolean saveEmployee(Employee employee);
	public Employee getEmployeeById(int empId);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int empId);
	public boolean updateEmployee(Employee employee);

}
