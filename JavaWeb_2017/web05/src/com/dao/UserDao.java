package com.dao;

import com.entity.User;

public interface UserDao {
	
	/*
	 * user ��Ҫע����û�
	 */
	public void add(User user) throws Exception;
	/*
	 * ��Ҫ��¼���û���
	 * �����û������ҵ����û���Ϣ
	 */
	
	public User findByUser(String userName) throws Exception;

}
