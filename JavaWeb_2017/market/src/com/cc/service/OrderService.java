package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.ServiceOrder;
import com.cc.dao.OrderMapper;
import com.cc.json.JPage;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	public void add(ServiceOrder order){
		this.orderMapper.add(order);
	}
	
	public List<ServiceOrder> queryList(JPage jPage){
		return this.orderMapper.queryList(jPage);
	}
	
	public List<ServiceOrder> queryAllList(JPage jPage){
		return this.orderMapper.queryAllList(jPage);
	}
	
	public int getAllCount(Long supermarketId){
		return this.orderMapper.getAllCount(supermarketId);
	}
	
	public ServiceOrder getItemById(Long id){
		return this.orderMapper.getItemById(id);
	}
	
	public void update(ServiceOrder order){
		this.orderMapper.update(order);
	}
	
}
