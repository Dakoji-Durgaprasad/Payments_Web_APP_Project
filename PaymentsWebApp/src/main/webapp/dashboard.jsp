<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.pack.dto.User"%>
<%@ page import="com.pack.dto.BankAccount" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash Board</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="title main-title">
		<h1>Payments Web App</h1>
	</div>
	<div class="title dashboardtitle">
		<%
			User sessionUser = (User)session.getAttribute("user");
		%>
		<pre>
		<h1>Welcome, <%out.print(request.getParameter("username"));%></h1> 
		<!--  <h1>Welcome, <%--((User)request.getAttribute("user")).getLastName()--%></h1> -->
		</pre>
		<p>
            <form action="index.jsp" method="">
                <input type="submit" value="Logout">
            </form>
		</p>
		
	</div>
	
	<div class="container box1">
		<div class="primaryDetails primarybox">
			<h2>PRIMARY ACCOUNT NO : </h2>
			<h3>ACCOUNT BALANCE : </h3>
			<h3>WALLET BALANCE : </h3>
		</div>	
		<div  class="addnewbankacct primarybox">
			<form action="" method="" >
                <input type="submit" value="SEND MONEY">
            </form>
		</div>
	</div>
	
	<div class="container bankdetailsbox">
	  <%-- List<BankAccount> baList = (List<BankAccount>)request.getAttribute("baList"); --%>
		<table>
			<tr>
			<%--
				for(int i=0; i<baList.size();i++){
					BankAccount ba = baList.get(i);
			--%>
				<td>
					BANK NAME :	<br>
					BANK ACCOUNT NO : <br>
					CURRENT BALANCE : <br>
					IFSC CODE : <br>
				</td>
			<%--	}	--%>
			
			<td>
				<div  class="addnewbankacct primarybox">
					<form action=" http://localhost:8080/PaymentsWebApp/bankacctform.jsp" method="" >
                		<input type="submit" value="ADD NEW BANK ACCOUNT">
            		</form>
				</div>
			</td>
			</tr>
		</table>
	</div>
	<!-- <div class="container options">
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
	</div> -->
</body>
</html>
