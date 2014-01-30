package edu.neumont.csc150.lab6.rollinsb;

import java.util.Random;

public class Container {

	private BattleBot[] bots;
	private Random rand;
	
	/**
	 * Creates a Container with the specified number of BattleBots.
	 * @param numberOfBots		The number of BattleBots to create
	 * @param numberOfColumns	The number of columns on the field (to create the BattleBots in bounds)
	 * @param numberOfRows		The number of rows on the field (to create the BattleBots in bounds)
	 */
	public Container(int numberOfBots, int numberOfColumns, int numberOfRows) {		
		rand = new Random();
		bots = new BattleBot[numberOfBots];
		for (int i = 0; i < numberOfBots; i++) {
			bots[i] = new BattleBot(getRandomLocation(numberOfColumns), getRandomLocation(numberOfRows));
		}
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
	 * Places all the Bots in the container on the input Field
	 * @param inField	The Field to add the Bots to
	 */
	public void placeBotsOnField(Field inField) {
		for (BattleBot b : bots) {
			inField.placeBot(b.getColumn(), b.getRow());
		}
	}
	
}
