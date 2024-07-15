package com.typogenius.actions.course;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.CourseDAO;
import com.typogenius.models.Course;

public class CourseAddAction extends ActionSupport {

	private String instituteId;
	private String courseId;
	private String courseName;
	private String 	description;
	private String duration;
	private long fees;
	private String status;
	
	
	
	public String execute()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		Course  course=new Course(courseId,instituteId,courseName,description,duration,fees,status);
		
		boolean check=CourseDAO.getInstance().addCourse(course);
		
		if(!check)
		{
			 session.setAttribute("CourseCreationFailed", "Course Added Failed");
	            return ERROR; 
		}
        session.setAttribute("CourseCreationSuccess", "Course Added Successful");
		return SUCCESS;
	}
	
	
	public String getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public long getFees() {
		return fees;
	}
	public void setFees(long fees) {
		this.fees = fees;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
