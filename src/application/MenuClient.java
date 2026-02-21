package application;

import java.util.Scanner;

import entities.Client;
import services.ClientService;

public class MenuClient {

	private Scanner sc = new Scanner(System.in);
	private ClientService clientService = new ClientService();

	public void menuClient() {
		System.out.println("Main Menu");

		int type = sc.nextInt();
		sc.nextLine();

		while (type != 0) {
			System.out.println("Please select one of the options");
			System.out.println("1: Open Account");
			System.out.println("2: Customer Login");

			switch (type) {
			case 1:
				System.out.println("Open Account");
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("CPF: ");
				String cpf = sc.nextLine();
				System.out.print("E-mail: ");
				String email = sc.nextLine();
				System.out.print("Phone Number: ");
				String phoneNumber = sc.nextLine();
				System.out.print("Passaword: ");
				String password = sc.nextLine();
				Client client = new Client(null, name, cpf, email, phoneNumber, password);
				clientService.registerClient(client);
				break;

			case 2:
				System.out.print("Enter CPF: ");
				String cpfValidation = sc.nextLine();
				Client found = clientService.findByCpf(cpfValidation);
				if (found != null) {
					System.out.println(found);
				} else {
					System.out.println("Customer not found");
				}

				break;

			case 0:
				break;

			default:
				System.out.println("Invalid Selection");

			}
		}
	}
}
