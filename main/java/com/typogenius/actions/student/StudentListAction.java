package com.typogenius.actions.student;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.StudentDAO;
import com.typogenius.models.Student;

public class StudentListAction extends ActionSupport {


private List<Student> studentList;	
private Student student;
private String id;



public String execute()
{
	studentList=StudentDAO.getInstance().getAllStudents();
	return SUCCESS;
}


public String getStaffDetails()
{
	if(id!=null && !id.isEmpty())
	{
		student=StudentDAO.getInstance().getStudentById(id);
	}
	return SUCCESS;
}


public List<Student> getStudentList() {
	return studentList;
}


public void setStudentList(List<Student> studentList) {
	this.studentList = studentList;
}


public Student getStudent() {
	return student;
}


public void setStudent(Student student) {
	this.student = student;
}


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


	
	
}
