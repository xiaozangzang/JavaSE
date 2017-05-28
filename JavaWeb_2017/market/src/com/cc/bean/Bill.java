package com.cc.bean;

import java.io.Serializable;
import java.util.Date;

public class Bill  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525891696626602546L;


	public Bill() {
	
	}
	
	private Long id;
	
	private long supermarketId;
	
	private String supermarketName;
	
	private String serviceOrderIds;
	
	private Date startTime;
	
	private Date endTime;
	
	private double totalPrice;
	/**提成*/
	private double cut;
	
	private String status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(long supermarketId) {
		this.supermarketId = supermarketId;
	}

	public String getServiceOrderIds() {
		return serviceOrderIds;
	}

	public void setServiceOrderIds(String serviceOrderIds) {
		this.serviceOrderIds = serviceOrderIds;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getCut() {
		return cut;
	}

	public void setCut(double cut) {
		this.cut = cut;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupermarketName() {
		return supermarketName;
	}

	public void setSupermarketName(String supermarketName) {
		this.supermarketName = supermarketName;
	}
	
	
	
	
}
