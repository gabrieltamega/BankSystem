package application;

import java.util.Scanner;

import controller.Login;
import entities.Employee;
import services.ClientService;
import services.EmployeeService;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeService employeeService = new EmployeeService();
		ClientService clientService = new ClientService();

		clientService.loadClients(clientService.getPath());
		employeeService.loadEmployees(employeeService.getPath());

		if (employeeService.getEmployees().isEmpty()) {
			Employee admin = new Employee("ADMIN123", "GABRIEL TAMEGA", "43697064835", "gabrieltamega@gmail.com",
					"11995256167", "TESTE123");
			employeeService.registerEmployee(admin);
			System.out.println("Default admin created");
		}

		Login loginController = new Login(employeeService, clientService);

		int choice = -1;

		while (choice != 0) {

			System.out.println("Main System");
			System.out.println("1: Login");
			System.out.println("0: Shutdown System");
			System.out.print("Option: ");
			choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				System.out.println("Select 1User Type");
				System.out.println("1: Internal");
				System.out.println("2: Customer");
				int type = sc.nextInt();
				sc.nextLine();
				System.out.print("Login (Id / CPF): ");
				String login = sc.nextLine();
				System.out.print("Password: ");
				String password = sc.nextLine();
				loginController.authenticate(type, login, password);

			}

		}

		sc.close();
	}

}
