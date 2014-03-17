package edu.neumont.csc150.lab12.rollinsb;

import java.util.ArrayList;

public class Company {
	private String companyName;
	private long revenue;
	private ArrayList<Company> childCompanies;
	private ArrayList<Person> employees;
	
	public Company(String companyName, long revenue) {
		this.companyName = companyName;
		this.revenue = revenue;
		this.childCompanies = new ArrayList<Company>();
		this.employees = new ArrayList<Person>();
	}
	
	public void addChild(String companyName, long revenue) {
		this.childCompanies.add(new Company(companyName, revenue));
	}
	
	public Company getChildCompany(String companyName) {
		for (int i = 0; i < childCompanies.size(); i++) {
			if (childCompanies.get(i).companyName.equals(companyName)) {
				return this.childCompanies.get(i);				
			}
		}
		return null;
	}
	
	public long getChildRevenue() {
		long total = 0;
		for (Company child : childCompanies) {
			total += child.revenue;
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "Company information: Name: " + this.companyName + ", Revenue: " + this.revenue;
	}
	
	public String printChildren() {
		String retVal = "";
		
		retVal += "And its brands are: \n";
		for (Company child : childCompanies) {
			retVal += child.companyName + ": " + child.revenue + "\n";
		}

		retVal += "Making the total revenue for GM:  \n";
		retVal += getChildRevenue() + this.revenue + "\n";
		retVal += "\n";
		
		return retVal;
	}
	
	public String printEmployees() {
		String retVal = "";
		for (Person p : this.employees) {
			retVal += p + "\n";
		}
		for (Company c : this.childCompanies) {
			retVal += c.printEmployees();
		}
		return retVal;
	}

	public void addEmployee(Person p) {
		this.employees.add(p);
	}
}
