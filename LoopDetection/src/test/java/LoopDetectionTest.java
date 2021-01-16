import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopDetectionTest {


    private static LinkedListNode generateExampleLoopLinkedList() {
        LinkedListNode head = new LinkedListNode('A');
        head.appendToTail(new LinkedListNode('B'));

        LinkedListNode corruptNode = new LinkedListNode('C');
        corruptNode.appendToTail(new LinkedListNode('D'));
        corruptNode.appendToTail(new LinkedListNode('E'));
        corruptNode.appendToTail(corruptNode);

        head.appendToTail(corruptNode);
        return head;
    }

    private static LinkedListNode generateExampleLinkedListWithNoLoops() {
        LinkedListNode head = new LinkedListNode('A');
        head.appendToTail(new LinkedListNode('B'));
        head.appendToTail(new LinkedListNode('C'));
        head.appendToTail(new LinkedListNode('D'));
        head.appendToTail(new LinkedListNode('E'));
        head.appendToTail(new LinkedListNode('C'));
        return head;
    }

    @Test
    void should_return_C_for_given_example() {
        LinkedListNode corruptNode  = LoopDetection.getCorruptedNode(generateExampleLoopLinkedList());
        assertNotNull(corruptNode);
        assertEquals('C',corruptNode.data);
        assertEquals('D',corruptNode.next.data);
    }

    @Test
    void should_return_null_for_non_looping_linked_list() {
        LinkedListNode corruptNode  = LoopDetection.getCorruptedNode(generateExampleLinkedListWithNoLoops());
        assertNull(corruptNode);
    }


    @Test
    void should_return_C_for_given_example_with_floyds() {
        LinkedListNode corruptNode  = LoopDetection.getCorruptedNodeWithFloydsAlgorithm(generateExampleLoopLinkedList());
        assertNotNull(corruptNode);
        assertEquals('C',corruptNode.data);
        assertEquals('D',corruptNode.next.data);
    }

    @Test
    void should_return_null_for_non_looping_linked_list_with_floyds() {
        LinkedListNode corruptNode  = LoopDetection.getCorruptedNodeWithFloydsAlgorithm(generateExampleLinkedListWithNoLoops());
        assertNull(corruptNode);
    }
}