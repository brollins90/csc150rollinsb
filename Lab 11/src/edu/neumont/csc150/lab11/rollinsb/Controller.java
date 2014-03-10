package edu.neumont.csc150.lab11.rollinsb;

import java.io.File;

/**
 * This Lab is to demonstrate recursion.  The program will list all the files and directories and their sizes on a computer
 * @author Blake
 *
 */
public class Controller {
	
	private int deepest = 0;
	private String deepestPath = "";
	
	/**
	 * Run the code.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controller c = new Controller();
		c.checkDirectorySize(new File("C:\\test"));
		c.checkDirectorySize(new File("C:\\test"), 0, 1);
		/*
		 * The deepest file that I have on my pc is at a depth of 26
		 //* C:\_\_\ users\blake\AppData\Local\Google\Chrome\User Data\Default\Pepper Data\Shockwave Flash\WritableRoot\#SharedObjects\GBQSZ6JS\cdnbakmi.kaltura.com\p\1289861\sp\128986100\flash\kdp3\v3.8.9\kdp3.swf\Kaltura.sol
		 */
		c.checkDirectorySize(new File("C:\\"), 0, 5);
		
	}
	
	/**
	 * This method will take in a File object and tell print out all the files and directory sizes of every object beneath it
	 * @param currentFileOrDir	The File or Directory to start with
	 * @return	The number of bytes in the file or directory
	 */
	private long checkDirectorySize(File currentFileOrDir) {
		try {
			long fileSize = 0;
			if (currentFileOrDir.isDirectory()) {
				// find all sub items
				File[] subFiles = currentFileOrDir.listFiles();
				for (File f : subFiles) {
					fileSize += this.checkDirectorySize(new File(f.getAbsolutePath()));
				}
				System.out.println("Directory: " + currentFileOrDir.getAbsolutePath() + ", bytes: " + fileSize);
				return fileSize;
			} else {
				// is a file
				fileSize = currentFileOrDir.length();
				System.out.println("File: " + currentFileOrDir.getAbsolutePath() + ", bytes: " + fileSize);
				return fileSize;
			}
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	/**
	 * This method will take in a File object and tell print out all the files and directory sizes of every object beneath it
	 * and will also track the depth and optionally take a parameter in gigabytes of the smallest size to print
	 * @param currentFileOrDir	The File or Directory to start with
	 * @param depth	The depth of the recursion for this file
	 * @param	smallestSizeToPrint	An int in gigabytes of the smallest file or directory to print
	 * @return	The number of bytes in the file or directory
	 */
	private long checkDirectorySize(File currentFileOrDir, int depth, long smallestSizeToPrint) {
		
		if (depth > deepest) {
			deepest = depth;
			deepestPath = currentFileOrDir.getAbsolutePath();
		}
		
		try {
			if (depth != 0) {
				long fileSize = 0;
				if (currentFileOrDir.isDirectory()) {
					// find all sub items
					File[] subFiles = currentFileOrDir.listFiles();
					for (File f : subFiles) {
						fileSize += this.checkDirectorySize(new File(f.getAbsolutePath()), depth + 1, smallestSizeToPrint);
					}
					if (fileSize > smallestSizeToPrint) {
						System.out.println("Directory: " + currentFileOrDir.getAbsolutePath() + ", " + humanReadableByteCount(fileSize, false));
					}
					return fileSize;
				} else {
					// is a file
					fileSize = currentFileOrDir.length();
					if (fileSize > smallestSizeToPrint) {
						System.out.println("File: " + currentFileOrDir.getAbsolutePath() + ", " + humanReadableByteCount(fileSize, false));
					}
					return fileSize;
				}
			} else {
				smallestSizeToPrint = smallestSizeToPrint * 1024 * 1024 * 1024;
				System.out.println("running...");
				System.out.println("Only printing files larger than: " + humanReadableByteCount(smallestSizeToPrint, false));
				long total = this.checkDirectorySize(currentFileOrDir, depth + 1, smallestSizeToPrint);
				System.out.println("complete");
				System.out.println("The deepest path was: " + deepestPath + " at a depth of " + deepest);
				System.out.println("");
				return total;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * This Method I found online cause I got stuck trying to figure out the bit-shifting myself and changing the output to a human readable format was not part of the lab
	 * The code takes in a long of the number of bytes and a boolean that tells us if we should divide by 1000 or 1024 and returns a human readable string
	 * @param bytes	The number of bytes
	 * @param si	If we should divide my 1000 or 1024
	 * @return		I human readable byte string
	 */
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
