package com.cc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.bean.ShoppingCar;
import com.cc.dao.ShoppingCarMapper;
import com.cc.json.JPage;

@Service
public class ShoppingCarService {
	
	@Autowired
	private ShoppingCarMapper shoppingCarMapper;
	
	public List<ShoppingCar> queryList(JPage jPage){
		return this.shoppingCarMapper.queryList(jPage);
	}
	
	public int getCount(long userId){
		return this.shoppingCarMapper.getCount(userId);
	}
	
	public ShoppingCar getItemById(Long id){
		return this.shoppingCarMapper.getItemById(id);
	}
	
	public ShoppingCar getItemByCommodityId(ShoppingCar car){
		return this.shoppingCarMapper.getItemByCommodityId(car);
	}
	
	public void add(ShoppingCar shoppingCar){
		this.shoppingCarMapper.add(shoppingCar);
	}
	
	public void update(ShoppingCar shoppingCar){
		this.shoppingCarMapper.update(shoppingCar);
	}
	
	public void delete(Long id){
		this.shoppingCarMapper.delete(id);
	}
}
