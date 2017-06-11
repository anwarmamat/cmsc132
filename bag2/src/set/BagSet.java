package set;

import bag.Bag;

public class BagSet<E> extends Bag<E> implements Set<E>{
	@Override
	public void insert(E e){
		if(!contains(e)) 
			super.insert(e);
	}
	@Override
	public void clear() {
		capacity = 10;
		items = (E[]) new Object[capacity];
	}

	@Override
	public boolean remove(E o) {
		// TODO
		return false;
	}
	
	public static void main(String[] args) {
		Set<Integer> s = new BagSet<>();	
		s.insert(1);
		s.insert(2);
		s.insert(3);
		s.insert(2);
		s.insert(1);
		System.out.println(s);
	}

}
