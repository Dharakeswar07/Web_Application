package com.typogenius.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {

	private static final String url="jdbc:mysql://localhost:3306/ims";
	private static final String username="root";
	private static final String password="7112000@God";
	
	private static Connection conn;
	public static Connection getConnection()
	{
		if(conn==null)
		{
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
					conn =DriverManager.getConnection(url,username,password);					
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		return conn;
				
	}
}
