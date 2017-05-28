package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TwoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();

		// String str = (String)request.getAttribute("keyData");
		HttpSession session = request.getSession();
		// String str = (String)session.getAttribute("keyData");
		ServletContext sc = session.getServletContext();
		String str = (String) sc.getAttribute("keyData");
		pw.println("<h1>OneServlet:success" + str + "</h1>");
		String size = sc.getInitParameter("size");
		String location = sc.getInitParameter("location");
		pw.println("<h1>" + size + " " + location + "</h1>");
	}
}
