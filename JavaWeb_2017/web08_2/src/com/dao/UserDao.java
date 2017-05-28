package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	/**
	 *  ע���û��������ݿ����һ����¼  user
	 * @param user
	 * @throws Exception
	 */
	public void add(User user) throws Exception;
	
	public User findUserByName(String userName) throws Exception;
	
	public List<User> listUser()throws Exception;

}
