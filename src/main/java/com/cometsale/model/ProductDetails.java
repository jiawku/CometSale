package com.cometsale.model;

import java.util.UUID;

import com.cometsale.mongodb.ProductDB;

public class ProductDetails {
	
	String productID;
	String productname;
	String ownerID;
    byte[] imageBytes;
	String productDesc;
	double offerPrice;
	String status; //values: sold, available, locked.
	String quality;
	Address pickupAddress;
	String category;
	
	public ProductDetails(){
		 String uuid = UUID.randomUUID().toString();
		 while(ProductDB.productIDinDB(uuid)) {
			 uuid = UUID.randomUUID().toString();
		 }
		 setProductID(uuid);
	}
	
	
	public byte[] getImageBytes(){
		return imageBytes;
	}
	
	public void setImageBytes(byte[] inputImageBytes){
		this.imageBytes=inputImageBytes;
	}
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productid) {
		this.productID = productid;
	}
	
	public String getOwnerID() {
		return productID;
	}
	public void setOwnerID(String ownerid) {
		this.ownerID = ownerid;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Address getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
