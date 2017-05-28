package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		PrintWriter pw = response.getWriter();
		if(path.equals("/validUserName")){
			//验证网络延迟
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = request.getParameter("username");
			System.out.println("name:"+name);
			if(name.equals("zs")){
				pw.println("用户名已存在");
				System.out.println("用户名已存在");
			}else{
				pw.println("可以使用");
				System.out.println("可以使用");
			}
		}else if(path.equals("/validPwd")){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String pwd = request.getParameter("MyPwd");
			if(pwd.equals("123")){
				pw.println("密码正确");
				System.out.println("密码正确");
			}else{
				pw.println("密码错误");
				System.out.println("密码错误");
			}
		}
		
		if(path.equals("/regist")){
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			if(name.equals("zs")){
				request.setAttribute("regist_err","user exist");
			}else{
				request.setAttribute("regist_err","ok");
			}
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
	}
}





