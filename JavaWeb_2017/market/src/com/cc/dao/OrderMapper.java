package com.cc.dao;

import java.util.List;

import com.cc.bean.ServiceOrder;
import com.cc.json.JPage;


public interface OrderMapper {
	public void add(ServiceOrder order);
	
	public List<ServiceOrder> queryList(JPage jPage);
	
	public List<ServiceOrder> queryAllList(JPage jPage);
	
	public int getAllCount(Long supermarketId);
	
	public ServiceOrder getItemById(Long id);
	
	public void update(ServiceOrder order);
}