import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RemoveDupsTest {

    @Test
    void shouldDoNothingForNonDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        LinkedList withoutDups = RemoveDups.remove(list);
        assertEquals(list, withoutDups);
    }

    @Test
    void shouldRemoveDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Integer[]{1, 2, 2, 4, 5}));
        LinkedList withoutDups = RemoveDups.remove(list);
        assertNotEquals(list, withoutDups);
        assertEquals(withoutDups, Arrays.asList(new Integer[]{1, 2, 4, 5}));
    }

    @Test
    void shouldRemoveSeveralDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Integer[]{2, 2, 2, 2, 5}));
        LinkedList withoutDups = RemoveDups.remove(list);
        assertNotEquals(list, withoutDups);
        assertEquals(withoutDups, Arrays.asList(new Integer[]{2,5}));
    }

    @Test
    void shouldRemoveDifferentDuplicates() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Integer[]{2, 2, 2, 2, 5, 5, 6, 6}));
        LinkedList withoutDups = RemoveDups.remove(list);
        assertNotEquals(list, withoutDups);
        assertEquals(withoutDups, Arrays.asList(new Integer[]{2,5,6}));
    }

    @Test
    void shouldRemoveDifferentDuplicatesForCharacters() {
        LinkedList<Character> list = new LinkedList<>();
        list.addAll(Arrays.asList(new Character[]{'a', 'a','a', 'b', 'b', 'b','c', 'c'}));
        LinkedList withoutDups = RemoveDups.remove(list);
        assertNotEquals(list, withoutDups);
        assertEquals(withoutDups, Arrays.asList(new Character[]{'a','b','c'}));
    }
}