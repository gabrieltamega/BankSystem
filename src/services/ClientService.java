package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Client;

public class ClientService {

	String path = "clients.csv";
	private List<Client> clients = new ArrayList<>();

	public ClientService() {
		super();
	}

	public String getPath() {
		return path;
	}

	public String generateId() {
		String characteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(characteres.length());
			sb.append(characteres.charAt(index));
		}
		return sb.toString();
	}

	public Client findByCpf(String cpf) {
		for (Client c : clients) {
			if (c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}

	public Client findById(String id) {
		for (Client c : clients) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public void registerClient(Client client) {
		String newId;
		do {
			newId = generateId();

		} while (findById(newId) != null);
		client.setId(newId);
		clients.add(client);
		savingClients(this.path);
	}

	public void listAll() {
		for (Client c : clients) {
			System.out.println(c.toStringList());
		}

	}

	public void savingClients(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("Id, Name, CPF, Email, Phone, Password");
			bw.newLine();

			for (Client c : clients) {
				bw.write(c.getId() + "," + c.getName() + ", " + c.getCpf() + ", " + c.getEmail() + ", "
						+ c.getPhoneNumber() + ", " + c.getPassword());
				bw.newLine();
			}
			System.out.println("File saved successfully at: " + path);
		} catch (IOException e) {
			System.out.println("Error writing in CSV fiel" + e.getMessage());
		}

	}

	public void loadClients(String path) {
		clients.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");

				Client c = new Client();
				c.setId(fields[0].trim());
				c.setName(fields[1].trim());
				c.setCpf(fields[2].trim());
				c.setEmail(fields[3].trim());
				c.setPhoneNumber(fields[4].trim());
				c.setPassword(fields[5].trim());
				
				clients.add(c);

			}
		} catch (IOException e) {
			System.out.println("No saved data found.");
		}

	}
}
