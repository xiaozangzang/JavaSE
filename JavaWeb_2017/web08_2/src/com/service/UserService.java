package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	/**
	 *  注册用户，向数据库添加一条记录  user
	 * @param user
	 * @throws Exception
	 */
	public void add(User user) throws Exception;
	
	public User findUserByName(String userName) throws Exception;
	
	public List<User> listUser() throws Exception;

}
