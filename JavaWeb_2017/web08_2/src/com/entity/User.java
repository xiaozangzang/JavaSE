package com.entity;

/*
 * userName,name,password,age,sex,phone
 */
public class User {
	private int id;
	private String userName;
	private String name;
	private String password;
	private int age;
	private String sex;
	private String phone;

	public User() {
		super();
	}

	public User(int id, String userName, String password, String sex) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
	}

	public User( String userName, String name, String password,
			int age, String sex, String phone) {
		super();
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}
	public User(int id, String userName, String name, String password,
			int age, String sex, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", name=" + name
				+ ", phone=" + phone + ", psssword=" + password + ", sex="
				+ sex + ", userName=" + userName + "]";
	}

}
