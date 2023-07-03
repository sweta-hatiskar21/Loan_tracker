package com.loansystem.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loansystem.DTO.Loan;
import com.loansystem.Repository.LoanTrackerRepoImpl;

@Service
public class LoanTrackerSvcImpl {

	@Autowired
	LoanTrackerRepoImpl loanTrackerRepoImpl;
	
	public String addLoan(Loan loan) throws Exception {
		checkloandetails(loan);
		checkduealert(loan);
		loanTrackerRepoImpl.addLoan(loan);
		return "success";
	}

	private String checkloandetails(Loan loan) throws Exception {
		// TODO Auto-generated method stub
		
		if((loan.getPaymentdate().compareTo(loan.getDuedate()))<0) {
			System.out.println("validation successfully");
			return "Validation Successful";
		}
		else {
			System.out.println("Payment date can't be greater than due date");
			throw new Exception("Payment date can't be greater than due date");

		}
	}

   public void checkduealert(Loan loan) throws Exception {	
	   if(loan.getDuedate().isBefore(LocalDate.now())) {
			System.out.println("loan with id-"+loan.getLoanid()+"has passed due date");
			throw new Exception("loan with id-"+loan.getLoanid()+"has passed due date");

		}
	}



	/*
	 * public Map<String, Loan> getaggreationonremainingamount() { // TODO
	 * Auto-generated method stub return
	 * loanTrackerRepoImpl.getaggreationonremainingamount(); }
	 */

}
