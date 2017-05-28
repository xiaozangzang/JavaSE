package com.cc.bean;

import java.io.Serializable;
import java.util.Date;

public class ShoppingCar  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525891696626602546L;


	public ShoppingCar() {
	
	}
	
	private Long id;
 
	private long commodityId;
	
	private double price;
	
	private String supermarketName;
	
	private String picture;
	
	private String commodityName;
	
	private long supermarketId;
	private long userId;

	private Date creationTime;
	
	private int count;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(long commodityId) {
		this.commodityId = commodityId;
	}

	public long getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(long supermarketId) {
		this.supermarketId = supermarketId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSupermarketName() {
		return supermarketName;
	}

	public void setSupermarketName(String supermarketName) {
		this.supermarketName = supermarketName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	



	
}
