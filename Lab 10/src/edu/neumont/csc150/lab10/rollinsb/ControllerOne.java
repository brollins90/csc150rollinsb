package edu.neumont.csc150.lab10.rollinsb;

/**
 * ControllerOne:
 * a class that expects four integer arguments passed into the main method
 * a.	Print a message to the user on the expected format and terminate the program
 * b.	To see a similarly-behaving program, from the command prompt, type: "ipconfig /asdf"
 * 
 * @author Blake Rollins
 *
 */
public class ControllerOne {
	
	/**
	 * Starts the execution for ControllerOne
	 * @param args
	 */
	public static void main(String[] args) {
		ControllerOne c = new ControllerOne();
		if (c.run(args)) {
			c.printSuccess();
		} else {
			c.printUsage();
		}			
	}
	
	/**
	 * Actually runs ControllerOne.  Required a separate method to facilitate testing
	 * @param args	A String[] of intergers (confusing right?)
	 * @return True if the args are all parseable as integers.
	 */
	public boolean run(String[] args) {

		if (args.length != 4) {
			return false;
		} else {
			boolean validArgs = true;
			for (int i = 0; i < args.length; i++) {
				if (!this.canParseInt(args[i])) {
					validArgs = false;
				}
			}
			if (!validArgs) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * Prints to the console that the arguments are correct
	 */
	private void printSuccess() {
		System.out.println("Args are valid.  YAY!");
	}

	/**
	 * Prints the to the console that the arguments were not correct and what the expected format should be.
	 */
	private void printUsage() {
		System.out.println("Error: Unrecognized or incomplete command line arguments.");
		System.out.println("Usage: java edu.neumont.csc150.lab10.rollinsb.ControllerOne 1 2 3 4");
	}
	
	/**
	 * Attempts to parse a string to extract an integer.
	 * Requires the use of a try/catch block since java has no built in way to check if a string is parseable
	 * @param intString	The string that may contain an integer
	 * @return	If the string contains an integer
	 */
	public boolean canParseInt(String intString) {
		try {
			int tempInt = Integer.parseInt(intString);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
