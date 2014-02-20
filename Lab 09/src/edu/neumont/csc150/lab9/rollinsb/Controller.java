package edu.neumont.csc150.lab9.rollinsb;

/**
 * The Controller drives the BattleBot project.  
 * Currently it creates the Container, Field and FieldPanel and starts the program
 * @author Blake
 *
 */
public class Controller {

	/**
	 * main takes 4 args to run.
	 * @param args	numberOfColumns numberofRows numberOfTimeUnits numberOfBots typeOfField
	 */
	public static void main(String[] args) {
		
//		args = new String[5];
//		args[0] = "20";  // columns
//		args[1] = "20"; // rows
//		args[2] = "0";	// time
//		args[3] = "40";	// bots
//		args[4] = "0"; // 0 = Console, 1 = GUI, 2 = Both
		
		if (args.length == 5) {
			
			// Parse the args
			int numberOfCols = Integer.parseInt(args[0]);
			int numberOfRows = Integer.parseInt(args[1]);
			int numberOfTimeUnits = Integer.parseInt(args[2]);
			int numberOfBots = Integer.parseInt(args[3]);
			int typeOfField = Integer.parseInt(args[4]);
			
			// Make a Container
			Container bbContainer = new Container(numberOfBots, numberOfCols, numberOfRows);
			
			// If we need a Console Field
			if (typeOfField == 0 || typeOfField == 2) {
				// Make a Console Field and add it to the Container
				bbContainer.addField(new Console(numberOfCols, numberOfRows));
			}
			
			// If we need a GUI Field
			if (typeOfField == 1 || typeOfField == 2) {
				bbContainer.addField(new GUI(numberOfCols, numberOfRows));
			}
			
			// Move the bots and update the Fields
			bbContainer.moveBots(numberOfTimeUnits);
			bbContainer.printFields();
						
		} else {
			System.out.println("Invalid arguments.");
		}
	}
}
