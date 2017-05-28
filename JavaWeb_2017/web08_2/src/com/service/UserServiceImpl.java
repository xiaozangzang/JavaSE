package com.service;

import java.util.List;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

public class UserServiceImpl implements UserService{
	private UserDao dao ;
	public void setDao(UserDao dao){
		this.dao = dao;
	}
	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		dao.add(user);
	}

	public User findUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		User user = dao.findUserByName(userName);
		return user;
	}
	public List<User> listUser() throws Exception {
		// TODO Auto-generated method stub
		List list = dao.listUser();
		return list;
	}

}
