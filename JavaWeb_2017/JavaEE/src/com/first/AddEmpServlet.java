package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 通过request对象获取浏览器的数据
		// 浏览器将请求信息交给服务器处理
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println("name:" + name);
		System.out.println("pwd:" + pwd);
		// 服务器处理结束之后，将响应结果返回给浏览器
		PrintWriter pw = resp.getWriter();
		pw.println("<h1 style='color:red;'>" + name + "</h1>add Success");
		pw.close();

	}
}
