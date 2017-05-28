package com.some;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * 获取web.xml配置中的数据
		 */
		ServletConfig config = getServletConfig();
		String value = config.getInitParameter("pageSize");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>"+value+"</h1>");
		String str = req.getParameter("name");
		pw.println("<h1>"+str+"</h1>");
		String[] str1 = req.getParameterValues("name");
		for (String s : str1) {
			pw.println("<h1>"+s+"</h1>");
		}
	}
}
