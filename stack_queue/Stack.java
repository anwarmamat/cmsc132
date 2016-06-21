public interface Stack<T> extends Iterable<T> {
    void push(T t);
    T pop();// throws EmptyStackException;
    T peek() ;//throws EmptyStackException;
    boolean isEmpty();
    int size();
}