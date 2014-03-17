package edu.neumont.csc150.lab12.rollinsb;

import java.util.ArrayList;

public class Person {

	private String firstName, lastName;
	private ArrayList<Company> companies;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.companies = new ArrayList<>();
	}
	
	public void addCompany(Company company) {
		companies.add(company);
	}

	public String getFirstname() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getNumberOfCompanies() {
		return this.companies.size();
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
