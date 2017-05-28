package com.cc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.Supermarket;
import com.cc.bean.SystemAdmin;
import com.cc.service.SystemAdminService;


@Controller
@RequestMapping(value="systemAdmin")
public class SystemAdminController {
	
	@Autowired
	private SystemAdminService systemAdminService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username,String password,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		SystemAdmin admin = this.systemAdminService.getUserByUsername(username);
		if(admin == null || !admin.getPassword().equals(password)){
			mav.addObject("message","用户名或密码错误");
			mav.setViewName("/manage/error.jsp");
		}else{
			mav.setViewName("/manage/main.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", admin.getId());
		}
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Long id, String password) {
		SystemAdmin admin = new SystemAdmin();
		admin.setId(id);
		admin.setPassword(password);
		this.systemAdminService.update(admin);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin.jsp");
		return mav;
	}
}






