package edu.neumont.csc150.lab4.rollinsb;

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

		BattleBotCLI program = new BattleBotCLI();		
		
		// For the third / fourth lab we are placing 4 Bots in the corners of a board.
		// We are going to pass in three arguments, the number of cols in 
		// the board, the number of rows in the board and the number of time units to process before 
		// printing the board.
		if (args.length == 3) {
			int numberOfCols = Integer.parseInt(args[0]);
			int numberOfRows = Integer.parseInt(args[1]);
			int numberOfTimeUnits = Integer.parseInt(args[2]);
			
			BattleBotField testBoard = new BattleBotField(numberOfCols, numberOfRows, 4);
			//program.placeFourCornerBots(testBoard);
			testBoard.moveBots(numberOfTimeUnits);
			System.out.println(testBoard.toString());
		} else {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java edu.neumont.csc150.lab4.rollinsb.BattleBotCLI numberOfCols numberOfRows amountOfTime");
		}
		

	}

}
