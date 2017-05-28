package com.cc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.User;
import com.cc.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getUserByUsername(String username){
		return this.userMapper.getUserByUsername(username);
	}
	public User getUserById(Long id){
		return this.userMapper.getById(id);
	}
	public void insert(User user){
		this.userMapper.insert(user);
	}
	public void update(User user){
		this.userMapper.update(user);
	}
}
