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
import com.dao.ComputerDao;
import com.dao.ComputerDaoImpl;
import com.entity.Computer;

public class ComputerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(path);
		ComputerDao dao = new ComputerDaoImpl();
		//将商品所有信息显示
		if(path.equals("/list")){
			//从数据库中获取信息
			try {
				List<Computer> lists = dao.findAll();
				//将lists集合转发到jsp界面，显示查到的信息
				request.setAttribute("lists", lists);
				request.getRequestDispatcher("/computer_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//买一件商品，并将该商品加入购物车，将购物车交给session
		}else if(path.equals("/buy")){
			//根据电脑的id获取一台电脑
			int buyId = Integer.parseInt(request.getParameter("buyId"));
			try {
				Computer computer = dao.findByComputer(buyId);
				//创建一个购物车  将购物车交给session
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				if(cart == null){//证明session中之前没有购物车
					cart = new Cart();
					session.setAttribute("cart", cart);
				}
				//购物车中添加CartItem
				CartItem item = new CartItem();
				item.setComputer(computer);
				item.setCount(1);
				boolean flag = cart.add(item);
				//根据购买的返回值，确定是否是第一次购买
				if(flag){
					//第一次购买
					response.sendRedirect(request.getContextPath()+"/list.do");
				}else{
					//给用户提示，已经购买过此商品了，转发
					request.setAttribute("buy_err"+computer.getId(), "该商品已加入购物车！");
					request.getRequestDispatcher(request.getContextPath()+"/list.do").forward(request,response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//清空购物车，将所有商品全部加入回收站
		}else if(path.equals("/clear")){
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			cart.clear();
			response.sendRedirect(request.getContextPath()+"/cart.jsp");
		}else if(path.equals("/delete")){
			int id = Integer.valueOf(request.getParameter("id"));
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			List<CartItem> lists = cart.delete(id);
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}else if(path.equals("/modify")){
			String id = request.getParameter("id");
			String count = request.getParameter("num");
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			cart.modify(Integer.valueOf(id), Integer.parseInt(count));
			request.getRequestDispatcher("/cart.jsp")
			.forward(request, response);
			//从回收站里恢复
		}else if(path.equals("/recover")){
			String id = request.getParameter("recoverId");
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.recover(Integer.valueOf(id));
			request.getRequestDispatcher("/cart.jsp")
			.forward(request, response);
			//彻底删除回收站中的商品
		}else if(path.equals("/remove")){
			String id = request.getParameter("removeId");
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.remove(Integer.valueOf(id));
			request.getRequestDispatcher("/cart.jsp")
			.forward(request, response);
		}
		
	}

}
