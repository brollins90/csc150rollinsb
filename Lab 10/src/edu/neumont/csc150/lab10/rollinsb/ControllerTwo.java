package edu.neumont.csc150.lab10.rollinsb;

import java.util.Scanner;

public class ControllerTwo {
	Scanner scan;
	
	public ControllerTwo() {
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		ControllerTwo c = new ControllerTwo();		
		
		int[] ints = new int[4];
		
		boolean validArgs = true;
		
		// First check if the command line args are valid
		if (args.length == 4) {
			for (int i = 0; i < args.length; i++) {
				if (c.canParseInt(args[i])) {
					ints[i] = Integer.parseInt(args[i]);
				} else {
					validArgs = false;
				}
			}
		}
		
		// if any of the command line args were invalid, or if there were not 4 args,
		// then ask the uer for more input
		if (!validArgs) {
			
			System.out.println("The arguments were not valid.");
			ints[0] = c.getIntFromQuestion("What is the first int?");
			ints[1] = c.getIntFromQuestion("What is the second int?");
			ints[2] = c.getIntFromQuestion("What is the third int?");
			ints[3] = c.getIntFromQuestion("What is the fourth int?");
			
		}
		
		System.out.println("The 4 ints added together is: " + (ints[0] + ints[1] + ints[2] + ints[3]));
		
	}
	
	private int getIntFromQuestion(String question){
		boolean isValidInt = false;
		
		System.out.println(question);
		
		while (!isValidInt) {
			String temp = readLine();
			if (canParseInt(temp)) {
				return Integer.parseInt(temp);
			} else {
				System.out.println( temp + " is not a valid int.  Try again.");
			}
		}
		// this will never be called
		return 0;
	}
	
	private String readLine() {
		return this.scan.nextLine();
	}
	
	private void printSuccess() {
		System.out.println("Args are valid.  YAY!");
	}

	private void printUsage() {
		System.out.println("Error: Unrecognized or incomplete command line arguments.");
		System.out.println("Usage: java edu.neumont.csc150.lab10.rollinsb.ControllerOne 1 2 3 4");
	}
	
	public boolean canParseInt(String intString) {
		try {
			int tempInt = Integer.parseInt(intString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
