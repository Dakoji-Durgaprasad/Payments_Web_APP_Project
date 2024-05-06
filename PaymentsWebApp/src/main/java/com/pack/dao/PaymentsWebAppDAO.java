
package com.pack.dao;

import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pack.dto.User;

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
					+ "values('" + u.getUserName() + "','" + u.getFirstName() + "','" + u.getLastName() + "','" + u.getEmail() + "','" + u.getPhoneNumber() + "','" + u.getDateOfBirth()
					+ "','" + u.getAddress() + "','" + u.getPassword() + "')";

			int rs = st.executeUpdate(storeUserDetailsQuery);
			System.out.println(rs + " row/s effected.\n");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void storeUserBankDetails(String acctNum, String acctHolderName, String bankName, String acctIfscCode,
//			String pin, String acctType, String userName, double bankBalance, String ph_num) {
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
//					"root");
//			Statement st = con.createStatement();
//			String storeUserBankDetailsQuery = "insert into Bank_acct_details(Acct_Num, Acct_Holder_Name, Bank_Name, Acct_IFSC_Code, Acct_Pin, Acct_Type, User_Name, BanK_Balance, Phone_Num)"
//					+ "values('" + acctNum + "','" + acctHolderName + "', '" + bankName + "',  '" + acctIfscCode
//					+ "', '" + pin + "', '" + acctType + "', '" + userName + "', '"+ bankBalance +"','" + ph_num + "')";
//
//			int rs = st.executeUpdate(storeUserBankDetailsQuery);
//			System.out.println(rs + " row/s effected.\n");
//
//			con.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/*
	 * ---------------------------------------------------- Validating Data in the
	 * DataBase---------------------------------------------------------------------
	 * -
	 */

	public static boolean loginValidate(String userNameOrPhoneNo, String password) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments_web_app", "root",
					"root");
			Statement st = con.createStatement();
			String loginValidateQuery = "SELECT User_Name, Phone_Number, Password FROM user_info WHERE (User_Name = '" + userNameOrPhoneNo +"' || Phone_Number = '"+ userNameOrPhoneNo +"') && Password ='"+ password +"'";
			ResultSet rs = st.executeQuery(loginValidateQuery);
			while (rs.next()) {
				System.out.println("Login Successfull !!");
			}
			con.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * ---------------------------------------------------- Viewing Data in the
	 * DataBase---------------------------------------------------------------------
	 * -
	 */

}
