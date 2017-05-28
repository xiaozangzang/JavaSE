package com.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnDemo {
	
	/**
	 *   ���ӵ�oracle���ݿ�ʵ��
	 * @return
	 */
	public Connection getConnection(){
		// �������ݿ�
	    //1.�����������������ݿ��Ӧ�İ���oracle.jdbc.driver
	    //1.���������ݿ��Ӧ�������ࣩOracleDriver.class
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//���д���ǹ̶���
		    //2.��ȡ���ݿ�����:ͨ��java������������
		    //url-���ݿ��ַ,��ͬ�����ݿ�д����ͬ 127.0.0.1��localhost��������
		    //url-���ݿ��ַ��user -�û�����password-����     ConnectionΪ����     DriverManager����������
			System.out.println("��ʼ��������");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE",
	            "zhang","123456");
			System.out.println("���ݿ����ӳɹ���");
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
	 * �ر����ݿ�
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

