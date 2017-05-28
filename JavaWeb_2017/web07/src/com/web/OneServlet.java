package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 如何获得其实例：
        a, GenericServlet.getServletContext();
        b, ServletConfig.getServletContext();
        c, HttpSession.getServletContext();
 *
 * @author 张志鹏
 */
public class OneServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		ServletContext sc = getServletContext();
		sc.setAttribute("keyDate", "valueDate");
//		String size = sc.getContext("");
		String str = (String)sc.getAttribute("keyDate");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>"+str+"</h1>");
	}

}
