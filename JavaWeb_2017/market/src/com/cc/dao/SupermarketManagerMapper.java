package com.cc.dao;

import java.util.List;

import com.cc.bean.Supermarket;
import com.cc.bean.SupermarketManager;
import com.cc.json.JPage;

public interface SupermarketManagerMapper {
	
	public List<SupermarketManager> queryList(JPage page);
	
	public int getSupermarketManagerCount(long supermarketId);
	
	public void delete(Long id);
	
	public SupermarketManager getItemById(Long id);
	
	public void update(SupermarketManager supermarketManager);
	
	public void updatePassword(SupermarketManager supermarketManager);
	
	public void insert(SupermarketManager supermarketManager);
	
	public SupermarketManager getUserByUsername(String username);
}