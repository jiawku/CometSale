package com.cometsale.model;

public class Offer {
	
	Student buyer;
	int price;
	
	public Offer(Student buyer,int price) {
		this.buyer=buyer;
		this.price=price;
	}
	
	public Student getBuyer() {
		return buyer;
	}
	public void setBuyer(Student buyer) {
		this.buyer = buyer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
