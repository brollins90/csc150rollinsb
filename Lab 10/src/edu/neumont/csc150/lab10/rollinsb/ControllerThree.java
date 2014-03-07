package edu.neumont.csc150.lab10.rollinsb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
* Q3 English Answer
* In what scenarios would skipping invalid lines be a 
* wise decision in production code?
* A: The example that we talked about in class is the software that runs a pacemaker.
* In a pacemaker, it is important to keep the hardware running even if the sensors are
* sending it invalid data.  So we would want to accept invalid data in a program if in the
* case of an error, we would prefer to have the software run, rather than not run.
*/ 

/**
 * ControllerThree:
 * a class that expects a single argument passed into the main method which is the path to the input file
 * Reads one int per line in the file and prints the sum of all the ints at the console and to an output file
 * If there are any parsing errors, the errors are noted in the output
 * 
 * @author Blake Rollins
 *
 */
public class ControllerThree {
	
	/**
	 * Starts the execution for ControllerThree
	 * @param args
	 */	
	public static void main(String[] args) {
		
		ControllerThree c = new ControllerThree();
		if (args.length == 1) {
			c.readAndSumFile(args[0], "C:\\test\\outFile.txt");
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
	public int readAndSumFile(String inFilePath, String outFilePath) {
		
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
					fileErrors.add("Error reading line " + lineNumber);
				}
				lineNumber++;
			}
			
		} catch (IOException e) {
			fileErrors.add("There was an IO error reading the file");
			
		} 
		
		String outString = "";
		outString += "The sum of all the numbers in the file is " + totalSum + "\n";
		if (fileErrors.size() > 0) {
			outString += "The sum is incomplete because of errors on the following lines: \n";
			for (String s : fileErrors) {
				outString += s + "\n";
			}
			writeFile(outFilePath, outString);
			return 0;
		}
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
		System.out.println("Usage: java edu.neumont.csc150.lab10.rollinsb.ControllerThree fileName");
	}
}
