package com.typogenius.models;

import java.time.LocalDateTime;

public class Institute {

	private String  institute_Id;
	private String ins_name;
	private String admin_name;
	private String email;
	private long phone_no;
	private String doorno;
	private String street;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private LocalDateTime date;
	private int emp_count;
	private String profile;
	private String status;
	
	public Institute()
	{
		
	}
	
	
	
	

	public Institute(String institute_Id, String ins_name, String admin_name, String email, long phone_no,
			String doorno, String street, String area, String city, String state, String pincode, String country,
			LocalDateTime date, int emp_count, String profile, String status) {
		super();
		this.institute_Id = institute_Id;
		this.ins_name = ins_name;
		this.admin_name = admin_name;
		this.email = email;
		this.phone_no = phone_no;
		this.doorno = doorno;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.date = date;
		this.emp_count = emp_count;
		this.profile = profile;
		this.status = status;
	}





	public String getInstitute_Id() {
		return institute_Id;
	}

	public void setInstitute_Id(String institute_Id) {
		this.institute_Id = institute_Id;
	}

	public String getIns_name() {
		return ins_name;
	}

	public void setIns_name(String ins_name) {
		this.ins_name = ins_name;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public String getDoorno() {
		return doorno;
	}

	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getEmp_count() {
		return emp_count;
	}

	public void setEmp_count(int emp_count) {
		this.emp_count = emp_count;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
