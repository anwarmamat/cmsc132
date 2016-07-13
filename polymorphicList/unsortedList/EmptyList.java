package unsortedList;
public class EmptyList<K extends Comparable<K>> implements List<K> {
	
	public EmptyList() {
		/* Nothing to do */
	}
	
	public boolean contains(K key) {
		return false;
	}

	public NonEmptyList<K> insert(K key) {
		return new NonEmptyList<K>(key, this);
	}

	public List<K> remove(K key) {
		return this;
	}

	public K max() throws ListIsEmptyException {
		throw new ListIsEmptyException();
	}
	
	public String toString() {
		return "";
	}
}