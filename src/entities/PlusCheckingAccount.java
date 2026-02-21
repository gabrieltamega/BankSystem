package entities;

import java.time.LocalDate;

import model.entities.Taxable;

public class PlusCheckingAccount extends Account implements Taxable {

	public PlusCheckingAccount() {
		super();
	}

	public PlusCheckingAccount(Integer number, LocalDate openingDate, Double balance) {
		super(number, openingDate, balance);
	}

	@Override
	protected double withdrawFee() {
		return 0.50;
	}
	
	@Override
	protected double accountFee() {
		return 6.80;
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
		return 0.0055;
	}

	@Override
	protected void applyMonthlyUpdate() {
		double balance = getBalance();
		double interest = balance * super.yield();
		super.addToBalance(interest);
	}

}
