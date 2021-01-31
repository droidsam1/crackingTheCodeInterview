import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SortStackTest {

    @Test
    void push_should_add_elements() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);
    }

    @Test
    void pop_should_return_exception_if_empty() {
        SortStack<Integer> sortStack = new SortStack();
        assertThrows(EmptyStackException.class, sortStack::pop);
    }

    @Test
    void pop_should_return_min_element_of_stack() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);

        assertEquals(1, sortStack.pop());
    }


    @Test
    void pop_should_return_stack_sorted_in_ascending_order() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);

        assertEquals(1, sortStack.pop());
        assertEquals(2, sortStack.pop());
        assertEquals(3, sortStack.pop());
        assertEquals(4, sortStack.pop());
    }


    @Test
    void pop_should_return_min_element_after_several_operations() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);

        assertEquals(1, sortStack.pop());
        assertEquals(2, sortStack.pop());
        assertEquals(3, sortStack.pop());


        sortStack.push(9);
        sortStack.push(2);

        assertEquals(2, sortStack.pop());
        assertEquals(4, sortStack.pop());

        sortStack.push(5);

        assertEquals(5, sortStack.pop());
        assertEquals(9, sortStack.pop());
    }


    @Test
    void peek_should_return_min_value_of_stack() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);

        assertEquals(1, sortStack.peek());
    }


    @Test
    void peek_should_return_not_remove_elements() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);


        assertEquals(3, sortStack.peek());
        assertEquals(3, sortStack.peek());
    }

    @Test
    void peek_should_return_exception_if_empty() {
        SortStack<Integer> sortStack = new SortStack();
        assertThrows(EmptyStackException.class, sortStack::peek);
    }

    @Test
    void isEmpty_should_return_true_if_stack_has_no_elements() {
        SortStack<Integer> sortStack = new SortStack();
        assertTrue(sortStack.isEmpty());
    }

    @Test
    void isEmpty_should_return_false_if_stack_has_elements() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);
        assertFalse(sortStack.isEmpty());
    }

    @Test
    void isEmpty_should_return_true_if_stack_has_pop_all_elements() {
        SortStack<Integer> sortStack = new SortStack();
        sortStack.push(4);
        sortStack.push(3);
        sortStack.push(2);
        sortStack.push(1);
        sortStack.pop();
        sortStack.pop();
        sortStack.pop();
        sortStack.pop();
        assertTrue(sortStack.isEmpty());
    }


}