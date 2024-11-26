package lab3.task1;

public interface Queue<T> {

    void enqueue(T object);
    void dequeue();
    T peek();
    int size();
    boolean isEmpty();


}
