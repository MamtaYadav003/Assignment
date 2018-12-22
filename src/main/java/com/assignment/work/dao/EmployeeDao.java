package com.assignment.work.dao;

import java.util.List;

import com.assignment.work.model.Employee;



public interface EmployeeDao {

	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> empls);
	List<Employee> getAllEmployee();
	void deleteEmployee();
	
}
