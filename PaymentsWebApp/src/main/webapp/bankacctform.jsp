<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Bank Account Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="title">
		<h1>Bank Account Form</h1>
	</div>
    <div class="container bankform">
        <form action="http://localhost:8080/PaymentsWebApp/BankAcctFormServlet" method="post">
            <div class="bankforminput">
            <input type="text" name="bankAcctNo" class="bankAcctNo" placeholder="Enter Account Number...." required>
            <input type="text" name="AcctHolderName" class="AcctHolderName" placeholder="Enter Account Holder Name...." required>
            <input type="text" name="bankName" class="bankName" placeholder="Enter Bank Name...." required>
            <input type="text" name="bankIfscCode" class="bankIfscCode" placeholder="Enter Bank IFSC Code...." required>
            <select name="bankAcctType" id="bankAcctType" required>
                <option value=" ">Select Account Type....</option>
                <option value="SA"> SAVINGS ACCOUNT </option>
                <option value="CU"> CURRENT ACCOUNT </option>
                <option value="LA"> LOAN ACCOUNT </option>
                <option value="SL"> SALARY ACCOUNT </option>
            </select>
            <input type="text" name="ph_num" class="ph_num" placeholder="Enter Bank Linked Mobile Number...." required>
            <input type="password" name="bankAcctPin" class="bankAcctPin" placeholder="Enter Bank Pin...." required>
            <input type="submit" value="ADD ACCOUNT" class="subtn">
        </div>
        </form>
    </div>
</body>
</html>