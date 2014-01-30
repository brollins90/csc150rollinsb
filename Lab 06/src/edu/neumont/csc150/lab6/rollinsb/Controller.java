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
		
		// Check place the bots on the field
		for (int i = 0; i < bbContainer.getNumberOfBots(); i++) {
			int botColumn = bbContainer.getBotColumn(i);
			int botRow = bbContainer.getBotRow(i);
			bbField.placeBot(botColumn,  botRow);
		}
		System.out.println(bbField);
		
	}
}
