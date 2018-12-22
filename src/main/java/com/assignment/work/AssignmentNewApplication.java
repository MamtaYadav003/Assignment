package com.assignment.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.assignment.work.repository.EmployeeRepository;

@SpringBootApplication
public class AssignmentNewApplication {
	
	@Autowired
	EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AssignmentNewApplication.class, args);
	}
	
	
	

}

