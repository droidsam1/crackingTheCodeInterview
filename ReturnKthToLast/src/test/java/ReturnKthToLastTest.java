import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnKthToLastTest {

    private static LinkedListNode getNumberedLinkedListOf(int nElements) {
        LinkedListNode head = new LinkedListNode(1);
        for (int i = 1; i <= nElements; i++) {
            head.appendToTail(new LinkedListNode(i));
        }
        return head;
    }

    @Test
    void shouldReturnSecondLast() {
        LinkedListNode linkedList = getNumberedLinkedListOf(10);
        assertEquals(8, ReturnKthToLast.getKthToLast(linkedList, 2).data);
    }


    @Test
    void shouldReturnFirst() {
        LinkedListNode linkedList = getNumberedLinkedListOf(11);
        assertEquals(1, ReturnKthToLast.getKthToLast(linkedList, 11).data);
    }

    @Test
    void shouldReturnLast() {
        LinkedListNode linkedList = getNumberedLinkedListOf(11);
        assertEquals(11, ReturnKthToLast.getKthToLast(linkedList, 0).data);
    }
}