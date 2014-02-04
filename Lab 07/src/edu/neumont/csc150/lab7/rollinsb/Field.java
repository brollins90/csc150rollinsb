package edu.neumont.csc150.lab7.rollinsb;

/**
 * The BattleBotField holds a 2 dimensional array of Strings representing the
 * locations of the BattleBots
 * 
 * @author Blake Rollins
 * 
 */
public class Field {
	
	private String[][] field;

	/**
	 * Creates a Field of the specified dimensions.
	 * 
	 * @param numberOfRows  The number of rows for the field
	 * @param numberOfColumns  The number of columns for the field
	 */
	public Field(int numberOfColumns, int numberOfRows) {
		
		// Create a new [][]
		field = new String[numberOfColumns][numberOfRows];
		
		// Initialize the [][] to all "empty" values
		clearField();
	}
	
	/**
	 * Sets all locations of the field array to the empty value.
	 */
	public void clearField() {
		for (int i = 0; i < getNumberOfColumns(); i++) {
			for (int j = 0; j < getNumberOfRows(); j++) {
				field[i][j] = "-";
			}
		}
	}
		
	/**
	 * Returns the number of columns on the field
	 * @return	The number of columns on the field
	 */
	public int getNumberOfColumns() {
		return field.length;
	}
		
	/**
	 * Returns the number of rows on the field
	 * @return	The number of rows on the field
	 */
	public int getNumberOfRows() {
		return field[0].length;
	}
		
	/**
	 * Checks if the specified location is on the field
	 * @param testColumn
	 * @param testRow
	 * @return
	 */
	public boolean isLocationOnField(int testColumn, int testRow) {
		return (testColumn >=0 && testColumn < getNumberOfColumns() && testRow >=0 && testRow < getNumberOfRows());
	}
		
	/**
	 * Set the location to the occupied value
	 */
	public void placeBot(int column, int row) {
		if (isLocationOnField(column, row)) {
			field[column][row] = "X";
		}
	}
		
	/**
	 * returns the BattleBotField as a String
	 */
	public String toString() {
		String outString = "";
		
		for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
				outString += field[columnIndex][rowIndex];
			}
			outString += "\n";
		}		
		return outString;
	}

}