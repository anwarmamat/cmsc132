package sortedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedListTests {

	@Test
	public void testIntegerInsert() {
		List<Integer> lst = EmptyList.getInstance();
		
		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);  /* lst must be assigned the result of lst.insert */
		
		System.out.println(lst);
		assertTrue(lst.toString().equals("10|20|30|40|50|60|"));
	}
	
	@Test
	public void testIntegerRemoveAndMax() {
		List<Integer> lst = EmptyList.getInstance();
		
		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);  /* lst must be assigned the result of lst.insert */
		
		System.out.println(lst);
		
		lst = lst.remove(30);
		lst = lst.remove(10);
		System.out.println("After removing 30 and 10: " + lst);
		
		assertTrue(lst.toString().equals("20|40|50|60|"));

		/* Getting the maximum */
		String result = "";
		result = "For list: " + "\"" + lst + "\"\n";
		try {
			Integer max = lst.max();
			result += "Maximum value is: " + max;
		} catch(ListIsEmptyException e) { 
			result += "No maximum value as list is empty."; 
		}
		System.out.println(result);
		
		/* Clearing the list and computing the maximum */
		for (Integer v : new int[]{20, 40, 50, 60})
			lst = lst.remove(v);  /* lst must be assigned the result of lst.remove */
		
		/* Getting the maximum */
		result = "For list: " + "\"" + lst + "\"\n";
		try {
			Integer max = lst.max();
			result += "Maximum value is: " + max;
		} catch(ListIsEmptyException e) { 
			result += "No maximum value as list is empty."; 
		}
		System.out.println(result);
	}
	
	@Test
	public void testIntegerMin() {
		List<Integer> lst = EmptyList.getInstance();

		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);  /* lst must be assigned the result of lst.insert */

		/* Getting the minimum */
		String result = "";
		result = "For list: " + "\"" + lst + "\"\n";
		try {
			Integer min = lst.min();
			result += "Minimum value is: " + min;
		} catch(ListIsEmptyException e) { 
			result += "No minimum value as list is empty."; 
		}
		System.out.println(result);
		
		/* Clearing the list and computing the minimum */
		for (Integer v : new int[]{10, 20, 30, 40, 50, 60})
			lst = lst.remove(v);  /* lst must be assigned the result of lst.remove */
		
		/* Getting the minimum */
		result = "For list: " + "\"" + lst + "\"\n";
		try {
			Integer min = lst.min();
			result += "Minimum value is: " + min;
		} catch(ListIsEmptyException e) { 
			result += "No minimum value as list is empty."; 
		}
		System.out.println(result);
	}
	
	@Test
	public void testInsert() {
		List<String> lst = EmptyList.getInstance();
		
		assertFalse(lst.contains("a"));
		lst = lst.insert("a");
		System.out.println(lst);
		assertTrue(lst.contains("a"));
		assertFalse(lst.contains("b"));
		lst = lst.insert("b");
		System.out.println(lst);
		assertTrue(lst.contains("a"));
		assertTrue(lst.contains("b"));
		lst = lst.insert("c");
		System.out.println(lst);
		assertTrue(lst.contains("a"));
		assertTrue(lst.contains("b"));
		assertTrue(lst.contains("c"));
	}

	@Test
	public void testDeleteMiddle() {
		List<String> lst = EmptyList.getInstance();

		lst = lst.insert("a");
		lst = lst.insert("b");
		lst = lst.insert("c");
		lst = lst.remove("b");
		System.out.println(lst);
		assertTrue(lst.contains("a"));
		assertFalse(lst.contains("b"));
		assertTrue(lst.contains("c"));
	}

	@Test
	public void testDeleteFirst() {
		List<String> lst = EmptyList.getInstance();
		
		lst = lst.insert("a");
		lst = lst.insert("b");
		lst = lst.insert("c");
		lst = lst.remove("a");
		System.out.println(lst);
		assertFalse(lst.contains("a"));
		assertTrue(lst.contains("b"));
		assertTrue(lst.contains("c"));
	}

	@Test
	public void testDeleteLast() {
		List<String> lst = EmptyList.getInstance();
		
		lst = lst.insert("a");
		lst = lst.insert("b");
		lst = lst.insert("c");
		lst = lst.remove("c");
		System.out.println(lst);
		assertTrue(lst.contains("a"));
		assertTrue(lst.contains("b"));
		assertFalse(lst.contains("c"));
	}
}
