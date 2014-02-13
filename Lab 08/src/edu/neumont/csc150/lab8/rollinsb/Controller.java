package edu.neumont.csc150.lab8.rollinsb;

import javax.swing.JFrame;

/**
 * The Controller drives the BattleBot project.  
 * Currently it creates the Container, Field and FieldPanel and starts the program
 * @author Blake
 *
 */
public class Controller {

	/**
	 * main takes 4 args to run.
	 * @param args	numberOfColumns numberofRows numberOfTimeUnits numberOfBots
	 */
	public static void main(String[] args) {
		
//		args = new String[4];
//		args[0] = "20";  // columns
//		args[1] = "20"; // rows
//		args[2] = "0";	// time
//		args[3] = "40";	// bots
		
		if (args.length == 4) {
			int numberOfCols = Integer.parseInt(args[0]);
			int numberOfRows = Integer.parseInt(args[1]);
			int numberOfTimeUnits = Integer.parseInt(args[2]);
			int numberOfBots = Integer.parseInt(args[3]);
			
			// Make a Frame
			JFrame frame = new JFrame("BattleBots");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
	
			// Make a Container
			Container bbContainer = new Container(numberOfBots, numberOfCols, numberOfRows);
	
			// Make a Field 
			Console bbField = new Console(numberOfCols, numberOfRows);
			
			// Make a FieldPanel
			GUI fPanel = new GUI(numberOfCols, numberOfRows);
			//fPanel.setContainer(bbContainer);
			frame.add(fPanel);
			
			// Add the Fields to the container
			bbContainer.addField(bbField);
			bbContainer.addField(fPanel);
			
			// Move Bots the number of times specified as arguments
			bbContainer.moveBots(numberOfTimeUnits);
			
			// Give the Field to the container to add the Bots
			bbContainer.printFields();
			
			// Ready the frame
			frame.pack();
			frame.setVisible(true);
		} else {
			System.out.println("Invalid arguments.");
		}
	}
}
