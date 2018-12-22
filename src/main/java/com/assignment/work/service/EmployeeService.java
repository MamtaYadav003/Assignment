package com.assignment.work.service;

import java.util.List;

import com.assignment.work.model.Employee;


public interface EmployeeService {

	public  void insertEmployee(Employee emp);
	public void insertEmployees(List<Employee> empl);
	List<Employee> getAllEmployee();
	
	void deleteEmployee();
}
