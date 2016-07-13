package unsortedList;

import static org.junit.Assert.assertTrue;

public class Main {
	public static void main(String[] args){
		List<Integer> lst = new EmptyList();
		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);  /* lst must be assigned the result of lst.insert */
		
		int i = 100;
		System.out.println(i);
	}
	
}
