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
 * cookie中不可以保存中文，如果要保存，需要对中文进行编码
 * 同样cookie获取的时候，要对解码后的结果进行解码
 */
public class AddCookieServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//对张三进行编码
		String str = URLEncoder.encode("张三","utf-8");
		//如果要读取cookie，需要将编码后的中文进行解码
//		String name = URLDecoder.decode(str,"utf-8");
		Cookie cookie = new Cookie("userName",str);
		//设置cokie的生存时间
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		Cookie cookie1 = new Cookie("pwd","1234");
		response.addCookie(cookie1);
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Cookie成功</h1>");
	}

}
