package com.entity;

public class User {
	private int id;
	private String name;
	private int age;
	private Card cards;
	private String[] interset;
	
	public String[] getInterset() {
		return interset;
	}
	public void setInterset(String[] interset) {
		this.interset = interset;
	}
	public Card getCards() {
		return cards;
	}
	public void setCards(Card cards) {
		this.cards = cards;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
