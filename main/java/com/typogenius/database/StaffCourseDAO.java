package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.typogenius.models.Staff;

public class StaffCourseDAO {

	private Connection con=DbConnector.getConnection();
	private static StaffCourseDAO staffCourseDAO;
	
	public static StaffCourseDAO getInstance()
	{
		if(staffCourseDAO==null)
		{
			staffCourseDAO=new StaffCourseDAO();
		}
		return staffCourseDAO;
	}
	
	  public boolean addStaffCourse(Staff staff) {
	        String query = "INSERT INTO Staff_Course (staffid,courseid) VALUES ( ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	        	statement.setString(1, staff.getStaffId());
	        	statement.setString(2, staff.getCourses());
	            int rowsAffected = statement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 	
	  public boolean deleteStaffCourse(String staffId) {
		    String query = "DELETE FROM staff_course WHERE staffId = ?";
		    try (PreparedStatement statement = con.prepareStatement(query)) {
		        statement.setString(1, staffId);
		        int rowsAffected = statement.executeUpdate();
		        return rowsAffected > 0; 
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
}
