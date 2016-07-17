
import java.util.ArrayList;
import java.util.Comparator;
public class MinPQ<T extends Comparable<T>> implements PriorityQueue<T>
{
	private ArrayList<T> pqArray;
	private int Size = 0;
    private Comparator<T> comparator;  // optional Comparator
    MinPQ(){
		pqArray = new ArrayList<>();
	}
    
    MinPQ(Comparator<T> comparator){
        this.comparator = comparator;
        pqArray = new ArrayList<>();
    }

	/*
	*  Add new items to the PQ
    */
    @Override
	public void insert(T t){
            //start at index 1 
            if(pqArray.isEmpty()){
                pqArray.add(t);
            }
            pqArray.add(t);
            Size++;
            swim(Size); 
	}
        
    /*
	*  Remove the max/min item
    */
    @Override
	public void remove(){
            if(Size == 0){
                throw new EmptyQueueException("Queue is empty.");
            }
            swap(1,Size);
            pqArray.remove(Size);
            Size--;
            sink(1);
	}
    public int size(){
        return Size;
    }
            
    /*
	* get the min/mx item
    */
    @Override
	public T top(){
            if(Size == 0){
                throw new EmptyQueueException("Queue is empty.");
            }
            return pqArray.get(1);
        }
	
        @Override
        public boolean empty(){
            return (Size == 0);
        }
	/*
    * swap two items of the PQ
    */
    private void swap(int i, int j){
    	T t = pqArray.get(i);
        pqArray.set(i, pqArray.get(j));
        pqArray.set(j,t);
    }
    
    boolean greater(int i, int j){
        if(comparator == null){
            return pqArray.get(i).compareTo(pqArray.get(j)) > 0;
        }
        else{
            return comparator.compare(pqArray.get(i), pqArray.get(j))>0;
        }
    }
    
    /*
	* adjust bottom to top
    */
    private void swim(int k){
    	while(k > 1 && greater(k/2,k)){
        	swap(k,k/2);
            k = k/2;
        }
    }
    /*
    * Adjust top to bottom
    */
    private void sink(int k){
    	while(2 * k <= Size){
        	int j = 2*k;
            if(j < Size && greater(j, j+1)) {
            	j++;
            }
            if(!greater(k,j)){
            	break;
            }
            swap(k,j);
            k = j;
        }
    }
        
}