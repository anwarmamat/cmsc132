package set;

public interface Set<E> {
	public  void insert(E e);
	public void clear();
	public boolean 	contains(E o);
	public boolean 	isEmpty();
	public boolean 	remove(E o);
	public int 	size();
}
