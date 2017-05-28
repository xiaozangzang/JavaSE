package com.cc.dao;

import java.util.List;

import com.cc.bean.CommodityCategory;
import com.cc.bean.Supermarket;
import com.cc.json.JPage;

public interface CommodityCategoryMapper {
	
	public List<CommodityCategory> queryAllList();
	
	public List<CommodityCategory> queryList(JPage page);
	
	public int getCommodityCategoryCount();
	
	public void delete(Long id);
	
	public CommodityCategory getItemById(Long id);
	
	public void update(CommodityCategory supermarket);
	
	public void insert(CommodityCategory supermarket);
}