package application;

import java.util.Scanner;

import controller.Login;
import services.ClientService;
import services.EmployeeService;

public class PrincipalMenu {

	protected Scanner sc;

	public PrincipalMenu(Scanner sc) {
		this.sc = sc;
	}

	public void Menu() {

		EmployeeService employeeService = new EmployeeService();
		ClientService clientService = new ClientService();

		clientService.loadClients(clientService.getPath());
		employeeService.loadEmployees(employeeService.getPath());

		Login loginController = new Login(employeeService, clientService, sc);

		int choice = -1;

		while (choice != 0) {

			System.out.println("Main System");
			System.out.println("1: Login");
			System.out.println("0: Shutdown System");
			System.out.print("Option: ");

			try {
				choice = sc.nextInt();
				sc.nextLine();

				if (choice == 1) {
					System.out.println("Select User Type");
					System.out.println("1: Internal");
					System.out.println("2: Customer");
					System.out.print("Option: ");
					int type = sc.nextInt();
					sc.nextLine();
					System.out.print("Login (Id / CPF): ");
					String login = sc.nextLine();
					System.out.print("Password: ");
					String password = sc.nextLine();
					loginController.authenticate(type, login, password);

				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid number");
				sc.nextLine();
			}
		}
		System.out.println("System shut down.");
	}
}
