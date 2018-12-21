package com.assignment.work.service;

import java.util.List;

import com.assignment.work.model.Users;

public interface UserService {
	void insertUser(Users usr);
	void insertUsers(List<Users> user);
	List<Users> getAllUser();
	void getUserById(String Id);
	void deleteById(String Id);
}