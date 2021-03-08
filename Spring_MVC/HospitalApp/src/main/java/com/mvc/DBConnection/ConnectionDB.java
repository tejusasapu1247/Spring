package com.mvc.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	public static Connection InitializeDatabase() throws SQLException, ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from patients");
//			while (rs.next())
//				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
//						+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
//			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
//	 public static void main(String args[]) throws ClassNotFoundException,
//	 SQLException {
//	 ConnectionDB con=new ConnectionDB();
//	 InitializeDatabase();
//}

}
