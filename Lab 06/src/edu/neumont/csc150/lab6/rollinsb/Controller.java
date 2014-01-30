package edu.neumont.csc150.lab6.rollinsb;

public class Controller {

	public static void main(String[] args) {
		
		args = new String[4];
		args[0] = "7";  // columns
		args[1] = "10"; // rows
		args[2] = "1";	// time
		args[3] = "5";	// bots
		
		int numberOfCols = Integer.parseInt(args[0]);
		int numberOfRows = Integer.parseInt(args[1]);
		int numberOfTimeUnits = Integer.parseInt(args[2]);
		int numberOfBots = Integer.parseInt(args[3]);
		
		
		// Make a Field 
		Field bbField = new Field(numberOfCols, numberOfRows);

		// Make a Container
		Container bbContainer = new Container(numberOfBots, numberOfCols, numberOfRows);
		
		// Move Bots
		bbContainer.moveBots(numberOfTimeUnits);
		
		// Give the Field to the container to add the Bots
		bbContainer.placeBotsOnField(bbField);
		
		// Print the Field
		System.out.println(bbField);
		
	}
}
