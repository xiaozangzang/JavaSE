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
/*
 * cookie�в����Ա������ģ����Ҫ���棬��Ҫ�����Ľ��б���
 * ͬ��cookie��ȡ��ʱ��Ҫ�Խ����Ľ�����н���
 */
public class AddCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//���������б���
		String str = URLEncoder.encode("����","utf-8");
		//���Ҫ��ȡcookie����Ҫ�����������Ľ��н���
//		String name = URLDecoder.decode(str,"utf-8");
		Cookie cookie = new Cookie("userName",str);
		//����cokie������ʱ��
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		Cookie cookie1 = new Cookie("pwd","1234");
		response.addCookie(cookie1);
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Cookie�ɹ�</h1>");
	}

}
