package com.dao;

import com.entity.User;

public interface UserDao {
	
	/*
	 * user 需要注册的用户
	 */
	public void add(User user) throws Exception;
	/*
	 * 需要登录的用户名
	 * 根据用户名查找到的用户信息
	 */
	
	public User findByUser(String userName) throws Exception;

}
