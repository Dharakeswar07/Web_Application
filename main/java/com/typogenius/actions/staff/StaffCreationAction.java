package com.typogenius.actions.staff;

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
import com.typogenius.database.CreditantailsDAO;
import com.typogenius.database.StaffCourseDAO;
import com.typogenius.database.StaffDAO;
import com.typogenius.models.Creditantails;
import com.typogenius.models.Staff;

public class StaffCreationAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String instituteId;
	private String staffId;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;
	private String dateOfJoining;
	private Long salary;
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
	private File profile_image;
	private String profile_imageContentType;
	private String profile_imageFileName;
	private String newPassword;
	private String confirmPassword;
	private String extraPath;
	private Map<String, Object> responseMap = new HashMap<>();

	public String execute() throws IOException {

		HttpSession session = ServletActionContext.getRequest().getSession();
		String filePath = "E:\\Java Projects\\IMS\\TypoGenius\\src\\main\\webapp\\assets\\profiles\\staff";

		File destinationDir = new File(filePath);
		if (!destinationDir.exists()) {
			destinationDir.mkdirs();
		}
		LocalDate doj = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String fileExtension = profile_imageFileName.substring(profile_imageFileName.lastIndexOf('.'));

		String newFileName = staffId + fileExtension;

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

		profile_imageFileName = newFileName;
		String relativePath = "assets/profiles/staff/" + profile_imageFileName;
		LocalDateTime date = LocalDateTime.now();
		Staff staff = new Staff(instituteId, staffId, firstName, lastName, email, phoneNumber, doj, qualification,
				experience, doorno, street, area, pincode, city, state, country, salary, relativePath);
		Staff staffCourse = new Staff(staffId, courses);
		Creditantails creditantails = new Creditantails(instituteId, staffId, "Teacher", email, confirmPassword,
				"Active");
		boolean check = StaffDAO.getInstance().addStaff(staff);
		boolean creCheck = CreditantailsDAO.getInstance().addCreditantails(creditantails);
		boolean staffCourseCheck = StaffCourseDAO.getInstance().addStaffCourse(staffCourse);
		if (!(check && creCheck && staffCourseCheck)) {
			session.setAttribute("RegisterFailed", "Register Failed");
			return ERROR;
		}
		File destinationFile = new File(destinationDir, profile_imageFileName);
		try {
			FileUtils.copyFile(profile_image, destinationFile);
		} catch (IOException e) {
			session.setAttribute("RegisterFailed", "Register Failed: Unable to save profile image");
			e.printStackTrace();
			return ERROR;
		}
		session.setAttribute("RegisterSuccess", "Register Successful");
		return SUCCESS;
	}

	public String updateStaff() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String filePath = "E:\\Java Projects\\IMS\\TypoGenius\\src\\main\\webapp\\assets\\profiles\\staff";

		// Retrieve the existing institute details to retain the current profile image
		// if no new image is uploaded
		Staff existingStaff = StaffDAO.getInstance().getStaffById(staffId);
		String relativePath = existingStaff.getProfileImagePath();

		if (profile_image != null) {
			// If a new profile image is uploaded, update the file path
			File destinationDir = new File(filePath);
			if (!destinationDir.exists()) {
				destinationDir.mkdirs();
			}
			String fileExtension = profile_imageFileName.substring(profile_imageFileName.lastIndexOf('.'));

			String newFileName = staffId + fileExtension;

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

			// Update the profile_imageFileName with the new file name
			profile_imageFileName = newFileName;

			relativePath = "assets/profiles/staff/" + profile_imageFileName;

			File destinationFile = new File(destinationDir, profile_imageFileName);
			try {
				FileUtils.copyFile(profile_image, destinationFile);
			} catch (IOException e) {
				session.setAttribute("UpdateFailed", "Update Failed: Unable to save profile image");
				e.printStackTrace();
				return ERROR;
			}
		} else {
			relativePath = extraPath;
		}
		LocalDateTime date = LocalDateTime.now();
		LocalDate doj = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Staff staff = new Staff(instituteId, staffId, firstName, lastName, email, phoneNumber, doj, qualification,
				experience, doorno, street, area, pincode, city, state, country, salary, relativePath);

		boolean check = StaffDAO.getInstance().updateStaff(staff);

		if (!check) {
			session.setAttribute("UpdateFailed", "Update Failed");
			return ERROR;
		}

		session.setAttribute("UpdateSuccess", "Update Successful");
		return SUCCESS;
	}

	public String deleteStaff() {
		try {
			boolean check = StaffDAO.getInstance().deleteStaff(staffId);
			boolean creCheck = CreditantailsDAO.getInstance().deleteCreditantails(staffId);
			boolean staffCourseCheck = StaffCourseDAO.getInstance().deleteStaffCourse(staffId);
			if (!(check && creCheck && staffCourseCheck)) {
				responseMap.put("success", false);
				responseMap.put("message", "Delete Record Failed");
				return ERROR;
			}

			responseMap.put("success", true);
			responseMap.put("message", "Delete Record Successful");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			responseMap.put("success", false);
			responseMap.put("message", "An error occurred: " + e.getMessage());
			return ERROR;
		}
	}

	// Getters and Setters for all the fields

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

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getExtraPath() {
		return extraPath;
	}

	public void setExtraPath(String extraPath) {
		this.extraPath = extraPath;
	}

	public Map<String, Object> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, Object> responseMap) {
		this.responseMap = responseMap;
	}
}
