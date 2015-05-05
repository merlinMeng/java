package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.UserDao;
import com.sky.pojo.User;

@Service
public class UserService  {
	@Autowired
	private UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> queryAll() {
		return userDao.query();
	}
	
	public boolean matchUser(String userName,String password){
		int bn =userDao.getMatchCount(userName, password);
		boolean isExist = true;
		if(bn<1){
			isExist = false;
		}
		return isExist;
	}
	
	

}
