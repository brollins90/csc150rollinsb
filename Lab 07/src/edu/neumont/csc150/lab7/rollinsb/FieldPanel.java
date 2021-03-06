package edu.neumont.csc150.lab7.rollinsb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {

	private static final long serialVersionUID = 3754185169806893540L;	
	private JLabel[][] field;
	private JPanel topPanel, leftPanel, rightPanel, bottomPanel, botPanel;
	private JButton forwardButton,reverseButton;
	private Random rand;
	private ActionListener timeListener;
	
	public FieldPanel(int numberOfColumns, int numberOfRows) {
		
		rand = new Random();
		// Create a new [][]
		field = new JLabel[numberOfColumns][numberOfRows];
		
		this.setLayout(new BorderLayout());
		
		// Top Panel
		topPanel = new JPanel();	
		this.add(topPanel, BorderLayout.NORTH);
		
		// Left Panel
		leftPanel = new JPanel();
		this.add(leftPanel, BorderLayout.WEST);
		
		// Right Panel
		rightPanel = new JPanel();
		this.add(rightPanel, BorderLayout.EAST);
		
		// Bottom Panel
		bottomPanel = new JPanel();
		reverseButton = new JButton("-1 time");
		reverseButton.addActionListener(new ButtonListener());
		bottomPanel.add(reverseButton);
		
		forwardButton = new JButton("+1 time");
		forwardButton.addActionListener(new ButtonListener());
		bottomPanel.add(forwardButton);	
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		// Bot Panel
		botPanel = new JPanel();
		botPanel.setLayout(new GridLayout(numberOfRows,numberOfColumns));
		// add the field and initialize it
		initializeField();
		this.add(botPanel);
	}

	/**
	 * Adds the TimeListener from the parent class so it know what to notify when a button is clicked
	 * @param tListener	The container's time listener
	 */
	public void addTimeListener(ActionListener tListener) {
		this.timeListener = tListener;
	}

	/**
	 * Sets all locations of the field array to the empty value.
	 */
	public void clearField() {
		for (JLabel[] c : field) {
			for (JLabel r : c) {
				r.setText("-");
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
	 * Initializes the JLabel[][]
	 * Should only be called once.
	 */
	private void initializeField() {
		for (int i = 0; i < getNumberOfColumns(); i++) {
			for (int j = 0; j < getNumberOfRows(); j++) {
				// Sets every spot to empty and then adds the spot to the output
				field[i][j] = new JLabel("-");
				field[i][j].setForeground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
				botPanel.add(field[i][j]);
			}
		}
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
			field[column][row].setText("X");
		}
	}
	
	/**
	 * The ButtonListener listens for the button click in the panel
	 * @author Blake
	 *
	 */
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Button Clicked!");
			
			JButton source = (JButton) arg0.getSource();
			String command = "";
			
			if (source == forwardButton) {
				command = "forward";
			} else if (source == reverseButton) {
				command = "reverse";
			}
			timeListener.actionPerformed(new ActionEvent(source, 7, command));
		}
	}

}
