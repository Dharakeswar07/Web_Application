package com.typogenius.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {

	private String instituteId;
    private LocalDate dateOfJoining;
    private String street;
    private String pincode;
    private String courses;
	  private String studentId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private Long phoneNumber;
	    private LocalDate dateOfBrith;
	    private String gender;
	    private String doorno;
	    private String area;
	    private String city;
	    private String state;
	    private String country;
	    private String profileImagePath;
	    private String educationDetails;
	    private int age;
	    private String bloodGroup;
	    private String educationLevel;
	    private int examCheck;	    
	    private LocalDateTime createdDate;
	    private Course course;
	    
	    public Student()
	    {
	    	
	    }
	    
		public Student(String instituteId, 
				String studentId, String firstName, String lastName, String email, Long phoneNumber,
				LocalDate dateOfBrith, String gender, String doorno, String area, String street,
				String pincode, String city, String state,
				String country,LocalDate dateOfJoining, String courses,  String profileImagePath,
				String educationDetails, int age,
				String bloodGroup, String educationLevel, int examCheck,LocalDateTime createdDate) {
			super();
			this.instituteId = instituteId;
			this.dateOfJoining = dateOfJoining;
			this.street = street;
			this.pincode = pincode;
			this.courses = courses;
			this.studentId = studentId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.dateOfBrith = dateOfBrith;
			this.gender = gender;
			this.doorno = doorno;
			this.area = area;
			this.city = city;
			this.state = state;
			this.country = country;
			this.profileImagePath = profileImagePath;
			this.educationDetails = educationDetails;
			this.age = age;
			this.bloodGroup = bloodGroup;
			this.educationLevel = educationLevel;
			this.examCheck = examCheck;
			this.createdDate=createdDate;
		}

		public String getInstituteId() {
			return instituteId;
		}

		public void setInstituteId(String instituteId) {
			this.instituteId = instituteId;
		}

		public LocalDate getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(LocalDate dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getCourses() {
			return courses;
		}

		public void setCourses(String courses) {
			this.courses = courses;
		}

		public String getStudentId() {
			return studentId;
		}

		public void setStudentId(String studentId) {
			this.studentId = studentId;
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

		public LocalDate getDateOfBrith() {
			return dateOfBrith;
		}

		public void setDateOfBrith(LocalDate dateOfBrith) {
			this.dateOfBrith = dateOfBrith;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDoorno() {
			return doorno;
		}

		public void setDoorno(String doorno) {
			this.doorno = doorno;
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

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		public String getProfileImagePath() {
			return profileImagePath;
		}

		public void setProfileImagePath(String profileImagePath) {
			this.profileImagePath = profileImagePath;
		}

		public String getEducationDetails() {
			return educationDetails;
		}

		public void setEducationDetails(String educationDetails) {
			this.educationDetails = educationDetails;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getBloodGroup() {
			return bloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

		public String getEducationLevel() {
			return educationLevel;
		}

		public void setEducationLevel(String educationLevel) {
			this.educationLevel = educationLevel;
		}

		public int getExamCheck() {
			return examCheck;
		}

		public void setExamCheck(int examCheck) {
			this.examCheck = examCheck;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}
		
		
}
