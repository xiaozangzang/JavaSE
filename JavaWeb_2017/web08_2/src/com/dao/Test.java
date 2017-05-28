package com.dao;

import com.entity.User;

/**
 * username,name,pwd,age,sex,phone)
 * @author ’≈÷æ≈Ù
 *
 */
public class Test {
	public static void main(String[] args) {
	
		 try {
			User user = new UserDaoImpl().findUserByName("1001");
			System.out.println(user);
			System.out.println(new UserDaoImpl().listUser().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
