package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Account {

	private Integer number;
	private Double balance;
	private String client;
	private List<Double> transactionHistory;
	private LocalDate openingDate;
	private LocalDate lastProcessingDate;

	public Account() {
	}

	public Account(Integer number, Double balance, String client, LocalDate openingDate, LocalDate lastProcessingDate) {
		this.number = number;
		this.balance = balance;
		this.client = client;
		this.openingDate = openingDate;
		this.lastProcessingDate = lastProcessingDate;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public List<Double> getTransactionHistory() {
		return transactionHistory;
	}

	public void withdraw(double value) {
		if (balance < value) {
			throw new IllegalArgumentException("Insufficient Balance");
		}
		balance -= value;
	}

	public void deposit(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Deposit must be greater than zero");
		}
		balance += value;
	}

	public void transfer(double value, Account target) {
		withdraw(value);
		target.deposit(value);
	}

	protected abstract void applyMonthlyUpdate();

	protected void addToBalance(double value) {
		balance += value;
	}

	public void processMonth(LocalDate currentDate) {
		long months = ChronoUnit.MONTHS.between(lastProcessingDate, currentDate);
		if (months >= 1) {
			for (long i = 0; i < months; i++) {
				applyMonthlyUpdate();
			}
			lastProcessingDate.plusMonths(months);
		}
	}

}
