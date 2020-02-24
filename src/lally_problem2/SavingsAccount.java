package lally_problem2;

public class SavingsAccount {

	private int savingsBalance;
	private double annualInterestRate = .04;
	
	public double calculateMonthlyInterest() {
		return (savingsBalance * annualInterestRate) / 12;
	}
	public double modifyInterestRate() {
		annualInterestRate = .05;
	}
	public static void main(String[] args) {
		SavingsAccount obj = new SavingsAccount();
		obj.calculateMonthlyInterest();
		SavingsAccount.modifyInterestRate();

	}

}
