package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 统计在线人数 
 * 	有人在线，就创建；有人下线，就销毁
 * @author 张志鹏
 *
 */
public class MySessionListener implements HttpSessionListener{
	private int count;

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("create...");

		count++;
		//获取SerletContext对象
		ServletContext sc = se.getSession().getServletContext();
		sc.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("destroy...");
		count--;
	}

}
