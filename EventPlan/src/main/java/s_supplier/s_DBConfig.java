package s_supplier;

import java.sql.Connection;
import java.sql.DriverManager;

public class s_DBConfig {

	private static String url = "jdbc:mysql://localhost:3306/eventplan";
	private static String user = "root";
	private static String password = "s2001";
	

	private static Connection con;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Database connection is not success!");
		}

		return con;
	}
}