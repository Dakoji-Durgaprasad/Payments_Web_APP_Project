<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash Board</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="title dashboardtitle">
		<h1>Welcome To The Payments Application</h1>
        <p><a href="#">Profile</a></p>
	</div>
	<div class="container options">
		<div class="row">
			<div class="col">
			
				<form action="http://localhost:8080/PaymentsWebApp/PrimaryAcctServlet" method="">
					<input type="submit" value="PRIMARY ACCOUNT AND BALANCE">
				</form>
				
				<form action="http://localhost:8080/PaymentsWebApp/BankAcctDetailsServlet" method="">
					<input type="submit" value="LIST OF BANK ACCOUNTS">
				</form>
				
				
				<form action="">
					<input type="submit" value="REQUEST FOR STATEMENT">
				</form>
			</div>
			<div class="col">
				
				<form action="http://localhost:8080/PaymentsWebApp/WalletBalanceServlet" method="">
					<input type="submit" value="WALLET BALANCE">
				</form>
				
				<form action="http://localhost:8080/PaymentsWebApp/TransactionOperationsServlet" method="">
					<input type="submit" value="SEND MONEY">
				</form>
				
				<form action="http://localhost:8080/PaymentsWebApp/index.html" method="">
					<input type="submit" value="LOG OUT">
				</form>
			</div>
		</div>
	</div>
</body>
</html>