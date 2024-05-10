
CREATE DATABASE payments_web_app;

USE payments_web_app;

CREATE TABLE user_info(
Id INT  PRIMARY KEY AUTO_INCREMENT,
User_Name VARCHAR(50) UNIQUE NOT NULL,
First_Name VARCHAR(50) NOT NULL,
Last_Name VARCHAR(50) NOT NULL,
Email_Id VARCHAR(30) UNIQUE NOT NULL,
Phone_Number  VARCHAR(15) UNIQUE NOT NULL,
Date_Of_Birth DATE NOT NULL,
Address VARCHAR(150) NOT NULL,
Password VARCHAR(15) NOT NULL,
Wallet_Balance DOUBLE NOT NULL DEFAULT "0"
);

DESC user_info;

SELECT * FROM user_info;	

-- delete from  user_info;
-- SET SQL_SAFE_UPDATES = 0;  // Uses to 'off' safe mode while deleting data in the table.
-- SET SQL_SAFE_UPDATES = 1;  // Uses to 'on' safe mode to prevent the data from deleting.
-- drop table user_info;

SELECT User_Name, Phone_Number, Password FROM user_info WHERE ((User_Name = "" || Phone_Number = "6303244920") && Password ="Dp@123");

CREATE TABLE Bank_Account_Type(
Id INT UNIQUE NOT NULL AUTO_INCREMENT,
Acct_Type_Code VARCHAR(3) PRIMARY KEY,
Acct_Type_Name VARCHAR(15)
);
INSERT INTO Bank_Account_Type(Id,Acct_Type_Code,Acct_Type_Name) 
VALUES (1,"SA","SAVINGS ACCOUNT"),
(2,"CA","CURRENT ACCOUNT"),
(3,"LA","LOAN ACCOUNT"),
(4,"SL","SALARY ACCOUNT");

DESC Bank_Account_Type;
SELECT * FROM Bank_Account_Type;


CREATE TABLE Bank_Acct_Details(
Id INT PRIMARY KEY AUTO_INCREMENT,
Acct_Num VARCHAR(30) UNIQUE NOT NULL,
Acct_Holder_Name VARCHAR(50) NOT NULL,
Bank_Name VARCHAR(40) NOT NULL,
Acct_IFSC_Code VARCHAR(20) NOT NULL,
Acct_Pin VARCHAR(30) NOT NULL,
Acct_Type VARCHAR(3) NOT NULL, 
FOREIGN KEY(Acct_Type) REFERENCES Bank_Account_Type(Acct_Type_Code)
ON UPDATE CASCADE
ON DELETE CASCADE,
User_Id  INT NOT NULL, FOREIGN KEY(User_Id) REFERENCES User_info(Id)
ON UPDATE CASCADE
ON DELETE CASCADE,
BanK_Balance DOUBLE NOT NULL DEFAULT "0",
Phone_Num varchar(20) not null
);

select * from Bank_acct_details;

-- alter table bank_acct_details 
-- add column Phone_Num varchar(20) not null ;

CREATE TABLE Txn_Details (
    TxnId INT PRIMARY KEY AUTO_INCREMENT,
    TxnDate DATETIME NOT NULL,
    TxnAmount DOUBLE NOT NULL,
    source_type ENUM("BA","WA"),
    source_id INT NOT NULL,
    dest_type ENUM("BA","WA"),
    dest_id INT NOT NULL,
    User_Id  INT NOT NULL, FOREIGN KEY(User_Id) REFERENCES User_info(Id)
);

select * from Txn_Details;

select * from INFORMATION_SCHEMA.key_column_usage
where table_name ='Bank_Acct_Details';


select * from  INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
where table_name ='BankAccounts'
and column_name='userid';
