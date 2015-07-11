package datastructure.stack;

/**
 * Created by Francisco Yllera.
 */
public interface Stack<T> {
    public boolean isEmpty();
    public void push(T item);
    public T pop();
}