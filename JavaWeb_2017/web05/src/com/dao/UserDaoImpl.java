package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.User;
import com.util.DButils;

public class UserDaoImpl implements UserDao {

	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "insert into t_user(userName,name,password,sex) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getSex());
		ps.executeUpdate();
		DButils.closeConnection(conn);
	}

	public User findByUser(String userName) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DButils.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select id,userName,name,password,sex from t_user where userName=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()){
			u = new User();
			u.setId(rs.getInt("id"));
			u.setUserName(rs.getString("userName"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setSex(rs.getString("sex"));
		}
		return u;
	}

}
