package com.cc.dao;

import java.util.List;

import com.cc.bean.Bill;
import com.cc.bean.ServiceOrder;
import com.cc.bean.Supermarket;
import com.cc.json.JPage;

public interface BillMapper {
	
	public List<Bill> queryList(JPage page);
	
	public int getCount();
	
	
	public Bill getItemById(Long id);
	
	public void update(Bill bill);
	
	public void insert(Bill bill);
	
	public Bill getItemBySupermarketId(Long supermarketId);
}