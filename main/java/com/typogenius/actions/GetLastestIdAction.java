package com.typogenius.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.CourseDAO;
import com.typogenius.database.InstituteDAO;
import com.typogenius.database.StaffDAO;
import com.typogenius.database.StudentDAO;

public class GetLastestIdAction extends ActionSupport {
    private String latestInstituteId;
    private String latestStaffId;
    private String instituteId;
    private String latestCourseId;
    private String latestStudentId;
    
    
    
    
    public String getLatestStudentId() {
		return latestStudentId;
	}

	public void setLatestStudentId(String latestStudentId) {
		this.latestStudentId = latestStudentId;
	}

	public String getLatestCourseId() {
		return latestCourseId;
	}

	public void setLatestCourseId(String latestCourseId) {
		this.latestCourseId = latestCourseId;
	}

	public String getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }

    public String getLatestStaffId() {
        return latestStaffId;
    }

    public void setLatestStaffId(String latestStaffId) {
        this.latestStaffId = latestStaffId;
    }

    public String getLatestInstituteId() {
        return latestInstituteId;
    }

    public void setLatestInstituteId(String latestInstituteId) {
        this.latestInstituteId = latestInstituteId;
    }

    @Override
    public String execute() {
        latestInstituteId = InstituteDAO.getInstance().getLastestInsId();
        if (latestInstituteId == null || latestInstituteId.isEmpty()) {
            latestInstituteId = "INS001";
        } else {
            String numericPart = latestInstituteId.substring(3);
            int num = Integer.parseInt(numericPart);
            num++;
            latestInstituteId = String.format("INS%03d", num); 
        }
        return SUCCESS;
    }
    
    public String getLatestStaffByInstitute() {
        latestStaffId = StaffDAO.getInstance().getLastestStaffId(instituteId);
        System.out.println(latestStaffId);
        
        if (latestStaffId == null || latestStaffId.isEmpty()) {
            latestStaffId = instituteId + "_ST001";
        } else {
            String numericPart = latestStaffId.substring(latestStaffId.lastIndexOf('_') + 3);
            int num = Integer.parseInt(numericPart);
            num++;
            String formattedNumber = String.format("%03d", num); 
            latestStaffId = latestStaffId.substring(0, latestStaffId.lastIndexOf('_') + 3) + formattedNumber;
        }
        
        return SUCCESS;
    }
    
    public String getLatestCourseByInstitute() {
    	
        latestCourseId = CourseDAO.getInstance().getLastestCourseId(instituteId);
        if (latestCourseId == null || latestCourseId.isEmpty()) {
            latestCourseId = instituteId + "_CS001";
        } else {
            String numericPart = latestCourseId.substring(latestCourseId.lastIndexOf('_') + 3);
            int num = Integer.parseInt(numericPart);
            num++;
            String formattedNumber = String.format("%03d", num); 
            latestCourseId = latestCourseId.substring(0, latestCourseId.lastIndexOf('_') + 3) + formattedNumber;
        }
        
        return SUCCESS;
    }
    
 public String getLatestStudentByInstitute() {
    	
        latestStudentId = StudentDAO.getInstance().getLastestStudentId(instituteId);
        if (latestStudentId == null || latestStudentId.isEmpty()) {
        	latestStudentId = instituteId + "_STD001";
        } else {
            String numericPart = latestStudentId.substring(latestStudentId.lastIndexOf('_') + 4);
            int num = Integer.parseInt(numericPart);
            num++;
            String formattedNumber = String.format("%03d", num); 
            latestStudentId = latestStudentId.substring(0, latestStudentId.lastIndexOf('_') + 4) + formattedNumber;
        }
        
        return SUCCESS;
    }

}
