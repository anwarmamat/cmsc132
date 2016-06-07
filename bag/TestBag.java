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
public class TestBag {
    
    public static void main(String[] args){
        
        int sampleSize =1000;
        String fileName = "data/"+Integer.toString(sampleSize)+".txt";
        Bag<Integer> bag = new Bag();
        Numbers2 num = new Numbers2();
        try {
            num.read(bag, fileName);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("bag size=" + bag.size()); 
        //for(Integer b:bag){
        //    System.out.print(b +",");
        //}
        
        
        long tStart = System.currentTimeMillis();
        //for(int j = 0; j < 10; ++j){
            for(int i = 0; i < 1000; ++i){
                int n = (int)(Math.random()*sampleSize);
                bag.contains(n);
            }
        //}
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
	double elapsedSeconds = tDelta / 1000.0;
	System.out.println("Elapsed time: " + elapsedSeconds + " seconds");    
    }
    
    
    
            
}
