package com.cc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.SupermarketManager;
import com.cc.service.SupermarketManagerService;


@Controller
@RequestMapping(value="supermarketManager")
public class SupermarketManagerController {
	
	@Autowired
	private SupermarketManagerService supermarketManagerService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount,
			@RequestParam(value = "id", defaultValue = "0") long id

			) {
		
		List<SupermarketManager> list = this.supermarketManagerService.queryList(startNum,pageCount,String.valueOf(id));
		int count = this.supermarketManagerService.getSupermarketCount(id);
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		mav.addObject("supermarketId",id);

		mav.setViewName("/manage/supermarketManagerList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount,
			long id) {
		SupermarketManager manager=this.supermarketManagerService.getItemById(id);
		long superketId=manager.getSupermarketId();
		this.supermarketManagerService.delete(id);
		
		return this.queryList(startNum, pageCount,superketId);
	}
	
	@RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	public ModelAndView getItemById(Long id) {
		
		SupermarketManager item = this.supermarketManagerService.getItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item);
		mav.setViewName("/manage/supermarketManagerUpdate.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(
			@RequestParam("username") String username, 
			@RequestParam("password") String password, 
			@RequestParam("supermarketId") long supermarketId, 

			HttpServletRequest request) {
		SupermarketManager item = new SupermarketManager();
		item.setUsername(username);
		item.setPhone("");
        item.setPassword(password);
        item.setSupermarketId(supermarketId);
		this.supermarketManagerService.insert(item);
		return this.queryList(0,10,supermarketId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Long id, String username, String phone,String password) {
		SupermarketManager item = this.supermarketManagerService.getItemById(id);
		item.setUsername(username);
		item.setPhone(phone);
		item.setPassword(password);
		this.supermarketManagerService.update(item);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/marketAdmin.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		SupermarketManager admin = this.supermarketManagerService.getUserByUsername(username);
		if(admin == null || !admin.getPassword().equals(password)){
			mav.addObject("message","用户名或密码错误");
			mav.setViewName("/marketManage/error.jsp");
		}else{
			mav.setViewName("/marketManage/main.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userId", admin.getId());
		}
		return mav;
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(Long id, String password) {
		SupermarketManager item = this.supermarketManagerService.getItemById(id);
		item.setPassword(password);;
		this.supermarketManagerService.update(item);

		return this.queryList(0,10,item.getSupermarketId());
	}
	
}






