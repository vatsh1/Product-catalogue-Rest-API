<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*"%>
<% 
String id = request.getParameter("id");
String url = "jdbc:mysql://localhost:3306/ecommerce";
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url,"root","root");
	Statement st = conn.createStatement();
	int i = st.executeUpdate("DELETE FROM productdata WHERE id="+id);
	response.sendRedirect("product.jsp");
}catch(SQLException e){
	out.print(e);
	e.printStackTrace();
}
%>