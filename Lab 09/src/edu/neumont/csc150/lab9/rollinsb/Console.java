package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.awt.event.ActionListener;

/**
 * The Console extends Field and holds a 2 dimensional array of Strings
 * representing the locations of the Robots
 * 
 * @author Blake Rollins
 * 
 */
public class Console implements Field {

	private String[][] fieldArray;

	/**
	 * Creates a Console Field of the specified dimensions.
	 * 
	 * @param numberOfRows
	 *            The number of rows for the field
	 * @param numberOfColumns
	 *            The number of columns for the field
	 */
	public Console(int numberOfColumns, int numberOfRows) {

		// Create a new [][]
		fieldArray = new String[numberOfColumns][numberOfRows];

		// Initialize the [][] to all "empty" values
		clearField();
	}

	/**
	 * Sets all locations of the field array to the empty value.
	 */
	@Override
	public void clearField() {
		for (int i = 0; i < getNumberOfColumns(); i++) {
			for (int j = 0; j < getNumberOfRows(); j++) {
				fieldArray[i][j] = "-";
			}
		}
	}

	/**
	 * Returns the number of columns on the field
	 * 
	 * @return The number of columns on the field
	 */
	@Override
	public int getNumberOfColumns() {
		return fieldArray.length;
	}

	/**
	 * Returns the number of rows on the field
	 * 
	 * @return The number of rows on the field
	 */
	@Override
	public int getNumberOfRows() {
		return fieldArray[0].length;
	}

	/**
	 * Checks if the specified location is on the field
	 * 
	 * @param testColumn
	 * @param testRow
	 * @return
	 */
	@Override
	public boolean isLocationOnField(Point testLocation) {
		return (testLocation.x >= 0 && testLocation.x < getNumberOfColumns()
				&& testLocation.y >= 0 && testLocation.y < getNumberOfRows());
	}

	/**
	 * Set the location to the occupied value
	 */
	@Override
	public void placeBot(Point robotLocation, String robotString) {
		if (isLocationOnField(robotLocation)) {
			fieldArray[robotLocation.x][robotLocation.y] = robotString;
		}
	}

	@Override
	public void printField() {
		System.out.println(toString());
	}

	@Override
	public void addTimeListener(ActionListener tListener) {
		// TODO: Not yet implemented
	}

	/**
	 * returns the BattleBotField as a String
	 */
	public String toString() {
		String outString = "";

		for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
				outString += fieldArray[columnIndex][rowIndex];
			}
			outString += "\n";
		}
		return outString;
	}

}