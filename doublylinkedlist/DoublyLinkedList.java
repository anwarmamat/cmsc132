
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author anwar
 */
public class DoublyLinkedList<E> implements Iterable<E>{
    private int N;  // number of nodes
    private Node head;  //sentinel before the first node
    private Node tail;  //sentinel aftet the last node;
    DoublyLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public ListIterator<E> iterator() {
        return new DoublyListIterator();
    }
    
    private class Node{
        private E data;
        private Node previous;
        private Node next;
        Node(E item){
            data = item;
            next = null;
            previous = null;
        }
        Node(){
            data = null;
            next = null;
            previous = null;
        }
    }
    public int size(){return N;}
    public boolean isEmpty(){ return N==0;}
    
    public void insert(E item){
        Node last = tail.previous;
        Node t = new Node(item);
        t.next = tail;
        t.previous = last;
        tail.previous = t;
        last.next = t;
        N++;
    }
    
    public String toString(){
        StringBuilder s  = new StringBuilder();
        Node current = head.next;
        while(current != tail){
            s.append(current.data+",");
            current = current.next;
        }
        return s.toString();
    }
    
    private class DoublyListIterator implements ListIterator<E>{
        private int index = 0;
        private Node current;
        private Node lastAccessed;
        DoublyListIterator(){
            current = head.next;
            lastAccessed = null;
            index = 0;
        }
        
        @Override
        public boolean hasNext() {
            return index < N;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
                
            }
            lastAccessed = current;
            E item = current.data;
            current = current.next;
            index++;
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public E previous() {
            if(!hasPrevious()){
                throw new NoSuchElementException();   
            }
            current = current.previous;
            lastAccessed = current;
            index--;
            return current.data;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            Node a = lastAccessed.previous;
            Node b = lastAccessed.next;
            a.next = b;
            b.previous = a;
            N--;
            index--;
            /*if(current == lastAccessed){
                current = b;
            }else{
                index--;
            }*/
                
            lastAccessed = null;
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void add(E e) {
            Node b = new Node(e);
            Node a = current.previous;
            Node c = current;
            a.next = b;
            b.next = c;
            c.previous = b;
            b.previous = a;
            index++;
            N++;
            lastAccessed = null;
        }
        
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dl = new DoublyLinkedList<>();
        ListIterator<Integer> li;
        for(int i = 2; i <= 6; i++){
            dl.insert(i);
        }
        li = dl.iterator();
        for(int i = 10; i <= 15; i++){
            li.add(i);
        }
        //print using toString()
        System.out.println(dl);
        System.out.println("\n");
        //print using foreach
        for(Integer i: dl){
            System.out.print(i+",");
        }
        System.out.println("\n");
        //print using iterator
        li = dl.iterator();
        while(li.hasNext()){
            int t = li.next(); 
            System.out.print(t+",");
        }
        //print using iterator in reverse order
        System.out.println("\n");
        while(li.hasPrevious()){
            int t = li.previous();
            //if(t == 3)
            System.out.print(t+",");
            //if(t % 2 ==0) li.remove();
        }
        System.out.println("\n");
    }
    
   
}
