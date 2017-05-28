package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.Commodity;
import com.cc.dao.CommodityMapper;
import com.cc.json.JPage;

@Service
public class CommodityService {
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	public List<Commodity> queryList(JPage jPage){
		return this.commodityMapper.queryList(jPage);
	}
	public int getCommodityCount(Long marketId){
		return this.commodityMapper.getCommodityCount(marketId);
	}
	
	public int getCount(){
		return this.commodityMapper.getCount();
	}
	
	public void delete(Long id){
		this.commodityMapper.delete(id);
	}
	public Commodity getItemById(Long id){
		return this.commodityMapper.getItemById(id);
	}
	
	public void insert(Commodity commodity){
		this.commodityMapper.insert(commodity);
	}
	
	public void update(Commodity commodity){
		this.commodityMapper.update(commodity);
	}

}
