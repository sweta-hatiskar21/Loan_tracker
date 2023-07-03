package com.loansystem.Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.loansystem.DTO.Loan;
import com.loansystem.Service.LoanTrackerSvcImpl;

@RestController
public class LoanTracker {

	@Autowired
	public LoanTrackerSvcImpl loanTrackerSvcImpl;
	
	private Map<String, Double> remainingAmountAggregation;
    private Map<String, Double> interestAggregation;
    private Map<String, Double> penaltyAggregation;

    
    public LoanTracker() {
        remainingAmountAggregation = new HashMap<>();
        interestAggregation = new HashMap<>();
        penaltyAggregation = new HashMap<>();
    }

	@GetMapping(value = "/addLoans")
	public String addLoans(@ModelAttribute Loan loan) {
		//for testing
 		//Loan loan= new Loan("L2", "C1", "LEN1", 1000, 1000, LocalDate.of(2022,7,15), 1, LocalDate.of(2023,7,4),0.01, "S");

		System.out.println("addloans started");
		String status;
		try {
		status=loanTrackerSvcImpl.addLoan(loan);
		if (status.equalsIgnoreCase("success")) {
			getaggregation(loan);
		}
		} catch (Exception e) {
			e.printStackTrace();
			return status=e.getMessage();
		}
		return status;
	}
		public void getaggregation(Loan loan) {
			updateAggregation(remainingAmountAggregation, loan.getLenderid(), loan.getRemainingamount());
	        updateAggregation(interestAggregation, loan.getLenderid(), loan.getInterestperday());
	        updateAggregation(penaltyAggregation, loan.getCustomerid(), loan.getPenalty());
	    }
	    private void updateAggregation(Map<String, Double> aggregationMap, String key, double value) {
	        double existingValue = aggregationMap.getOrDefault(key, 0.0);
	        aggregationMap.put(key, existingValue + value);
	    }

	public Map<String, Double> getremainingAmountAggregation() {
		return remainingAmountAggregation;
	}
	
	public Map<String, Double> getinterestAggregation() {
		return interestAggregation;
	}
	public Map<String, Double> gettpenaltyAggregation() {
		return penaltyAggregation;
	}
}
