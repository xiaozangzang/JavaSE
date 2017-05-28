package com.cc.dao;

import com.cc.bean.User;


public interface UserMapper {
	public User getUserByUsername(String username);
	
	public void insert(User user);
	
	
	public void update(User user);

	public User getById(Long id);
}