package com.IT22603418.IT22603418_DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class IT22603418_DBConnect {
	// Define the parameters for connecting to the MySQL database.
	private static final String url = "jdbc:mysql://localhost:3306/eventmanagement";  // Database URL
	private static final String userName = "root"; // Database username
	private static final String password = "Thewa@123"; // Database password
	private static Connection con;// Connection object to hold the database connection
	// Static method to obtain a database connection.
	public static Connection getConnection() {
		try {
			// Load the MySQL JDBC driver. This step is necessary to use the driver.
			Class.forName("com.mysql.jdbc.Driver");
			// Establish a connection to the database using the provided URL, username, and password.
			con = DriverManager.getConnection(url, userName, password);
		}
		catch (Exception e){
			// If an exception occurs during the connection process, display an error message.
			System.out.println("Database Connection is not success!!!");
		}
		return con; // Return the established database connection (or null if an exception occurred).
	}
}
