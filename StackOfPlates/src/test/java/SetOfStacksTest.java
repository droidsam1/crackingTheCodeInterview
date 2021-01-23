import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class SetOfStacksTest {

    @Test
    void push_should_add_elements() {
        SetOfStacks myStack = new SetOfStacks<Integer>(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.size());
    }


    @Test
    void pop_should_remove_elements() {
        SetOfStacks myStack = new SetOfStacks<Integer>(10);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        assertEquals(0, myStack.size());
    }

    @Test
    void pop_should_throw_exception_if_the_stack_is_empty() {
        SetOfStacks myStack = new SetOfStacks<Integer>(10);
        assertThrows(EmptyStackException.class, () -> myStack.pop());
    }

    @Test
    void peek_should_return_first_element_if_only_one_exists() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        myStack.push(1);
        assertEquals(1, myStack.peek());
    }

    @Test
    void peek_should_not_remove_elements() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        myStack.push(1);
        assertEquals(1, myStack.peek());
        assertEquals(1, myStack.peek());
    }

    @Test
    void peek_should_return_last_pushed_element() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        assertEquals(3, myStack.peek());
        myStack.pop();
        assertEquals(2, myStack.peek());
        myStack.pop();
        assertEquals(1, myStack.peek());
    }


    @Test
    void peek_should_throw_exception_if_the_stack_is_empty() {
        SetOfStacks myStack = new SetOfStacks<Integer>(10);
        assertThrows(EmptyStackException.class, () -> myStack.peek());
    }

    @Test
    void empty_should_return_true_after_creation() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        assertTrue(myStack.isEmpty());
    }

    @Test
    void empty_should_return_false_after_adding_element() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        myStack.add(1);
        assertFalse(myStack.isEmpty());
    }


    @Test
    void popAt_should_pop_at_indicated_stack_number_for_one_sized_stacks() {
        SetOfStacks myStack = new SetOfStacks<Integer>(1);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        assertEquals(1, myStack.popAt(0));
        assertEquals(2, myStack.popAt(1));
        assertEquals(3, myStack.popAt(2));
        assertEquals(4, myStack.popAt(3));

    }

    @Test
    void popAt_should_pop_at_indicated_stack_number() {
        SetOfStacks myStack = new SetOfStacks<Integer>(2);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        assertEquals(2, myStack.popAt(0));
        assertEquals(1, myStack.popAt(0));
        assertEquals(4, myStack.popAt(1));
        assertEquals(3, myStack.popAt(1));
    }

    @Test
    void popAt_should_throw_exception_if_the_index_is_out_bounds() {
        SetOfStacks myStack = new SetOfStacks<Integer>(10);
        myStack.push(1);
        assertThrows(IndexOutOfBoundsException.class, () -> myStack.popAt(9));
    }

    @Test
    void popAt_should_throw_exception_if_the_selected_stack_is_empty() {
        SetOfStacks myStack = new SetOfStacks<Integer>(2);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        assertEquals(2, myStack.popAt(0));
        assertEquals(1, myStack.popAt(0));
        assertEquals(4, myStack.popAt(1));
        assertEquals(3, myStack.popAt(1));
        assertThrows(EmptyStackException.class, () -> myStack.popAt(1));
    }
}