package com.spring.dao;

import java.util.List;

import com.spring.model.Employee;

/**
 * 
 * @author RMAJH
 *
 */
public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
