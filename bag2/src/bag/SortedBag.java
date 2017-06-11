package bag;

public class SortedBag<E extends Comparable> extends Bag<E> {
	public SortedBag(){
		items = (E[])new Comparable[capacity];
	}
	protected void resize(){
		capacity *= 2;
		E[] temp = (E[])new Comparable[capacity];
		for(int i =0; i <N; i++){
			temp[i] = items[i];
		}
		items = temp;
	}
	
	//@Override
	public void insert2(E item){
		
		if(N == capacity){
			resize();
		}
		if(N == 0){
			items[0] = item;
			N++;
			return;
		}
		int index = N-1;
		while(items[index].compareTo(item) >0){	
			items[index+1] = items[index];
			index--;
			if(index <0) break;
		}
		items[++index] = item;
		N++;
	}	

	public boolean contains(E item){
		int m = 0;
		int s = 0;
		int t = N-1;
		while(s <= t){
			m = (t+s)/2;
			if(items[m].equals(item)) return true;
			if(items[m].compareTo(item) > 0 ){
				t = m - 1;
			}else {
				s = m+1;
			}
		}
		return false;
	}
}
