package unsortedList;

public class NonEmptyList<K extends Comparable<K>> implements List<K> {
	private K key;
	private List<K> rest;
	
	public NonEmptyList(K key, List<K> rest) {
		this.key = key;
		this.rest = rest;
	}

	public boolean contains(K key) {
		if (key.compareTo(this.key) == 0) {
			return true;
		}
		
		return rest.contains(key);
	}

	public NonEmptyList<K> insert(K key) {
		System.out.println("inserting at " + this.key);
		rest = rest.insert(key);
		return this;
	}

	public List<K> remove(K key) {
		if (key.compareTo(this.key) == 0) {
			return rest;
		}

		rest = rest.remove(key);
		return this;	
	}
	
	public K max() {
		try {
			K value = rest.max();
			if (key.compareTo(value) >= 0) {
				return key;
			}
			
			return value;
		} catch (ListIsEmptyException e) {
			return key;
		}
	}
	
	public String toString() {
		return key + "|" + rest;
	}
}