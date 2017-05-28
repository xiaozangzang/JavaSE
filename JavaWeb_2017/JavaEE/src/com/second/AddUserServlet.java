package com.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.third.DButils;

public class AddUserServlet  extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,IOException{
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("text/html;charset=gbk");
			//1、获取数据库连接
			Connection conn = DButils.getConnection();
			//2、获取浏览器界面的数据
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			String sex = request.getParameter("sex");
			String tel = request.getParameter("tel");
			System.out.print(name+salary+age+sex+tel);
			//3、将获取到的界面数据添加到数据库
			String sql = "insert into user(name,salary,age,sex,tel) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, salary);
			ps.setString(3, age);
			ps.setString(4, sex);
			ps.setString(5, tel);
			int num = ps.executeUpdate();
			System.out.println("有"+num+"条数据插入库中");
			//4、跳转到显示add success界面
//			PrintWriter pw = response.getWriter();
//			pw.println("<h1>add success</h1>");
//			pw.println("<a href='list'>list</a>");
			response.sendRedirect("list");
//			pw.close();
			DButils.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
