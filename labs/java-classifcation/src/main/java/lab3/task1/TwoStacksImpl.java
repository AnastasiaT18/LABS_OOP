package lab3.task1;

public class TwoStacksImpl<T> implements Queue<T> {
    private Stack<T> inputStack;
    private Stack<T> outputStack;

    public TwoStacksImpl() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    @Override
    public void enqueue(T data) {
        inputStack.push(data);
    }

    @Override
    public void dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty, cannot dequeue.");
        }
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.peek());
                inputStack.pop();
            }
        }
        outputStack.pop();
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty, cannot peek.");
        }
        if(outputStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outputStack.push(inputStack.peek());
                inputStack.pop();
            }
        }
        return outputStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    @Override
    public int size(){
        return inputStack.getSize() + outputStack.getSize();
    }

}
