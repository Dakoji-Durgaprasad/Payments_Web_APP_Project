
package com.pack.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.dto.User;
import com.pack.dto.BankAccount;

public class PaymentsWebAppDAO {

	/*
	 * ---------------------------------------------------- Storing Data in to
	 * DataBase---------------------------------------------------------------------
	 * --------
	 */

	public static void storeUserDetails(User u) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String storeUserDetailsQuery = "insert into User_info(User_Name, First_Name, Last_Name, Email_Id, Phone_Number, Date_Of_Birth, Address, Password) "
					+ "values('" + u.getUserName() + "','" + u.getFirstName() + "','" + u.getLastName() + "','"
					+ u.getEmail() + "','" + u.getPhoneNumber() + "','" + u.getDateOfBirth() + "','" + u.getAddress()
					+ "','" + u.getPassword() + "')";

			int rs = st.executeUpdate(storeUserDetailsQuery);
			System.out.println(rs + " row/s effected.\n");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void storeUserBankDetails(BankAccount ba) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String storeUserBankDetailsQuery = "insert into Bank_acct_details(Acct_Num, Acct_Holder_Name, Bank_Name, Acct_IFSC_Code, Acct_Pin, Acct_Type, User_Id, BanK_Balance, Phone_Num)"
					+ "values('" + ba.getBankAcctNum() + "','" + ba.getBankAcctHolderName() + "', '" + ba.getBankName()
					+ "',  '" + ba.getBankIfscCode() + "', '" + ba.getBankAcctPin() + "', '" + ba.getBankAcctType()
					+ "', '" + ba.getUserId() + "', '" + ba.getBankAcctCurBalance() + "','" + ba.getPhoneNumber()
					+ "')";

			int rs = st.executeUpdate(storeUserBankDetailsQuery);
			System.out.println(rs + " row/s effected.\n");

			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ---------------------------------------------------- Validating Data in the
	 * DataBase---------------------------------------------------------------------
	 * -
	 */

	public static boolean loginValidate(String userNameOrPhoneNo, String password) throws SQLException {
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String loginValidateQuery = "SELECT User_Name, Phone_Number, Password FROM user_info WHERE (User_Name = '"
					+ userNameOrPhoneNo + "' || Phone_Number = '" + userNameOrPhoneNo + "') && Password ='" + password
					+ "'";
			ResultSet rs = st.executeQuery(loginValidateQuery);
			while (rs.next()) {
				System.out.println("Login Successfull !!");
//				System.out.println(rs.getInt("Id"));
//				 u.setUserId(rs.getInt("Id"));
				return true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isUserExistsWithPhNo(String userName, String phNum) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root", "root");
			Statement st = con.createStatement();
			String query = "select * from users u where (user.User_Name = '" + userName + "' && user.Phone_Number = '"
					+ phNum + "')";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				return true;
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	public static boolean verifyUserWalletBalance(int userId, double txnAmount) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String verifyUserWalletBalanceQuery = "SELECT Wallet_Balance FROM user_info WHERE Id = " + userId + " ";
			ResultSet rs = st.executeQuery(verifyUserWalletBalanceQuery);
			rs.next();
			double walletBalance = rs.getDouble("Wallet_Balance");
			if (txnAmount < walletBalance) {
				return true;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static boolean verifyUserCurBankBalance(int userId, double txnAmount) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String verifyUserCurBankBalanceQuery = "SELECT BanK_Balance FROM Bank_Acct_Details WHERE User_Id = " + userId
					+ " ";
			ResultSet rs = st.executeQuery(verifyUserCurBankBalanceQuery);
			rs.next();
			double bankBalance = rs.getDouble("BanK_Balance");
			if (txnAmount < bankBalance) {
				return true;
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/*
	 * ---------------------------------------------------- Getting Data in the
	 * DataBase---------------------------------------------------------------------
	 * -
	 */
	

	public User getUserByUserNameOrUserPhNo(String userNameOrPhoneNo) {

		User user = new User();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement stmt = con.createStatement();
			String query = "select * from User_info user where (user.User_Name = '" + userNameOrPhoneNo
					+ "' || user.Phone_Number = '" + userNameOrPhoneNo + "')";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int userId = rs.getInt("Id");
				String fName = rs.getString("First_Name");
				String lName = rs.getString("Last_Name");
				String phNo = rs.getString("Phone_Number");
				double currWABal = rs.getDouble("Wallet_Balance");

				user.setUserId(userId);
				user.setFirstName(fName);
				user.setLastName(lName);
				user.setPhoneNumber(Long.parseLong(phNo));
				user.setCurWalBalance(currWABal);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}

	public List<BankAccount> getBADetailsByuserId(int userId) {

		List<BankAccount> baList = new ArrayList<BankAccount>();
		User user = new User();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement stmt = con.createStatement();

			String query = "select * from Bank_Acct_Details ba where ba.User_Id = " + userId;
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				BankAccount ba = new BankAccount();

				String baName = rs.getString("Bank_Name");
				String baAcctNumber = rs.getString("Acct_Num");
				String currBaAcctBal = rs.getString("BanK_Balance");
				String ifscCode = rs.getString("Acct_IFSC_Code");
				String acctType = rs.getString("Acct_Type");
				int currUserId = rs.getInt("User_Id");

				ba.setUserId(currUserId);
				ba.setBankName(baName);
				ba.setBankAcctNum(baAcctNumber);
				ba.setBankAcctCurBalance(Double.parseDouble(currBaAcctBal));
				ba.setBankIfscCode(ifscCode);
				ba.setBankAcctType(acctType);
				baList.add(ba);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return baList;

	}
	
	/*
	 * ---------------------------------------------------- Deleting And Updating Bank Account  
	 * ---------------------------------------------------------------------
	 * -
	 */

	public static void deleteUserBankAccount(int accNum) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String deleteUserBankAcctQuery = "DELETE FROM Bank_Acct_Details WHERE Acct_Num = "+ accNum+" ";
			int rs = st.executeUpdate(deleteUserBankAcctQuery);
			System.out.println(rs + " record deleted.\n");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
