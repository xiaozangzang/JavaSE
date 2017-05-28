package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   写一个Find_SaveCookie Servlet:
 先去查询一个名叫name的cookie,如果有，则
 显示该cookie的值，如果没有，则创建该cookie
 new Cookie("name","zs")。

 */
public class Find_SaveCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = request.getCookies();
		PrintWriter pw = response.getWriter();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					pw.println("<h1>存在cookie</h1>" + "cookieName:"
							+ cookies[i].getName());
					return ;
				}
			}
			Cookie cookie = new Cookie("name", "zs");
			response.addCookie(cookie);
			pw.println("<h1>已创建zscookie</h1>");

		}
	}
}
