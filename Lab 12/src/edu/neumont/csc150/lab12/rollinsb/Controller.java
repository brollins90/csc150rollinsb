package edu.neumont.csc150.lab12.rollinsb; // fix lab name

import java.util.ArrayList;

public class Controller {

	public String parentCompanyName; // no static, bad name
	// private Revenue r = new Revenue(); // revenue is just an int...
	private String[] brands;
	private int[] bRev; // bad name
	private long bigr;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Controller c = new Controller();
		c.buildGMRevenue();
	}

	public void buildGMRevenue() {

		Company parent = new Company("General Motors Inc", 155_430_000_000l);
		// parent.setRevenueAmount(); // see http://finance.yahoo.com/q/ks?s=gm
		ArrayList<Person> people = new ArrayList<Person>();

		System.out.println(parent);

		parent.addChild("Chevrolet", 1_000_000);
		parent.addChild("Buick", 5_000_000);
		parent.addChild("GMC", 10_000_000);
		parent.addChild("Cadillac", 1_000_000);
		parent.addChild("Opel", 23_000_000);
		parent.addChild("Holden", 1_000_000);
		parent.addChild("Vauxhall", 1_000_000);
		parent.addChild("Wuling", 151_000_000);
		parent.addChild("Baojun", 1_000_000);
		parent.addChild("Jie Fang", 1_000_030);
		parent.addChild("UzDaewoo", 1_002_000);

		System.out.println(parent.printChildren());

		Person jeff = new Person("Jeff", "Smith");
		people.add(jeff);

		Person dave = new Person("Dave", "Cuthbertson");
		people.add(dave);
		linkPersonAndCompany(dave, parent.getChildCompany("Chevrolet"));
		linkPersonAndCompany(dave, parent.getChildCompany("Buick"));

		Person barb = new Person("Barb", "Hansen");
		linkPersonAndCompany(barb, parent.getChildCompany("Buick"));
		people.add(barb);

		System.out.println("And here are the people that work at GM");
		System.out.println(parent.printEmployees());

		System.out.println("And here are the people that work at Chevrolet");
		System.out.println(parent.getChildCompany("Chevrolet").printEmployees());

		System.out.println("And here are the people that work at Buick");
		System.out.println(parent.getChildCompany("Buick").printEmployees());

		System.out.println("And here are the people that don't work for any GM company");
		for (Person p : people) {
			if (p.getNumberOfCompanies() == 0) {
				System.out.println(p);
			}
		}
	}

	private void linkPersonAndCompany(Person p, Company c) {
		p.addCompany(c);
		c.addEmployee(p);
	}

}
