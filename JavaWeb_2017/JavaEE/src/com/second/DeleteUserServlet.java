package com.second;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.third.DButils;

public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1、获取数据库连接
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("text/html;charset=gbk");
			Connection conn = DButils.getConnection();
			Statement stmt = conn.createStatement();
			int id = Integer.valueOf(request.getParameter("delId"));
			String sql ="delete from user where id='"+id+"'";
			int i = stmt.executeUpdate(sql);
			System.out.println(i);
			response.sendRedirect("list");
			DButils.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
