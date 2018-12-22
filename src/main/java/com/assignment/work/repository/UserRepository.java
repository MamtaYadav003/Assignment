package com.assignment.work.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.work.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

	Users findById(Long l);
	public Users findByUsername(String username);

	void deleteById(long l);


}
