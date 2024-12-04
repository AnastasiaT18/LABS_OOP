package test;

import lab3.task1.ArrayImpl;
import lab3.task1.ListImpl;
import lab3.task1.TwoStacksImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoringTest {

    @Test
    public void testStoringList(){
        ListImpl<Integer> queue = new ListImpl<>();

        Assertions.assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assertions.assertEquals(3,queue.size());

        queue.dequeue();
        Assertions.assertEquals(2,queue.size());

        Assertions.assertEquals(20,queue.peek());
        Assertions.assertEquals(20,queue.peek());

        queue.dequeue();
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testStoringArray(){
        ArrayImpl<Integer> queue = new ArrayImpl<>();

        Assertions.assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        Assertions.assertEquals(3,queue.size());

        queue.dequeue();
        Assertions.assertEquals(2,queue.size());

        Assertions.assertEquals(20,queue.peek());
        Assertions.assertEquals(20,queue.peek());

        queue.dequeue();
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testStoringTwoStacks(){
        TwoStacksImpl<String> queue = new TwoStacksImpl<>();

        Assertions.assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue.enqueue("hey");
        queue.enqueue("there");
        queue.enqueue("Delilah");

        Assertions.assertEquals(3,queue.size());

        queue.dequeue();
        Assertions.assertEquals(2,queue.size());

        Assertions.assertEquals("there",queue.peek());
        Assertions.assertEquals("there",queue.peek());

        queue.dequeue();
        Assertions.assertEquals(1,queue.size());

        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }


}
