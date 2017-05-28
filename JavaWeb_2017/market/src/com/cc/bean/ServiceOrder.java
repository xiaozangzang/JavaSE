package com.cc.bean;

import java.io.Serializable;
import java.util.Date;

public class ServiceOrder  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525891696626602546L;


	public ServiceOrder() {
	
	}
	
	private Long id;
 
	private long userId;
	
	private long shoppingCarId;
	
	private Date creationtime;
	
	private String status;
	
	private String sendType;
	
	private String commodityName;
	
	private String picture;
	

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public Date getCreationtime() {
		return creationtime;
	}

	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public long getShoppingCarId() {
		return shoppingCarId;
	}

	public void setShoppingCarId(long shoppingCarId) {
		this.shoppingCarId = shoppingCarId;
	}
}
