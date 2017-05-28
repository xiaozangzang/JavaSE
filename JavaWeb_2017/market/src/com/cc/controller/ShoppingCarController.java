package com.cc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.Commodity;
import com.cc.bean.ServiceOrder;
import com.cc.bean.ShoppingCar;
import com.cc.json.JPage;
import com.cc.service.CommodityService;
import com.cc.service.OrderService;
import com.cc.service.ShoppingCarService;


@Controller
@RequestMapping(value="shoppingCar")
public class ShoppingCarController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShoppingCarService shoppingCarService;
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			HttpServletRequest request,
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		
		//用户ID
 		Long userId = (Long)request.getSession().getAttribute("userId");
		
		JPage jPage = new JPage();
		jPage.setFilter(String.valueOf(userId));
		jPage.setStartNum(startNum);
		jPage.setPageCount(pageCount);
		
		List<ShoppingCar> list = this.shoppingCarService.queryList(jPage);	
		
		int count = this.shoppingCarService.getCount(userId);
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/ec/shoppingCarList.jsp");
		return mav;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public void add(Long commodityId,HttpServletRequest request) {
		Long userId = (Long)request.getSession().getAttribute("userId");
		Commodity item = this.commodityService.getItemById(commodityId);
		ShoppingCar c = new ShoppingCar();
		c.setCommodityId(commodityId);
		c.setUserId(userId);
		ShoppingCar car = this.shoppingCarService.getItemByCommodityId(c);
		if(car == null){
			car  =  new ShoppingCar();
			car.setCommodityId(commodityId);
			car.setCount(1);
			car.setCreationTime(new Date());
			car.setSupermarketId(item.getSupermarketId());
			car.setUserId(userId);
			this.shoppingCarService.add(car);
		}else{
			car.setCount(car.getCount() + 1);
			this.shoppingCarService.update(car);
		}
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public void delete(Long id,HttpServletRequest request) {
		this.shoppingCarService.delete(id);
	}
	
	@RequestMapping(value = "/addOrder")
	@ResponseBody
	public void addOrder(Long id,HttpServletRequest request) {
		ServiceOrder order = new ServiceOrder();
		Long userId = (Long)request.getSession().getAttribute("userId");
		order.setCreationtime(new Date());
		order.setSendType("自取");
		order.setShoppingCarId(id);
		order.setStatus("审核中");
		order.setUserId(userId);
		this.orderService.add(order);
	}
	
}






