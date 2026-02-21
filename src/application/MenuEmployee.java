package application;

import java.util.Scanner;

import entities.Client;
import services.ClientService;

public class MenuEmployee {

	private Scanner sc = new Scanner(System.in);
	private ClientService cs;

	public void menuEmployee(ClientService clientService) {
		
		this.cs = clientService;

		int option = -1;
		
		while (option != 0) {
			System.out.println("Please select one of the options");
			System.out.println("1: New Customer");
			System.out.println("2: Customer");
			System.out.println("3: List All Customers");
			System.out.println("0: Logout");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				System.out.println("New Customer Registration");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("E-mail: ");
				String email = sc.nextLine();
				System.out.print("Phone Number: ");
				String phoneNumber = sc.nextLine();
				System.out.print("Initial Passaword");
				String password = sc.nextLine();
				Client client = new Client(null, name, cpf, email, phoneNumber, password);
				cs.registerClient(client);
				break;

			case 2:
				System.out.print("Enter CPF: ");
				String cpfValidation = sc.nextLine();
				Client found = clientService.findByCpf(cpfValidation);
				if (found != null) {
					System.out.println(found);
				} else {
					System.out.println("Custumer not found");
				}

				break;

			case 3:
				cs.listAll();
				break;

			case 0:
				break;

			default:
				System.out.println("Invalid Selection");

			}
		}
	}
}
