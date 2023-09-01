package com.productManagementApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	String sql = "select * from LoginCredentials Where Username = ?";
	String sqlQuery = "select * from LoginCredentials Where Username = ? and Password = ?";
	String url = "jdbc:mysql://localhost:3306/ecommerce";
	String username = "root";
	String password = "root";
	public boolean check(String uname/*, String pass*/) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			/*st.setString(2, pass);*/
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean verifyAuthentication(String uname, String pass) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sqlQuery);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
