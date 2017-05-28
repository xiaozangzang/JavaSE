package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
//		String comment = request.getParameter("comment");
//		if(comment.indexOf("dog")>0){
//			pw.println("ÓÐ·Ç·¨×Ö·û");
//			return;
//		}
		pw.println("<h1>service.....</h1>");
		pw.close();
	}

}
