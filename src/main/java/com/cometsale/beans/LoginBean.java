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
}
