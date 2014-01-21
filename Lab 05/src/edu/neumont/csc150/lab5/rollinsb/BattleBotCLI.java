package edu.neumont.csc150.lab5.rollinsb;

import java.util.Random;

/**
 * Runs the CLI version of the BattleBot program.
 * 
 * @author Blake Rollins
 * 
 */
public class BattleBotCLI {
	
	private Random rand;
	
	public BattleBotCLI() {
		rand = new Random();
	}
	
	public int getRandom(int range) {
		return rand.nextInt(range);
	}

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
	 * Places provided number of BattleBots on the field with random speeds
	 * @param bbField	The BattleBotField to use
	 * @param numberOfBots	The number of BattleBots to create
	 */
	public void placeXRandomBots(BattleBotField bbField, int numberOfBots) {
		int numberOfCols = bbField.getNumberOfColumns();
		int numberOfRows = bbField.getNumberOfRows();
		// TODO:
		
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
		
		// For lab 5 we want to create X number of BattleBots at random places on the board.
		// We want to take four parameters.  number of columns in the board, number of rows in the board,
		// the number of time units and the number of BattleBots to add to the board.
		if (args.length == 4) {
			int numberOfCols = Integer.parseInt(args[0]);
			int numberOfRows = Integer.parseInt(args[1]);
			int numberOfTimeUnits = Integer.parseInt(args[2]);
			int numberOfBots = Integer.parseInt(args[3]);
			
			BattleBotField testBoard = new BattleBotField(numberOfCols, numberOfRows);
			program.placeXRandomBots(testBoard, numberOfBots);
			testBoard.moveBots(numberOfTimeUnits);
			System.out.println(testBoard.toString());
		} else {
			System.out.println("Invalid number of arguments:");
			System.out.println("Usage: java edu.neumont.csc150.lab5.rollinsb.BattleBotCLI numberOfCols numberOfRows amountOfTime numberOfBots");
		}
		

	}

}
