package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterExample implements Filter{
	private FilterConfig config;

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory....");
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接受请求的数据
		String comment = request.getParameter("comment");
		PrintWriter pw = response.getWriter();
		if(comment.indexOf(config.getInitParameter("name"))>0){
			pw.println("此话语中有dog");
		}else{
			pw.println("过滤器："+comment);
			chain.doFilter(request, response);//调用后续的过滤器
		}
	}
	/**
	 * 初始化数据
	 * 拦截器实例是在启动服务的时候就会创建，这个方法只会执行一次
	 * ServletConfig -- 接口 获取web.xml配置中的servlet的配置参数
	 * FilterConfig -- 接口 获取web.xml配置中的过滤器的配置参数
	 * init方法调用结束后，FilterConfig就会销毁，为了在doFilter中使用
	 * FilterConfig，可以通过创建全局变量的形式，将FilterConfig保存下来
	 */

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println();
		config = filterConfig;
	}

}
