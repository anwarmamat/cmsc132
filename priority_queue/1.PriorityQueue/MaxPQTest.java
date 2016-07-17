/*
 * Binary Heap implementation of the Priority Queue
 */

import java.util.Comparator;
public class MaxPQTest {
    
    private MaxPQ<String> pq;
    public static void main(String[] args)
    {    
        PriorityQueue<String> q = new MaxPQ<>();
        
        String inp;
        inp = InputHelper.getStringInput("Enter next value:");
        while (!inp.equals("done")){
            String inputs[] = inp.split(" ");
            try{
                if(inputs[0].toLowerCase().equals("i")){
                    q.insert(inputs[1].toLowerCase());
                }else if(inputs[0].toLowerCase().equals("r")){
                    q.remove();
                    System.out.println("Top element is removed");
                }else if(inputs[0].toLowerCase().equals("t")){
                    System.out.println("Top element:"+ q.top());
                }
            }catch(EmptyQueueException ex){
                System.out.println(ex);
            }catch(ArrayIndexOutOfBoundsException ex)
            {
                System.out.println(ex);
            }
            inp = InputHelper.getStringInput("Enter next value:");
        }
        
    }   //end of main
}
