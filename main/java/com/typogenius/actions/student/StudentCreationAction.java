package com.typogenius.actions.student;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.StudentDAO;
import com.typogenius.models.Student;

public class StudentCreationAction extends ActionSupport {

	private String instituteId;
	private String dateOfJoining;
	private String dateofBrith;
	private int attendExam;
	private String street;
	private String pincode;
	private String courses;
	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private LocalDate dateOfBirth;
	private String gender;
	private String doorno;
	private String area;
	private String city;
	private String state;
	private String country;
	private String courseId;
	private String profileImagePath;
	private String educationDetails;
	private File profile_image;
	private String profile_imageContentType;
	private String profile_imageFileName;
	private int age;
	private String bloodGroup;
	private String educationLevel;
	private String classLevel;
	private String jobTitle;
	private String degree;

	private Map<String, Object> responseMap = new HashMap<>();

	public String execute() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String filePath = "E:\\Java Projects\\IMS\\TypoGenius\\src\\main\\webapp\\assets\\profiles\\student";

		File destinationDir = new File(filePath);
		if (!destinationDir.exists()) {
			destinationDir.mkdirs();
		}
		LocalDate doj = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate dob = LocalDate.parse(dateofBrith, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String fileExtension = profile_imageFileName.substring(profile_imageFileName.lastIndexOf('.'));

		String newFileName = studentId + fileExtension;

		String newFilePath = filePath + File.separator + newFileName;
		File newDestinationFile = new File(newFilePath);
		if (newDestinationFile.exists()) {
			newDestinationFile.delete();
		}

		try {
			// Copy the file to the new destination
			FileUtils.copyFile(profile_image, newDestinationFile);
		} catch (IOException e) {
			session.setAttribute("CopyFailed", "Failed to copy the file");
			e.printStackTrace();
			return ERROR;
		}
		System.out.println(attendExam);
		if ("School".equals(educationLevel)) {
			educationDetails = classLevel;
		} else if ("College".equals(educationLevel)) {
			educationDetails = degree;
		} else if ("Work".equals(educationLevel)) {
			educationDetails = jobTitle;
		}

		profile_imageFileName = newFileName;
		String relativePath = "assets/profiles/student/" + profile_imageFileName;
		LocalDateTime date = LocalDateTime.now();

		Student student = new Student(instituteId, studentId, firstName, lastName, email, phoneNumber, dob, gender,
				doorno, area, street, pincode, city, state, country, doj, courses, relativePath, educationDetails, age,
				bloodGroup, educationLevel, attendExam, date);

		boolean check = StudentDAO.getInstance().addStudent(student);
		if (!(check)) {
			session.setAttribute("StudentRegisterFailed", "Register Failed");
			return ERROR;
		}
		File destinationFile = new File(destinationDir, profile_imageFileName);
		try {
			FileUtils.copyFile(profile_image, destinationFile);
		} catch (IOException e) {
			session.setAttribute("StudentRegisterFailed", "Register Failed: Unable to save profile image");
			e.printStackTrace();
			return ERROR;
		}
		session.setAttribute("StudentRegisterSuccess", "Register Successful");
		return SUCCESS;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
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

	public File getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(File profile_image) {
		this.profile_image = profile_image;
	}

	public String getProfile_imageContentType() {
		return profile_imageContentType;
	}

	public void setProfile_imageContentType(String profile_imageContentType) {
		this.profile_imageContentType = profile_imageContentType;
	}

	public String getProfile_imageFileName() {
		return profile_imageFileName;
	}

	public void setProfile_imageFileName(String profile_imageFileName) {
		this.profile_imageFileName = profile_imageFileName;
	}

	public Map<String, Object> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, Object> responseMap) {
		this.responseMap = responseMap;
	}

	public String getDateofBrith() {
		return dateofBrith;
	}

	public void setDateofBrith(String dateofBrith) {
		this.dateofBrith = dateofBrith;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int isAttendExam() {
		return attendExam;
	}

	public void setAttendExam(int attendExam) {
		this.attendExam = attendExam;
	}
}
