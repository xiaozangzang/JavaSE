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
		//�������������
		String comment = request.getParameter("comment");
		PrintWriter pw = response.getWriter();
		if(comment.indexOf(config.getInitParameter("name"))>0){
			pw.println("�˻�������dog");
		}else{
			pw.println("��������"+comment);
			chain.doFilter(request, response);//���ú����Ĺ�����
		}
	}
	/**
	 * ��ʼ������
	 * ������ʵ���������������ʱ��ͻᴴ�����������ֻ��ִ��һ��
	 * ServletConfig -- �ӿ� ��ȡweb.xml�����е�servlet�����ò���
	 * FilterConfig -- �ӿ� ��ȡweb.xml�����еĹ����������ò���
	 * init�������ý�����FilterConfig�ͻ����٣�Ϊ����doFilter��ʹ��
	 * FilterConfig������ͨ������ȫ�ֱ�������ʽ����FilterConfig��������
	 */

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println();
		config = filterConfig;
	}

}
