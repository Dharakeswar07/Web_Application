package com.typogenius.models;



public class Admin {
	
	private int adminId;
	private String userName;
	private String password;
	private String status;
	
	public Admin()
	{
		
	}
	public Admin(String userName, String password, String status) {
		this.userName = userName;
		this.password = password;
		this.status = status;
	}


	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
