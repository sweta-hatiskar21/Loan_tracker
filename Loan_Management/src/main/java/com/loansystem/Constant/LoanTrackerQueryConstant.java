package com.loansystem.Constant;

public class LoanTrackerQueryConstant {

	public static final String SQL_QUERY_TO_INSERT="INSERT INTO `loan_manager`.`loan_data` (`Loan_ID`, `Customer_ID`, `Lender_ID`, `Amount`, `Remaining_Amount`, `Payment Date`, `Interest per Day(%)`, `Due Date`, `Penalty`, `Cancel`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	
	public static final String SQL_SELECT_LOAN_DATA="select loanid,paymenydate, duedate";
}
