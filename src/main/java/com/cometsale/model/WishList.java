package com.cometsale.model;

import java.util.ArrayList;


public class WishList {
	private ArrayList<Product> intresetedProduct;
	
	public WishList(){
		this.intresetedProduct=new ArrayList<Product>();
	}
	
	public void addProductToWishlist(Product p) {
		intresetedProduct.add(p);
	}
	
	public void removeProduct(Product p) {
		intresetedProduct.remove(p);
	}
	
	public void makeAnOffer(Product p,Student buyer,int price) {
		Offer offer = new Offer(buyer,price);
		p.offers.add(offer);
	}
	
	public void setWishList(ArrayList<Product> wishlist) {
		this.intresetedProduct=wishlist;
	}
	
	public ArrayList<Product> getWishList() {
		return this.intresetedProduct;
	}
	
	public void Accept(Product p) {}
	
	public void Reject(Product p) {}
}
