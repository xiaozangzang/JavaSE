package com.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.third.DButils;

public class UpdateUserServlet extends HttpServlet {

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
			String sql = "select * from user where id ='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta http-equiv='content-type' content='text/html;charset=utf-8'>");
			pw.println("</head>");
			pw.println("<h1>Update User</h1>");
			while(rs.next()){
			String name = rs.getString("name");
			String salary = rs.getString("salary");
			String age = rs.getString("age");
			String sex = rs.getString("sex");
			String tel = rs.getString("tel");
			System.out.println(id);
			pw.println("<form action='update2?updateId="+id+"' method='post'>");
			pw.println("<table>");
//			pw.println("<tr><td>id:</td><td><input type='text'name='id'value='"+id+"'/></td></tr>");
			pw.println("<tr><td>name:</td>");
			pw.println("<td><input type='text' name='name' value='"+name+"'/></td></tr>");
			pw.println("<tr><td>salary:</td>");
			pw.println("<td><input type='text' name='salary' value='"+salary+"'/></td></tr>");
			pw.println("<tr><td>age:</td><td><input type='text' name='age' value='"+age+"'/></td></tr>");
			pw.println("<tr><td>sex:</td>");
			pw.println("<td>");
			if(sex.equals("M")){
				pw.println("ÄÐ:<input disabled='disabled' checked='checked' type='radio' name='sex' value='M'/>");
			}else{
				pw.println("Å®:<input disabled='disabled' checked='checked' type='radio' name='sex' value='F'/>");
			}
			pw.println("</td></tr>");
			pw.println("<tr><td>tel:</td><td><input type='text' name='tel' value='"+tel+"'/></td></tr>");
			pw.println("<tr><td></td><td><input type='submit' value='submit' /></td></tr>");
			pw.println("</table></form>");
			}
			pw.println("</html>");
			pw.close();
			DButils.closeConnection(conn);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
