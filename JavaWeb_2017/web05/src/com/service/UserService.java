package com.service;


import com.entity.User;

public interface UserService {
	/*
 * ��¼ҵ��ʵ��
 *   ��¼���û��� 
 *   	��¼�ɹ����û���Ϣ
 */
	public User findByUserName(String userName) throws Exception;
	/*
	 * �û�ע��ʵ��
	 */
	public void add(User user) throws Exception;
	
	

}
