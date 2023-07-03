package com.loansystem.DTO;


import java.time.LocalDate;

import lombok.Data;

@Data
public class Loan {

	public String loanid;
	public String customerid;
	public String lenderid;
	public double amount;
	public double remainingamount;
	public LocalDate paymentdate;
	public float interestperday;
	public 	LocalDate duedate;
	public double penalty;
	public String cancel;
	public Loan(String loanid, String customerid, String lenderid, double amount, double remainingamount,
			LocalDate paymentdate, float interestperday, LocalDate duedate, double penalty, String cancel) {
		super();
		this.loanid = loanid;
		this.customerid = customerid;
		this.lenderid = lenderid;
		this.amount = amount;
		this.remainingamount = remainingamount;
		this.paymentdate = paymentdate;
		this.interestperday = interestperday;
		this.duedate = duedate;
		this.penalty = penalty;
		this.cancel = cancel;
	}
	
	
}
