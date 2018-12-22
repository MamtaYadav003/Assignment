package com.assignment.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.work.model.Employee;
import com.assignment.work.repository.EmployeeRepository;
import com.assignment.work.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeDao;
	
	 
	@Override
	public void insertEmployee(Employee empl) {
		System.out.println("in add new emp normal");
		employeeDao.save(empl);
		
	}

	@Override
	public void insertEmployees(List<Employee> emp) {
		System.out.println("in add new emp list ");
		employeeDao.save(emp);
		
	}

	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeDao.findAll();
		
	}

	
	
	
	@Override
	public void deleteEmployee() {
		employeeDao.deleteAll();
		//userDao.deleteById(Id);
		
	}
	
}
