
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedStack<T> implements Stack<T> {
    private int N;
    private Node first;

    @Override
    public Iterator<T> iterator() {
        //TO DO
        return null;
    }
    
    private class Node{
        private T data;
        private Node next;
        Node(T item){
            data = item;
            next = null;
        }
    }
    LinkedStack(){
        first = null;
        N = 0;
    }
    
    public void push(T item){
        //first.next = item;
        Node t = new Node(item);
        Node old = first;
        first = t;
        first.next = old;
        N++;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T item = first.data;
        first = first.next;
        N--;
        return item;
    }
    public int size(){
        return N;
    }
    
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return first.data;
    }
    
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for(int i = 1; i <= 7; i++){
            ls.push(i);
        }
        System.out.println("size:" + ls.size());
        //System.out.print("\n");
        while(!ls.isEmpty()){
            System.out.print(ls.peek()+",");
            System.out.print(ls.pop()+",");
        }
    }
}
