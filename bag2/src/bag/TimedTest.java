package bag;
/*
 * Tests the Bag class
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author anwar mamat
 */

public class TimedTest {
    
    public static void main(String[] args){

	
	//Test the bag with different input size
	int[] sampleSize = {10,1000};
	/*
	To test the bag with large input, generate followng data sets using the Number2 class.
   	int[] sampleSize = {10000,100000,1000000,2000000,5000000,10000000};
	*/
	
	System.out.println("n\t\t time (secs)"); 
        for(int n :sampleSize){
        	String fileName = "src/data/"+Integer.toString(n)+".txt";
        	Bag<Integer> bag = new Bag();
        	Numbers2 num = new Numbers2();
        	try {
        		num.read(bag, fileName);
        	} catch (IOException ex) {
        		System.err.println(ex.getMessage());
        	}
        	
        	 System.out.print(bag.size());
        	long tStart = System.currentTimeMillis();
        	//for(int j = 0; j < 10; ++j){
            	for(int i = 0; i < 1000; ++i){
            		int t = (int)(Math.random()* n);
            		//System.out.println(n);
            		bag.contains(t);
            	}
            	//}
            	long tEnd = System.currentTimeMillis();
            	long tDelta = tEnd - tStart;
            	double elapsedSeconds = tDelta / 1000.0;
            	System.out.println("\t\t"+ elapsedSeconds);
	   
        }
    }
            
}
