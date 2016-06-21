

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private T[] items;
    private int N; // number of elements in the stack
    
    ArrayStack(){
        items = (T[])new Object[2];
        N = 0;
    }
    
    private void resize(int capacity){
        //System.out.println("Resizing...");
        T[] temp = (T[]) new Object[capacity];
        for(int i =0; i < N; i++){
            temp[i] = items[i];
        }
        items = temp;
                
    }
            
    public void push(T item){
        if(N == items.length){
            resize(2 * items.length);
        }
        items[N++] = item;
    }
    
    
    public boolean isEmpty(){
        return N == 0;
    }
    public T pop(){
        if(isEmpty()) throw new NoSuchElementException();
        T item = items[--N];
        items[N] = null;
        return item;
    }
    
    public T peek()//alias top
    {
        if(isEmpty()) throw new NoSuchElementException("Stack Underflow");
        return items[N-1];
    }
    
    

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    @Override
    public int size() {
        return N;
    }
    
    private class StackIterator implements Iterator<T>{
        private int index;
        StackIterator(){
            index = N;
        }
        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return items[--index];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    
    public static void main(String[] args) {
        Stack<Integer> as = new ArrayStack<>();
        for(int i = 1; i <= 5; i++){
            as.push(i);
        }
       while(!as.isEmpty()){
            //System.out.println(as.peek());
            //System.out.println(as.peek());
            System.out.print(as.pop());
        }
        
        /*for(Integer i: as){
            System.out.println(i);
        }*/
    }
    
}
