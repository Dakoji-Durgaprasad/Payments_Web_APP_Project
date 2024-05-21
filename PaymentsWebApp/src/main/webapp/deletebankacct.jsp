<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Bank Account</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="title">
		<h1>Delete Bank Account</h1>
	</div>
	<div class="container">
		<div class="deletebankacctform">
			<form action="http://localhost:8080/PaymentsWebApp/LoginServlet"
				method="post">
				<div class="delbankacctInputs">
					<input type="text" name="delacctno" id="delacctno" class="delacctno" placeholder="Please Re-Enter Bank Account Number To Delete" required> 
					<input type="submit" value="CONFIRM" class="subtn">
				</div>
			</form>
		</div>
	</div>
</body>
</html>