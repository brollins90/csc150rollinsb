package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.awt.event.ActionListener;

/**
 * A Field will display the location of the Robots to the user
 * @author Blake
 *
 */
public interface Field {

	/**
	 * Clears the display for a repaint
	 */
	public void clearField();
	
	/**
	 * Returns the number of columns the board has
	 * @return The number of columns
	 */
	public int getNumberOfColumns();
	
	/**
	 * Returns the number of rows the board has
	 * @return The number of rows
	 */
	public int getNumberOfRows();
	
	/**
	 * Returns if the location is on the Field
	 * @param testLocation The Point to test
	 * @return If the location is on the board
	 */
	public boolean isLocationOnField(Point testLocation);
	
	/**
	 * Adds a Robot representation to the field
	 * @param robotLocation the location to place the Robot
	 * @param row the String that is displayed
	 */
	public void placeBot(Point robotLocation, String robotString);
	
	/**
	 * Updates the field to display the most recent Robot information
	 */
	public void printField();
	
	/**
	 * Adds a time listener reference for the Container object
	 * @param tListener
	 */
	public void addTimeListener(ActionListener tListener);
}
