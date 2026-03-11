package application;

import java.util.Scanner;

import services.ClientService;

public class MenuEmployee extends MenuPeople {


	public MenuEmployee(Scanner sc, ClientService cs) {
		super(sc, cs);
	}

	public void displayEmployeeMenu() {

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
				clientRegister();
				break;

			case 2:
				clientSearch();
				break;

			case 3:
				this.cs.listAll();
				break;

			case 0:
				break;

			default:
				System.out.println("Invalid Selection");

			}
		}
	}

}
