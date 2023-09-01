package com.productManagementApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddProductInDB extends HttpServlet {
	String url = "jdbc:mysql://localhost:3306/ecommerce";
	String username = "root";
	String password = "root";

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			HttpSession session2 = req.getSession();
			String usernamee = session2.getAttribute("user").toString();
			String title = req.getParameter("Title");
			String quantity = req.getParameter("Quantity");
			String size = req.getParameter("Size");
			String image = req.getParameter("Image");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement st = conn.createStatement();
			int i = st.executeUpdate("insert into productdata(Username,Title,Quantity,Size,Image)values('"+ usernamee +"','"+ title +"','"+ quantity +"','"+ size +"','"+ image +"')");
			res.sendRedirect("product.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
