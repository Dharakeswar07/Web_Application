package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.typogenius.models.Institute;

public class InstituteDAO {

	
	private Connection con=DbConnector.getConnection();
	private static InstituteDAO instituteDAO;
	
	public static InstituteDAO getInstance()
	{
		if(instituteDAO==null)
		{
			instituteDAO=new InstituteDAO();
		}
		return instituteDAO;
	}
	
	public String getLastestInsId()
	{
		String query="Select * from institute Order by sno desc Limit 1";
		try(PreparedStatement statement=con.prepareStatement(query))
		{
			try(ResultSet set=statement.executeQuery())
			{
				if(set.next())
				{
					return set.getString("institute_id");
				}
				else 
				{
					return "";				
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	
	public boolean addInstitute(Institute institute) {
		System.out.println("Iam in Sql");
		String query = "INSERT INTO institute (institute_id, name, AdminName, email, phone, area, street, doorno, city, state, pincode, country, "
		        + "date, emp_count, profile, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, institute.getInstitute_Id());
            statement.setString(2, institute.getIns_name());
            statement.setString(3, institute.getAdmin_name());
            statement.setString(4, institute.getEmail());
            statement.setLong(5, institute.getPhone_no());
            statement.setString(6, institute.getArea());
            statement.setString(7, institute.getStreet());
            statement.setString(8, institute.getDoorno());
            statement.setString(9, institute.getCity());
            statement.setString(10, institute.getState());
            statement.setString(11, institute.getPincode());
            statement.setString(12, institute.getCountry());
            LocalDateTime localDateTime = institute.getDate();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            statement.setTimestamp(13, timestamp);
            statement.setInt(14, institute.getEmp_count());
            statement.setString(15, institute.getProfile());
            statement.setString(16, institute.getStatus());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	
	   public List<Institute> getInstituteList() {
	        List<Institute> instituteList = new ArrayList<>();
	        String query = "SELECT * FROM institute";

	        try (PreparedStatement statement = con.prepareStatement(query);
	             ResultSet set = statement.executeQuery()) {

	            while (set.next()) {
	                Institute institute = new Institute();
	                institute.setInstitute_Id(set.getString("institute_id"));
	                institute.setIns_name(set.getString("name"));
	                institute.setAdmin_name(set.getString("AdminName"));
	                institute.setEmail(set.getString("email"));
	                institute.setPhone_no(set.getLong("phone"));
	                institute.setArea(set.getString("area"));
	                institute.setStreet(set.getString("street"));
	                institute.setDoorno(set.getString("doorno"));
	                institute.setCity(set.getString("city"));
	                institute.setState(set.getString("state"));
	                institute.setPincode(set.getString("pincode"));
	                institute.setCountry(set.getString("country"));
	                institute.setEmp_count(set.getInt("emp_count"));
	                institute.setProfile(set.getString("profile"));
	                institute.setStatus(set.getString("status"));

	                // Using getTimestamp to get the date and convert it to LocalDateTime
	                Timestamp timestamp = set.getTimestamp("date");
	                if (timestamp != null) {
	                    LocalDateTime createdDate = timestamp.toInstant()
	                                                        .atZone(ZoneId.systemDefault())
	                                                        .toLocalDateTime();
	                    institute.setDate(createdDate);
	                } else {
	                    institute.setDate(null);
	                }

	                instituteList.add(institute);
	            }
	            return instituteList;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	   
	   public boolean update(Institute institute) {
	        String query = "UPDATE institute SET name = ?, AdminName = ?, email = ?, phone = ?, area = ?, street = ?, " +
	                       "doorno = ?, city = ?, state = ?, pincode = ?, country = ?, emp_count = ?, profile = ?, " +
	                       "status = ?  WHERE institute_id = ?";
	        
	        try (PreparedStatement statement = con.prepareStatement(query)) {
	            statement.setString(1, institute.getIns_name());
	            statement.setString(2, institute.getAdmin_name());
	            statement.setString(3,institute.getEmail());
	            statement.setLong(4, institute.getPhone_no());
	            statement.setString(5, institute.getArea());
	            statement.setString(6, institute.getStreet());
	            statement.setString(7, institute.getDoorno());
	            statement.setString(8, institute.getCity());
	            statement.setString(9, institute.getState());
	            statement.setString(10, institute.getPincode());
	            statement.setString(11, institute.getCountry());
	            statement.setInt(12, institute.getEmp_count());
	            statement.setString(13, institute.getProfile());
	            statement.setString(14, institute.getStatus());
	            statement.setString(15, institute.getInstitute_Id());
	            
	            int rowsUpdated = statement.executeUpdate();
	            return rowsUpdated > 0; 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	public Institute getInstituteById(String id) {
		String query="SELECT * FROM institute where institute_id=?";
		try(PreparedStatement statement=con.prepareStatement(query))
		{
			statement.setString(1, id);
			try(ResultSet set=statement.executeQuery())
			{
				  if (set.next()) {
		                Institute institute = new Institute();
		                institute.setInstitute_Id(set.getString("institute_id"));
		                institute.setIns_name(set.getString("name"));
		                institute.setAdmin_name(set.getString("AdminName"));
		                institute.setEmail(set.getString("email"));
		                institute.setPhone_no(set.getLong("phone"));
		                institute.setArea(set.getString("area"));
		                institute.setStreet(set.getString("street"));
		                institute.setDoorno(set.getString("doorno"));
		                institute.setCity(set.getString("city"));
		                institute.setState(set.getString("state"));
		                institute.setPincode(set.getString("pincode"));
		                institute.setCountry(set.getString("country"));
		                institute.setEmp_count(set.getInt("emp_count"));
		                institute.setProfile(set.getString("profile"));
		                institute.setStatus(set.getString("status"));

		                // Using getTimestamp to get the date and convert it to LocalDateTime
		                Timestamp timestamp = set.getTimestamp("date");
		                if (timestamp != null) {
		                    LocalDateTime createdDate = timestamp.toInstant()
		                                                        .atZone(ZoneId.systemDefault())
		                                                        .toLocalDateTime();
		                    institute.setDate(createdDate);
		                } else {
		                    institute.setDate(null);
		                }
		                return institute;
		            }
				  else 
				  {
	                    System.out.println("No Data found with the provided credentials.");
	                    return null;
				  }
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public boolean deleteInstitute(String institute_id) {
	    String query = "DELETE FROM institute WHERE institute_id=?";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, institute_id);
	        int rowsAffected = statement.executeUpdate();
	        return rowsAffected > 0; 
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
}
