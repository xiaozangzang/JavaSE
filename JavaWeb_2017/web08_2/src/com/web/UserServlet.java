package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.service.UserServiceImpl;

public class UserServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(path);
		UserDao dao = new UserDaoImpl();
		UserServiceImpl service = new UserServiceImpl();
		service.setDao(dao);
		if (path.equals("/regist")) {
			String num = request.getParameter("number");
			HttpSession session = request.getSession();
			String num1 = (String) session.getAttribute("code");
			if (!num.equals(num1)) {
				request.setAttribute("code_err", "��֤�����");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			}
			String userName = request.getParameter("username");
			// �����û��������û��Ƿ���ڣ�������ڣ�������һ����ʾ����������ע�����
			try {
				if (userName == null || userName.equals("")) {
					request.setAttribute("regist_err", "�û�������Ϊ��");
					request.getRequestDispatcher("/regist.jsp").forward(
							request, response);
				} else {
					String name = request.getParameter("name");
					String password = request.getParameter("password");
					String sex = request.getParameter("sex");
					int age = Integer.valueOf(request.getParameter("age"));
					String phone = request.getParameter("phone");
					User user = service.findUserByName(userName);
					System.out.println(user);
					if (user == null) {
						User u = new User(userName, name, password, age, sex,
								phone);
						System.out.println(u + "dsa");
						service.add(u);
						response.sendRedirect(request.getContextPath()
								+ "/login.jsp");
					} else {
						request.setAttribute("regist_err", "�û��Ѵ��ڣ�������ע��");
						request.getRequestDispatcher("/regist.jsp").forward(
								request, response);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (path.equals("/login")) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			try {
				User user = service.findUserByName(userName);
				if (user != null && user.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					//����¼�û�user����Ϣ������session
					session.setAttribute("login_success", user);
					response.sendRedirect(request.getContextPath()
							+ "/userList.do");
				} else {
					request.setAttribute("login_err", "�û������������");
					request.getRequestDispatcher("/login.jsp").forward(request,
							response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ��ʾ�����û���Ϣ
		} else if (path.equals("/userList")) {
			List<User> list = new ArrayList<User>();

			try {
				list = service.listUser();
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("login_success");
				request.setAttribute("list", list);
				System.out.println(list.toString());
				request.getRequestDispatcher("/userList.jsp").forward(request,
						response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("/detail")){
			try {
				String userName = request.getParameter("detailName");
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("login_success");
				User user1 = service.findUserByName(userName);
				request.setAttribute("user", user1);
				request.getRequestDispatcher("/userDetail.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(path.equals("/upload")){
			
		}

	}
}
