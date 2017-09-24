package com.cometsale.model;

import java.util.Date;

public class UserDetails {
    private String netId;
    private String userName;
    private String  firstName;
    private String  lastName;
    private String  password;
    private String  phoneNumber;
    private Address homeAddress;
    private String email;
       

	public UserDetails(){}
    
    public UserDetails(String ID,String Username,String FirstName,String LastName){
        this.netId=ID;
        this.userName=Username;
        this.firstName=FirstName;
        this.lastName=LastName;
    }
    public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String UserName){
        this.userName=UserName;
    } 
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String FirstName){
        this.firstName=FirstName;
    } 
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String LastName){
        this.lastName=LastName;
    }
    
    public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}
    
}
