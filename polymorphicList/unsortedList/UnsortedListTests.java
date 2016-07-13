package unsortedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnsortedListTests {
	
	@Test
	public void testIntegerInsert() {
		List<Integer> lst = new EmptyList();
		
		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);  /* lst must be assigned the result of lst.insert */
		
		assertTrue(lst.contains(30));
		assertFalse(lst.contains(100));
		System.out.println(lst);
		assertTrue(lst.toString().equals("60|30|10|20|50|40|"));
	}

	@Test
	public void testIntegerRemove() {
		List<Integer> lst = new EmptyList();
		
		for (Integer v : new int[]{60, 30, 10, 20, 50, 40})
			lst = lst.insert(v);
			
		lst = lst.remove(30);
		lst = lst.remove(10);
		System.out.println("After removing 30 and 10: " + lst);
		
		assertTrue(lst.toString().equals("60|20|50|40|"));
	}

	@Test
	public void testMax() {
		List<Integer> lst = new EmptyList();
		
		for (Integer v : new int[]{40, 30, 70, 1000, 50, 80})
			lst = lst.insert(v);
		
		try {
			Integer value = lst.max();
			System.out.println("Max value is: " + value);
		} catch (ListIsEmptyException e) {
			System.out.println("List has not maximum as it is empty.");
		}
	}
}
