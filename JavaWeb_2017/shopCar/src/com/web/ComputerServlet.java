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
		//����Ʒ������Ϣ��ʾ
		if(path.equals("/list")){
			//�����ݿ��л�ȡ��Ϣ
			try {
				List<Computer> lists = dao.findAll();
				//��lists����ת����jsp���棬��ʾ�鵽����Ϣ
				request.setAttribute("lists", lists);
				request.getRequestDispatcher("/computer_list.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��һ����Ʒ����������Ʒ���빺�ﳵ�������ﳵ����session
		}else if(path.equals("/buy")){
			//���ݵ��Ե�id��ȡһ̨����
			int buyId = Integer.parseInt(request.getParameter("buyId"));
			try {
				Computer computer = dao.findByComputer(buyId);
				//����һ�����ﳵ  �����ﳵ����session
				HttpSession session = request.getSession();
				Cart cart = (Cart)session.getAttribute("cart");
				if(cart == null){//֤��session��֮ǰû�й��ﳵ
					cart = new Cart();
					session.setAttribute("cart", cart);
				}
				//���ﳵ�����CartItem
				CartItem item = new CartItem();
				item.setComputer(computer);
				item.setCount(1);
				boolean flag = cart.add(item);
				//���ݹ���ķ���ֵ��ȷ���Ƿ��ǵ�һ�ι���
				if(flag){
					//��һ�ι���
					response.sendRedirect(request.getContextPath()+"/list.do");
				}else{
					//���û���ʾ���Ѿ����������Ʒ�ˣ�ת��
					request.setAttribute("buy_err"+computer.getId(), "����Ʒ�Ѽ��빺�ﳵ��");
					request.getRequestDispatcher(request.getContextPath()+"/list.do").forward(request,response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��չ��ﳵ����������Ʒȫ���������վ
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
			//�ӻ���վ��ָ�
		}else if(path.equals("/recover")){
			String id = request.getParameter("recoverId");
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			cart.recover(Integer.valueOf(id));
			request.getRequestDispatcher("/cart.jsp")
			.forward(request, response);
			//����ɾ������վ�е���Ʒ
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
