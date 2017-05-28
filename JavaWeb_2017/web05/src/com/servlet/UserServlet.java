package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.service.UserService;
import com.service.UserServiceImpl;

public class UserServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		UserDao dao = new UserDaoImpl();
		UserServiceImpl service = new UserServiceImpl();
		service.setDao(dao);
		if(path.equals("/regist")){
			String num = request.getParameter("number");
			HttpSession session = request.getSession();
			String num1 = (String)session.getAttribute("code");
			if(!num.equals(num1)){
				request.setAttribute("code_err", "��֤�����");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
				return;
			}
			String userName = request.getParameter("username");
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			//�����û��������û��Ƿ���ڣ�������ڣ�������һ����ʾ����������ע�����
			try {
				if(userName == null || userName.equals("")){
					request.setAttribute("regist_err", "�û�������Ϊ��");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);
				}else{
					User user = service.findByUserName(userName);
					if(user == null){
						User u = new User(userName, name, password, sex);
						service.add(u);
						response.sendRedirect(request.getContextPath()+"/login.jsp");
					}else{
						request.setAttribute("regist_err", "�û��Ѵ��ڣ�������ע��");
						request.getRequestDispatcher("/regist.jsp").forward(request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(path.equals("/login")){
			String userName = request.getParameter("name");
			String password = request.getParameter("password");
			try {
				User user = service.findByUserName(userName);
				if(user != null && user.getPassword().equals(password)){
					HttpSession session = request.getSession();
					session.setAttribute("login_success", user);
					response.sendRedirect(request.getContextPath()+"/main.jsp");
				}else{
					request.setAttribute("login_err", "�û������������");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
