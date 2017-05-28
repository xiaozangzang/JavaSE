package com.bean;

import java.util.ArrayList;
import java.util.List;

/*
 * ���ﳵ��
 */
public class Cart {
	private List<CartItem> lists = new ArrayList<CartItem>();
	private List<CartItem> recoverLists = new ArrayList<CartItem>();
	/**
	 * ����Ʒ��Ŀ��ӵ����ﳵ��
	 *     item ���Ժ�����
	 *     @return false:�û��Ѿ�����һ��  true:��û����
	 */
	
	public boolean add(CartItem item){
		for(int i = 0;i < lists.size();i ++){
			CartItem items = lists.get(i);
			if((items.getComputer().getId() ==
				item.getComputer().getId())){
				//���ﳵ�Ѿ���һ����Ʒ
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
	
	//��չ��ﳵ,ȫ����Ʒ�������վ
	public void clear(){
		for(int i = 0;i < lists.size();i++){
			CartItem item = lists.get(i);
			recoverLists.add(item);
			lists.remove(i);
		}
	}
	//ɾ��ĳ����Ʒ,���ü���Ʒ�������վ
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
	//ɾ������վ�����빺�ﳵ
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
	//�ӻ���վ����ɾ��
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
