import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void queue_is_generic() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);

        MyQueue<String> queueOfStrings = new MyQueue<String>();
        queueOfStrings.add("aa");
        queueOfStrings.add("bb");

        MyQueue<Boolean> queueOfBoolean = new MyQueue<Boolean>();
        queueOfBoolean.add(true);
        queueOfBoolean.add(false);
    }

    @Test
    void poll_should_return_elements_in_entry_order() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1,queue.poll());
        assertEquals(2,queue.poll());
        assertEquals(3,queue.poll());
    }

    @Test
    void poll_should_throw_exception_if_empty() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);

        assertEquals(1,queue.poll());
        assertEquals(2,queue.poll());
        assertThrows(EmptyQueueException.class, ()-> queue.poll());
    }

    @Test
    void poll_should_return_elements_in_entry_order_with_mixed_operations() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1,queue.poll());
        assertEquals(2,queue.poll());

        queue.add(4);
        queue.add(5);

        assertEquals(3,queue.poll());
        assertEquals(4,queue.poll());
        assertEquals(5,queue.poll());

        queue.add(6);

        assertEquals(6,queue.poll());
    }

    @Test
    void peek_should_return_first_element() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);

        assertEquals(1,queue.peek());
    }

    @Test
    void peek_should_return_first_element_after_operations() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        assertEquals(1,queue.peek());
        queue.poll();
        queue.poll();
        assertEquals(3,queue.peek());

    }

    @Test
    void peek_should_throw_exception_if_stack_is_empty() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        assertThrows(EmptyQueueException.class, queue::peek);
    }
}