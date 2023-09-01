<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.util.*"%>
<%
	String id = request.getParameter("id");
	String title = request.getParameter("Title");
	String quantity = request.getParameter("Quantity");
	String size = request.getParameter("Size");
	String image = request.getParameter("Image");
	String url = "jdbc:mysql://localhost:3306/ecommerce";
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,"root","root");
		String sqlQuery = "Select * from productdata where id="+id;
		PreparedStatement st = conn.prepareStatement(sqlQuery);
		ResultSet rs = st.executeQuery(sqlQuery);
		while(rs.next()){
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Record</title>
<style>
label{
	display: inline-block;
	width:70px;
	text-align:left;
}
</style>
</head>
<body>
<form action="Edit-process.jsp" method="post">
<input type="hidden" name="id" value="<%=rs.getString("id")%>">
<br>
<label>Title: </label><input type="text" name="Title" value="<%=rs.getString("Title")%>"><br><br>
<label>Quantity: </label><input type="text" name="Quantity" value="<%=rs.getString("Quantity")%>"><br><br>
<label>Size: </label><input type="text" name="Size" value="<%=rs.getString("Size")%>"><br><br>
<label>Image: </label><input type="text" name="Image" value="<%=rs.getString("Image")%>"><br><br>
<input type="submit" value="submit">
</form>
<%
}
conn.close();
	} catch(SQLException e){
		e.printStackTrace();
	}
%>
</body>
</html>