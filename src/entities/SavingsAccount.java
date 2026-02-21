package entities;

import java.time.LocalDate;

public class SavingsAccount extends Account {

	
	public SavingsAccount(Integer number, LocalDate openingDate, Double balance) {
		super(number, openingDate, balance);
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
		double interest = balance * super.yield();
		super.addToBalance(interest);
	}


}
