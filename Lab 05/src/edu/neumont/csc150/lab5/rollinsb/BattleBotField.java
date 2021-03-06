package edu.neumont.csc150.lab5.rollinsb;

import java.util.Random;

/**
 * The BattleBotField holds an 2 dimensional array of Booleans representing the
 * locations of the Bots Also holds an array of BattleBot objects
 * 
 * @author Blake Rollins
 * 
 */
public class BattleBotField {

	private BattleBot[] bots;
	private boolean[][] field;
	private Random rand;

	/**
	 * Creates a BattleBotField of the specified dimensions. Creates an empty
	 * array of BattleBots.
	 * 
	 * @param numberOfRows  The number of rows for the field
	 * @param numberOfColumns  The number of columns for the field
	 */
	public BattleBotField(int numberOfColumns, int numberOfRows) {
		rand = new Random();
		field = new boolean[numberOfColumns][numberOfRows];

		bots = new BattleBot[0];
	}

	/**
	 * Creates a BattleBotField of the specified dimensions. Creates an array of BattleBots in random locations.
	 * 
	 * @param numberOfRows  The number of rows for the field
	 * @param numberOfColumns  The number of columns for the field
	 * @param numberOfBots  The number of Bots to place on the field
	 */
	public BattleBotField(int numberOfColumns, int numberOfRows, int numberOfBots) {
		rand = new Random();
		field = new boolean[numberOfColumns][numberOfRows];

		bots = new BattleBot[numberOfBots];
		for (int i = 0; i < numberOfBots; i++) {
			bots[i] = new BattleBot(getRandomLocation(getNumberOfColumns()), getRandomLocation(getNumberOfRows()));
		}
	}

	/**
	 * Adds a BattleBot object to the field in a random location
	 */
	public void addBot() {
		BattleBot newBot = new BattleBot(getRandomLocation(getNumberOfColumns()), getRandomLocation(getNumberOfRows()));
		addBot(newBot);
	}

	/**
	 * Adds a BattleBot object to the field
	 * 
	 * @param newBot  The new BattleBot object to be added
	 */
	public void addBot(BattleBot newBot) {
		BattleBot[] newBots = new BattleBot[bots.length + 1];

		for (int i = 0; i < bots.length; i++) {
			newBots[i] = bots[i];
		}
		newBots[bots.length] = newBot;

		bots = newBots;
	}
	
	/**
	 * Returns the BattleBot at the specified index
	 */
	public BattleBot getBot(int botIndex) {
		// TODO: Check NullPointer
		return bots[botIndex];
	}
	
	/**
	 * Returns the number of BattleBots on the field
	 * @return	The number of BattleBots on the field
	 */
	public int getNumberOfBots() {
		return bots.length;
	}
	
	/**
	 * Returns the number of columns on the field
	 * @return	The number of columns on the field
	 */
	public int getNumberOfColumns() {
		return field.length;
	}
	
	/**
	 * Returns the number of rows on the field
	 * @return	The number of rows on the field
	 */
	public int getNumberOfRows() {
		return field[0].length;
	}
	
	/**
	 * Returns a random int in the specified range
	 * @param range  The range of numbers
	 */
	public int getRandomLocation(int range) {
		return rand.nextInt(range);
	}

	/**
	 * Updates the location of each BattleBot on the field by calling the move
	 * method of each Bot.
	 */
	public void moveBots() {
		for (int i = 0; i < bots.length; i++) {
			bots[i].move(1);
		}

	}

	/**
	 * Updates the location of each BattleBot on the field by calling the move
	 * method of each Bot.
	 */
	public void moveBots(int timeUnits) {
		for (int i = 0; i < bots.length; i++) {
			bots[i].move(timeUnits);
		}

	}

	/**
	 * Updates the field array with the location of all the Bots.
	 */
	public void paintField() {
		for (int i = 0; i < bots.length; i++) {
			int botColumn = bots[i].getColumn();
			int botRow = bots[i].getRow();
			if (botColumn >= 0 && botColumn < getNumberOfColumns() && botRow >= 0 && botRow < getNumberOfRows()) {
				field[botColumn][botRow] = true;
			}
		}
	}

	/**
	 * Sets all locations of the field array to false.
	 */
	private void clearField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = false;
			}
		}
	}

	/**
	 * Returns a String representation of the field array.
	 */
	public String toString() {
		clearField();
		paintField();
		
		String outString = "";
		// Add the array to the output
		for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
				outString += (field[columnIndex][rowIndex]) ? "X" : "-";
			}
			outString += "\n";
		}
		// Print the info for the Bots (in case they are off screen
		for (int botIndex = 0; botIndex < getNumberOfBots(); botIndex++) {
			outString += "Bot " + (botIndex + 1) + " is at (" + bots[botIndex].getColumn() + "," + bots[botIndex].getRow() + ")\n";
		}
		return outString;
	}

}