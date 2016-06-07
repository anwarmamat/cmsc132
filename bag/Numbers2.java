/*
 * This class writes integer numbers to a text file
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anwar mamat
 */

public class Numbers2{
    private int minValue = 0;
    private int maxValue = 0;
    
    Numbers2(int low, int high){
        minValue = low;
        maxValue = high;
    }
    Numbers2(){
        minValue = 0;
        maxValue = 0;
    }
    public void write(String fileName) throws IOException{
        try {
            File file = new File(fileName);
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            List<Integer> temp = new ArrayList();
            for(int i = minValue; i <=maxValue; ++i){
                temp.add(i);
            }
            //Collections.shuffle(temp);
            for(Integer i: temp){
                output.write(Integer.toString(i) + '\n');
            }
            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }        
    }
     public void read(Bag bag,String fileName) throws IOException{
        try {
            File file = new File(fileName);
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line="";
            int count = 0;
            while((line = input.readLine()) != null){                
                Integer t = Integer.parseInt(line); 
                bag.insert(t);
                count++;
                if(count % 1000000==0){
                    System.out.println(count);
                }
            }
            input.close();
        } catch ( IOException e ) {
           e.printStackTrace();
        }        
    }
    
    public static void main(String[] args){
        int size = 10000000;
        String fileName = "sorted"+Integer.toString(size)+".txt";
        Numbers2 w = new Numbers2(1,size);
        try {
            w.write(fileName);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Done. Wrote "+ size + " numbers to " + fileName);
    }
    
    
}
