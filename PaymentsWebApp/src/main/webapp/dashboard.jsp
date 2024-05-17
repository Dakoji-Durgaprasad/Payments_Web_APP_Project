<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.pack.dto.User"%>
<%@ page import="com.pack.dto.BankAccount"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dash Board</title>
<link rel="stylesheet" href="dashboard.css">
</head>
<body>
	<%User sessionUser = (User)session.getAttribute("user");%>
	<div class="dashboard-title nav-bar">
		<h1>Payments Web App</h1>
		<div class="title-align">
			<h2>
				 Welcome,
				<%=((User)request.getAttribute("user")).getFirstName()%>
				!
			</h2>
			<div class="logoutbtn">
				<form action="" method="">
					<input type="submit" value="Logout">
				</form>
			</div>
		</div>
	</div>
	<!-- ---------------BOX - 1------------------ -->
	<div class="box1">
		<div class="primary-box">
			<h2>Primary Bank Account No :</h2>
			<h3>Account Balance :</h3>
			<h3>Wallet Balance :</h3>
		</div>
		<div class="sendmoney-btn">
			<form action="http://localhost:8080/PaymentsWebApp/" method="">
				<input type="submit" value="Send Money">
			</form>
		</div>
	</div>
	<!-- ---------------BOX - 2------------------ -->
	<div class="box2">
		<div class="table-data scrollmenu">
			<% List<BankAccount> baList = (List<BankAccount>)request.getAttribute("baList");%>
			<table>
				<tr>
					<%
                	for(int i=0;i<baList.size();i++){
						BankAccount ba = baList.get(i);
					%>
					<td>
						<p>
							Bank Name :
							<%=ba.getBankName() %></p>
						<p>
							Bank Account No :
							<%=ba.getBankAcctNum()%></p>
						<p>
							Balance : <span onclick="showBal()" id="showbtn">Show</span>
							<span id="bal"> <%=ba.getBankAcctCurBalance() %></span>
						</p>
						<p>
							IFSC Code :
							<%=ba.getBankIfscCode() %></p>
						<div class="editOptions">
							<form action="" method="">
								<input type="submit" value="Edit">
							</form>
							<form action="" method="">
								<input type="submit" value="Del">
							</form>
						</div>
					</td>
					<% } %>
				</tr>
			</table>
		</div>
		<div class="addbankacct">
			<form action="http://localhost:8080/PaymentsWebApp/bankacctform.jsp" method="">
				<input type="submit" value="Add New Bank Account">
			</form>
		</div>
	</div>
	<!-- ---------------BOX - 3------------------ -->
	<div class="box3">
		<div class="statmentbox">
			<h2>Recent txns list</h2>
			<p>1000 sent to ravi</p>
			<p>2000 received from rao</p>
			<p>.......</p>
			<p>.......</p>
			<p>.......</p>
		</div>
		<div class="detailedstmt">
			<form action="" method="">
				<input type="submit" value="Detailed Statement">
			</form>
		</div>
	</div>

	<script>
        function showBal() {
            document.getElementById('bal').style.display = 'inline';
            document.getElementById('showbtn').style.display = 'none';
        }
    </script>
</body>
</html>
