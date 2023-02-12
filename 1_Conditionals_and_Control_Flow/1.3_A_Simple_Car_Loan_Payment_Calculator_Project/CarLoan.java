public class CarLoan {
	public static void main(String[] args) {
    /* This program calculates the monthly car payment a user should expect to make after taking out a car loan.*/
    
    int carLoan = 10000;
    int loanLength = 3; // Loan length in years.
    int interestRate = 5; // Interest rate in %
    int downPayment = 2000;
    int remainingBalance = 0;
    
    if((loanLength <= 0) || (interestRate <= 0)) {
      System.out.println("Error! You must take out a valid car loan.");
    }
    else if(downPayment >= carLoan) {
      System.out.println("The car can be paid in full.");
    }
    else {
      remainingBalance = carLoan - downPayment;
    }
    
    int months = loanLength * 12;
    int monthlyBalance = remainingBalance / months;
    int interest = (monthlyBalance * interestRate) / 100;
    int monthlyPayment = monthlyBalance + interest;
    
    System.out.println(monthlyPayment);
	}
}
