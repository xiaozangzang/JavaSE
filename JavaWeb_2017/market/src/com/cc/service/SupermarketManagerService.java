package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.Supermarket;
import com.cc.bean.SupermarketManager;
import com.cc.dao.SupermarketManagerMapper;
import com.cc.dao.SupermarketMapper;
import com.cc.json.JPage;

@Service
public class SupermarketManagerService {
	
	@Autowired
	private SupermarketManagerMapper supermarketManagerMapper;

	public List<SupermarketManager> queryList(int startNum,int pageCount,String filter){
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		page.setFilter(filter);
		return this.supermarketManagerMapper.queryList(page);
	}
	
	public void update(SupermarketManager supermarket){
		this.supermarketManagerMapper.update(supermarket);
	}
	
	public void insert(SupermarketManager supermarket){
		this.supermarketManagerMapper.insert(supermarket);
	}
	
	public void delete(Long id){
		this.supermarketManagerMapper.delete(id);
	}
	
	public SupermarketManager getItemById(Long id){
		return this.supermarketManagerMapper.getItemById(id);
	}
	
	public int getSupermarketCount(long supermarketId){
		return this.supermarketManagerMapper.getSupermarketManagerCount(supermarketId);
	}
	
	public void updatePassword(SupermarketManager supermarketManager){
		
		this.supermarketManagerMapper.updatePassword(supermarketManager);
	}
	
	public SupermarketManager getUserByUsername(String username){
		return this.supermarketManagerMapper.getUserByUsername(username);
	}
	
}
