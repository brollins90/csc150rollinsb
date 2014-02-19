package edu.neumont.csc150.lab8.rollinsb;

import javax.swing.JFrame;

/**
 * The Controller drives the BattleBot project.  
 * Currently it creates the Container, Field and FieldPanel and starts the program
 * @author Blake
 *
 */
public class Controller {

	private Container container;
	
	public Controller(Container bbContainer) {
		this.container = bbContainer;
	}

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
			
			// Create a new Controller and add the Container
			Controller c = new Controller(bbContainer);
			
			// If we need a Console Field
			if (typeOfField == 0 || typeOfField == 2) {
				// Make a Console Field and add it to the Container
				Console bbField = new Console(numberOfCols, numberOfRows);
				c.container.addField(bbField);
				
				// If there is only a console field, then print it, else wait
				if (typeOfField == 0) {
					c.moveAndPrint(numberOfTimeUnits);
				}
			}
			
			// If we need a GUI Field
			if (typeOfField == 1 || typeOfField == 2) {
				// Make a Frame
				JFrame frame = new JFrame("BattleBots");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);

				// Make a FieldPanel
				GUI fPanel = new GUI(numberOfCols, numberOfRows);
				//fPanel.setContainer(bbContainer);
				frame.add(fPanel);
				
				// Add the GUI Field to the container
				c.container.addField(fPanel);
				
				// Always move because this is last.
				c.moveAndPrint(numberOfTimeUnits);
				
				// Ready the frame
				frame.pack();
				frame.setVisible(true);
			}
						
		} else {
			System.out.println("Invalid arguments.");
		}
	}
	
	private void moveAndPrint(int numberOfTimeUnits) {

		// Move Bots the number of times specified as arguments
		this.container.moveBots(numberOfTimeUnits);
		
		// Give the Field to the container to add the Bots
		this.container.printFields();
	}
}
