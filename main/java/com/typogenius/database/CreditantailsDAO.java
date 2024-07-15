package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.typogenius.models.Creditantails;

public class CreditantailsDAO {

    private Connection con = DbConnector.getConnection();
    private static CreditantailsDAO creditantailsDAO;

    public static CreditantailsDAO getInstance() {
        if (creditantailsDAO == null) {
        	creditantailsDAO = new CreditantailsDAO();
        }
        return creditantailsDAO;
    }
    
    
    public boolean addCreditantails(Creditantails creditantails) {
		String query = "INSERT INTO creditantails  (institute_id, user_id, role, username, password, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, creditantails.getInstitute_id());
            statement.setString(2, creditantails.getUser_id());
            statement.setString(3,creditantails.getRole());
            statement.setString(4, creditantails.getUsername());
            statement.setString(5, creditantails.getPassword());
            statement.setString(6, creditantails.getStatus());            
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
	
    
	public boolean deleteCreditantails(String id) {
	    String query = "DELETE FROM Creditantails WHERE user_id = ?";
	    try (PreparedStatement statement = con.prepareStatement(query)) {
	        statement.setString(1, id);
	        int rowsAffected = statement.executeUpdate();
	        return rowsAffected > 0; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
}
