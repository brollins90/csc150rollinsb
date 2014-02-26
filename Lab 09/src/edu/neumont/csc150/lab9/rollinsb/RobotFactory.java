package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.util.Random;

public class RobotFactory {
	
	private static Random rand = new Random();
	
	/**
	 * Creates a Robot of a random type at the input location with a random speed
	 * @param robotLocation The location of the Robot
	 * @return A new Robot
	 */
	public static Robot createRobot(Point robotLocation) {
		int temp = rand.nextInt(3);
		switch (temp) {
		default:
		case 0:
			return new CircleRobot(robotLocation);
		case 1:
			return new SquareRobot(robotLocation);
		case 2:
			return new TriangleRobot(robotLocation);
		}
	}
	
	
}
