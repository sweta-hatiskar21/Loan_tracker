package com.loansystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.loansystem"})
public class LoanManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementApplication.class, args);

// 		Loan loan= new Loan("L1", "C1", "LEN1", 1000, 1000, LocalDate.of(2022,7,15), 1, LocalDate.of(2022,7,18),0.01, "S");
//		LoanTracker l1=new LoanTracker();
//		l1.addLoans(loan);
	}

}
