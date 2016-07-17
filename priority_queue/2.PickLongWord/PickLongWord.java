
import java.util.Scanner;

public class PickLongWord {
    
    
    
    public static void main(String[] args) {
    
        int N = 1000;
        if(args.length < 2){
        	System.out.println("Usage: java PickLongWord 1 y < wordlist.txt");
        	return;
        }
        if(args[0] != null){
        	N = Integer.parseInt(args[0]);
        }
        
        //alphabetic order
        MinPQ<String> pq = new MinPQ<>();
        
        //word length order
        //MinPQ<String> pq = new MinPQ<>(new StringLengthComparator());
        
        Scanner scan= new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        long tStart = System.currentTimeMillis();
        while(scan.hasNext()){
            String word = scan.nextLine();
                
        //for(int i=0; i < words.length; i++){
        //    String word=words[i];
            pq.insert(word);
            if(pq.size()> N){
                pq.remove();
            }
        }
        long tEnd = System.currentTimeMillis();
        
        if(args[1].equals("y")){
        	while(!pq.empty())
        	{	
            	System.out.println(pq.top() +"\t\t" + pq.top().length());
            	pq.remove();
        	}
        }
        long tDelta = tEnd - tStart;
		double elapsedSeconds = tDelta / 1000.0;
		System.out.println("Elapsed time: " + elapsedSeconds + " seconds");
    }
}
