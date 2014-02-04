package edu.neumont.csc150.lab7.rollinsb;

import javax.swing.JFrame;

public class Controller {

	public static void main(String[] args) {
		
		args = new String[4];
		args[0] = "20";  // columns
		args[1] = "20"; // rows
		args[2] = "0";	// time
		args[3] = "20";	// bots
		
		int numberOfCols = Integer.parseInt(args[0]);
		int numberOfRows = Integer.parseInt(args[1]);
		int numberOfTimeUnits = Integer.parseInt(args[2]);
		int numberOfBots = Integer.parseInt(args[3]);
		
		// Make a Frame
		JFrame frame = new JFrame("Push Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Make a Container
		Container bbContainer = new Container(numberOfBots, numberOfCols, numberOfRows);
		
		// Make a FieldPanel
		FieldPanel fPanel = new FieldPanel(numberOfCols, numberOfRows);
		frame.add(fPanel);

		// Make a Field 
		Field bbField = new Field(numberOfCols, numberOfRows);
		fPanel.setContainer(bbContainer);
		
		// Move Bots
		bbContainer.moveBots(numberOfTimeUnits);
		
		// Give the Field to the container to add the Bots
		bbContainer.placeBots(bbField, fPanel);
		bbContainer.printFields(bbField, fPanel);
		
		// Ready the frame
		frame.pack();
		frame.setVisible(true);
		
		// Print the Field
		fPanel.updateFieldPanel();
		System.out.println(bbField);
		
	}
}
