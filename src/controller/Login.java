package controller;

import java.util.Scanner;

import application.MenuClient;
import application.MenuEmployee;
import entities.Client;
import entities.Employee;
import services.ClientService;
import services.EmployeeService;

public class Login {

	private EmployeeService es = new EmployeeService();
	private ClientService cs = new ClientService();
	private Scanner sc;

	public Login() {
	}

	public Login(EmployeeService es, ClientService cs, Scanner sc) {
		super();
		this.es = es;
		this.cs = cs;
		this.sc = sc;
	}

	public boolean authenticate(int type, String login, String password) {

		if (type == 1) {
			Employee foundE = es.findById(login);

			if (foundE != null && foundE.getPassword().equals(password)) {
				MenuEmployee me = new MenuEmployee(sc, cs);
				me.displayEmployeeMenu();
				return true;
			}


		} else if (type == 2) {
			Client foundC = cs.findByCpf(login);
			if (foundC != null && foundC.getPassword().equals(password)) {
				MenuClient mc = new MenuClient(sc, cs);
				mc.menuClient();
				return true;
			}
		}
		System.out.println("Invalid Credentials");
		return false;

	}

}
