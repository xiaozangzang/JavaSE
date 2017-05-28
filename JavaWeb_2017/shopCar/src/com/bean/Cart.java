package com.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * 购物车类
 */
public class Cart {
	private List<CartItem> lists = new ArrayList<CartItem>();
	private List<CartItem> recoverLists = new ArrayList<CartItem>();
	/**
	 * 将商品条目添加到购物车里
	 *     item 电脑和数量
	 *     @return false:用户已经买了一件  true:还没有买
	 */
	
	public boolean add(CartItem item){
		for(int i = 0;i < lists.size();i ++){
			CartItem items = lists.get(i);
			if((items.getComputer().getId() ==
				item.getComputer().getId())){
				//购物车已经有一件商品
				return false;
			}
		}
		lists.add(item);
		return true;
	}
	public List<CartItem> getList(){
		return lists;
	}
	public List<CartItem> getRecoverList(){
		return recoverLists;
	}
	
	//清空购物车,全部商品加入回收站
	public void clear(){
		for(int i = 0;i < lists.size();i++){
			CartItem item = lists.get(i);
			recoverLists.add(item);
			lists.remove(i);
		}
	}
	//删除某件商品,将该件商品加入回收站
	public List<CartItem> delete(int id){
		for(int i = 0;i < lists.size();i ++){
			CartItem item = lists.get(i);
			if(item.getComputer().getId() == id){
				recoverLists.add(item);
				lists.remove(i);
			}
		}
		return lists;
	}
	public void modify(int id, int count) {
		for (int i = 0; i < lists.size(); i++) {
			CartItem item = lists.get(i);
			if (item.getComputer().getId() == id) {
				item.setCount(count);
				return;
			}
		}
	}
	//删除回收站，加入购物车
	public void recover(int id) {
		// TODO Auto-generated method stub
		for(int i = 0;i < recoverLists.size();i ++){
			CartItem item = recoverLists.get(i);
			if(item.getComputer().getId() == id ){
				lists.add(item);
				recoverLists.remove(i);
			}
		}
	}
	//从回收站彻底删除
	public void remove(int id) {
		// TODO Auto-generated method stub
		for(int i = 0;i < recoverLists.size();i ++){
			CartItem item = recoverLists.get(i);
			if(item.getComputer().getId() == id ){
				recoverLists.remove(i);
			}
		}
	}
	
	
	
	
	
	
}
