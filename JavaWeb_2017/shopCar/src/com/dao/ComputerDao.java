package com.dao;

import java.util.List;

import com.entity.Computer;

public interface ComputerDao {
	
	/*
	 * 从数据库查找所有的电脑信息
	 * @return 电脑集合对象
	 * @throws Exception
	 */
	public List<Computer> findAll() throws Exception;
	/*
	 * 通过buyId查找用户所买的电脑
	 * 	购买电脑id所对应的对象
	 * @throws Exception
	 */

	public Computer findByComputer(int buyId) throws Exception;



}
