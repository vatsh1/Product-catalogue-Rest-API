<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<%
String id = request.getParameter("id");
String title = request.getParameter("Title");
String quantity = request.getParameter("Quantity");
String size = request.getParameter("Size");
String image = request.getParameter("Image");
String url = "jdbc:mysql://localhost:3306/ecommerce";
if(id!= null){
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String query = "Update productdata set id=?,Title=?,Quantity=?,Size=?,Image=? where id=" + id;
		Connection conn = DriverManager.getConnection(url,"root","root");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,id);
		ps.setString(2,title);
		ps.setString(3,quantity);
		ps.setString(4,size);
		ps.setString(5,image);
		int i = ps.executeUpdate();
		if(i>0){
			response.sendRedirect("product.jsp");
		}else{
			out.print("There is a problem editing Record");
		}
	} catch(SQLException e){
		request.setAttribute("error", e);
		out.println(e);
	}
}
%>