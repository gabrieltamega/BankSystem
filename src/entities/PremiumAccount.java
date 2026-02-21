package entities;

import java.time.LocalDate;

import model.entities.Taxable;

public class PremiumAccount extends Account implements Taxable {

	public PremiumAccount() {
		super();
	}

	public PremiumAccount(Integer number, LocalDate openingDate, Double balance) {
		super(number, openingDate, balance);
	}

	@Override
	protected double withdrawFee() {
		return 0.30;
	}
	
	@Override
	protected double accountFee() {
		return 12.80;
	}

	@Override
	public double calculateTax(double value) {
		return value + super.withdrawFee();
	}

	@Override
	public void withdraw(double value) {
		super.withdraw(calculateTax(value));
	}

	@Override
	public void deposit(double value) {
		super.deposit(value);
	}

	@Override
	public void transfer(double value, Account target) {
		double totalValue = value + super.withdrawFee();
		super.withdraw(totalValue);
		target.deposit(value);
	}

	@Override
	protected double yield() {
		return 0.008;
	}

	@Override
	protected void applyMonthlyUpdate() {
		double balance = getBalance();
		double interest = balance * super.yield();
		super.addToBalance(interest);
	}

}
