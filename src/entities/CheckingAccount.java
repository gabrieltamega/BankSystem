package entities;

import java.time.LocalDate;

public class CheckingAccount extends Account {

	private Double fee = 0.05;
	private Double feePerMonth = 5.00;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(Integer number, Double balance, String client, LocalDate openingDate,
			LocalDate lastProcessingDate) {
		super(number, balance, client, openingDate, lastProcessingDate);
	}

	@Override
	public void withdraw(double value) {
		double totalValue = value + fee;
		super.withdraw(totalValue);
	}

	@Override
	public void deposit(double value) {
		super.deposit(value);
	}

	@Override
	public void transfer(double value, Account target) {
		double totalValue = value + fee;
		super.withdraw(totalValue);
		target.deposit(value);
	}

	@Override
	protected void applyMonthlyUpdate() {
		double balance = getBalance();
		if (balance < feePerMonth) {
			super.addToBalance(-balance);
		}
		double feeMonth = balance - feePerMonth;
		super.addToBalance(feeMonth);

	}

}
