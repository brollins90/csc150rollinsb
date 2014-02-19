package edu.neumont.csc150.lab8.rollinsb;

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
	 * @param testColumn The test column
	 * @param testRow The test row
	 * @return If the location is on the board
	 */
	public boolean isLocationOnField(int testColumn, int testRow);
	
	/**
	 * Adds a Robot representation to the field
	 * @param column The column of the Robot
	 * @param row The row of the Robot
	 */
	public void placeBot(int column, int row);
	
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
