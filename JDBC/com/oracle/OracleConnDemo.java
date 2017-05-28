package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnDemo {
	
	/**
	 *   连接到oracle数据库实例
	 * @return
	 */
	public Connection getConnection(){
		// 访问数据库
	    //1.加载驱动：加载数据库对应的包名oracle.jdbc.driver
	    //1.（加载数据库对应的驱动类）OracleDriver.class
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//这个写法是固定的
		    //2.获取数据库连接:通过java的驱动管理器
		    //url-数据库地址,不同的数据库写法不同 127.0.0.1和localhost都代表本机
		    //url-数据库地址：user -用户名：password-密码     Connection为连接     DriverManager驱动管理器
			System.out.println("开始尝试连接");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
	            "zhang","123456");
			System.out.println("数据库连接成功！");
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
	 * 关闭数据库
	 * @param conn
	 */
	 public void closeDBConnection(Connection conn){
		 
		 try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
}

