package com.second;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.third.DButils;

public class UpdateServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;charset=gbk");
		Connection conn = DButils.getConnection();
		Statement stmt = conn.createStatement();
		int id = Integer.valueOf(request.getParameter("updateId"));
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		//3、将获取到的界面数据添加到数据库
		String sql = "update user set name='"+name+"',salary='"+salary+
		"',age='"+age+"',sex='"+sex+"',tel='"+tel+"' "+
				"where id='"+id+"'";
		stmt.executeUpdate(sql);
		response.sendRedirect("list");
		DButils.closeConnection(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
