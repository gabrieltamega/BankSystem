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

	public Account(Integer number, LocalDate openingDate, Double balance) {
		super();
		this.number = number;
		this.openingDate = openingDate;
		this.balance = balance;
		this.lastProcessingDate = openingDate;
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
		balance -= value + withdrawFee();
	}

	protected double withdrawFee() {
		return 1.50;
	}

	protected double accountFee() {
		return 5.00;
	}
	
	protected double yield() {
		return 0.0041;
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

	protected void addToBalance(double value) {
		double balance = getBalance();
		if (balance < accountFee()) {
			addToBalance(-balance);
		}
		double feeMonth = balance - accountFee();
		addToBalance(feeMonth);

	}

	protected abstract void applyMonthlyUpdate();

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
