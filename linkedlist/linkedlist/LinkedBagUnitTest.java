/*
 * test Linked List Bag
 */
package linkedlist;

import util.InputHelper;

public class LinkedBagUnitTest {
    public static void main(String[] args){
        LinkedBag<String> bag = new LinkedBag();
        System.out.println("Commands: \n Insert: i number \n Remove: r number\n Stop: done\n");
        System.out.println("To visualize, open the graph.dot file using GraphViz.\n");
        String inp;
        inp = InputHelper.getStringInput("Enter next command:");
        while (!inp.equals("done")){
            String inputs[] = inp.split(" ");
            try{
                if(inputs[0].toLowerCase().equals("i")){
                    bag.insert(inputs[1]);
                }else if(inputs[0].toLowerCase().equals("r")){
                    bag.remove(inputs[1]);
                    System.out.println("element is removed");
                }
            }catch(ArrayIndexOutOfBoundsException ex)
            {
                System.out.println(ex);
            }
            inp = InputHelper.getStringInput("Enter next command:");
        }
        //for(int i=1; i <= 3; i++){
        //    bag.insert(i);
        //}
        //System.out.println("Size="+bag.size());
        /*if(bag.contains(3)){
            System.out.println("Bag contains 3");
        }else{
            System.out.println("Not Found");
        }*/
        //print all items
        //for(Integer i:bag){
        //    System.out.print(i+",");
        //}
        /*System.out.println("\nall items");
        for(int i = 0; i < bag.size(); i++){
            System.out.print(bag.get(i)+",");
        }*/
    }
}
