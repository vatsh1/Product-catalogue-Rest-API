<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login/Register</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body >
	<div class="container" style = "margin-top:90px;">
		<div id = "loginBackgroundDgn" style = "background-color:#f4f8fb;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
			<form class="form-horizontal" action="login" method = "post">
				<div class="form-group dgn" id = "Backgroungdesign">
					<label class="control-label col-sm-1" for="email" id = "loginTxtDgn" >Login</label>
				</div>
				<div class="form-group" id = "usernameDgn">
					<label class="control-label col-sm-2" for="email">Username:</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" id="Username"
							placeholder="Enter Username" name="username" required>
					</div>
				</div>
				<div class="form-group" id = "usernameDgn">
					<label class="control-label col-sm-2" for="pwd">Password:</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="pwd"
							placeholder="Enter password" name="pwd" required>
					</div>
					
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style = "float:right;margin-right:3px;">
						<div class="checkbox">
							<a href="#forgetPassword">Forgotten Your Password?</a>
						</div>
					</div>
				</div>
				<div class="form-group" id = "Backgroungdesign">
					<div class="col-sm-offset-2 col-sm-4" style = "float:right">
						<button type="submit" class="btn btn-default" id = "btnBorderColor">Login</button>
					</div>
				</div>
			</form>
		</div>
		<b style = "color:red;"> ${var}</b>
	</div>
	
	

	
	
	 

</body>
</html>