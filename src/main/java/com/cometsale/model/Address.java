package com.cometsale.model;

public class Address {
	
	private String  streetname;
    private String 	city;
    private String  state;
    private String  pinCode;
    private String  AptNo;
    

    
	public String getAptNo() {
		return AptNo;
	}
	public void setAptNo(String aptNo) {
		AptNo = aptNo;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
