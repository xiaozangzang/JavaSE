package com.third;

import java.sql.Connection;
import java.sql.SQLException;
/*
 * 将数据库的操作封装在DButils中
 */
import java.sql.DriverManager;

public class DButils{
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/open?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(url,"root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	/**
	 * 关闭连接
	 * @param conn Connection连接对象
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
