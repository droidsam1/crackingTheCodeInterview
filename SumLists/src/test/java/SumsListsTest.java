import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumsListsTest {

    private static LinkedListNode generateExampleInputReverseLinkedListA() {
        LinkedListNode head = new LinkedListNode(7);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(6));
        return head;
    }

    private static LinkedListNode generateExampleInputReverseLinkedListB() {
        LinkedListNode head = new LinkedListNode(5);
        head.appendToTail(new LinkedListNode(9));
        head.appendToTail(new LinkedListNode(2));
        return head;
    }

    private static LinkedListNode generateExampleInputLinkedListA() {
        LinkedListNode head = new LinkedListNode(6);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(7));
        return head;
    }

    private static LinkedListNode generateExampleInputLinkedListB() {
        LinkedListNode head = new LinkedListNode(2);
        head.appendToTail(new LinkedListNode(9));
        head.appendToTail(new LinkedListNode(5));
        return head;
    }

    private static LinkedListNode generateExampleInputLinkedListC() {
        LinkedListNode head = new LinkedListNode(9);
        head.appendToTail(new LinkedListNode(9));
        return head;
    }


    private static LinkedListNode generateExampleReverseResultLinkedList() {
        LinkedListNode head = new LinkedListNode(2);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(9));
        return head;
    }

    private static LinkedListNode generateExampleResultLinkedList() {
        LinkedListNode head = new LinkedListNode(9);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(2));
        return head;
    }

    private static LinkedListNode generateResultLinkedListForInputAPlusC() {
        LinkedListNode head = new LinkedListNode(7);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(6));
        return head;
    }

    private static void assertLinkedListEquals(LinkedListNode actual, LinkedListNode expected) {
        while (actual != null) {
            assertEquals(actual.data, expected.data);
            actual = actual.next;
            expected = expected.next;
        }
    }


    @Test
    void shouldReturn219ForReverseSumAPlusB() {
        assertLinkedListEquals(generateExampleReverseResultLinkedList(), SumsLists.reverseSum(generateExampleInputReverseLinkedListA(), generateExampleInputReverseLinkedListB()));
    }

    @Test
    void shouldReturn912ForSumAPlusB() {
        assertLinkedListEquals(generateExampleResultLinkedList(), SumsLists.sum(generateExampleInputLinkedListA(), generateExampleInputLinkedListB()));
    }

    @Test
    void shouldReturn716ForSumAPlusC() {
        assertLinkedListEquals(generateResultLinkedListForInputAPlusC(), SumsLists.sum(generateExampleInputLinkedListA(), generateExampleInputLinkedListC()));
    }
}