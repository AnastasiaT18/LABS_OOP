package lab3.task1;

public class ArrayImpl<T> implements Queue<T> {
    private int size;
    private int front;
    private int rear;
    private T[] array;

    public ArrayImpl(){
        setArray(0);
        this.front = 0;
        this.rear = -1;
    }

    public void setArray(int size){
        this.array = (T[]) new Object[size];
        this.size = array.length;
    }

    @Override
    public void enqueue(T object) {
       if(!isEmpty()){
           size++;
           T[] new_array = (T[]) new Object[size];
           System.arraycopy(array, 0, new_array, 0, size-1);
           setArray(size);
           System.arraycopy(new_array, 0, array, 0, size-1);
       }
       else{
           size++;
           setArray(size);
       }
        array[++rear] = object;
    }

    @Override
    public void dequeue() {
        if (front>rear){
            System.out.println("Queue is empty.");
        }
        else{
            size--;
            T[] new_array = (T[]) new Object[size];
            System.arraycopy(array,1,new_array,0,size);
            setArray(size);
            System.arraycopy(new_array, 0, array, 0, size);
            rear--;
        }
    }

    @Override
    public T peek() {
        return array[front];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
