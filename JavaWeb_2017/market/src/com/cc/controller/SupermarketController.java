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

import com.cc.bean.Bill;
import com.cc.bean.Supermarket;
import com.cc.service.BillService;
import com.cc.service.SupermarketService;


@Controller
@RequestMapping(value="supermarket")
public class SupermarketController {
	
	@Autowired
	private SupermarketService supermarketService;
	@Autowired
	private BillService billService;
	
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ModelAndView queryList(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount) {
		
		List<Supermarket> list = this.supermarketService.queryList(startNum,pageCount);
		int count = this.supermarketService.getSupermarketCount();
		int currentPage = startNum/pageCount + 1;
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("count",count);
		mav.addObject("startNum",startNum);
		mav.addObject("pageCount",pageCount);
		mav.addObject("currentPage",currentPage);
		
		mav.setViewName("/manage/supermarketList.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(
			@RequestParam(value = "startNum", defaultValue = "0") int startNum,
			@RequestParam(value = "pageCount", defaultValue = "10") int pageCount,
			Long id) {
		
		this.supermarketService.delete(id);
		
		return this.queryList(startNum, pageCount);
	}
	
	@RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	public ModelAndView getItemById(Long id) {
		
		Supermarket item = this.supermarketService.getItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item);
		mav.setViewName("/manage/supermarketUpdate.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(@RequestParam("picture") CommonsMultipartFile[] picture,
			@RequestParam("name") String name, 
			@RequestParam("phone") String phone, 
			@RequestParam("address") String address, 
			@RequestParam("description") String description,
			HttpServletRequest request) {
		Supermarket item = new Supermarket();
		item.setName(name);
		item.setPhone(phone);
		item.setAddress(address);
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
		
		this.supermarketService.insert(item);
		
		return this.queryList(0,10);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("id") Long id, @RequestParam("picture") CommonsMultipartFile[] picture,
			@RequestParam("name") String name, 
			@RequestParam("phone") String phone, 
			@RequestParam("address") String address, 
			@RequestParam("description") String description,
			HttpServletRequest request) {
		Supermarket item = new Supermarket();
		item.setAddress(address);
		item.setId(id);
		item.setName(name);
		item.setPhone(phone);
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
		this.supermarketService.update(item);

		return this.queryList(0,10);
	}
	
	
}






