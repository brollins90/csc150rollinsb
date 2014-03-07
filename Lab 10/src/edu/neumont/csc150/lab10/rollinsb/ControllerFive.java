package edu.neumont.csc150.lab10.rollinsb;

import java.util.Date;

/**
 * ControllerFive:
 * a class that throws an exception if it is executed after 5:00 PM
 * 
 * @author Blake Rollins
 *
 */
public class ControllerFive {

	/**
	 * Starts the execution for ControllerFive
	 * @param args
	 */	
	public static void main(String[] args) {
		ControllerFive c = new ControllerFive();
		try {
			c.timeSensitiveCode();
		} catch (RunningAtABadTimeException e) {
			System.out.println("It is after 5:00, so you cannot run this code.");
		}
	}

	/**
	 * Throws an exception if executed after 5:00
	 * @throws RunningAtABadTimeException
	 */
	private void timeSensitiveCode() throws RunningAtABadTimeException{
		Date now = new Date();
		if (now.getHours() > 17) {
			throw new RunningAtABadTimeException();
		} else {
			System.out.println("It is before 5:00 so I can print this");
		}
	}
	
	/**
	 * A generic exception that we can throw
	 * @author Blake
	 *
	 */
	private class RunningAtABadTimeException extends Exception {
		
	}
}
