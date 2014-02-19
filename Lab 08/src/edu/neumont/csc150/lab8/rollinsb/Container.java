package edu.neumont.csc150.lab8.rollinsb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Container {

	private Robot[] bots;
	private Random rand;
	private Field[] fields;
	private TimeListener tListener;
	
	/**
	 * Creates a Container with the specified number of BattleBots.
	 * @param numberOfBots		The number of BattleBots to create
	 * @param numberOfColumns	The number of columns on the field (to create the BattleBots in bounds)
	 * @param numberOfRows		The number of rows on the field (to create the BattleBots in bounds)
	 */
	public Container(int numberOfBots, int numberOfColumns, int numberOfRows) {		
		rand = new Random();
		bots = new Robot[numberOfBots];
		fields = new Field[0];
		this.tListener = new TimeListener();
		for (int i = 0; i < numberOfBots; i++) {
			bots[i] = new Robot(getRandomLocation(numberOfColumns), getRandomLocation(numberOfRows));
		}
	}
	
	/**
	 * Creates a Container with the one input Bot
	 * @param newBot
	 */
	public Container(Robot newBot) {
		rand = new Random();
		bots = new Robot[1];
		bots[0] = newBot;
	}
	
	/**
	 * Sets the Field for the Container to use
	 * @param bbField	The Field for the Container
	 */
	public void addField(Field newField) {
		newField.addTimeListener(this.tListener);
		
		Field[] newArray = new Field[this.fields.length + 1];
		
		for (int i = 0; i < this.fields.length; i ++) {
			newArray[i] = this.fields[i];
		}
		newArray[newArray.length - 1] = newField;
		this.fields = newArray;
	}
	
	/**
	 * Returns the column number of the BattleBot at the specified index
	 * @param botIndex	The index of the BattleBot
	 * @return	The BattleBot at the specified index's column
	 */
	public int getBotColumn(int botIndex) {
		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
			return bots[botIndex].getColumn();
		}
		return 0;
	}
	
	/**
	 * Returns the column speed of the BattleBot at the specified index
	 * @param botIndex	The index of the BattleBot
	 * @return	The BattleBot at the specified index's column speed
	 */
	public int getBotColumnSpeed(int botIndex) {
		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
			return bots[botIndex].getColumnSpeed();
		}
		return 0;
	}
	
	/**
	 * Returns the row number of the BattleBot at the specified index
	 * @param botIndex	The index of the BattleBot
	 * @return	The BattleBot at the specified index's row
	 */
	public int getBotRow(int botIndex) {
		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
			return bots[botIndex].getRow();
		}
		return 0;
	}
	
	/**
	 * Returns the row speed of the BattleBot at the specified index
	 * @param botIndex	The index of the BattleBot
	 * @return	The BattleBot at the specified index's row speed
	 */
	public int getBotRowSpeed(int botIndex) {
		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
			return bots[botIndex].getRowSpeed();
		}
		return 0;
	}
	
	/**
	 * Returns the number of Bots
	 * @return
	 */
	public int getNumberOfBots() {
		return this.bots.length;
	}
	
	/**
	 * Returns a random int in the specified range
	 * @param range  The range of numbers
	 */
	private int getRandomLocation(int range) {
		return rand.nextInt(range);
	}

	/**
	 * Updates the location of each BattleBot on the field by calling the move
	 * method of each Bot.
	 */
	public void moveBots(int timeUnits) {
		for (int i = 0; i < bots.length; i++) {
			bots[i].move(timeUnits);
		}
	}
	
	/**
	 * Calls the clearField() method for both the fields
	 */
	private void clearFields() {
		for (Field f : fields) {
			f.clearField();
		}
	}

	/**
	 * Places all the Robots on both fields
	 */
	public void placeBots() {
		for (Robot b : bots) {
			for (Field f : fields) {
				f.placeBot(b.getColumn(), b.getRow());
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
		for (Field f : fields) {
			f.printField();
		}
		//this.botFieldPanel.updateFieldPanel(); // Dont need to update anymore since it does it automatically
		//System.out.println(this.botField);
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
