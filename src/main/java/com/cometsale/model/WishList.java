package com.cometsale.model;

import java.util.ArrayList;


public class WishList {
	private ArrayList<String> intresetedProduct;
	
	
	public WishList(){
		this.intresetedProduct=new ArrayList<String>();
	}
	
	public void addProduct(Product p) {
		intresetedProduct.add(p.getProductId());
	}
	
	public void removeProduct(Product p) {
		intresetedProduct.remove(p.getProductId());
	}
	
	public void makeAnOffer(Product p,Student buyer,int price) {
		Offer offer = new Offer(buyer);
		p.offers.add(offer);
	}
	
	public void setIntresetedProduct(ArrayList<String> wishlist) {
		this.intresetedProduct=wishlist;
	}

	
	public ArrayList<String> getIntresetedProduct() {
		return this.intresetedProduct;
	}
	
	
	public void Accept(Product p) {}
	
	public void Reject(Product p) {}
}
