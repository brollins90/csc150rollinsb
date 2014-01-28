package edu.neumont.csc150.lab6.rollinsb;

import java.util.Random;

/**
 * The BattleBot object moves around on the BattleBotField
 * 
 * @author Blake
 * 
 */
public class Bot {

	private int column;
	private int row;
	private int columnSpeed;
	private int rowSpeed;
	private Random rand;

	/**
	 * The BattleBot needs a starting row and column and will set a random speed
	 * 
	 * @param columnIn
	 * @param rowIn
	 */
	public Bot(int columnIn, int rowIn) {
		rand = new Random();
		column = columnIn;
		row = rowIn;
		columnSpeed = getRandomSpeed();
		rowSpeed = getRandomSpeed();
	}

	/**
	 * The BattleBot needs a starting row and column and movement speed
	 * 
	 * @param columnIn
	 * @param rowIn
	 * @param columnSpeedIn
	 * @param rowSpeedIn
	 */
	public Bot(int columnIn, int rowIn, int columnSpeedIn, int rowSpeedIn) {
		rand = new Random();
		column = columnIn;
		row = rowIn;
		columnSpeed = columnSpeedIn;
		rowSpeed = rowSpeedIn;
	}

	/**
	 * Returns the current column
	 * @return The current column value
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Returns the current column speed
	 * @return The current columnSpeed value
	 */
	public int getColumnSpeed() {
		return columnSpeed;
	}

	/**
	 * Returns the current row
	 * @return The current row value
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Returns the current row speed
	 * @return The current rowSpeed value
	 */
	public int getRowSpeed() {
		return rowSpeed;
	}
	
	/**
	 * Returns a random BattleBot speed
	 * @return a random BattleBot speed
	 */
	private int getRandomSpeed() {
		return rand.nextInt(7) - 3;
	}
	
	/**
	 * Moves the BattleBot any number of time units
	 * @param additionalTimeUnits
	 */
	public void move(int additionalTimeUnits) {
		column += (columnSpeed * additionalTimeUnits);
		row += (rowSpeed * additionalTimeUnits);
	}

}