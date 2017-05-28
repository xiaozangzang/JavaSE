package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.CommodityCategory;
import com.cc.bean.Supermarket;
import com.cc.dao.CommodityCategoryMapper;
import com.cc.dao.SupermarketMapper;
import com.cc.json.JPage;

@Service
public class CommodityCategoryService {
	
	@Autowired
	private CommodityCategoryMapper commodityCategoryMapper;

	public List<CommodityCategory> queryAllList(){
		
		return this.commodityCategoryMapper.queryAllList();
	}
	
	public List<CommodityCategory> queryList(JPage page){
//		 = new JPage();
//		page.setStartNum(startNum);
//		page.setPageCount(pageCount);
		return this.commodityCategoryMapper.queryList(page);
	}
	
	public void update(CommodityCategory category){
		this.commodityCategoryMapper.update(category);
	}
	
	public void insert(CommodityCategory category){
		this.commodityCategoryMapper.insert(category);
	}
	
	public void delete(Long id){
		this.commodityCategoryMapper.delete(id);
	}
	
	public CommodityCategory getItemById(Long id){
		return this.commodityCategoryMapper.getItemById(id);
	}
	
	public int getSupermarketCount(){
		return this.commodityCategoryMapper.getCommodityCategoryCount();
	}
	
}
