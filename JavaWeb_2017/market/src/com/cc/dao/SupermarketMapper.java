package com.cc.dao;

import java.util.List;

import com.cc.bean.Supermarket;
import com.cc.json.JPage;

public interface SupermarketMapper {
	
	public List<Supermarket> queryList(JPage page);
	
	public int getSupermarketCount();
	
	public void delete(Long id);
	
	public Supermarket getItemById(Long id);
	
	public void update(Supermarket supermarket);
	
	public void insert(Supermarket supermarket);
}