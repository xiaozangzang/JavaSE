package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.Bill;
import com.cc.bean.ServiceOrder;
import com.cc.dao.BillMapper;
import com.cc.json.JPage;

@Service
public class BillService {
	
	@Autowired
	private BillMapper billMapper;

	public List<Bill> queryList(int startNum,int pageCount){
		JPage page = new JPage();
		page.setStartNum(startNum);
		page.setPageCount(pageCount);
		return this.billMapper.queryList(page);
	}
	
	public void update(Bill bill){
		this.billMapper.update(bill);
	}
	
	public void insert(Bill bill){
		this.billMapper.insert(bill);
	}
	

	
	public Bill getItemById(Long id){
		return this.billMapper.getItemById(id);
	}
	
	public int getCount(){
		return this.billMapper.getCount();
	}
	
	public Bill getItemBySupermarketId(Long supermarketId){
		return this.billMapper.getItemBySupermarketId(supermarketId);
	}

	
}
