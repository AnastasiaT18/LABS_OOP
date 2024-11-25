package lab3.task1;

public class ListImpl<T> implements Queue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public void enqueue(T object) {
        size++;
        Node<T> node = new Node<>(object);
        if(isEmpty()){
            head = node;
            tail = node;
            head.next = null;
        }
        else{
           tail.next = node;
           tail = node;
           node.next = null;
        }
    }

    @Override
    public void dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        size--;
        head = head.next;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }


}
