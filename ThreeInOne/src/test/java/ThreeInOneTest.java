import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeInOneTest {

    @Test
    void test_call_to_new_should_create_empty_stacks() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(10);
        assertTrue(threeInOne.isEmpty(0));
        assertTrue(threeInOne.isEmpty(1));
        assertTrue(threeInOne.isEmpty(2));
    }

    @Test
    void test_push_fulfilling_stacks_of_size_1() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(1);
        threeInOne.push(0, 0);
        threeInOne.push(1, 1);
        threeInOne.push(2, 2);
        assertEquals(0, threeInOne.pop(0));
        assertEquals(1, threeInOne.pop(1));
        assertEquals(2, threeInOne.pop(2));
    }

    @Test
    void test_push_should_throw_exception_if_a_out_of_bounds_stack_is_used() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(1);
        Assertions.assertThrows(ThreeInOne.StackNumberOutOfBoundsException.class, () -> {
            threeInOne.push(1, 3);
        });
        Assertions.assertThrows(ThreeInOne.StackNumberOutOfBoundsException.class, () -> {
            threeInOne.push(1, -1);
        });
    }

    @Test
    void test_push_should_throw_exception_if_stack_is_full() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(1);
        threeInOne.push(0, 0);
        Assertions.assertThrows(ThreeInOne.StackIsFullException.class, () -> {
            threeInOne.push(1, 0);
        });
    }

    @Test
    void test_pop_order() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(2);
        threeInOne.push(0, 0);
        threeInOne.push(1, 0);
        threeInOne.push(2, 1);
        threeInOne.push(3, 1);
        threeInOne.push(4, 2);
        threeInOne.push(5, 2);


        assertEquals(1, threeInOne.pop(0));
        assertEquals(0, threeInOne.pop(0));
        assertEquals(3, threeInOne.pop(1));
        assertEquals(5, threeInOne.pop(2));
        assertEquals(4, threeInOne.pop(2));
    }

    @Test
    void test_pop_should_throw_exception_if_a_out_of_bounds_stack_is_used() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(1);
        Assertions.assertThrows(ThreeInOne.StackNumberOutOfBoundsException.class, () -> {
            threeInOne.pop(5);
        });
        Assertions.assertThrows(ThreeInOne.StackNumberOutOfBoundsException.class, () -> {
            threeInOne.pop(-1);
        });
    }

    @Test
    void test_pop_should_throw_exception_stack_is_empty() throws Exception {
        ThreeInOne threeInOne = new ThreeInOne(1);
        Assertions.assertThrows(ThreeInOne.StackIsEmptyException.class, () -> {
            threeInOne.pop(1);
        });
        Assertions.assertThrows(ThreeInOne.StackIsEmptyException.class, () -> {
            threeInOne.pop(0);
        });
    }


    @Test
    void peek_should_not_remove_elements() throws ThreeInOne.StackIsFullException, ThreeInOne.StackNumberOutOfBoundsException, ThreeInOne.StackIsEmptyException {
        ThreeInOne threeInOne = new ThreeInOne(2);
        threeInOne.push(0, 0);
        threeInOne.push(1, 0);
        assertEquals(1, threeInOne.peek(0));
        assertEquals(1, threeInOne.peek(0));
    }

    @Test
    void peek_should_return_always_the_top_element() throws ThreeInOne.StackIsFullException, ThreeInOne.StackNumberOutOfBoundsException, ThreeInOne.StackIsEmptyException {
        ThreeInOne threeInOne = new ThreeInOne(10);
        threeInOne.push(1, 0);
        threeInOne.push(2, 0);
        threeInOne.push(3, 0);
        threeInOne.push(4, 0);
        threeInOne.push(5, 0);
        assertEquals(5, threeInOne.peek(0));
        assertEquals(5, threeInOne.pop(0));
        assertEquals(4, threeInOne.peek(0));
    }
}