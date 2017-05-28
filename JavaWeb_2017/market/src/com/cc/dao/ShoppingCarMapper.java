package com.cc.dao;

import java.util.List;

import com.cc.bean.ShoppingCar;
import com.cc.json.JPage;


public interface ShoppingCarMapper {
	
	public List<ShoppingCar> queryList(JPage jPage);
	
	public int getCount(long userId);
	
	public void add(ShoppingCar shoppingCar);
	
	public void update(ShoppingCar shoppingCar);
	
	public ShoppingCar getItemById(Long id);
	
	public ShoppingCar getItemByCommodityId(ShoppingCar car);
	
	public void delete(Long id);
}