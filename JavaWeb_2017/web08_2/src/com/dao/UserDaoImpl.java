package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DButils;

public class UserDaoImpl implements UserDao{
	//添加  username,name,pwd,age,sex,phone
	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "insert into friend_user(userName,name,password,age,sex,phone) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getAge());
		ps.setString(5, user.getSex());
		ps.setString(6, user.getPhone());
		ps.executeUpdate();
		DButils.closeConnection(conn);
		
		
	}
	//通过id查找用户信息
	public User findUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		User user = null;
		String sql = "select * from friend_user where userName = '"+userName+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("userName"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
		}
		DButils.closeConnection(conn);
		return user;
	}
	/**
	 * id ,username,sex,age
	 * 返回所有用户信息的list
	 */
	public List<User> listUser() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		String sql = "select id,userName,sex,age from friend_user";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<User> list  = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("userName"));
			user.setSex(rs.getString("sex"));
			user.setAge(rs.getInt("age"));
			list.add(user);
		}
		return list;
	}

}
