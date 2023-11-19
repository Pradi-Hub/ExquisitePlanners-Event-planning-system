package com.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	// Define variables
	private static boolean isSuccess; // instance variables
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// Validates the username and password from the database
	public static boolean validate(String username, String password) {

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where userName = '" + username + "' and password = '" + password + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}
	
	// Retrieves customer details based on the username
	public static List<User> getCustomer(String username) {

		ArrayList<User> use = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where userName = '" + username + "'";
			// run the sql query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String uname = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String nic = rs.getString(6);
				String address = rs.getString(7);
				String passU = rs.getString(8);

				User u = new User(id, name, uname, email, phone, nic, address, passU);
				use.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return use;

	}
	
	// Inserts a new user into the database
	public static boolean insertuser(String name, String username, String email, String phone, String nic,
			String address, String password) {
		boolean isSuccess = false;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "insert into user values (0,'" + name + "','" + username + "', '" + email + "','" + phone
					+ "', '" + nic + "', '" + address + "', '" + password + "')";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	// Updates an existing user's details in the database
	public static boolean updateuser(String id, String name, String username, String email, String phone, String nic,
			String address, String password) {

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update user set fullName = '" + name + "', userName = '" + username + "', email = '" + email
					+ "', phoneNO = '" + phone + "', nic = '" + nic + "', address = '" + address + "', password = '"
					+ password + "' where userID = '" + id + "'";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}
	
	// Retrieves user details based on the ID
	public static List<User> getUserDetails(String Id) {

		int convertedID = Integer.parseInt(Id);

		ArrayList<User> use = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from user where userID = '" + convertedID + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String uname = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String nic = rs.getString(6);
				String address = rs.getString(7);
				String passU = rs.getString(8);

				User u = new User(id, name, uname, email, phone, nic, address, passU);
				use.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return use;

	}
	
	// Deletes a user from the database based on the ID
	public static boolean deleteUser(String id) {

		int convertedID = Integer.parseInt(id);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "delete from user where userID = '" + convertedID + "' ";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}
}