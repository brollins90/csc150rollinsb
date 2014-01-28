package edu.neumont.csc150.lab6.rollinsb;

public class BattleBotController {

	public static void main(String[] args) {
		
		args = new String[4];
		args[0] = "7";
		args[1] = "10";
		args[2] = "0";
		args[3] = "5";
		
		int numberOfCols = Integer.parseInt(args[0]);
		int numberOfRows = Integer.parseInt(args[1]);
		int numberOfTimeUnits = Integer.parseInt(args[2]);
		int numberOfBots = Integer.parseInt(args[3]);
		
		
		// Make a Field 
		BattleBotField bbField = new BattleBotField(numberOfCols, numberOfRows);

		// Make a Container
		BattleBotContainer bbContainer = new BattleBotContainer(numberOfBots, numberOfCols, numberOfRows);
		
		// Move Bots
		bbContainer.moveBots(2);
		
		// Check validity of bot locations
		for (int i = 0; i < bbContainer.getNumberOfBots(); i++) {
			int botColumn = bbContainer.getBot(i).getColumn();
			int botRow = bbContainer.getBot(i).getRow();
			boolean validLocation =bbField.isValidLocation(botColumn,botRow); 
			System.out.println(validLocation);
		}
		
		System.out.println("wait");
		
	}
}
