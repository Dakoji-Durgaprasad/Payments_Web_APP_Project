<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<div class="title">
		<h1>Welcome To The Payments Application</h1>
	</div>
	<div class="container">

		<div class="regform">
			<div class="subtitle">
				<h2>REGISTRATION</h2>
			</div>
			<form action="http://localhost:8080/PaymentsWebApp/RegisterServlet" method="post">
				<div class="registerInputs">
					<div class="row">
						<div class="col">
							<input type="text" placeholder="User Name..." name="username" required>
							<input type="text" placeholder="First Name..." name="firstname" required>
							<input type="text" placeholder="Last Name..." name="lastname" required>
							<input type="email" placeholder="Email-Id..." name="email" required>
						</div>
						<div class="col">
							<input type="text" placeholder="Phone No..." name="phno" required>
							<input type="date" placeholder="Date Of Birth..." name="dob" required>
							<input type="text" placeholder="Address..." name="address" required>
							<input type="password" placeholder="Password..." name="pswd" required>
						</div>
					</div>
					<input type="submit" value="Register" class="subtn">
					<p class="passage">
						If you have already register. please <a href="index.jsp" class="a">Login
							here</a>
					</p>
				</div>

			</form>
		</div>
	</div>
</body>
</html>