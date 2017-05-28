package com.service;


import com.entity.User;

public interface UserService {
	/*
 * 登录业务实现
 *   登录的用户名 
 *   	登录成功的用户信息
 */
	public User findByUserName(String userName) throws Exception;
	/*
	 * 用户注册实现
	 */
	public void add(User user) throws Exception;
	
	

}
