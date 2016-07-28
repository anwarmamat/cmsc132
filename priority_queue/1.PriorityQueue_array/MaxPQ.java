
public class MaxPQ<T extends Comparable<T>> implements PriorityQueue<T>
{
	private T[] pqArray;			//stores the items in the queue
	private GraphVizWrite<T> GW;	//Used to create GraphViz file from the binary heap
	private int Size = 0;	//number of items in the queue

	@SuppressWarnings("unchecked")
    MaxPQ(int capacity){
		pqArray = (T[])(new Comparable<?>[capacity]);
	}

	@SuppressWarnings("unchecked")
    MaxPQ(){
		pqArray = (T[])(new Comparable<?>[1]);
	}

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
        assert capacity > Size;
        T[] temp = (T[]) new Comparable<?>[capacity];
        for (int i = 1; i <= Size; i++) {
            temp[i] = pqArray[i];
        }
        pqArray = temp;
    }

	/*
	*  Add new items to the PQ
    */
    @Override
	public void insert(T t){
            if (Size >= pqArray.length - 1) resize(2 * pqArray.length);
            pqArray[++Size] = t;
            swim(Size);
            
            //demo purpose only
            GW = new GraphVizWrite<>(pqArray,Size); 
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
            pqArray[1] = pqArray[Size];
            pqArray[Size] = null;
            Size--;
            sink(1);
            GW = new GraphVizWrite<>(pqArray, Size);
            GW.print();
	}
       
    /*
	* 	get the min/mx item
    */
    @Override
	public T top(){
            if(Size == 0){
                throw new EmptyQueueException("Queue is empty.");
            }
            return pqArray[1];
        }
	
    @Override
    public boolean empty(){
            return (Size == 0);
    }
	/*
    * swap two items of the PQ
    */
    public void swap(int i, int j){
    	T t = pqArray[i];
        pqArray[i] = pqArray[j];
        pqArray[j] = t; 
    }
    /*
	* adjust bottom to top
    */
    private void swim(int k){
    	while(k > 1 && pqArray[k/2].compareTo(pqArray[k]) < 0){
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
            if(j < Size && pqArray[j].compareTo(pqArray[j+1]) < 0){
            	j++;
            }
            if(pqArray[k].compareTo(pqArray[j]) >= 0 ){
            	break;
            }
            swap(k,j);
            k = j;
        }
    }
        
}