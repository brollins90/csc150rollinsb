package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.util.Random;

/**
 * The BattleBot object contains all the information related to a BattleBot * 
 * @author Blake Rollins 
 */
public abstract class Robot {

	protected Point location;
	protected Point speed;
	protected Random rand;

	/**
	 * The BattleBot needs a starting row and column and will set a random speed
	 * @param columnIn
	 * @param rowIn
	 */
	public Robot(Point robotLocation) {
		rand = new Random();
		location = robotLocation;
		speed = new Point(getRandomSpeed(),getRandomSpeed());
	}

	/**
	 * The BattleBot needs a starting row and column and movement speed
	 * 
	 * @param columnIn
	 * @param rowIn
	 * @param columnSpeedIn
	 * @param rowSpeedIn
	 */
	public Robot(Point robotLocation, Point robotSpeed) {
		rand = new Random();
		location = robotLocation;
		speed = robotSpeed;
	}

	/**
	 * Returns the current column
	 * @return The current column value
	 */
	public int getColumn() {
		return location.x;
	}

	/**
	 * Returns the current column speed
	 * @return The current columnSpeed value
	 */
	public int getColumnSpeed() {
		return speed.x;
	}

	/**
	 * Returns the current row
	 * @return The current row value
	 */
	public int getRow() {
		return location.y;
	}

	/**
	 * Returns the current row speed
	 * @return The current rowSpeed value
	 */
	public int getRowSpeed() {
		return speed.y;
	}
	
	/**
	 * Returns a random BattleBot speed
	 * @return a random BattleBot speed
	 */
	protected int getRandomSpeed() {
		return rand.nextInt(7) - 3;
	}
	
	/**
	 * Moves the BattleBot the specified number of time units
	 * @param additionalTimeUnits
	 */
	public abstract void move(int timeUnits);
	
	public abstract String getConsoleDisplay();

}