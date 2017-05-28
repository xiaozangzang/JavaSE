package com.web;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.dao.PersonDaoImp1;
import com.entity.Person;
import com.service.PersonService;
import com.service.PersonServiceImp1;

public class PersonServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String path = 
			uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
//		System.out.println(path);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PersonDao dao = new PersonDaoImp1();
		PersonService service = new PersonServiceImp1(dao);
		PrintWriter out = response.getWriter();
		
		if(path.equals("/list")){
			List<Person> lists = service.findAll();
//			System.out.println(lists.toString()+"哈哈");
			//1.将list集合保存到request对象当中
			request.setAttribute("lists", lists);
			//2. 将lists集合转发到哪个组件进行显示
//			RequestDispatcher dispatcher = 
//			request.getRequestDispatcher("list.jsp");
//			dispatcher.forward(request,response);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		}else if(path.equals("/view")){
			Person p = new Person();
			p = service.findById(Integer.valueOf(request.getParameter("viewId")));
			List<Person> lists = new ArrayList<Person>();
			lists.add(p);
			System.out.println(lists.toString().toString());
			request.setAttribute("lists", lists);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		}else if(path.equals("/add")){
			Person p = new Person();
			p.setName(request.getParameter("name"));
			p.setSalary(request.getParameter("salary"));
			p.setAge(request.getParameter("age"));
			service.save(p);
			response.sendRedirect("list.do");

//			request.getRequestDispatcher("list.do").forward(request, response);

		}else if(path.equals("/modify")){
			int id = Integer.valueOf(request.getParameter("modId"));
			Person p = new Person();
			p = service.findById(id);
			request.setAttribute("p", p);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}else if(path.equals("/update")){
			Person p = new Person();
			System.out.println(request.getParameter("id"));
			p.setId(Integer.valueOf(request.getParameter("id")));
			p.setName(request.getParameter("name"));
			p.setSalary(request.getParameter("salary"));
			p.setAge(request.getParameter("age"));
			service.update(p);
			response.sendRedirect("list.do");
//			request.getRequestDispatcher("list.do").forward(request, response);

		}else if(path.equals("/delete")){
			int id = Integer.valueOf(request.getParameter("delId"));
			service.delete(id);
			response.sendRedirect("list.do");
//			request.getRequestDispatcher("list.do").forward(request, response);

		}
		
	}

}
