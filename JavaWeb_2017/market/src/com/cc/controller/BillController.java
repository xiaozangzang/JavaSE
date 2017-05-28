package com.cc.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.Bill;
import com.cc.bean.Supermarket;
import com.cc.bean.SupermarketManager;
import com.cc.service.BillService;
import com.cc.service.SupermarketManagerService;
import com.cc.service.SupermarketService;


@Controller
@RequestMapping(value="bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	@Autowired
	private SupermarketManagerService supermarketManagerService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		
		List<Bill> list = this.billService.queryList(startNum,pageCount);
		int count = this.billService.getCount();
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/manage/billList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/queryItem", method = RequestMethod.GET)
	public ModelAndView queryItem(HttpServletRequest request) {
		Long userId = (Long)request.getSession().getAttribute("userId");
		SupermarketManager manage = this.supermarketManagerService.getItemById(userId);
		Long supermarketId = manage.getSupermarketId();
		Bill bill = this.billService.getItemBySupermarketId(supermarketId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",bill);
		mav.setViewName("/marketManage/billList.jsp");
		return mav;
	}
	
	
	
}






