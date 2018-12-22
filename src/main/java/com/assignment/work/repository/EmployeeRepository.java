package com.assignment.work.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.assignment.work.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
}
