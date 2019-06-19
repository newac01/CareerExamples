//Aaron New
//CS 161
//Project 1
//Calculation Class
public class AutoInfoLoan {
	// fields
	private double salesTaxAmt, loanAmt, monthPay, totalPay;

	// overloaded constructor receiving variables from combined panels
	public AutoInfoLoan(double interestRate, double basePrice,
			double downPayment, double salesTax, double optionCost,
			int numberOfMonths) {
		salesTax = (salesTax / 100);
		// calculations
		salesTaxAmt = (basePrice - downPayment + optionCost) * salesTax;
		loanAmt = basePrice - downPayment + optionCost + salesTaxAmt;
		// get monthly rate to calculate the monthly payment
		interestRate = (interestRate / 12);
		monthPay = loanAmt
				* interestRate
				/ (1 - (Math.pow(1 / (1 + interestRate),
						(double) numberOfMonths)));
		totalPay = monthPay * numberOfMonths + downPayment;
	}// end AutoInfoLoan constructor

	// getter methods to return values to JLabels in combined panels
	public double getLoanAmt() {
		return loanAmt;
	}// end method

	public double getmonthPay() {
		return monthPay;
	}// end method

	public double getTotalPay() {
		return totalPay;
	}// end method

}// end AutoInfoLoan PUBLIC Class
