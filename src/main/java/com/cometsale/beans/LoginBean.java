package com.cometsale.beans;


public class LoginBean {

	private String netId;
	private String password;
    /**
     * Default constructor. 
     */
    public LoginBean() {
    	netId = "";
    	password = "";
    }
	
	public String getnetId() {
		return netId;
	}
	
	public void setnetId(String netId) {
		this.netId = netId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
