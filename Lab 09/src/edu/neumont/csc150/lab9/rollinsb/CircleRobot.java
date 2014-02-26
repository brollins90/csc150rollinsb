package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;

public class CircleRobot extends Robot {

	/**
	 * Creates a CircleRobot at the specified location
	 * @param robotLocation The location to create the Robot
	 */
	public CircleRobot(Point robotLocation) {
		super(robotLocation);
	}

	/**
	 * Creates a CircleRobot at the specified location with the specified speed
	 * @param robotLocation The location to create the Robot
	 * @param robotSpeed The speed for the Robot
	 */
	public CircleRobot(Point robotLocation, Point robotSpeed) {
		super(robotLocation, robotSpeed);
	}

	/**
	 * Updates the Robot's location
	 * @param timeUnits The number of times to perform the move
	 */
	@Override
	public void move(int timeUnits) {
		super.location.x += (super.speed.x * timeUnits);
		super.location.y += (super.speed.y * timeUnits);
	}
	
	/**
	 * Returns a String that will represent the Robot on the Console
	 */
	@Override
	public String getConsoleDisplay() {
		return "C";
	}
	
	/**
	 * Returns a String representation of the Robot
	 */
	@Override
	public String toString() {
		return "C";
	}
	

}
