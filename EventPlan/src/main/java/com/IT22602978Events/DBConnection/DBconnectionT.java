package com.IT22602978Events.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.IT22602978Events.EventClass.EventLogger;

public class DBconnectionT {
	// Define the connection parameters
	private static String url="jdbc:mysql://localhost:3306/eventmanagement";
	private static String user="root";
	private static String pass="Thewa@123";
	private static Connection con;
	
	 // Get an instance of the EventLogger
	static EventLogger logger=EventLogger.getInstance();
	// Method to get a database connection
	public static Connection getconnection() {
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establish a connection to the database
	         con = DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e) {
			// Handle exceptions related to database connection
			System.out.println("Database connection is not successfull!!");
			try {
				
			} catch (Exception e1) {
				// Log the exception using the EventLogger
				logger.logExceptionWarning("Error Exception (Database Connection):", e1);
				// Handle any exceptions that occur while logging
				e1.printStackTrace();
			}
		}
		return con;
	}
	

}
