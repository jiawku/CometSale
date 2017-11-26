package com.cometsale.model;

import java.util.List;
import java.util.UUID;

import com.cometsale.mongodb.ProductDB;

public class Product {
	
	String productId;
	Student seller;
	List<Offer> offers;
	public ProductDetails details;
	ProductStatus status;
	
	public Product(){
		 String uuid = UUID.randomUUID().toString();
		 while(ProductDB.productIDinDB(uuid)) {
			 uuid = UUID.randomUUID().toString();
		 } 
		 setProductId(uuid);
		 setStatus(ProductStatus.open);
		 details=new ProductDetails();
	}
	
	
	//getter and setters
	public String getProductId() {
		return productId;	
	}
	public void setProductId(String uuid) {
		this.productId = uuid;
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
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status=status;
	}
	public void setProductDetials(ProductDetails details) {
		this.details=details;
	}
	public ProductDetails getProductDetials() {
		return details;
	}
}
