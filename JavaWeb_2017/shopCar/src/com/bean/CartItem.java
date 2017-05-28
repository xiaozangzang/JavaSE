package com.bean;

import com.entity.Computer;

/*
 * 商品条目类
 * 	 每个条目对象封装了一台电脑和这台电脑所对应的数量
 */
public class CartItem {
	private Computer computer;
	private int count;
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CartItem() {
		super();
	}
	public CartItem(Computer computer, int count) {
		super();
		this.computer = computer;
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((computer == null) ? 0 : computer.hashCode());
		result = prime * result + count;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (computer == null) {
			if (other.computer != null)
				return false;
		} else if (!computer.equals(other.computer))
			return false;
		if (count != other.count)
			return false;
		return true;
	}
	

}
