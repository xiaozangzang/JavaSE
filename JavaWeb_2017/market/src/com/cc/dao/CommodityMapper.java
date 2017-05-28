package com.cc.dao;

import java.util.List;

import com.cc.bean.Commodity;
import com.cc.json.JPage;

public interface CommodityMapper {
	
	public List<Commodity> queryList(JPage jPage);
	
	public int getCommodityCount(long marketId);

	public int getCount();

	public void delete(long id);
	
	public Commodity getItemById(long id);
	
	public void insert(Commodity commodity);
	
	public void update(Commodity commodity);
}