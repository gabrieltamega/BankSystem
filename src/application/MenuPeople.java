package application;

import java.util.Scanner;

import entities.Client;
import services.ClientService;

public class MenuPeople {

		protected Scanner sc;
		protected ClientService cs;
		
		public MenuPeople(Scanner sc, ClientService cs) {
	        this.sc = sc;
	        this.cs = cs;
	    }
		
		public void clientRegister() {
			System.out.println("New Customer Registration");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			System.out.print("E-mail: ");
			String email = sc.nextLine();
			System.out.print("Phone Number: ");
			String phoneNumber = sc.nextLine();
			System.out.print("Initial Passaword: ");
			String password = sc.nextLine();
			Client client = new Client(null, name, cpf, email, phoneNumber, password);
			cs.registerClient(client);
			System.out.println("Customer registered successfully!");

		}

		public void clientSearch() {
			System.out.print("Enter CPF: ");
			String cpfValidation = sc.nextLine();
			Client found = cs.findByCpf(cpfValidation);
			if (found != null) {
				System.out.println(found);
			} else {
				System.out.println("Custumer not found");
			}

		}

	}

	
