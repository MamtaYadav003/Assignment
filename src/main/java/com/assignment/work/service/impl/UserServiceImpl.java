package com.assignment.work.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.work.dao.UserDao;
import com.assignment.work.model.Users;
import com.assignment.work.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void insertUser(Users usr) {
		userDao.insertUser(usr);
	}

	@Override
	public void insertUsers(List<Users> user) {
		userDao.insertUsers(user);
	}

	public List<Users> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void getUserById(String Id) {
		Users user = userDao.getUserById(Id);
		System.out.println(user);
	}
	
	@Override
	public void deleteById(String Id) {
		userDao.deleteById(Id);
		
	}

}