package edu.neumont.csc150.lab5.rollinsb;

/**
 * Runs the CLI version of the BattleBot program.
 * 
 * @author Blake Rollins
 * 
 */
public class BattleBotCLI {

	/**
	 * The CLI version of the BattleBot program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// For lab 5 we want to create X number of BattleBots at random places on the board.
		// We want to take four parameters.  number of columns in the board, number of rows in the board,
		// the number of time units and the number of BattleBots to add to the board.
		if (args.length == 4) {
			
			// Get the args
			int numberOfCols = Integer.parseInt(args[0]);
			int numberOfRows = Integer.parseInt(args[1]);
			int numberOfTimeUnits = Integer.parseInt(args[2]);
			int numberOfBots = Integer.parseInt(args[3]);
			
			// Create a field with inputed number of bots
			BattleBotField testBoard = new BattleBotField(numberOfCols, numberOfRows, numberOfBots);
						
			// Move the bots
			testBoard.moveBots(numberOfTimeUnits);
			
			// Print the board
			System.out.println(testBoard.toString());
		} else {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java edu.neumont.csc150.lab5.rollinsb.BattleBotCLI numberOfCols numberOfRows amountOfTime numberOfBots");
		}
		

	}

}
