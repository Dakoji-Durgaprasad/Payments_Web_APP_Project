<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Do transaction</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="title">
		<h1>Send Money</h1>
	</div>
	<div class="container">

		<div class="sendmoneyform">
			<form action="http://localhost:8080/PaymentsWebApp/SendMoneyServlet" method="post">
				<div class="sendmoneyInputs">
					<input type="text" name="txnamount" id="txnamount" class="txnamount" placeholder="Enter an amount to send" required> 
					<select	name="txnFrom" id="txnFrom" required>
						<option value=" ">Select txn Type....</option>
						<option value="wallet">Wallet</option>
						<option value="bank">BANK ACCOUNT</option>
					</select> 
                    <table>
                        <tr>
                        <td><input type="radio" name="txnTo" id="txnTo" class="txnTo" value="wallet" onclick="showWalBox()" required></td>
                        <td> To Wallet </td>
                        </tr>
                        <tr>
                        <td><input type="radio" name="txnTo" id="txnTo" class="txnTo" value="bank" onclick="showBankBox()" required> </td>
                        <td> To Bank Account</label></td>
                        </tr>                 
                    </table>
                        <input type="text" name="userWalletTosendMoney" id="enterusertosend" placeholder="Enter Users Id/Phone Number/ User Name..">
                        <input type="text" name="userBankAcctToSendMoney" id="enterbankaccttosend" placeholder="Enter Users Bank Account Number..">
					<input type="submit" value="SEND" class="subtn">
				</div>
			</form>
		</div>
	</div>

    <script>
         function showWalBox() {
            document.getElementById('enterusertosend').style.display = 'inline';
            document.getElementById('enterbankaccttosend').style.display = 'none';
        }

        function showBankBox() {
            document.getElementById('enterbankaccttosend').style.display = 'inline';
            document.getElementById('enterusertosend').style.display = 'none';
        }
    </script>
</body>
</html>