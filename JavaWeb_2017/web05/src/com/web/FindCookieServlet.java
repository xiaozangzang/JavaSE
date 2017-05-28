package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 查找cookie
		PrintWriter pw = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String cookieName = cookie.getName();
				//对cookieValue进行转码，utf-8       URLDecoder.decode(value,"utf-8");
				String cookieValue = URLDecoder.decode(cookie.getValue(),"utf-8");
				pw.println("<h1>cookieName:" + cookieName + "    cookieValue:"
						+ cookieValue + "</h1>");
			}
		} else {
			pw.println("<h1>没有查找到cookie</h1>");
		}

	}
}
