package com.cc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.Bill;
import com.cc.bean.Commodity;
import com.cc.bean.ServiceOrder;
import com.cc.bean.ShoppingCar;
import com.cc.bean.SupermarketManager;
import com.cc.json.JPage;
import com.cc.service.BillService;
import com.cc.service.CommodityService;
import com.cc.service.OrderService;
import com.cc.service.ShoppingCarService;
import com.cc.service.SupermarketManagerService;


@Controller
@RequestMapping(value="order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private SupermarketManagerService supermarketManagerService;
	@Autowired
	private ShoppingCarService shoppingCarService;
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private BillService billService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(HttpServletRequest request) {
		
		//用户ID
 		Long userId = (Long)request.getSession().getAttribute("userId");
		
		JPage jPage = new JPage();
		jPage.setFilter(String.valueOf(userId));
		
		List<ServiceOrder> list = this.orderService.queryList(jPage);	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);

		mav.setViewName("/ec/orderList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/queryAllList", method = RequestMethod.GET)
	public ModelAndView queryAllList(HttpServletRequest request,
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		ModelAndView mav = new ModelAndView();
		//用户ID
 		Long userId = (Long)request.getSession().getAttribute("userId");
 		
 		SupermarketManager manage = this.supermarketManagerService.getItemById(userId);
 		Long supermarketId = manage.getSupermarketId();
		
		JPage jPage = new JPage();
		jPage.setStartNum(startNum);
		jPage.setPageCount(pageCount);
		jPage.setFilter(String.valueOf(supermarketId));
		int currentPage = startNum/pageCount + 1;
		List<ServiceOrder> list = this.orderService.queryAllList(jPage);	
		int count = this.orderService.getAllCount(supermarketId);
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);

		mav.setViewName("/marketManage/orderList.jsp");
		return mav;
	}
	
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	@ResponseBody
	public Map success(HttpServletRequest request,Long id) {
		//用户ID
		Long userId = (Long)request.getSession().getAttribute("userId");
		
		ServiceOrder order = this.orderService.getItemById(id);
		
		Long shoppingCarId = order.getShoppingCarId();
		
		ShoppingCar car = this.shoppingCarService.getItemById(shoppingCarId);
		
		Long commodityId = car.getCommodityId();
		
		Commodity commodity = this.commodityService.getItemById(commodityId);
		
		Long supermarketId = commodity.getSupermarketId();
		
		double price = commodity.getPrice();
		
		int count = car.getCount();
		
		double totalPrice = count * price;
		
		Bill bill = this.billService.getItemBySupermarketId(supermarketId);
		
		if(bill == null){
			bill = new Bill();
			bill.setCut(totalPrice* 0.1);
			bill.setSupermarketId(supermarketId);
			bill.setTotalPrice(totalPrice);
			this.billService.insert(bill);
		}else{
			bill.setCut(bill.getCut() + totalPrice* 0.1);
			bill.setTotalPrice(bill.getTotalPrice() + totalPrice);
			this.billService.update(bill);
		}
		
		order.setStatus("购买成功");
		
		this.orderService.update(order);

		return new HashMap();
	}
	
}






