package com.cc.bean;

import java.io.Serializable;

public class Commodity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3821416861106759726L;

	public Commodity() {
		// TODO Auto-generated constructor stub
	}
	
	private Long id;
	
	private String name;
	
	
	private String picture;
	
	private long categoryId;
	
	private double price;
	
	private long supermarketId;
	
	private long salesCount;
	
	private String description;
	
	private String categoryName;
	
	private String supermaketName;

	
	
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSupermaketName() {
		return supermaketName;
	}

	public void setSupermaketName(String supermaketName) {
		this.supermaketName = supermaketName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(long supermarketId) {
		this.supermarketId = supermarketId;
	}

	public long getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(long salesCount) {
		this.salesCount = salesCount;
	}
	
}
