package com.cometsale.model;

import java.util.Date;

public class UserDetails {
    private String netId;
    private String userName;
    private String  firstName;
    private String  lastName;
    
    public UserDetails(){}
    
    public UserDetails(String ID,String Username,String FirstName,String LastName){
        this.netId=ID;
        this.userName=Username;
        this.firstName=FirstName;
        this.lastName=LastName;
    }
    
    public String getNetID(){
        return netId;
    } 
    
    public void setNetID(String ID){
        this.netId=ID;
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

	public Date getLastLogin() {
		// TODO Auto-generated method stub
		return null;
	} 
    
    
}
