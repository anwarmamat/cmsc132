import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException{
		/*Bag<Integer> bag1 = new Bag();
		for(int i = 1; i <= 5; i++){
			bag1.insert((int)(Math.random()*10));
		}
		for(Integer i:bag1){
			System.out.print(i+",");
		}
		System.out.println("\n");
		
		
		Bag<String> bag2 = new SortedBag();
		bag2.insert("bob");
		bag2.insert("alice");
		bag2.insert("cathy");
		
		Iterator<String> it = bag2.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+",");
		}
		System.out.println("\n");
		Bag<Integer> bag5 = bag1.clone();
		bag1.insert(100);
		bag5.insert(99);
		
		for(Integer i:bag1){
			System.out.print(i+",");
		}
		System.out.println("\n");
		for(Integer i:bag5){
			System.out.print(i+",");
		}
		System.out.println("\n");
		
		*/
		
		Bag<Integer> bag10 = new Bag();
		Bag<Integer> bag11 = bag10.clone();
		bag10.insert(100);
		bag11.insert(200);
		for(Integer i:bag10){System.out.println(i);}
		for(Integer i:bag11){System.out.println(i);}
		if(bag10 == bag11){System.out.println("same");}
		else if(bag10.equals(bag11)){System.out.println("equal");}
		else {System.out.println("not equal");}
		
		
		
	}
}
