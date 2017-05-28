package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * ͳ���������� 
 * 	�������ߣ��ʹ������������ߣ�������
 * @author ��־��
 *
 */
public class MySessionListener implements HttpSessionListener{
	private int count;

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("create...");

		count++;
		//��ȡSerletContext����
		ServletContext sc = se.getSession().getServletContext();
		sc.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("destroy...");
		count--;
	}

}
