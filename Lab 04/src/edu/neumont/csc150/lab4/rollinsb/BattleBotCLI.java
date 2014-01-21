package edu.neumont.csc150.lab4.rollinsb;

/**
 * Runs the CLI version of the BattleBot program.
 * 
 * @author Blake Rollins
 * 
 */
public class BattleBotCLI {

	/**
	 * Places a BattleBot on the field
	 * 
	 * @param bbField	The BattleBotField to use
	 * @param botColumn The Bot's starting column
	 * @param botRow The Bot's starting row
	 * @param botColumnSpeed The Bot's column movement speed
	 * @param botRowSpeed The Bot's row movement speed
	 */
	public void placeBot(BattleBotField bbField, int botColumn, int botRow, int botColumnSpeed, int botRowSpeed) {
		bbField.addBot(new BattleBot(botColumn, botRow, botColumnSpeed, botRowSpeed));
	}
	
	/**
	 * Places four BattleBots on the field in the corners with random speeds
	 * @param bbField	The BattleBotField to use
	 */
	public void placeFourCornerBots(BattleBotField bbField) {
		bbField.addBot(new BattleBot(0, 0));
		bbField.addBot(new BattleBot(0, bbField.getNumberOfRows() - 1));
		bbField.addBot(new BattleBot(bbField.getNumberOfColumns() - 1, 0));
		bbField.addBot(new BattleBot(bbField.getNumberOfColumns() - 1, bbField.getNumberOfRows() - 1));
	}

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
			
			BattleBotField testBoard = new BattleBotField(numberOfCols, numberOfRows);
			program.placeFourCornerBots(testBoard);
			testBoard.moveBots(numberOfTimeUnits);
			System.out.println(testBoard.toString());
		} else {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java edu.neumont.csc150.lab4.rollinsb.BattleBotCLI numberOfCols numberOfRows amountOfTime");
		}
		

	}

}
