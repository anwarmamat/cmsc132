
public interface PriorityQueue<T extends Comparable<T> >
{
	void insert(T t);
	void remove() throws EmptyQueueException;
	T top() throws EmptyQueueException;
	boolean empty();
}