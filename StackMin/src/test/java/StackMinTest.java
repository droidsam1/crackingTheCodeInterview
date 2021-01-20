import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMinTest {

    @Test
    void push() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(18);
        assertEquals(3,stack.size());
    }

    @Test
    void pop() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(18);

        assertEquals(18,stack.pop());
        assertEquals(9,stack.pop());
        assertEquals(10,stack.pop());
    }

    @Test
    void min() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(18);

        assertEquals(9,stack.min());
    }

    @Test
    void min_should_return_min_after_call_pop() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(18);

        assertEquals(9,stack.min());
        stack.pop();
        assertEquals(9,stack.min());
    }


    @Test
    void min_should_keep_returning_min_after_several_calls_to_pop() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        stack.push(18);

        assertEquals(1,stack.min());
        stack.pop();
        assertEquals(1,stack.min());
        stack.pop();
        assertEquals(1,stack.min());
        stack.pop();
        assertEquals(9,stack.min());
        stack.pop();
        assertEquals(10,stack.min());
    }

    @Test
    void min_should_keep_returning_min_after_several_mixing_calls_to_pop_and_push() {
        StackMin stack = new StackMin();
        stack.push(10);
        stack.push(9);
        stack.push(1);
        stack.push(6);
        stack.push(18);

        assertEquals(1,stack.min());
        stack.push(0);
        assertEquals(0,stack.min());
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(1,stack.min());
        stack.pop();
        assertEquals(9,stack.min());
        stack.pop();
        assertEquals(10,stack.min());
    }

    @Test()
    void min_should_return_exception_on_pop_on_empty_stack() {
        StackMin stack = new StackMin();
        Assertions.assertThrows(java.util.EmptyStackException.class, stack::pop);
    }


    @Test()
    void min_should_return_exception_on_min_on_empty_stack() {
        StackMin stack = new StackMin();
        Assertions.assertThrows(java.util.EmptyStackException.class, stack::min);
    }

}