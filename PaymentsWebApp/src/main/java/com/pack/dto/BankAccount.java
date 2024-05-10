package com.pack.dto;

public class BankAccount {

	int bankAcctId;
	String bankAcctNum;
	String bankAcctHolderName;
	String bankName;
	String bankIfscCode;
	String bankAcctPin;
	String bankAcctType;
	double bankAcctCurBalance;
	long phoneNumber;
	
	int userId;
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBankAcctId() {
		return bankAcctId;
	}
	public void setBankAcctId(int bankAcctId) {
		this.bankAcctId = bankAcctId;
	}
	public String getBankAcctNum() {
		return bankAcctNum;
	}
	public void setBankAcctNum(String bankAcctNum) {
		this.bankAcctNum = bankAcctNum;
	}
	public String getBankAcctHolderName() {
		return bankAcctHolderName;
	}
	public void setBankAcctHolderName(String bankAcctHolderName) {
		this.bankAcctHolderName = bankAcctHolderName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankIfscCode() {
		return bankIfscCode;
	}
	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}
	public String getBankAcctPin() {
		return bankAcctPin;
	}
	public void setBankAcctPin(String bankAcctPin) {
		this.bankAcctPin = bankAcctPin;
	}
	public String getBankAcctType() {
		return bankAcctType;
	}
	public void setBankAcctType(String bankAcctType) {
		this.bankAcctType = bankAcctType;
	}
	public double getBankAcctCurBalance() {
		return bankAcctCurBalance;
	}
	public void setBankAcctCurBalance(double bankAcctCurBalance) {
		this.bankAcctCurBalance = bankAcctCurBalance;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
