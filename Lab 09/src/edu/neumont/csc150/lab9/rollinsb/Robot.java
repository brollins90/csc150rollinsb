package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.util.Random;

/**
 * The BattleBot object contains all the information related to a BattleBot
 * @author Blake Rollins 
 */
public abstract class Robot {

	protected Point location;
	protected Point speed;
	protected Random rand;

	/**
	 * Creates a Robot at the input location with a random speed
	 * @param robotLocation The location of the robot
	 */
	public Robot(Point robotLocation) {
		rand = new Random();
		location = robotLocation;
		speed = new Point(getRandomSpeed(),getRandomSpeed());
	}

	/**
	 * Creates a Robot at the input location with the input speed
	 * @param robotLocation The location of the robot
	 * @param robotSpeed The speed of the robot
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
	 * Moves the Robot the specified number of time units
	 * @param additionalTimeUnits
	 */
	public abstract void move(int timeUnits);

	/**
	 * Returns a String representation of the Robot
	 */
	public abstract String getConsoleDisplay();

}