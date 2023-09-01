<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset = "ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- <link rel="stylesheet" type="text/css" href="product.css"> -->
	<style type="text/css">
		div{
			margin-bottom:0px;
		}
		label {
			display: inline-block;
			width: 70px;
			text-align: left;
		}
	</style>
</head>
<body>
	<div class="container">
	<form align = "right" action="logout">
		Hii <b>${user}</b> <input type="submit" value = "logout">
	</form>
	<center>
		<h2>Product Management Tool</h2>
	</center>
	<h4>Please enter product details to add to stock</h4>
	<form action="AddProductInDB" method="post">
		<div>
			<label>Title: </label><input type="text" name="Title" required>
		</div>
		<br>
		<div>
			<label>Quantity: </label><input type="text" name="Quantity" required>
		</div>
		<br>
		<div>
			<label>Size: </label><input type="text" name="Size" required>
		</div>
		<br>
		<div>
			<label>Image: </label><input type="text" name="Image" required>
		</div>
		<br>
		<div>
			<input type="submit" value="Add"><br> <br>
		</div>
	</form>
	
	<%
	String sqlQuery = "select * from productdata Where Username = ?";
	String url = "jdbc:mysql://localhost:3306/ecommerce";
	int i = 1;
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		PreparedStatement st = con.prepareStatement(sqlQuery);
		String name = session.getAttribute("user").toString();
		st.setString(1,name);
		ResultSet rs = st.executeQuery();
	%>
	<center>
		<table style = "text-align:center; width:90%;border-collapse:collapse;
		border-spacing:inherit;border-color:black;" border = "1" >
			<tr height="5px">
				<td>S.NO.</td>
				<td>Title</td>
				<td>Quantity</td>
				<td>Size</td>
				<td>Image</td>
				<td>Action</td>
			</tr>
			<%
			while(rs.next()){
			%>
			<tr height = "120px">
				<td><%=i%></td>
				<td><%=rs.getString("Title")%></td>
				<td><%=rs.getString("Quantity")%></td>
				<td><%=rs.getString("Size")%></td>
				<td><img src ="<%=rs.getString("Image")%>" alt="img loading.." width = "100" height = "70"></td>
				<td><a href="Delete.jsp?id=<%=rs.getString("id")%>"><img alt="delete" src="https://cdn.onlinewebfonts.com/svg/img_216917.png" width = "20" height = "20"></a>
				<a style = "margin-left:19px" href="Edit.jsp?id=<%=rs.getString("id")%>"><img  alt="delete" src="https://th.bing.com/th/id/R.e3d9ab63fdb9b258a62921535e0f8a3a?rik=uhDZS4Ak03dfww&riu=http%3a%2f%2fcdn.onlinewebfonts.com%2fsvg%2fimg_386644.png&ehk=RK039QvKQGHWDkqFd6IH6qStFaYVwvoX1nijQYAiAhk%3d&risl=&pid=ImgRaw&r=0" width = "20" height = "20"></a>
				</td>
			</tr>
			<%
			i++;
			}
			%>
		</table>
	</center>
	<%
	con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	%>
	</div>
	 

</body>
</html>