package edu.neumont.csc150.lab10.rollinsb;

public class Lab10tests {
	public static void main(String[] args) {
		Lab10tests l = new Lab10tests();
		l.testController1();
		l.testController2();
		l.testController3();
		l.testController4();
		l.testController5();
	}

	private void testController1() {
		System.out.println("Testing ControllerOne:");
		String[] args;
		
		args = new String[4];
		args[0] = "1";
		args[1] = "1";
		args[2] = "1";
		args[3] = "1";
		System.out.println("Test 1: " + assertControllerOne(args, true));
		
		args = new String[4];
		args[0] = "1";
		args[1] = "S";
		args[2] = "1";
		args[3] = "1";
		System.out.println("Test 2: " + assertControllerOne(args, false));
		
		args = new String[2];
		args[0] = "1";
		args[1] = "1";
		System.out.println("Test 3: " + assertControllerOne(args, false));
		
		args = new String[2];
		args[0] = "1";
		args[1] = "S";
		System.out.println("Test 4: " + assertControllerOne(args, false));
		
		System.out.println("");
	}
	
	private boolean assertControllerOne(String[] args, boolean expectedResult) {
		ControllerOne one = new ControllerOne();
		return (expectedResult == one.run(args));
	}

	private void testController2() {
		System.out.println("Testing ControllerTwo:");
	}

	private void testController3() {
		System.out.println("Testing ControllerThree:");
	}

	private void testController4() {
		System.out.println("Testing ControllerFour:");
	}

	private void testController5() {
		System.out.println("Testing ControllerFive:");
	}

}
