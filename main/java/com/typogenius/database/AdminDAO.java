package com.typogenius.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.typogenius.models.Admin;

public class AdminDAO {

    private Connection con = DbConnector.getConnection();
    private static AdminDAO adminDAO;

    public static AdminDAO getInstance() {
        if (adminDAO == null) {
            adminDAO = new AdminDAO();
        }
        return adminDAO;
    }

    public Admin loginCheck(String username, String password) {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet set = statement.executeQuery()) {
                if (set.next()) {
                    Admin admin = new Admin();
                    admin.setAdminId(set.getInt("admin_id"));
                    admin.setUserName(set.getString("username"));
                    admin.setPassword(set.getString("password"));
                    admin.setStatus(set.getString("status"));
                    return admin;
                } else {
                    System.out.println("No user found with the provided credentials.");
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
