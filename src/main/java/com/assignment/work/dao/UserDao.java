package com.assignment.work.dao;

import java.util.List;

import com.assignment.work.model.Users;

public interface UserDao {
	void insertUser(Users cus);
	void insertUsers(List<Users> user);
	List<Users> getAllUser();
	Users getUserById(String userId);
	void deleteById(long Id);
}