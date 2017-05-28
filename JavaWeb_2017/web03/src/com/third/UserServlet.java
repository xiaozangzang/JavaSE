package com.third;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.third.DButils;

public class UserServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//http://localhost:8080/taobao/list.do
		String uri = request.getRequestURI();
		String path = 
			uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if(path.equals("/list")){
			try {
				//1、与数据库建立连接
				Connection conn = DButils.getConnection();
//					DriverManager.getConnection(url, "root", "1234");
				//2、从数据库中获取数据
				String sql = "select * from user";
				Statement stmt = conn.createStatement();
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
					//3、获取的数据添加到表格中作为响应信息传递给浏览器显示
					pw.println("<tr>"
							+ "<td>"+id+"</td>"
							+ "<td><a href='view.do?viewId="+id+"'>"+name+"</a></td>"
							+ "<td>"+salary+"</td>"
							+ "<td>"+age+"</td>"
							+ "<td>"+sex+"</td>"
							+ "<td>"+tel+"</td>"
							+ "<td><a href='delete.do?delId="+id+"'>delete</a></td>"
							+ "<td><a href='modify.do?modId="+id+"'>update</a></td>"
							+ "</tr>");
				}
				pw.println("</table>");
				pw.println("<a href='add.html'>add</a>");
				pw.close();
				DButils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/add")){
			try {
				//1、获取数据库连接
				Connection conn = DButils.getConnection();
				//2、获取浏览器界面的数据
				String name = request.getParameter("name");
				String salary = request.getParameter("salary");
				String age = request.getParameter("age");
				String sex = request.getParameter("sex");
				String tel = request.getParameter("tel");
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
//				PrintWriter pw = response.getWriter();
//				pw.println("<h1>add success</h1>");
//				pw.println("<a href='list'>list</a>");
				response.sendRedirect("list.do");
//				pw.close();
				DButils.closeConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/modify")){
			try {
				Connection conn = DButils.getConnection();
				Statement stmt = conn.createStatement();
				int id = Integer.valueOf(request.getParameter("modId"));
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
				pw.println("<form action='update.do?updateId="+id+"' method='post'>");
				pw.println("<table>");
//				pw.println("<tr><td>id:</td><td><input type='text'name='id'value='"+id+"'/></td></tr>");
				pw.println("<tr><td>name:</td>");
				pw.println("<td><input type='text' name='name' value='"+name+"'/></td></tr>");
				pw.println("<tr><td>salary:</td>");
				pw.println("<td><input type='text' name='salary' value='"+salary+"'/></td></tr>");
				pw.println("<tr><td>age:</td><td><input type='text' name='age' value='"+age+"'/></td></tr>");
				pw.println("<tr><td>sex:</td>");
				pw.println("<td>");
				if("男".equals(sex)){
					pw.println("男:<input  checked='checked' type='radio' name='sex' value='男'/>");
					pw.println("女:<input   type='radio' name='sex' value='女'/>");
				}else{
					pw.println("男:<input   type='radio' name='sex' value='男'/>");
					pw.println("女:<input  checked='checked' type='radio' name='sex' value='女'/>");
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
		}else if(path.equals("/update")){
			try {
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
				response.sendRedirect("list.do");
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("/delete")){
			//1、获取数据库连接
			try {
				Connection conn = DButils.getConnection();
				Statement stmt = conn.createStatement();
				int id = Integer.valueOf(request.getParameter("delId"));
				String sql ="delete from user where id='"+id+"'";
				int i = stmt.executeUpdate(sql);
				System.out.println(i);
				response.sendRedirect("list.do");
				DButils.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("/view")){
			try {
				Connection conn = DButils.getConnection();
				Statement stmt = conn.createStatement();
				int id = Integer.valueOf(request.getParameter("viewId"));
				String sql = "select * from user where id ='"+id+"'";
				ResultSet rs = stmt.executeQuery(sql);
				PrintWriter pw = response.getWriter();
				pw.println("<h1>Update User</h1>");
				while(rs.next()){
				String name = rs.getString("name");
				String salary = rs.getString("salary");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String tel = rs.getString("tel");
				System.out.println(id);
				pw.println("<form action='list.do' method='post'>");
				pw.println("<table>");
//				pw.println("<tr><td>id:</td><td><input type='text'name='id'value='"+id+"'/></td></tr>");
				pw.println("<tr><td>name:</td>");
				pw.println("<td><input disabled='disabled' type='text' name='name' value='"+name+"'/></td></tr>");
				pw.println("<tr><td>salary:</td>");
				pw.println("<td><input disabled='disabled'type='text' name='salary' value='"+salary+"'/></td></tr>");
				pw.println("<tr><td>age:</td><td><input disabled='disabled'type='text' name='age' value='"+age+"'/></td></tr>");
				pw.println("<tr><td>sex:</td>");
				pw.println("<td>");
				if(sex.equals("男")){
					pw.println("男:<input disabled='disabled' checked='checked' type='radio' name='sex' value='男'/>");
				}else{
					pw.println("女:<input disabled='disabled' checked='checked' type='radio' name='sex' value='女'/>");
				}
				pw.println("</td></tr>");
				pw.println("<tr><td>tel:</td><td><input disabled='disabled'type='text' name='tel' value='"+tel+"'/></td></tr>");
				pw.println("<tr><td></td><td><input type='submit' value='submit' /></td></tr>");
				pw.println("</table></form>");
				}
				pw.close();
				DButils.closeConnection(conn);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
