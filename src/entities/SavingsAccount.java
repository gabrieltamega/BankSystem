package entities;

import java.time.LocalDate;

public class SavingsAccount extends Account {

	private Double yield = 0.0041;

	public SavingsAccount(Integer number, Double balance, String client, LocalDate openingDate,
			LocalDate lastProcessingDate) {
		super(number, balance, client, openingDate, lastProcessingDate);
	}

	public void withdraw(double value) {
		double balance = super.getBalance();
		if (balance < value) {
			throw new IllegalArgumentException("Insufficient Balance");
		}
		withdraw(value);
		CheckingAccount ca = new CheckingAccount();
		ca.deposit(value);

	}
	
	public void deposit(double value) {
		super.deposit(value);
	}

	@Override
	protected void applyMonthlyUpdate() {
		double balance = getBalance();
		double interest = balance * yield;
		super.addToBalance(interest);
	}

}
