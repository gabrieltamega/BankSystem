package entities;

import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client> {

	private String id;
	private String name;
	private String cpf;
	private String email;
	private String phoneNumber;
	private String password;
	private List<Account> accounts = new ArrayList<>();

	public Client() {
	}

	public Client(String id, String name, String cpf, String email, String phoneNumber, String password) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addAccount(Account accountType) {
		accounts.add(accountType);
	}

	@Override
	public int compareTo(Client other) {
		int result = this.name.compareToIgnoreCase(other.name);
		if (result == 0) {
			return this.cpf.compareTo(other.cpf);
		}
		return result;
	}

	@Override
	public String toString() {
		return "Client Id: " + id + "\nName: " + name + "\nCPF: " + cpf + "\nEmail: " + email + "\nContact : "
				+ phoneNumber + "\nAccounts:" + accounts;
	}

	public String toStringList() {
		return "Name: " + name + "	// Client Id: " + id + "	  // CPF: " + cpf + "\n";
	}

}
