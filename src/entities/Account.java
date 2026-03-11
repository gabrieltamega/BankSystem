package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class Account {

	private String number;
	private Double balance;
	private Client client;
	private List<String> accountType;
	private List<String> transactionHistory;
	private LocalDate openingDate;
	private LocalDate lastProcessingDate;
	
	public Account() {
	}

	public Account(String number, LocalDate openingDate, Double balance) {
		super();
		this.number = client.getCpf();
		this.openingDate = openingDate;
		this.balance = balance;
		this.lastProcessingDate = openingDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public List<String> getAccountType() {
		return accountType;
	}

	public void setAccountType(List<String> accountType) {
		this.accountType = accountType;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public List<String> getTransactionHistory() {
		return transactionHistory;
	}

	protected double withdrawFee() {
		return 2.50;
	}

	protected double transferFee() {
		return 1.50;
	}

	protected double accountFee() {
		return 5.00;
	}

	protected double yield() {
		return 0.0106;
	}

	protected double overdraft() {
		return 0.0260;
	}

	protected double limitOverdraft() {
		return 0000.00;
	}
	
	public void addLog(String message) {
		transactionHistory.add(LocalDate.now() + " - " + message);
	}

	public void withdraw(double value) {
		double totalWithdrawFee = value + withdrawFee();
		if (this.balance + limitOverdraft() < totalWithdrawFee) {
			throw new IllegalArgumentException("Insufficient Balance");
		}
		this.balance -= totalWithdrawFee;
		addLog("Withdraw: " + String.format("%.2f", totalWithdrawFee) + " // " + value + withdrawFee());
	}

	public void deposit(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Deposit must be greater than zero");
		}
		this.balance += value;
		addLog("Deposit: " + String.format("%.2f", value));
	}

	public void transfer(double value, Account target) {
		double totalTransfer = value + withdrawFee();
		if (balance + limitOverdraft() < totalTransfer) {
			throw new IllegalArgumentException("Insufficient Balance");
		}
		balance -= value + transferFee();
		target.deposit(value);
		addLog("Transfer: " + String.format("%.2f", totalTransfer) + " // " + value + withdrawFee());
	}

	protected void addToBalance(double value) {
		this.balance += value;
	}

	protected void applyMonthlyUpdate() {
		if (getBalance() < 0) {
			double interest = getBalance() * overdraft();
			addToBalance(interest - accountFee());
		} else {
			double netValue = (this.balance * this.yield()) - accountFee();
			addToBalance(netValue);
		}
	}

	public void processMonth(LocalDate currentDate) {
		long months = ChronoUnit.MONTHS.between(lastProcessingDate, currentDate);
		if (months >= 1) {
			for (long i = 0; i < months; i++) {
				applyMonthlyUpdate();
			}
			lastProcessingDate = lastProcessingDate.plusMonths(months);
		}
	}



}
