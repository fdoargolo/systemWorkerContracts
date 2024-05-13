package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import workerEntitiesEnum.WorkerLevel;

public class systemContracts {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter department's name:");
		String departmentName = scanner.nextLine();

		System.out.println("Enter worker data:");
		System.out.print("Name:");
		String workerName = scanner.nextLine();
		System.out.print("Level:");
		String workerLevel = scanner.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = scanner.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

		System.out.println("How many contracts to this worker?");
		int contracts = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < contracts; i++) {
			System.out.println();
			System.out.println("Enter contact #" + (i + 1) + " data.");
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate data = LocalDate.parse(scanner.nextLine(), fmt);
			System.out.print("Value per hour:");
			double valueHour = scanner.nextDouble();
			System.out.print("Duration (hours):");
			int hours = scanner.nextInt();
			scanner.nextLine();

			HourContract contract = new HourContract(data, valueHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String dateContract = scanner.nextLine();
		String[] parts = dateContract.split("/");
		int month = Integer.parseInt(parts[0]);
		int year = Integer.parseInt(parts[1]);

		double totalIncome = worker.income(month, year);
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.printf("Income for " + dateContract + ": " + totalIncome);

		scanner.close();

	}

}
