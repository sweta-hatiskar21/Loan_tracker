package com.loansystem;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loansystem.Controller.LoanTracker;
import com.loansystem.DTO.Loan;
//NOTE- Testing can be done by hitting http://localhost:8080/addLoans
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    private LoanTracker loanStore;

    @BeforeEach
    void setUp() {
        loanStore = new LoanTracker();
    }

	
	/*
	 * @org.junit.jupiter.api.Test void testAddLoan_ValidLoan() { Loan loan = new
	 * Loan("L2", "C1", "LEN1", 10000, 10000, LocalDate.of(2023, 6, 5), 1,
	 * LocalDate.of(2023, 7, 5), 0.01,"S");
	 * 
	 * Assertions.assertDoesNotThrow(() -> loanStore.addLoans(loan));
	 * Assertions.assertEquals(10000,
	 * loanStore.getremainingAmountAggregation().getOrDefault("LEN1", 0.0));
	 * Assertions.assertEquals(1,
	 * loanStore.getinterestAggregation().getOrDefault("LEN1", 0.0));
	 * Assertions.assertEquals(0,
	 * loanStore.gettpenaltyAggregation().getOrDefault("C1", 0.0)); }
	 */

    @org.junit.jupiter.api.Test
    void testAddLoan_InvalidPaymentDate() {
        Loan loan = new Loan("L6", "C1", "LEN1", 20000, 5000, LocalDate.of(2023, 6, 1),
                1, LocalDate.of(2023, 5, 8), 0.01,"S");

        Assertions.assertEquals("Payment date can't be greater than due date", loanStore.addLoans(loan));
    }

    @org.junit.jupiter.api.Test
    void testCheckDueDateAlert_DueDateNotCrossed() {
        Loan loan = new Loan("L3", "C2", "LEN2", 50000, 30000, LocalDate.of(2023, 4, 4),
                2, LocalDate.of(2023, 4, 5), 0.02,"S");

        Assertions.assertEquals("success", loanStore.addLoans(loan));
    }

    @org.junit.jupiter.api.Test
    void testCheckDueDateAlert_DueDateCrossed() {
        Loan loan = new Loan("L4", "C3", "LEN2", 50000, 30000, LocalDate.of(2023, 4, 4),
                2, LocalDate.of(2023, 3, 1), 0.02,"S");

        Assertions.assertEquals("loan with id-"+loan.getLoanid()+"has passed due date", loanStore.addLoans(loan));
        // Due date crossed, an alert message should be printed
    }
}


