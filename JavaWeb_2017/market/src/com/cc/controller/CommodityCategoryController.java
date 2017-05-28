package com.cc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.CommodityCategory;
import com.cc.bean.Supermarket;
import com.cc.json.JPage;
import com.cc.service.CommodityCategoryService;
import com.cc.service.SupermarketService;


@Controller
@RequestMapping(value="commodityCategory")
public class CommodityCategoryController {
	
	@Autowired
	private CommodityCategoryService commodityCategoryService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		List<CommodityCategory> list = this.commodityCategoryService.queryList(page);
		int count = this.commodityCategoryService.getSupermarketCount();
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/manage/commodityCategoryList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount,
			Long id) {
		
		this.commodityCategoryService.delete(id);
		
		return this.queryList(startNum, pageCount);
	}
	
	@RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	public ModelAndView getItemById(Long id) {
		
		CommodityCategory item = this.commodityCategoryService.getItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item);
		mav.setViewName("/manage/commodityCategoryUpdate.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(String name) {
		CommodityCategory item = new CommodityCategory();
		item.setName(name);
		this.commodityCategoryService.insert(item);

		return this.queryList(0,10);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Long id, String name) {
		CommodityCategory item = new CommodityCategory();
		item.setId(id);
		item.setName(name);
		this.commodityCategoryService.update(item);

		return this.queryList(0,10);
	}
	
	
}






