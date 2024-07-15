package com.typogenius.actions.institute;

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
import org.apache.struts2.components.Password;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.CreditantailsDAO;
import com.typogenius.database.InstituteDAO;
import com.typogenius.models.Creditantails;
import com.typogenius.models.Institute;

public class InstituteCreationAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String institute_id;
	private String name;
	private String email;
	private long phoneNo; 
	private String doorno;
	private String street;
	private String area;
	private String pincode;
	private String city;
	private String state;
	private String country;
	private String adminName;
	private int emp_count;
	private File profile_image;
	private String profile_imageContentType;
	private String profile_imageFileName;
	private String newPassword;
	private String confirmPassword;
	private String extraPath;
	private Map<String, Object> responseMap = new HashMap<>();

	// Getters and Setters

	public String execute() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String filePath = "E:\\Java Projects\\IMS\\TypoGenius\\src\\main\\webapp\\assets\\profiles\\staff";

		File destinationDir = new File(filePath);
		if (!destinationDir.exists()) {
			destinationDir.mkdirs();
		}
		String fileExtension = profile_imageFileName.substring(profile_imageFileName.lastIndexOf('.'));

		String newFileName = institute_id + fileExtension;

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
		String relativePath = "assets/profiles/institute/" + profile_imageFileName;
		
		LocalDateTime date = LocalDateTime.now();
		Institute institute = new Institute(institute_id, name, adminName, email, phoneNo, doorno,street,area, city, state, pincode, country, date, emp_count, relativePath, "Active");
		Creditantails creditantails=new Creditantails(institute_id,institute_id,"Admin",email,confirmPassword,"Active");
		boolean check = InstituteDAO.getInstance().addInstitute(institute);
		boolean creCheck=CreditantailsDAO.getInstance().addCreditantails(creditantails);
		if (!(check & creCheck) ) {
			session.setAttribute("RegisterFailed", "Register Failed");
			return ERROR;
		}
		File destinationFile = new File(destinationDir, profile_imageFileName);
		System.out.println(destinationFile);
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
	
	public String updateInstitute() {
	    HttpSession session = ServletActionContext.getRequest().getSession();
	    String filePath = "E:\\Java Projects\\IMS\\TypoGenius\\src\\main\\webapp\\assets\\profiles\\institute";
	    
	    // Retrieve the existing institute details to retain the current profile image if no new image is uploaded
	    Institute existingInstitute = InstituteDAO.getInstance().getInstituteById(institute_id);
	    String relativePath = existingInstitute.getProfile();

	    if (profile_image != null) {
	        // If a new profile image is uploaded, update the file path
	        File destinationDir = new File(filePath);
	        if (!destinationDir.exists()) {
	            destinationDir.mkdirs();
	        }
	        String fileExtension = profile_imageFileName.substring(profile_imageFileName.lastIndexOf('.'));

			String newFileName = institute_id + fileExtension;

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
	        relativePath = "assets/profiles/institute/" + profile_imageFileName;
	        
	        File destinationFile = new File(destinationDir, profile_imageFileName);
	        try {
	            FileUtils.copyFile(profile_image, destinationFile);
	        } catch (IOException e) {
	            session.setAttribute("UpdateFailed", "Update Failed: Unable to save profile image");
	            e.printStackTrace();
	            return ERROR;
	        }
	    }
	    else {
			relativePath=extraPath;
		}

	    LocalDateTime date = LocalDateTime.now();
	    Institute institute = new Institute(institute_id, name, adminName, email, phoneNo, doorno, street, area, city, state, pincode, country, date, emp_count, relativePath, "Active");
	    
	    boolean check = InstituteDAO.getInstance().update(institute);

	    if (!check) {
	        session.setAttribute("UpdateFailed", "Update Failed");
	        return ERROR;
	    }

	    session.setAttribute("UpdateSuccess", "Update Successful");
	    return SUCCESS;
	}

	public String deleteInstitute() {
        try {
            boolean check = InstituteDAO.getInstance().deleteInstitute(institute_id);
            boolean creCheck=CreditantailsDAO.getInstance().deleteCreditantails(institute_id);

            if (!(check & creCheck)) {
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
	
	public String getInstitute_id() {
		return institute_id;
	}

	public void setInstitute_id(String institute_id) {
		this.institute_id = institute_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
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

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getEmp_count() {
		return emp_count;
	}

	public void setEmp_count(int emp_count) {
		this.emp_count = emp_count;
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
