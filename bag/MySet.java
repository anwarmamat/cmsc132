
public class MySet<E> extends Bag<E>{
	public void insert(E item){
		if(!contains(item)){
			super.insert(item);
		}
	}
}
