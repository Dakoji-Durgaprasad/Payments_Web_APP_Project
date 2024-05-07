<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="title">
		<h1>Welcome To The Payments Application</h1>
	</div>
	<div class="container">

		<div class="logform">
			<div class="subtitle">
				<h2>Login</h2>
			</div>
			<form action="http://localhost:8080/PaymentsWebApp/LoginServlet"
				method="post">
				<div class="loginInputs">

					<input type="text" name="username" id="username" class="urname" placeholder="User Name/Phone Number...." required> 
					<input type="password" name="pswd" id="pswd" class="pswd" placeholder="Enter Your Password..." required> 
					<input type="submit" value="LOGIN" class="subtn">

					<p class="passage">
						If you are new! ? <a href="register.jsp" class="a">Register
							here</a>
					</p>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
