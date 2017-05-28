package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.Supermarket;
import com.cc.dao.SupermarketMapper;
import com.cc.json.JPage;

@Service
public class SupermarketService {
	
	@Autowired
	private SupermarketMapper supermarketMapper;

	public List<Supermarket> queryList(int startNum,int pageCount){
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		return this.supermarketMapper.queryList(page);
	}
	
	public void update(Supermarket supermarket){
		this.supermarketMapper.update(supermarket);
	}
	
	public void insert(Supermarket supermarket){
		this.supermarketMapper.insert(supermarket);
	}
	
	public void delete(Long id){
		this.supermarketMapper.delete(id);
	}
	
	public Supermarket getItemById(Long id){
		return this.supermarketMapper.getItemById(id);
	}
	
	public int getSupermarketCount(){
		return this.supermarketMapper.getSupermarketCount();
	}
	
}
