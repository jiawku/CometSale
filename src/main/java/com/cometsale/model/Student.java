package com.cometsale.model;

public class Student {

	String netId;
	WishList wishList;
	public StudentDetails details;
	
	public Student(){
		this.wishList=new WishList();
		this.details=new StudentDetails();
	}
	
	public String getNetid() {
		return netId;
	}

	public void setNetid(String string) {
		this.netId = string;
	}
	
	public void register() {}
	
	public void validate() {}
}
