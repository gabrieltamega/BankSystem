package entities;

import java.util.List;

public class Client {

	private Integer id;
	private String name;
	private Integer cpf;
	private String email;
	private List<String> accountList;
	
	public Client(Integer id, String name, Integer cpf, String email, List<String> accountList) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.accountList = accountList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getAccountList() {
		return accountList;
	}

}
