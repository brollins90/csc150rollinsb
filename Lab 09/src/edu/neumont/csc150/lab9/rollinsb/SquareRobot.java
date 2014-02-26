package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;

public class SquareRobot extends Robot {
	
	private int timeStalled;

	/**
	 * Creates a SquareRobot at the specified location
	 * @param robotLocation The location to create the Robot
	 */
	public SquareRobot(Point robotLocation) {
		super(robotLocation);
		timeStalled = 0;
	}

	/**
	 * Creates a SquareRobot at the specified location with the specified speed
	 * @param robotLocation The location to create the Robot
	 * @param robotSpeed The speed for the Robot
	 */
	public SquareRobot(Point robotLocation, Point robotSpeed) {
		super(robotLocation, robotSpeed);
	}

	/**
	 * Updates the Robot's location
	 * @param timeUnits The number of times to perform the move
	 */
	@Override
	public void move(int timeUnits) {
		if (timeStalled == 0) {
			int shouldStall = super.rand.nextInt(10);
			if (shouldStall < 3) {
				timeStalled = 5;
			}
		}
		if (timeStalled == 0) {
			super.location.x += (super.speed.x * timeUnits);
			super.location.y += (super.speed.y * timeUnits);
		} else {
			System.out.println(this.toString());
			timeStalled--;
		}
	}

	/**
	 * Returns a String that will represent the Robot on the Console
	 */
	@Override
	public String getConsoleDisplay() {
		if (timeStalled == 0) {
			return "S";
		} else {
			return "s";
		}
	}

	/**
	 * Returns a String representation of the Robot
	 */
	@Override
	public String toString() {
		if (timeStalled == 5) {
			return "Square bot stalled.";
		} else if (timeStalled !=0) {
			return "Squarebot still stalled for " + timeStalled + " more turns";
		} else {
			return "";
		}
	}

}
