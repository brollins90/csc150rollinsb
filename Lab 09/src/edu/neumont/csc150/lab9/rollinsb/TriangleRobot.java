package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;

public class TriangleRobot extends Robot {

	/**
	 * Creates a TriangleRobot at the specified location
	 * @param robotLocation The location to create the Robot
	 */
	public TriangleRobot(Point robotLocation) {
		super(robotLocation);
	}

	/**
	 * Creates a TriangleRobot at the specified location with the specified speed
	 * @param robotLocation The location to create the Robot
	 * @param robotSpeed The speed for the Robot
	 */
	public TriangleRobot(Point robotLocation, Point robotSpeed) {
		super(robotLocation, robotSpeed);
	}
	
	/**
	 * Returns a random location between 0 and 9
	 * @return
	 */
	private int getRandomLocation() {
		return super.rand.nextInt(10);
	}
	
	/**
	 * Changes the Robot's location to a random value
	 */
	private void changeLocation() {
		super.location = new Point(getRandomLocation(),getRandomLocation());
	}
	
	/**
	 * Changes the Robot's speed to a random value
	 */
	private void changeSpeed() {
		super.speed = new Point(super.getRandomSpeed(), super.getRandomSpeed());
	}

	/**
	 * Updates the Robot's location
	 * @param timeUnits The number of times to perform the move
	 */
	@Override
	public void move(int timeUnits) {
		int shouldTeleport = super.rand.nextInt(10);
		if (shouldTeleport < 1) {
			// Change speed and loc
			this.changeLocation();
			this.changeSpeed();
			System.out.println(this.toString());
		} else {
			super.location.x += (super.speed.x * timeUnits);
			super.location.y += (super.speed.y * timeUnits);
		}
	}

	/**
	 * Returns a String that will represent the Robot on the Console
	 */
	@Override
	public String getConsoleDisplay() {
		return "T";
	}

	/**
	 * Returns a String representation of the Robot
	 */
	@Override
	public String toString() {
		return "Triangle robot teleported";
	}

}
