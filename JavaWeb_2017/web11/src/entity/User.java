package entity;

import java.util.Date;
import java.util.List;

public class User{
	private int id;
	private String name;
	private Date time;
	//1.
	private int[] num;
	//2.
	private Card card;
	//3.
	private Card[] cards;
	//4.
	private List<Card> cardsList;
	public User(int id, String name, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

	public User() {
		super();
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
