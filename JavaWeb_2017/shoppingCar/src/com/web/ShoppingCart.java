package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.CartItem;
import com.dao.ComputerDAO;
import com.entity.Computer;


public class ShoppingCart extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String uri = request.getRequestURI();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
			if(path.equals("/list")){
				ComputerDAO dao = 
					new ComputerDAO();
				try {
					List<Computer> computers = 
						dao.findAll();
					request.setAttribute("computers", computers);
					request.getRequestDispatcher("computer_list.jsp")
					.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}
			}
			if(path.equals("/buy")){
				String id = request.getParameter("id");
				ComputerDAO dao = 
					new ComputerDAO();
				try {
					Computer c = 
						dao.findById(Long.parseLong(id));
					HttpSession session = 
						request.getSession();
					Cart cart = (Cart)session.getAttribute("cart");
					if(cart == null){
						cart = new Cart();
						session.setAttribute("cart", cart);
					}
					CartItem item = new CartItem();
					item.setC(c);
					item.setQty(1);
					boolean flag = cart.add(item);
					if(!flag){
						request.setAttribute("buy_err_" + id, "已添加至购物车");
						request.getRequestDispatcher("list.do")
						.forward(request, response);
					}else{
						response.sendRedirect("list.do");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				} 
			}
			if(path.equals("/delete")){
				String id = request.getParameter("id");
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				cart.delete(Long.parseLong(id));
				request.getRequestDispatcher("cart.jsp")
				.forward(request, response);
			}
			if(path.equals("/clear")){
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				cart.clear();
				request.getRequestDispatcher("cart.jsp")
				.forward(request, response);
			}
			if(path.equals("/modify")){
				String id = request.getParameter("id");
				String qty = request.getParameter("num");
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				cart.modify(Long.parseLong(id), Integer.parseInt(qty));
				request.getRequestDispatcher("cart.jsp")
				.forward(request, response);
			}
			
	}

}
