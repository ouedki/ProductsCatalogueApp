package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {
	private static Connection conn;
	
	static {
		try {
			String url = "jdbc:mysql://localhost:3306/CAT_DB";
			String user = "root";
			String pasword = "root";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("trying");
		conn = DriverManager.getConnection(url, user, pasword);
		System.out.println("seccess");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}
}
