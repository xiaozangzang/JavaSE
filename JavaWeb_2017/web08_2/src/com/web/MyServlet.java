package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private String userName = "zs";// Ù–‘
	
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int total = add(3,4);
		out.println("<h1>"+total+"</h1>");
		out.println("<h1>"+userName+"</h1>");
	
		out.flush();
		out.close();
	}

	public int add(int a, int b){
		return a+ b;
	}
}
