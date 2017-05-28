package com.test;

import com.dao.ComputerDAO;
import com.entity.Computer;


public class TestDAO {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ComputerDAO dao = new ComputerDAO();
		dao.save(
				new Computer("x500","x500.jpg","²»´í",30000));
	}

}
