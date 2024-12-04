package lab3.task1;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack(){
        top = null;
        size = 0;
    }

    public void push(T data){
        size++;
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top = node;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        size--;
        top = top.getNext();
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty, cannot peek.");
        }else{
            return top.getData();
        }
    }

    public boolean isEmpty(){
        return top==null;
    }

    public int getSize(){
        return size;
    }
}
