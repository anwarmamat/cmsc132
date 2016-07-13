package unsortedList;
public interface List<K extends Comparable<K>> {
	public boolean contains(K key);
	public NonEmptyList<K> insert(K key);
	public List<K> remove(K key);
	public K max() throws ListIsEmptyException;
}
