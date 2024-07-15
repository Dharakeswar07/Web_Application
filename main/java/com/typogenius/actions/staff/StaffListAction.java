package com.typogenius.actions.staff;

import java.util.List;



import com.opensymphony.xwork2.ActionSupport;
import com.typogenius.database.StaffDAO;
import com.typogenius.models.Staff;

public class StaffListAction extends ActionSupport {

private List<Staff>	staffList;
private Staff staff;
private String id;



public String execute()
{
	staffList=StaffDAO.getInstance().getStaffList();
	return SUCCESS;
}


public String getStaffDetails()
{
	if(id!=null && !id.isEmpty())
	{
		staff=StaffDAO.getInstance().getStaffById(id);
	}
	return SUCCESS;
}


public List<Staff> getStaffList() {
	return staffList;
}
public void setStaffList(List<Staff> staffList) {
	this.staffList = staffList;
}
public Staff getStaff() {
	return staff;
}
public void setStaff(Staff staff) {
	this.staff = staff;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


	
	
}
