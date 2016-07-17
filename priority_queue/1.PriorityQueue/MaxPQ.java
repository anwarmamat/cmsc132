
import java.util.ArrayList;
import java.util.Comparator;
public class MaxPQ<T extends Comparable<T>> implements PriorityQueue<T>
{
	private ArrayList<T> pqArray;
	private GraphVizWrite<T> GW;
	private int Size = 0;
    MaxPQ(){
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
            
            //demo purpose only
            GW = new GraphVizWrite<>(pqArray); 
            GW.print();
            
	}
        
    /*
	*  Remove the max/min item
    */
    @Override
	public void remove(){
            if(Size == 0){
                throw new EmptyQueueException("Queue is empty.");
            }
            pqArray.set(1, pqArray.get(Size));//pq[1]=pq[N]
            pqArray.remove(Size);
            Size--;
            sink(1);
            GW = new GraphVizWrite<>(pqArray);
            GW.print();
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
    public void swap(int i, int j){
    	T t = pqArray.get(i);
        pqArray.set(i, pqArray.get(j));
        pqArray.set(j,t);
    }
    /*
	* adjust bottom to top
    */
    private void swim(int k){
    	while(k > 1 && pqArray.get(k/2).compareTo(pqArray.get(k)) < 0){
        	swap(k/2,k);
            k = k/2;
        }
    }
    /*
    * Adjust top to bottom
    */
    private void sink(int k){
    	while(2 * k <= Size){
        	int j = 2 * k;
            if(j < Size && pqArray.get(j).compareTo(pqArray.get(j+1)) < 0){
            	j++;
            }
            if(pqArray.get(k).compareTo(pqArray.get(j)) >= 0 ){
            	break;
            }
            swap(k,j);
            k = j;
        }
    }
        
}