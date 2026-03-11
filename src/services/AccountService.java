package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;

import entities.Account;

public class AccountService {

	private Set<Account> accounts = new TreeSet<>();
	private String path = "accounts.csv";

	public String getPath() {
		return path;
	}

	public void showStatement(Account acc) {
		System.out.println("Bank Statement");
		System.out.println("Account: " + acc.getNumber());
		System.out.println("Current Balance: " + String.format("%.2f", acc.getBalance()));
		System.out.println("---------------------------");

		if (acc.getTransactionHistory().isEmpty()) {
			System.out.println("No transactions found");
		} else {
			for (String transactions : acc.getTransactionHistory()) {
				System.out.println(transactions);
			}
		}
	}

	public Account findByNumber(String number) {
		for (Account acc : accounts) {
			if (acc.getNumber().equals(number)) {
				return acc;
			}
		}

		return null;

	}

	public void savingAccount(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("Number,Name,AccountType");
			bw.newLine();

			for (Account acc : accounts) {
				bw.write(acc.getNumber() + "," + acc.getClient().getCpf() + "," + acc.getAccountType());
				bw.newLine();
			}
			System.out.println("File saved successfully at: " + path);

		} catch (Exception e) {
			System.out.println("Error writing in CSV fiel" + e.getMessage());
		}
	}

}
