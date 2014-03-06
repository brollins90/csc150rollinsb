package edu.neumont.csc150.lab10.rollinsb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ControllerThree {

	public static void main(String[] args) {
		
		ControllerThree c = new ControllerThree();
		if (args.length == 1) {
			c.readAndSumFile(args[0], "C:\\outFile.txt");
		} else {
			c.printUsage();
		}
	}

	private boolean readAndSumFile(String inFilePath, String outFilePath) {
		
		File fileToParse = new File(inFilePath);
		// Check tht the file exists
		if (!fileToParse.exists()) {
			System.out.println("Error: The input file does not exist.");
			return false;
		}
		// Start reading the file
		int totalSum = 0;
		ArrayList<String> fileErrors = new ArrayList();
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
			return false;
		}
		writeFile(outFilePath, outString);
		return true;
		
		
	}

	private void writeFile(String outFilePath, String outString) {

		System.out.println(outString);
	}

	private void printUsage() {
		System.out.println("Error: Unrecognized or incomplete command line arguments.");
		System.out.println("Usage: java edu.neumont.csc150.lab10.rollinsb.ControllerThree fileName");
	}
}
