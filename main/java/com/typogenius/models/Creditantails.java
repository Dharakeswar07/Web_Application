package com.typogenius.models;

public class Creditantails {

	private String institute_id;
	private String user_id;
	private String role;
	private String username;
	private String password;
	private String status;
	
	
	public Creditantails()
	{
		
	}
	
	
	public Creditantails(String institute_id, String user_id, String role, String username, String password,
			String status) {
		super();
		this.institute_id = institute_id;
		this.user_id = user_id;
		this.role = role;
		this.username = username;
		this.password = password;
		this.status = status;
	}


	public String getInstitute_id() {
		return institute_id;
	}


	public void setInstitute_id(String institute_id) {
		this.institute_id = institute_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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
