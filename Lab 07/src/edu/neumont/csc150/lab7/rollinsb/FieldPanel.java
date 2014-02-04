package edu.neumont.csc150.lab7.rollinsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FieldPanel extends JPanel {

	private static final long serialVersionUID = 3754185169806893540L;	
	private String[][] field;
	private JTextArea fieldLabel;
	private JButton forwardButton;
	private Container botContainer;
	
	public FieldPanel(int numberOfColumns, int numberOfRows) {
		
		// Create a new [][]
		field = new String[numberOfColumns][numberOfRows];
		
		// Initialize the [][] to all "empty" values
		clearField();
		
		forwardButton = new JButton("+1 time");
		forwardButton.addActionListener(new ButtonListener());
		
		fieldLabel = new JTextArea(getFieldAsString());
		this.add(fieldLabel);
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
	
	public String getFieldAsString(){
		String outString = "";
		
		for (int rowIndex = 0; rowIndex < getNumberOfRows(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < getNumberOfColumns(); columnIndex++) {
				outString += field[columnIndex][rowIndex];
			}
			outString += "\n";
		}		
		return outString;
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
	
	public void updateFieldPanel() {
		fieldLabel.setText(getFieldAsString());
	}

	public void setContainer(Container bbContainer) {
		botContainer = bbContainer;		
	}
	
	private class ButtonListener implements ActionListener {
		
		public ButtonListener() {
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			botContainer.moveBots(1);			
		}
	}

}
