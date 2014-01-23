package edu.neumont.csc150.lab5.rollinsb;


public class BattleBotCLITests {

	/**
	 * Tests if the created field is the correct size.
	 * 
	 * @param bbField		The field to test
	 * @param expectedSize	The expected size
	 * @return 				A boolean if the field is the correct size
	 */
	public boolean checkGridSize(BattleBotField bbField, int expectedColumnSize, int expectedRowSize) {
		return ((bbField.getNumberOfColumns() == expectedColumnSize) && (bbField.getNumberOfRows() == expectedRowSize));
	}

	/**
	 * Tests if the Bot has moved to the correct location
	 * 
	 * @param bbField	The field to test
	 * @param expectedColumnLocation 	The expected column (a -1 means the Bot has moved off the board)
	 * @param expectedRowLocation		The expected row (a -1 means the Bot has moved off the board)
	 * @return 	A boolean if the Bot is at the correct location
	 */
	public boolean checkBotLocation(BattleBotField bbField, int botIndex, int expectedColumnLocation, int expectedRowLocation) {
		return ((bbField.getBot(botIndex).getColumn() == expectedColumnLocation) && (bbField.getBot(botIndex).getRow() == expectedRowLocation));
	}
	
	/**
	 * Will check the field output and verify that there is an X
	 * @param bbField the field to test
	 * @return If there is a Bot on the field
	 */
	public boolean checkBotIsOnField(BattleBotField bbField) {
		String fieldString = bbField.toString();
		if (fieldString.indexOf('X') == -1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Will check the field output and verify that there is no empty spaces
	 * @param bbField the field to test
	 * @return If there is no empty spaces on the field
	 */
	public boolean checkNoEmptySpots(BattleBotField bbField) {
		String fieldString = bbField.toString();
		if (fieldString.indexOf('-') == -1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check the bot's random speed generator
	 * @param min min allowed speed
	 * @param max max allowed speed
	 * @param timesToCheck the number of times to check (should be high)
	 * @return	if the speed generator was always in bounds
	 */
	public boolean checkRandomSpeedRange(int min, int max, int timesToCheck) {
		// Create timesToCheck # of bots and make sure their speeds are in range
		int lowestFound = max;
		int highestFound = min;
		for (int i = 0; i < timesToCheck; i++) {
			BattleBot testBot = new BattleBot(0, 0);
			int botColSpeed = testBot.getColumnSpeed();
			int botRowSpeed = testBot.getRowSpeed();

			if (botColSpeed < lowestFound) {
				lowestFound = botColSpeed;
			}
			if (botRowSpeed < lowestFound) {
				lowestFound = botRowSpeed;
			}

			if (botColSpeed > highestFound) {
				highestFound = botColSpeed;
			}
			if (botRowSpeed > highestFound) {
				highestFound = botRowSpeed;
			}
			
			if (botColSpeed > max || botColSpeed < min || botRowSpeed > max || botRowSpeed < min) {
				return false;
			}
		}
		// Since we tracked the highest and lowest, we should have hit them at least once
		if (lowestFound != min || highestFound != max) {
			return false;
		}
		return true;
	}

	/**
	 * Runs a list of tests for the program
	 * 
	 * @return A boolean if all the tests passed
	 */
	public void runTests() {
		System.out.println("Running tests...");;
		BattleBotField testField;
		
		System.out.println("");
		System.out.println("Grid size tests:");
		
		System.out.print("Grid size set to 3x3 worked: ");
		System.out.println(checkGridSize(new BattleBotField(3, 3), 3, 3));

		System.out.print("Grid size set to 3x5 worked: ");
		System.out.println(checkGridSize(new BattleBotField(3, 5), 3, 5));

		System.out.print("Grid size set to 5x3 worked: ");
		System.out.println(checkGridSize(new BattleBotField(5, 3), 5, 3));

		System.out.print("Grid size set to 5x5 worked: ");
		System.out.println(checkGridSize(new BattleBotField(5, 5), 5, 5));


		System.out.println("");
		System.out.println("Start location tests:");
		
		System.out.print("BattleBot starts in top left corner: ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(0, 0, 1, 1));
		System.out.println(checkBotLocation(testField, 0, 0, 0));
		
		System.out.print("BattleBot starts in top right corner: ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(testField.getNumberOfColumns() -1, 0, 1, 1));
		System.out.println(checkBotLocation(testField, 0, 4, 0));

		System.out.print("BattleBot starts in bottom left corner: ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(0, testField.getNumberOfRows() - 1, 1, 1));
		System.out.println(checkBotLocation(testField, 0, 0, 4));

		System.out.print("BattleBot starts in bottom right corner: ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(testField.getNumberOfColumns() -1, testField.getNumberOfRows() - 1, 1, 1));
		System.out.println(checkBotLocation(testField, 0, 4, 4));

		
		System.out.println("");
		System.out.println("Single bot move tests:");

		System.out.print("BattleBot moves correctly 1a (1 column, 1 row, 1 time): ");
		testField = new BattleBotField(10, 10);
		testField.addBot(new BattleBot(0,0,1,1));
		testField.moveBots(1);
		System.out.println(checkBotLocation(testField, 0, 1, 1));

		System.out.print("BattleBot moves correctly 1b (2 column, 1 row, 1 time): ");
		testField = new BattleBotField(10, 10);
		testField.addBot(new BattleBot(0,0,2,1));
		testField.moveBots(1);
		System.out.println(checkBotLocation(testField, 0, 2, 1));

		System.out.print("BattleBot moves correctly 1c (1 column, 2 row, 1 time): ");
		testField = new BattleBotField(10, 10);
		testField.addBot(new BattleBot(0,0,1,2));
		testField.moveBots(1);
		System.out.println(checkBotLocation(testField, 0, 1, 2));

		System.out.print("BattleBot moves correctly 2a (1 column, 2 row, 3 time): ");
		testField = new BattleBotField(10, 10);
		testField.addBot(new BattleBot(0,0,1,2));
		testField.moveBots(3);
		System.out.println(checkBotLocation(testField, 0, 3, 6));

		System.out.print("BattleBot moves correctly 3a (R column, R row, 3 time): ");
		testField = new BattleBotField(10, 10);
		testField.addBot(new BattleBot(0,0));
		int colSpeed = testField.getBot(0).getColumnSpeed();
		int rowSpeed = testField.getBot(0).getRowSpeed();
		int time = 3;
		testField.moveBots(3);
		System.out.println(checkBotLocation(testField, 0, colSpeed * time, rowSpeed * time));

		
		System.out.println("");
		System.out.println("Moves off the field tests:");
		
		System.out.print("BattleBot moves off field correctly 1a: (2 column, 1 row, 3 time): ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(0,0,2,1));
		testField.moveBots(3);
		System.out.println(!checkBotIsOnField(testField));
		
		System.out.print("BattleBot moves off field correctly 1b: (2 column, 1 row, 1000 time): ");
		testField = new BattleBotField(5, 5);
		testField.addBot(new BattleBot(0,0,2,1));
		testField.moveBots(1000);
		System.out.println(!checkBotIsOnField(testField));	
		
		
		System.out.println("");;
		System.out.println("Randomness test:");
		
		System.out.print("Random speed gen test 1: (-3, 3, 1000): ");
		System.out.println(checkRandomSpeedRange(-3,3,1000));
		
		System.out.print("Create a Bot with a random location 1: ");
		testField = new BattleBotField(10, 10);
		testField.addBot();
		System.out.println(checkBotIsOnField(testField));
		
		System.out.print("Create a Bot with a random location 2 (100 times): ");
		boolean hasSucceededEachTime = true;
		for (int i = 0; i < 100; i++) {
			testField = new BattleBotField(10, 10);
			testField.addBot();
			if (hasSucceededEachTime) {
				hasSucceededEachTime = checkBotIsOnField(testField);
			}
		}
		System.out.println(hasSucceededEachTime);
		
		System.out.print("Create a Bot with a random location 3 (fill the board): ");
		testField = new BattleBotField(5, 5);
		for (int i = 0; i < 1000; i++) {
			testField.addBot();
		}
		System.out.println(checkNoEmptySpots(testField));
		
		
		
		
		
	}

	/**
	 * Runs tests for the BattleBotCLI program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BattleBotCLITests program = new BattleBotCLITests();

		program.runTests();

	}
}
