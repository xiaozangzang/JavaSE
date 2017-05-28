package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stubr
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//浏览器访问服务器时，服务器查看请求数据中是否有sessionId查找对应的session对象，
		//如果不存在则创建，存在则返回该对象引用
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		Integer count = (Integer)session.getAttribute("count");
		if(count == null){
			count = 1;
		}else{
			count++;
		}
		session.setAttribute("count", count);
		session.setMaxInactiveInterval(30);
		System.out.println(count);
		PrintWriter pw = response.getWriter();
		pw.println("<h1>您是第<span style='color:red;'>"+count+"</span>次访问该网站</h1>");
	}

}
