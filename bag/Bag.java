import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E>,Cloneable{
	protected E[] items;
	protected int N;//number of items in the bag
	protected int capacity = 10;
	public Bag(){
		items = (E[])new Object[capacity];
	}
	// O(1)
	public void insert(E item){
		if(N == capacity){
			resize();
		}
		items[N++] = item;
	}
	
	protected void resize(){
		capacity *= 2;
		E[] temp = (E[])new Object[capacity];
		for(int i =0; i <N; i++){
			temp[i] = items[i];
		}
		items = temp;
	}
	//O(1)
	public int size(){
		return N;
	}
	//O(1)
	public boolean isEmpty(){
		return N == 0;
	}
	//O(1)
	public E get(int index){
		if(index >= N) throw new NoSuchElementException();
		return items[index];
	}
	//O(n) ==> O(logn)
	
	public boolean contains(E i){
		for(int index=0;index < N; index++){
			if(items[index].equals(i)) return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		String str="";
		for(int i=0; i < N; i++){
			str += items[i];
			str += ",";
		}
		return str;
	}
	@Override
	public Iterator<E> iterator() {
		return new BagIterator();
	}
	
	@Override
	public Bag<E> clone() throws CloneNotSupportedException{
		Bag<E> b = (Bag<E>) super.clone();
		b.items = (E[]) new Object[capacity];
		for(int i = 0; i <N; i++){
			b.items[i] = items[i];
		}
		return b;
		//return (Bag<E>) super.clone();
	}
	

	
	private class BagIterator implements Iterator<E>{
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			
			return index < N;
		}

		@Override
		public E next() {
			return items[index++];
		}
		
	}
	
}
