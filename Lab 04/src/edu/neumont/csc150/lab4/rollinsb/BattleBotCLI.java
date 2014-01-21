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

		// If there are 4 args, then it is the first lab
		if (args.length == 4) {
			int sizeOfBoard = Integer.parseInt(args[0]);
			int numberOfRowsMoved = Integer.parseInt(args[1]);
			int numberOfColsMoved = Integer.parseInt(args[2]);
			int numberOfTimeUnits = Integer.parseInt(args[3]);

			BattleBotField testBoard = new BattleBotField(sizeOfBoard, sizeOfBoard);
			program.placeBot(testBoard, 0, 0, numberOfRowsMoved, numberOfColsMoved);
			testBoard.moveBots(numberOfTimeUnits);
			System.out.println(testBoard);

		} else {
			//System.out.println("Invalid number of arguments.");
			
			BattleBotField testBoard = new BattleBotField(10, 7);
			program.placeFourCornerBots(testBoard);
			testBoard.moveBots(10);
			System.out.println(testBoard.toString());
			
		}

	}

}
