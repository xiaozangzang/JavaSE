package com.cc.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cc.bean.Commodity;
import com.cc.bean.CommodityCategory;
import com.cc.bean.SupermarketManager;
import com.cc.json.JPage;
import com.cc.service.CommodityCategoryService;
import com.cc.service.CommodityService;
import com.cc.service.SupermarketManagerService;


@Controller
@RequestMapping(value="commodity")
public class CommodityController {
	
	@Autowired
	private CommodityCategoryService commodityCategoryService;
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private SupermarketManagerService supermarketManagerService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			HttpServletRequest request,
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		
		//超市管理员id
 		Long userId = (Long)request.getSession().getAttribute("userId");
		//获取超市管理员信息
		SupermarketManager admin = this.supermarketManagerService.getItemById(userId);
		//超市ID
		Long marketId = admin.getSupermarketId();
		JPage jPage = new JPage();
		jPage.setFilter(String.valueOf(marketId));
		jPage.setStartNum(startNum);
		jPage.setPageCount(pageCount);
		
		List<Commodity> list = this.commodityService.queryList(jPage);
		List<CommodityCategory> categoryList = this.commodityCategoryService.queryAllList();
		int count = this.commodityService.getCommodityCount(marketId);
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("categoryList",categoryList);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/marketManage/commodityList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/userQueryList", method = RequestMethod.GET)
	public ModelAndView userQueryList(
			HttpServletRequest request,
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		
		JPage jPage = new JPage();
		jPage.setStartNum(startNum);
		jPage.setPageCount(pageCount);
		List<Commodity> list = this.commodityService.queryList(jPage);
		List<CommodityCategory> categoryList = this.commodityCategoryService.queryAllList();
		int count = this.commodityService.getCount();
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("categoryList",categoryList);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/ec/commodityList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(
			HttpServletRequest request,
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount,
			Long id) {
		
		this.commodityService.delete(id);
		
		return this.queryList(request,startNum, pageCount);
	}
	
	@RequestMapping(value = "/beforeAdd", method = RequestMethod.GET)
	public ModelAndView beforeAdd(
			HttpServletRequest request) {
		//获取所有分类
		List<CommodityCategory> list = this.commodityCategoryService.queryAllList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("/marketManage/commodityAdd.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	public ModelAndView getItemById(Long id) {
		Commodity item = this.commodityService.getItemById(id);
		ModelAndView mav = new ModelAndView();
		//获取所有分类
		List<CommodityCategory> list = this.commodityCategoryService.queryAllList();
		mav.addObject("item",item);
		mav.addObject("list",list);
		mav.setViewName("/marketManage/commodityUpdate.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(@RequestParam("picture") CommonsMultipartFile[] picture,
			@RequestParam("name") String name, 
			@RequestParam("categoryId") long categoryId, 
			@RequestParam("price") double price, 
			@RequestParam("description") String description,
			HttpServletRequest request) {
		//超市管理员id
 		Long userId = (Long)request.getSession().getAttribute("userId");
		//获取超市管理员信息
		SupermarketManager admin = this.supermarketManagerService.getItemById(userId);
		//超市ID
		Long marketId = admin.getSupermarketId();
		
		Commodity item = new Commodity();
		item.setSupermarketId(marketId);
		item.setName(name);
		item.setCategoryId(categoryId);
		item.setPrice(price);
		item.setDescription(description);
		for(int i = 0;i<picture.length;i++){          
            if(!picture[i].isEmpty()){  
                try {  
                	String path = request.getSession().getServletContext().getRealPath("/img");
                	Long time = new Date().getTime();
                    //拿到输出流，同时重命名上传的文件  
                    FileOutputStream os = new FileOutputStream(path+"/"+time + picture[i].getOriginalFilename());  
                    //拿到上传文件的输入流  
                    FileInputStream in = (FileInputStream) picture[i].getInputStream();  
                      
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();   
                    item.setPicture("/"+time + picture[i].getOriginalFilename());
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }
		
		this.commodityService.insert(item);

		return this.queryList(request,0,10);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("id") Long id, @RequestParam("picture") CommonsMultipartFile[] picture,
			@RequestParam("name") String name, 
			@RequestParam("categoryId") long categoryId, 
			@RequestParam("price") double price, 
			@RequestParam("description") String description,
			HttpServletRequest request) {
		//超市管理员id
 		Long userId = (Long)request.getSession().getAttribute("userId");
		//获取超市管理员信息
		SupermarketManager admin = this.supermarketManagerService.getItemById(userId);
		//超市ID
		Long marketId = admin.getSupermarketId();
		
		Commodity item = new Commodity();
		item.setId(id);
		item.setSupermarketId(marketId);
		item.setName(name);
		item.setCategoryId(categoryId);
		item.setPrice(price);
		item.setDescription(description);
		for(int i = 0;i<picture.length;i++){          
            if(!picture[i].isEmpty()){  
                try {  
                	String path = request.getSession().getServletContext().getRealPath("/img");
                	Long time = new Date().getTime();
                    //拿到输出流，同时重命名上传的文件  
                    FileOutputStream os = new FileOutputStream(path+"/"+time + picture[i].getOriginalFilename());  
                    //拿到上传文件的输入流  
                    FileInputStream in = (FileInputStream) picture[i].getInputStream();  
                      
                    //以写字节的方式写文件  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();   
                    item.setPicture("/"+time + picture[i].getOriginalFilename());
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }
		this.commodityService.update(item);

		return this.queryList(request,0,10);
	}
	
	
}






