package com.cc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.User;
import com.cc.service.UserService;


@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username,String password,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		User user = this.userService.getUserByUsername(username);
		if(user == null || !user.getPassword().equals(password)){
			mav.addObject("message","用户名或密码错误");
			mav.setViewName("/ec/error.jsp");
		}else{
			mav.setViewName("/ec/main.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", user.getId());
			session.setAttribute("phone", user.getPhone());
			session.setAttribute("address", user.getAddress());

		}
		return mav;
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(
			String username,
			String password,
			String phone,
			String address,
			HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);
		
		this.userService.insert(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ec/main.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("userId", user.getId());
		return mav;
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(
			String username,
			String password,
			String phone,
			String address,
			HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("userId"));
		User user = this.userService.getUserById((Long)request.getSession().getAttribute("userId"));
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);
		
		this.userService.update(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/ec/main.jsp");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("userId", user.getId());
		return mav;
	}
}






