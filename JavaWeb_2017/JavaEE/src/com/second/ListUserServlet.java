package com.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.third.DButils;


/**
 * �����ݿ��������������ʾ�������
 * http://localhost:8080/JavaEE/list
 */

public class ListUserServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=gbk");
		
			//1�������ݿ⽨������
			Connection conn = DButils.getConnection();
			//2�������ݿ��л�ȡ����
			String sql = "select * from user";
			Statement stmt;
			try {
				stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(sql);
				PrintWriter pw = response.getWriter();
				pw.println("<table border='1px'>");
				pw.println("<tr><th>id</th><th>name</th><th>salary</th><th>age</th><th>sex</th><th>tel</th><th>delete</th><th>update</th></tr>");
				while(rs.next()){
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String salary = rs.getString("salary");
					String age = rs.getString("age");
					String sex = rs.getString("sex");
					String tel = rs.getString("tel");
					//3����ȡ��������ӵ��������Ϊ��Ӧ��Ϣ���ݸ��������ʾ
					pw.println("<tr>"
							+ "<td>"+id+"</td>"
							+ "<td><a href='view?viewId="+id+"'>"+name+"</a></td>"
							+ "<td>"+salary+"</td>"
							+ "<td>"+age+"</td>"
							+ "<td>"+sex+"</td>"
							+ "<td>"+tel+"</td>"
							+ "<td><a href='delete?delId="+id+"'>delete</a></td>"
							+ "<td><a href='update?updateId="+id+"'>update</a></td>"
							+ "</tr>");
				}
				pw.println("</table>");
				pw.println("<a href='add.html'>add</a>");
				pw.close();
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}









