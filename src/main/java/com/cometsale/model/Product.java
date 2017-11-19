package com.cometsale.model;

import java.util.List;

public class Product {
	
	int productId;
	Student seller;
	List<Offer> offers;
	
	//getter and setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Student getSeller() {
		return seller;
	}
	public void setSeller(Student seller) {
		this.seller = seller;
	}
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	

}
