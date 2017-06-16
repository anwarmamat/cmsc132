/*
 * test Linked List Bag
 */
package linkedbag;

import util.InputHelper;

public class LinkedBagUnitTest {
    public static void main(String[] args){
        LinkedBag<String> bag = new LinkedBag();
        
        String inp;
        inp = InputHelper.getStringInput("Enter next value:");
        while (!inp.equals("done")){
            String inputs[] = inp.split(" ");
            try{
                if(inputs[0].toLowerCase().equals("i")){
                    bag.insert(inputs[1]);
                }else if(inputs[0].toLowerCase().equals("r")){
                    bag.remove_rec(inputs[1]);
                    System.out.println("element is removed");
                }
            }catch(ArrayIndexOutOfBoundsException ex)
            {
                System.out.println(ex);
            }
            bag.print();
            inp = InputHelper.getStringInput("Enter next value:");
            
        }
        
        System.out.println("Size="+bag.size());
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
