package edu.neumont.csc150.lab10.rollinsb;

import java.util.Scanner;

/**
 * ControllerTwo:
 * a class that expects four integer arguments passed into the main method
 * a.	If the user does not supply the arguments in the expected format, notify the user and prompt them to re-enter the values without terminating the program.
 * b.	Continue looping until the user enters “end” or enters 4 valid integers.  
 * c.	Print the result of adding the four integers

 * @author Blake Rollins
 *
 */
public class ControllerTwo {
	Scanner scan;
	
	/**
	 * We need to specify the default constructor so we can initialize the Scanner
	 */
	public ControllerTwo() {
		scan = new Scanner(System.in);
	}
	
	/**
	 * Starts the execution for ControllerTwo
	 * @param args
	 */	
	public static void main(String[] args) {
		ControllerTwo c = new ControllerTwo();	
		int result = c.run(args);
		
		System.out.println("The 4 ints added together is: " + result);		
	}
	
	/**
	 * Actually runs ControllerTwo.  Required a separate method to facilitate testing
	 * @param args	A String[] of four integers
	 * @return The sum of the four integers
	 */
	public int run(String[] args) {

		int[] ints = new int[4];
		boolean validArgs = false;
		do {
			boolean allValidThisRound = true;
			if (args.length == 4) {
				for (int i = 0; i < args.length; i++) {
					if (allValidThisRound && this.canParseInt(args[i])) {
						ints[i] = Integer.parseInt(args[i]);
					} else {
						allValidThisRound = false;
					}
				}
			} else if (args.length == 1) {
				if (args[0].equals("end")) {
					allValidThisRound = true;
					ints[0] = 0;
					ints[1] = 0;
					ints[2] = 0;
					ints[3] = 0;
					System.out.println("End has been entered.  The following line is incorrect:");
				}
			} else {
				args = this.getNewArgs();
			}
			
			if (allValidThisRound) {
				validArgs = true;
			} else {
				args = this.getNewArgs();
			}
		} while (!validArgs);
		
		return ints[0] + ints[1] + ints[2] + ints[3];
	}
	
	/**
	 * Asks the users to enter four new integers
	 * @return Returns a String[] of the entered String split at the spaces 
	 */
	private String[] getNewArgs(){

		System.out.println("The arguments were not valid.");
		System.out.println("Enter four integers seperated by spaces or 'end' to quit.");
		return readLine().split(" ");
	}
	
	/**
	 * Reads a line from the console
	 * @return A String that was entered at the console
	 */
	private String readLine() {
		return this.scan.nextLine();
	}
	
	/**
	 * Attempts to parse a string to extract an integer.
	 * Requires the use of a try/catch block since java has no built in way to check if a string is parseable
	 * @param intString	The string that may contain an integer
	 * @return	If the string contains an integer
	 */
	private boolean canParseInt(String intString) {
		try {
			Integer.parseInt(intString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
