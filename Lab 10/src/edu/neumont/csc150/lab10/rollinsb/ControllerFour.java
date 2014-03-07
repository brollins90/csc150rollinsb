package edu.neumont.csc150.lab10.rollinsb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
* Q4 English Answer
* In what scenarios would refusing to accept 
* invalid file input and stopping program execution be wise 
* in production code?
* A: THe example that we talked about in class is the code that sets the target for a missile
* It is important that if the data is bad, that he program stops executing.  We would want to take
* this approach, if in the case of an error, we would prefer to have the code stop, rather than run.
*/ 

/**
 * ControllerFour:
 * a class that expects a single argument passed into the main method which is the path to the input file
 * Reads one int per line in the file and prints the sum of all the ints at the console and to an output file
 * If there are any parsing errors, the an error will be shown to the user
 * 
 * @author Blake Rollins
 *
 */
public class ControllerFour {
	
	/**
	 * Starts the execution for ControllerFour
	 * @param args
	 */	
	public static void main(String[] args) {
		
		ControllerFour c = new ControllerFour();
		if (args.length == 1) {
			try {
			c.readAndSumFile(args[0], "C:\\test\\outFile.txt");
			} catch (Exception e) {
				System.out.println("There was a problem reading the file:");
				System.out.println(e.getMessage());
			}
		} else {
			c.printUsage();
		}
	}
	
	/**
	 * Actually runs ControllerThree.  Required a separate method to facilitate testing
	 * @param inFilePath The file to be read
	 * @param outFilePath The file to write to
	 * @return The sum of every line i (only used in testing)
	 */
	public int readAndSumFile(String inFilePath, String outFilePath) throws Exception {
		
		File fileToParse = new File(inFilePath);
		// Check tht the file exists
		if (!fileToParse.exists()) {
			System.out.println("Error: The input file does not exist.");
			return 0;
		}
		// Start reading the file
		int totalSum = 0;
		ArrayList<String> fileErrors = new ArrayList<String>();
		int lineNumber = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileToParse))) {
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				try {
					int currentLineInt = Integer.parseInt(currentLine);
					totalSum += currentLineInt;
				} catch (NumberFormatException e) {
					throw new Exception("Error reading line " + lineNumber);
				}
				lineNumber++;
			}
			
		} catch (IOException e) {
			fileErrors.add("There was an IO error reading the file");
			
		} 
		
		String outString = "";
		outString += "The sum of all the numbers in the file is " + totalSum + "\n";
		writeFile(outFilePath, outString);
		return totalSum;
		
		
	}
	/**
	 * Writes the inputed string to a file at the inputed file path
	 * @param outFilePath Path of the out file
	 * @param outString	The string to write
	 */
	private void writeFile(String outFilePath, String outString) {
		try {
			File outFile = new File(outFilePath);
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			FileWriter writer = new FileWriter(outFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(outString);
			bw.close();
		} catch (IOException e) {
			System.out.println("I failed to write the file: " + e.getMessage());
			System.out.println("But here are the results of reading the file:");
		}
		System.out.println(outString);
	}

	/**
	 * Prints the proper usage for the class
	 */
	private void printUsage() {
		System.out.println("Error: Unrecognized or incomplete command line arguments.");
		System.out.println("Usage: java edu.neumont.csc150.lab10.rollinsb.ControllerFour fileName");
	}
}
