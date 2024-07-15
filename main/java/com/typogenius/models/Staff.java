package com.typogenius.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Staff {
    private String instituteId;
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private LocalDate dateOfJoining;
    private String qualification;
    private int experience;
    private String doorno;
    private String street;
    private String area;
    private String pincode;
    private String city;
    private String state;
    private String country;
    private String courses;
    private Long salary;
    private String profileImagePath;
    private String password;
    private String status;

    public Staff()
    {
    	
    }
    
    

	public Staff(String staffId, String courses) {
		super();
		this.staffId = staffId;
		this.courses = courses;
	}



	public Staff(String instituteId, String staffId, String firstName, String lastName, String email, Long phoneNumber,
			LocalDate dateOfJoining, String qualification, int experience, String doorno, String street,
			String area, String pincode, String city, String state, String country, Long salary,
			String profileImagePath) {
		super();
		this.instituteId = instituteId;
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfJoining = dateOfJoining;
		this.qualification = qualification;
		this.experience = experience;
		this.doorno = doorno;
		this.street = street;
		this.area = area;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.salary = salary;
		this.profileImagePath = profileImagePath;
	}
	
	public Staff(String instituteId, String staffId, String email, String password, String status) {
		super();
		this.instituteId = instituteId;
		this.staffId = staffId;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
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
