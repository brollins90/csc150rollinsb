package edu.neumont.csc150.lab7.rollinsb;

import javax.swing.JFrame;

public class Controller {

	public static void main(String[] args) {
		
		args = new String[4];
		args[0] = "20";  // columns
		args[1] = "20"; // rows
		args[2] = "0";	// time
		args[3] = "40";	// bots
		
		int numberOfCols = Integer.parseInt(args[0]);
		int numberOfRows = Integer.parseInt(args[1]);
		int numberOfTimeUnits = Integer.parseInt(args[2]);
		int numberOfBots = Integer.parseInt(args[3]);
		
		// Make a Frame
		JFrame frame = new JFrame("Lab 07");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// Make a Container
		Container bbContainer = new Container(numberOfBots, numberOfCols, numberOfRows);

		// Make a Field 
		Field bbField = new Field(numberOfCols, numberOfRows);
		
		// Make a FieldPanel
		FieldPanel fPanel = new FieldPanel(numberOfCols, numberOfRows);
		fPanel.setContainer(bbContainer);
		frame.add(fPanel);
		
		// Add the Fields to the container
		bbContainer.addField(bbField);
		bbContainer.addFieldPanel(fPanel);
		
		// Move Bots the number of times specified as arguments
		bbContainer.moveBots(numberOfTimeUnits);
		
		// Give the Field to the container to add the Bots
		bbContainer.printFields();
		
		// Ready the frame
		frame.pack();
		frame.setVisible(true);
		
	}
}
