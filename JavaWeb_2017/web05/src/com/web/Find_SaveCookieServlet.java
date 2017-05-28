package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *   дһ��Find_SaveCookie Servlet:
 ��ȥ��ѯһ������name��cookie,����У���
 ��ʾ��cookie��ֵ�����û�У��򴴽���cookie
 new Cookie("name","zs")��

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
					pw.println("<h1>����cookie</h1>" + "cookieName:"
							+ cookies[i].getName());
					return ;
				}
			}
			Cookie cookie = new Cookie("name", "zs");
			response.addCookie(cookie);
			pw.println("<h1>�Ѵ���zscookie</h1>");

		}
	}
}
