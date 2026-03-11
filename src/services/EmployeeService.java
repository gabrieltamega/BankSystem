package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class EmployeeService {

	String path = "employees.csv";
	List<Employee> employees = new ArrayList<>();

	public EmployeeService() {
	}

	public String getPath() {
		return path;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void registerEmployee(Employee employee) {
		employees.add(employee);
		savingEmployees(path);
	}

	public Employee findById(String id) {
		for (Employee e : employees) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

	public void savingEmployees(String path) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write("Id,Name,CPF,Email,Phone,Password");
			bw.newLine();

			for (Employee e : employees) {
				bw.write(e.getId() + "," + e.getName() + ", " + e.getCpf() + "," + e.getEmail() + ","
						+ e.getPhoneNumber() + "," + e.getPassword());
				bw.newLine();
			}
			System.out.println("File saved successfully at: " + path);
		} catch (IOException e) {
			System.out.println("Error writing in CSV fiel" + e.getMessage());
		}

	}

	public void loadEmployees(String path) {
		employees.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");

				if (fields.length >= 6) {
					Employee e = new Employee();
					e.setId(fields[0].trim());
					e.setName(fields[1].trim());
					e.setCpf(fields[2].trim());
					e.setEmail(fields[3].trim());
					e.setPhoneNumber(fields[4].trim());
					e.setPassword(fields[5].trim());

					employees.add(e);
				}
			}
		} catch (IOException e) {
			System.out.println("No saved data found.");
		}

	}

}
