package com.assignment.work.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.work.model.Users;
import com.assignment.work.repository.UserRepository;
import com.assignment.work.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userDao;
	

	 
	@Override
	public void insertUser(Users usr) {
		userDao.save(usr);
		//userDao.insertUser(usr);
	}

	@Override
	public void insertUsers(List<Users> user) {
		userDao.save(user);
		
	}

	public List<Users> getAllUser() {
		return (List<Users>) userDao.findAll();
		
	}

	@Override
	public void getUserById(long Id) {
		Users user = userDao.findById(Id);
		//Users user = userDao.getUserById(Id);
		System.out.println(user);
	}
	
	@Override
	public void deleteById(long Id) {
		userDao.delete(Id);
		//userDao.deleteById(Id);
		
	}

}