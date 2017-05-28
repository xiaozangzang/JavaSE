package com.dao;

import java.util.List;

import com.entity.Computer;

public interface ComputerDao {
	
	/*
	 * �����ݿ�������еĵ�����Ϣ
	 * @return ���Լ��϶���
	 * @throws Exception
	 */
	public List<Computer> findAll() throws Exception;
	/*
	 * ͨ��buyId�����û�����ĵ���
	 * 	�������id����Ӧ�Ķ���
	 * @throws Exception
	 */

	public Computer findByComputer(int buyId) throws Exception;



}
