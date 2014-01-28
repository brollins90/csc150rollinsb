package edu.neumont.csc150.lab6.rollinsb;

import java.util.Random;

public class BattleBotContainer {

	private BattleBot[] bots;
	private Random rand;
	
	/**
	 * Creates a BattleBotContainer with the specified number of Bots
	 * @param numberOfBots
	 * @param numberOfColumns
	 * @param numberOfRows
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
	 */
	public BattleBot getBot(int botIndex) {
		// TODO: Check NullPointer
		return bots[botIndex];
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
	public void moveBots() {
		moveBots(1);

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
