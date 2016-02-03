package document;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/** A class for timing the EfficientDocument and BasicDocument classes
 * 
 * @author Shai Wilson
 *
 */

public class DocumentBenchmarking {

	
	public static void main(String [] args) {

	    // Run each test more than once to get bigger numbers and less noise.
	    // You can try playing around with this number.
	    int trials = 100;

	    // The text to test on
	    String textfile = "data/warAndPeace.txt";
		
	    // The amount of characters to increment each step
	    // You can play around with this
		int increment = 20000;

		double nano = 1000000000.0;
		
		// The number of steps to run.  
		// You can play around with this.
		int numSteps = 20;
		
		// THe number of characters to start with. 
		// You can play around with this.
		int start = 50000;
		
		// TODO: Fill in the rest of this method so that it runs two loops
		// and prints out timing results as described in the assignment 
		// instructions.
		for (int numToCheck = start; numToCheck < numSteps*increment + start; 
				numToCheck += increment)
		{
			// numToCheck holds the number of characters that you should read from the 
			// file to create both a BasicDocument and an EfficientDocument. 
			System.out.println("numToCheck: " + numToCheck);
			
			// Read numToCheck characters from the file into a String
			String stringFile = getStringFromFile(textfile, numToCheck);
			
			// Time a loop that runs trials times
			Long startTime = System.nanoTime();
			System.out.println("start time: " + startTime);
			System.out.print("\t");
			
			for (int trialsTime = 0; trialsTime < trials; trialsTime++){
				
				// Creates a BasicDocument 
				// Calls fleshScore on this document
				BasicDocument myBasDoc = new BasicDocument(stringFile);
				double basicFleshScore = myBasDoc.getFleschScore();
				
			}
			
			long endTime = System.nanoTime();
			System.out.print(endTime);
			System.out.print("\t");
			
			// Time it took to complete the loop
			// divide by 1 billion because it's in nano seconds
			double estTime = (endTime - startTime)/nano;
			System.out.print(estTime);
			
			// Time a loop that runs trials times on EfficientDocument
			startTime = System.nanoTime();
			System.out.println(startTime);
			System.out.print("\t");
			
			for (int trialsTime = 0; trialsTime < trials; trialsTime++){
				
				// Creates a EfficientDocument
				// Calls fleshScore on this document
				EfficientDocument myEffDoc = new EfficientDocument(stringFile);
				double effFleshScore = myEffDoc.getFleschScore();
			}
			
			endTime = System.nanoTime();
			System.out.print(endTime);
			System.out.print("\t");
			
			estTime = (endTime - startTime)/nano;
			System.out.print(estTime);
			System.out.println();
			
			
		}
	
	}
	
	/** Get a specified number of characters from a text file
	 * 
	 * @param filename The file to read from
	 * @param numChars The number of characters to read
	 * @return The text string from the file with the appropriate number of characters
	 */
	public static String getStringFromFile(String filename, int numChars) {
		
		StringBuffer s = new StringBuffer();
		try {
			FileInputStream inputFile= new FileInputStream(filename);
			InputStreamReader inputStream = new InputStreamReader(inputFile);
			BufferedReader bis = new BufferedReader(inputStream);
			int val;
			int count = 0;
			while ((val = bis.read()) != -1 && count < numChars) {
				s.append((char)val);
				count++;
			}
			if (count < numChars) {
				System.out.println("Warning: End of file reached at " + count + " characters.");
			}
			bis.close();
		}
		catch(Exception e)
		{
		  System.out.println(e);
		  System.exit(0);
		}
		
		
		return s.toString();
	}
	
}
