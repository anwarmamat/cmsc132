
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
        	pqArray.add(t);
            Size++;
	}
        
    /*
	*  Remove the max/min item
    */
    @Override
	public void remove(){
            if(Size == 0){
                throw new EmptyQueueException("Queue is empty.");
            }
            int index = 0;
            
            for(int i = 1; i <pqArray.size(); i++){
            	if(greater(index , i))
            		index = i;	
            }
            pqArray.remove(index);
            Size--;
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
            int index = 0;
            
            for(int i = 1; i <pqArray.size(); i++){
            	if(greater(index, i))
            		index = i;	
            }
            return pqArray.get(index);
        }
	
        @Override
        public boolean empty(){
            return (Size == 0);
        }
	
    boolean greater(int i, int j){
        if(comparator == null){
            return pqArray.get(i).compareTo(pqArray.get(j)) > 0;
        }
        else{
            return comparator.compare(pqArray.get(i), pqArray.get(j))>0;
        }
    }
        
}