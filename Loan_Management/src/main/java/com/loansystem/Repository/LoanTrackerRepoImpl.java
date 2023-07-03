package com.loansystem.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.loansystem.Constant.LoanTrackerQueryConstant;
import com.loansystem.DTO.Loan;

@Repository
public class LoanTrackerRepoImpl {

	public JdbcTemplate jdbcTemplate=new JdbcTemplate();
	@Autowired
	public void setdatasource(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	//adds the loan data to database
	public void addLoan(Loan loan) {
		// TODO Auto-generated method stub
		int status;
		try {
		status=jdbcTemplate.update(LoanTrackerQueryConstant.SQL_QUERY_TO_INSERT,new Object[] {loan.getLoanid(),loan.getCustomerid(),loan.getLenderid(),loan.getAmount(),loan.getRemainingamount(),Date.valueOf(loan.getPaymentdate()),loan.getInterestperday(),Date.valueOf(loan.getDuedate()),loan.getPenalty(),loan.getCancel()});
		if (status>0) {
			System.out.println("Loan data inserted successfully");
		}
		else {
			System.out.println("Error occured while entering data");
		}
		}
		catch (Exception e) {
			System.out.println("exception occured while entering data"+e.getMessage());
		}
	}

	/*
	 * public List<Loan> getData() { List<Loan>loanlist=new ArrayList<Loan>();
	 * loanlist=jdbcTemplate.query(LoanTrackerQueryConstant.SQL_QUERY_TO_INSERT, new
	 * BeanPropertyRowMapper<Loan>(Loan.class)); return loanlist; }
	 */

	/*
	 * public Map<String, Loan> getaggreationonremainingamount() { // TODO
	 * Auto-generated method stub
	 * 
	 * Map<String, V> return null; }
	 */
	
	

}
