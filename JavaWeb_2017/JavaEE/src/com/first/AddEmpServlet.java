package com.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ͨ��request�����ȡ�����������
		// �������������Ϣ��������������
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println("name:" + name);
		System.out.println("pwd:" + pwd);
		// �������������֮�󣬽���Ӧ������ظ������
		PrintWriter pw = resp.getWriter();
		pw.println("<h1 style='color:red;'>" + name + "</h1>add Success");
		pw.close();

	}
}
