package edu.neumont.csc150.lab6.rollinsb;

import java.util.Random;

public class BattleBotContainer {

	private BattleBot[] bots;
	private Random rand;
	
	/**
	 * Creates a BattleBotContainer with the specified number of BattleBots.
	 * @param numberOfBots		The number of BattleBots to create
	 * @param numberOfColumns	The number of columns on the field (to create the BattleBots in bounds)
	 * @param numberOfRows		The number of rows on the field (to create the BattleBots in bounds)
	 */
	public BattleBotContainer(int numberOfBots, int numberOfColumns, int numberOfRows) {
		
		rand = new Random();
		bots = new BattleBot[numberOfBots];
		for (int i = 0; i < numberOfBots; i++) {
			bots[i] = new BattleBot(getRandomLocation(numberOfColumns), getRandomLocation(numberOfRows));
		}
	}
	
	/**
	 * Returns the BattleBot at the specified index
	 * @param botIndex	The index of the BattleBot
	 * @return	The BattleBot at the specified index
	 */
	public BattleBot getBot(int botIndex) {
		if (botIndex >= 0 && botIndex < getNumberOfBots()) {
			return bots[botIndex];
		}
		return null;
	}
	
	/**
	 * Returns the number of BattleBots on the field
	 * @return	The number of BattleBots on the field
	 */
	public int getNumberOfBots() {
		return bots.length;
	}
	
	/**
	 * Returns a random int in the specified range
	 * @param range  The range of numbers
	 */
	public int getRandomLocation(int range) {
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
	
}
