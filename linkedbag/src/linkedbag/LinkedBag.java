/**
 *  The Bag class represents a collection of generic items.
 *  It supports insertion and iterating over the items in arbitrary order.
 */
package linkedbag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<E extends Comparable<E>> implements Iterable<E>
{
	protected int N;  //number of items in the bag
        private Node<E> first;    //beginning of bag
        
        // helper linked list class
        private class Node<E> {
            private E data;
            private Node<E> next;
            Node(E item){
                data = item;
            }
            Node(E item, Node r){
            	data = item;
            	next = r;
            }
        }

        /**
        * Initializes an empty bag.
        */
        public LinkedBag() {
            first = null;
            N = 0;
            
        }
	/**
        *   Returns an iterator that iterates through the items in the bag
        * @return an iterator that iterates through the items in the bag
        */
	public Iterator<E> iterator() {
            return new BagIterator(first);
        }
        /**
        *   The iterator implementation
        */
        private class BagIterator implements Iterator<E> { 
            private Node<E> current = null;
            public BagIterator(Node<E> first) {
                current = first;
            }
            public boolean hasNext()  { return current != null;}
            public void remove()      { System.out.println("to be implemented.");  }
            public E next() {
            	if(!hasNext()) {return null;}
        	E item = current.data;
                current = current.next; 
                System.out.println("work");
                return item;
            }
    
        }
        
        /**
        * Adds the item to this bag.
        * @param item the item to add to this bag
        */
        public void insert(E item) {
            first = new Node<E>(item, first);
            N++;
        }

	/**
        * Returns an item by index
        * @param index is the item index
        */
	public E get(int index)
	{
            Node<E> current = first;
            int i = 0;
            while(current != null && i < index){
                current = current.next;
                i++;
                System.out.println("work");
            }
            return current.data;
	}
        /**
        * Deletes an item
        * @param item is the item to be deleted
        * @return true if item is deleted. false otherwise
        */
	public boolean remove(E item){
		if(item == null) return false;
		if(isEmpty()) throw new NoSuchElementException();
            Node<E> current = first;
            Node<E> parent = first;
            while(current != null){
                if(current.data.equals(item)){
                	parent.next = current.next;
                    return true;
                }
                parent = current;
                current = current.next;                
            }
            return false;
	}
	/**
     * Deletes an item recursively
     * @param item is the item to be deleted
     * @return true if item is deleted. false otherwise
     */
	public boolean remove_rec(E item){
		first = remove_rec(first, item);
				return true;
	}
	
	/**
     * Deletes an item recursively
     * @param item is the item to be deleted
     * @param r is the starting node
     * @return true if item is deleted. false otherwise
     */
	
	private Node<E> remove_rec(Node<E> r, E item){
		if( r == null) return null;
		if(r.data.equals(item)){
			return r.next;
		}
		r.next = remove_rec(r.next, item);
		return r;
	}
	
	
        /**
        * Is this bag empty?
        * @return true if this bag is empty; false otherwise
        */
        public boolean isEmpty() {
            return first == null;
        }

        /**
        * Returns the number of items in this bag.
        * @return the number of items in this bag
        */
        public int size() {
            return N;
        }
	
        /**
        *   if the bag contains a given item?
        * @return true if bag contains the item. false otherwise
        */
	public boolean contains(E item)
	{
            Node<E> current = first;
            while(current != null){
                if(current.data.equals(item)) return true;
                current = current.next;
            }
            return false;
            
	}
	
	/**
        *  prints the linked list
        */
	public void print(){
		print(first);
		System.out.println("");
	}
	private void print(Node r){
		if(r == null) return; 
		System.out.print(r.data+",");
		print(r.next);
	}
        
}