package edu.neumont.csc150.lab6.rollinsb;

import java.util.Random;

/**
 * The BattleBotField holds an 2 dimensional array of Booleans representing the
 * locations of the Bots Also holds an array of BattleBot objects
 * 
 * @author Blake Rollins
 * 
 */
public class BattleBotField {
	
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
	
	public boolean isValidLocation(int testColumn, int testRow) {
		return (testColumn >=0 && testColumn < getNumberOfColumns() && testRow >=0 && testRow < getNumberOfRows());
	}
//
//	/**
//	 * Updates the field array with the location of all the Bots.
//	 */
//	public void paintField() {
//		for (int i = 0; i < bots.length; i++) {
//			int botColumn = bots[i].getColumn();
//			int botRow = bots[i].getRow();
//			if (botColumn >= 0 && botColumn < getNumberOfColumns() && botRow >= 0 && botRow < getNumberOfRows()) {
//				field[botColumn][botRow] = true;
//			}
//		}
//	}
//
//	/**
//	 * Sets all locations of the field array to false.
//	 */
//	private void clearField() {
//		for (int i = 0; i < field.length; i++) {
//			for (int j = 0; j < field[0].length; j++) {
//				field[i][j] = false;
//			}
//		}
//	}
//
//	/**
//	 * Returns a String representation of the field array.
//	 */
//	public String toString() {
//		clearField();
//		paintField();
//		
//		String outString = "";
//		// Add the array to the output
//		for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
//			for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
//				outString += (field[columnIndex][rowIndex]) ? "X" : "-";
//			}
//			outString += "\n";
//		}
//		// Print the info for the Bots (in case they are off screen
//		for (int botIndex = 0; botIndex < getNumberOfBots(); botIndex++) {
//			outString += "Bot " + (botIndex + 1) + " is at (" + bots[botIndex].getColumn() + "," + bots[botIndex].getRow() + ")\n";
//		}
//		return outString;
//	}

}