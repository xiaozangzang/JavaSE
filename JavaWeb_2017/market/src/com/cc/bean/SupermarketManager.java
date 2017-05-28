package com.cc.bean;

public class SupermarketManager {
	
	private Long id;

    private String username;
    
    private String password;
    private long supermarketId;

    private String phone;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public long getSupermarketId() {
		return supermarketId;
	}

	public void setSupermarketId(long supermarketId) {
		this.supermarketId = supermarketId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
