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
		String[] args;
		
		args = new String[4];
		args[0] = "1";
		args[1] = "1";
		args[2] = "1";
		args[3] = "1";
		System.out.println("Test 1: " + assertControllerTwo(args, 4));
		
		args = new String[4];
		args[0] = "1";
		args[1] = "5";
		args[2] = "1";
		args[3] = "1";
		System.out.println("Test 2: " + assertControllerTwo(args, 8));
		
		System.out.println("");
	}
	
	private boolean assertControllerTwo(String[] args, int expectedResult) {
		ControllerTwo two = new ControllerTwo();
		return (expectedResult == two.run(args));
	}

	private void testController3() {
		System.out.println("Testing ControllerThree:");
		String[] args;
		
		args = new String[4];
		args[0] = "c:\\test\\in1.txt";
		args[1] = "c:\\test\\c3test1.txt";
		System.out.println("Test 1: " + assertControllerThree(args, 26));
		
		args = new String[4];
		args[0] = "c:\\test\\in2.txt";
		args[1] = "c:\\test\\c3test2.txt";
		System.out.println("Test 2: " + assertControllerThree(args, 0));
		
		System.out.println("");
	}
	
	private boolean assertControllerThree(String[] args, int expectedResult) {
		ControllerThree three = new ControllerThree();
		return (expectedResult == three.readAndSumFile(args[0], args[1]));
	}

	private void testController4() {
		System.out.println("Testing ControllerFour:");
		String[] args;
		
		args = new String[4];
		args[0] = "c:\\test\\in1.txt";
		args[1] = "c:\\test\\c4test1.txt";
		System.out.println("Test 1: " + assertControllerFour(args, 26));
		
		args = new String[4];
		args[0] = "c:\\test\\in2.txt";
		args[1] = "c:\\test\\c4test2.txt";
		System.out.println("Test 2: " + assertControllerFour(args, 0));
		
		System.out.println("");
	}
	
	private boolean assertControllerFour(String[] args, int expectedResult) {
		ControllerFour four = new ControllerFour();
		try {
			return (expectedResult == four.readAndSumFile(args[0], args[1]));
		} catch (Exception e) {
			if (expectedResult == 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	private void testController5() {
		System.out.println("Testing ControllerFive:");
	}
	
//	private boolean assertControllerFive(String[] args, int expectedResult) {
//		ControllerFive five = new ControllerFive();
//		return (expectedResult == five.run(args));
//	}

}
