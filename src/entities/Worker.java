package entities;

import java.util.ArrayList;
import java.util.List;
import workerEntitiesEnum.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department department;
	List<HourContract> contracts = new ArrayList<>();

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);
	}

	public Double income(Integer month, Integer year) {
	    Double totalIncome = 0.0;
	    for (HourContract contract : contracts) {
	        if (contract.getDate().getMonthValue() == month && contract.getDate().getYear() == year) {
	            totalIncome += contract.totalValue();
	        }
	    }
	    totalIncome += this.baseSalary;
	    return totalIncome;
	}

}
