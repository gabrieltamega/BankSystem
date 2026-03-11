package application;

import java.util.Scanner;

import services.ClientService;

public class MenuClient extends MenuPeople {


	public MenuClient(Scanner sc, ClientService cs) {
		super(sc, cs);
	}

	public void menuClient() {
		System.out.println("Main Menu");

		int option = -1;
		

		while (option != 0) {
			System.out.println("Please select one of the options");
			System.out.println("1: Open Account");
			System.out.println("2: Customer Login");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				clientRegister();
				break;

			case 2:
				clientSearch();
				break;

			case 0:
				break;

			default:
				System.out.println("Invalid Selection");

			}
		}
	}
}
