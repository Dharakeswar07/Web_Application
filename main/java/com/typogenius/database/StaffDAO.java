package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.typogenius.models.Staff;

public class StaffDAO {

	private Connection con=DbConnector.getConnection();
	private static StaffDAO staffDAO;
	
	public static StaffDAO getInstance()
	{
		if(staffDAO==null)
		{
			staffDAO=new StaffDAO();
		}
		return staffDAO;
	}
	
	public String getLastestStaffId(String insId) {
	    String query = "SELECT * FROM staff WHERE institute_id = ? ORDER BY sno DESC LIMIT 1";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, insId); // Parameter index corrected to 1
	        try (ResultSet set = statement.executeQuery()) {
	            if (set.next()) {
	                return set.getString("staffid");
	            } else {
	                return "";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "";
	    }
	}


	
	public boolean addStaff(Staff staff) {
	    String query = "INSERT INTO staff (staffId, institute_id, First_Name, Last_Name, street, area, doorno, City, State, Country,pincode, "
	            + "picture, Email, PhoneNumber, DateofJoining, Salary, qualification, Experience) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, staff.getStaffId());
	        statement.setString(2, staff.getInstituteId());
	        statement.setString(3, staff.getFirstName());
	        statement.setString(4, staff.getLastName());
	        statement.setString(5, staff.getStreet());
	        statement.setString(6, staff.getArea());
	        statement.setString(7, staff.getDoorno());
	        statement.setString(8, staff.getCity());
	        statement.setString(9, staff.getState());
	        statement.setString(10, staff.getCountry());
	        statement.setString(11,staff.getPincode());
	        statement.setString(12, staff.getProfileImagePath());
	        statement.setString(13, staff.getEmail());
	        statement.setLong(14, staff.getPhoneNumber());
	        statement.setDate(15, java.sql.Date.valueOf(staff.getDateOfJoining()));
	        statement.setLong(16, staff.getSalary());
	        statement.setString(17, staff.getQualification());
	        statement.setInt(18, staff.getExperience());
	        int rowsAffected = statement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean updateStaff(Staff staff) {
	    String query = "UPDATE staff SET  First_Name = ?, Last_Name = ?,street=?, area = ?,doorno=?, City = ?, State = ?, Country = ?,pincode=?, picture = ?,"
	    		+ " Email = ?, PhoneNumber = ?, DateofJoining = ?, Salary = ?, qualification = ?,  Experience = ? WHERE staffId = ? And institute_id=?";
	    
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	      
	        statement.setString(1, staff.getFirstName());
	        statement.setString(2, staff.getLastName());
	        statement.setString(3, staff.getStreet());
	        statement.setString(4, staff.getArea());
	        statement.setString(5, staff.getDoorno());
	        statement.setString(6, staff.getCity());
	        statement.setString(7, staff.getState());
	        statement.setString(8, staff.getCountry());
	        statement.setString(9,staff.getPincode());
	        statement.setString(10, staff.getProfileImagePath());
	        statement.setString(11, staff.getEmail());
	        statement.setLong(12, staff.getPhoneNumber());
	        statement.setDate(13, java.sql.Date.valueOf(staff.getDateOfJoining()));
	        statement.setLong(14, staff.getSalary());
	        statement.setString(15, staff.getQualification());
	        statement.setInt(16, staff.getExperience());
	        statement.setString(17, staff.getStaffId());
	        statement.setString(18, staff.getInstituteId());
	        
	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public Staff getStaffById(String id) {
	    String query = "SELECT * FROM staff WHERE staffId = ?";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, id);
	        try (ResultSet set = statement.executeQuery()) {
	            if (set.next()) {
	                Staff staff = new Staff();
	                staff.setStaffId(set.getString("staffId"));
	                staff.setInstituteId(set.getString("institute_id"));
	                staff.setFirstName(set.getString("First_Name"));
	                staff.setLastName(set.getString("Last_Name"));
	                staff.setArea(set.getString("area"));
	                staff.setStreet(set.getString("street"));
	                staff.setDoorno(set.getString("doorno"));
	                staff.setCity(set.getString("City"));
	                staff.setState(set.getString("State"));
	                staff.setCountry(set.getString("Country"));
	                staff.setPincode(set.getString("pincode"));
	                staff.setProfileImagePath(set.getString("picture"));
	                staff.setEmail(set.getString("Email"));
	                staff.setPhoneNumber(set.getLong("PhoneNumber"));
	
	                        Timestamp timestamp = set.getTimestamp("DateofJoining");
	                        if (timestamp != null) {
	                            LocalDate dateOfJoining = timestamp.toLocalDateTime().toLocalDate();
	                            staff.setDateOfJoining(dateOfJoining);
	                        } else {
	                            staff.setDateOfJoining(null);
	                        }
	           
	                staff.setSalary(set.getLong("Salary"));
	                staff.setQualification(set.getString("qualification"));
	                staff.setExperience(set.getInt("Experience"));
	                return staff;
	            } else {
	                System.out.println("No Data found with the provided credentials.");
	                return null;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	public List<Staff> getStaffList() {
	    List<Staff> staffList = new ArrayList<>();
	    String query = "SELECT * FROM staff";

	    try (PreparedStatement statement = con.prepareStatement(query);
	         ResultSet set = statement.executeQuery()) {

	        while (set.next()) {
	        	 Staff staff = new Staff();
	                staff.setStaffId(set.getString("staffId"));
	                staff.setInstituteId(set.getString("institute_id"));
	                staff.setFirstName(set.getString("First_Name"));
	                staff.setLastName(set.getString("Last_Name"));
	                staff.setArea(set.getString("area"));
	                staff.setStreet(set.getString("street"));
	                staff.setDoorno(set.getString("doorno"));
	                staff.setCity(set.getString("City"));
	                staff.setState(set.getString("State"));
	                staff.setCountry(set.getString("Country"));
	                staff.setPincode(set.getString("pincode"));
	                staff.setProfileImagePath(set.getString("picture"));
	                staff.setEmail(set.getString("Email"));
	                staff.setPhoneNumber(set.getLong("PhoneNumber"));
	
	                        Timestamp timestamp = set.getTimestamp("DateofJoining");
	                        if (timestamp != null) {
	                            LocalDate dateOfJoining = timestamp.toLocalDateTime().toLocalDate();
	                            staff.setDateOfJoining(dateOfJoining);
	                        } else {
	                            staff.setDateOfJoining(null);
	                        }
	           
	                staff.setSalary(set.getLong("Salary"));
	                staff.setQualification(set.getString("qualification"));
	                staff.setExperience(set.getInt("Experience"));

	            staffList.add(staff);
	        }
	        return staffList;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	
	
	public boolean deleteStaff(String staffId) {
	    String query = "DELETE FROM staff WHERE staffId = ?";
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
