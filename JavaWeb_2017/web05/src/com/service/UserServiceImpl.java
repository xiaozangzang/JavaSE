package com.service;

import com.dao.UserDao;
import com.entity.User;

public class UserServiceImpl implements UserService {
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public User findByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		User user = dao.findByUser(userName);
		return user;
	}

	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		dao.add(user);
	}

}
