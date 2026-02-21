package controller;

import application.MenuClient;
import application.MenuEmployee;
import entities.Client;
import entities.Employee;
import services.ClientService;
import services.EmployeeService;

public class Login {

	private EmployeeService es = new EmployeeService();
	private ClientService cs = new ClientService();

	public Login() {
	}

	public Login(EmployeeService es, ClientService cs) {
		super();
		this.es = es;
		this.cs = cs;
	}

	public boolean authenticate(int type, String login, String password) {

		if (type == 1) {
			Employee foundE = es.findById(login);

			if (foundE != null && foundE.getPassword().equals(password)) {
				MenuEmployee me = new MenuEmployee();
				me.menuEmployee(cs);
				return true;
			}


		} else if (type == 2) {
			Client foundC = cs.findByCpf(login);
			if (foundC != null && foundC.getPassword().equals(password)) {
				MenuClient mc = new MenuClient();
				mc.menuClient();
				return true;
			}
		}
		System.out.println("Invalid Credentials");
		return false;

	}

}
