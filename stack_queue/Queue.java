

public interface Queue<T> extends Iterable<T> {
    void enqueue(T t);
    T dequeue();// throws EmptyStackException;
    T peek() ;//throws EmptyStackException;
    boolean isEmpty();
    int size();
}