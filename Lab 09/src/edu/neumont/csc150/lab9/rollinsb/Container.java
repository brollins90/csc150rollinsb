package edu.neumont.csc150.lab9.rollinsb;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Container {

	private ArrayList<Robot> botList;
	private ArrayList<Field> fieldList;
	private Random rand;
	private TimeListener tListener;
	
	/**
	 * Creates a Container with the specified number of Robots.
	 * @param numberOfBots		The number of Robots to create
	 * @param numberOfColumns	The number of columns on the field (to create the Robots in bounds)
	 * @param numberOfRows		The number of rows on the field (to create the Robots in bounds)
	 */
	public Container(int numberOfBots, int numberOfColumns, int numberOfRows) {	
		this.botList = new ArrayList<Robot>();	
		this.fieldList = new ArrayList<Field>();
		this.rand = new Random();
		this.tListener = new TimeListener();
		
		// Create the random Robots
		for (int i = 0; i < numberOfBots; i++) {
			botList.add(RobotFactory.createRobot(new Point(getRandomLocation(numberOfColumns), getRandomLocation(numberOfRows))));
		}
	}
	
	/**
	 * Creates a Container with the one input Robot
	 * @param newBot
	 */
	public Container(Robot newBot) {
		this.botList = new ArrayList<Robot>();	
		this.fieldList = new ArrayList<Field>();
		this.rand = new Random();
		this.tListener = new TimeListener();
		botList.add(newBot);
	}
	
	/**
	 * Adds a Field for the Container to use
	 * @param bbField	The Field to add
	 */
	public void addField(Field newField) {
		newField.addTimeListener(this.tListener);
		
		this.fieldList.add(newField);
	}
//	
//	/**
//	 * Returns the column number of the Robot at the specified index
//	 * @param botIndex	The index of the Robot
//	 * @return	The Robot at the specified index's column
//	 */
//	public int getBotColumn(int botIndex) {
//		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
//			return this.botList.get(botIndex).getColumn();
//		}
//		return 0;
//	}
//	
//	/**
//	 * Returns the column speed of the Robot at the specified index
//	 * @param botIndex	The index of the Robot
//	 * @return	The Robot at the specified index's column speed
//	 */
//	public int getBotColumnSpeed(int botIndex) {
//		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
//			return this.botList.get(botIndex).getColumnSpeed();
//		}
//		return 0;
//	}
//	
//	/**
//	 * Returns the row number of the Robot at the specified index
//	 * @param botIndex	The index of the Robot
//	 * @return	The Robot at the specified index's row
//	 */
//	public int getBotRow(int botIndex) {
//		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
//			return this.botList.get(botIndex).getRow();
//		}
//		return 0;
//	}
//	
//	/**
//	 * Returns the row speed of the Robot at the specified index
//	 * @param botIndex	The index of the Robot
//	 * @return	The Robot at the specified index's row speed
//	 */
//	public int getBotRowSpeed(int botIndex) {
//		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
//			return this.botList.get(botIndex).getRowSpeed();
//		}
//		return 0;
//	}
	
	/**
	 * Returns the number of Robots
	 * @return
	 */
	public int getNumberOfBots() {
		return this.botList.size();
	}
	
	/**
	 * Returns a random int in the specified range
	 * @param range  The range of numbers
	 */
	private int getRandomLocation(int range) {
		return this.rand.nextInt(range);
	}

	/**
	 * Updates the location of each Robot on the field by calling the move
	 * method of each Robot.
	 */
	public void moveBots(int timeUnits) {
		for (Robot r : this.botList) {
			r.move(timeUnits);
		}
	}
	
	/**
	 * Calls the clearField() method for all the fields
	 */
	private void clearFields() {
		for (Field f : this.fieldList) {
			f.clearField();
		}
	}

	/**
	 * Places all the Robots on all the fields
	 */
	public void placeBots() {
		for (Robot r : this.botList) {
			for (Field f : this.fieldList) {
				f.placeBot(new Point(r.getColumn(), r.getRow()), r.getConsoleDisplay());
			}
		}
	}

	/**
	 * Prints the Fields with the current Robots
	 */
	public void printFields() {
		// Clear the Fields
		clearFields();
		
		// Place the Robots
		placeBots();
		
		// Print the Fields
		for (Field f : this.fieldList) {
			f.printField();
		}
	}
	
	/**
	 * The TimeListener is called by the container when a time button has been clicked
	 * @author Blake
	 *
	 */
	private class TimeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String command = arg0.getActionCommand();
			System.out.println("Container recieved the click: " + command);
			
			int timeToMove = 0;
			if (command.equals("forward")) {
				timeToMove = 1;
			} else if (command.equals("reverse")) {
				timeToMove = -1;
			} else {
				System.out.println("an invalid button click has been recieved: " + arg0.getSource());
			}
			moveBots(timeToMove);
			placeBots();
			printFields();
		}
	}
	
}
