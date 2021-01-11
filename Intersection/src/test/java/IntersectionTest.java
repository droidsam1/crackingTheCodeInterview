import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {


    private static LinkedListNode generateInputLinkedList() {
        LinkedListNode head = new LinkedListNode(7);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(6));
        return head;
    }

    private static LinkedListNode generateAnotherLinkedList() {
        LinkedListNode head = new LinkedListNode(5);
        head.appendToTail(new LinkedListNode(9));
        head.appendToTail(new LinkedListNode(2));
        return head;
    }


    @Test
    void should_return_null_for_non_intersecting_lists() {
        assertNull(Intersection.getIntersectNode(generateInputLinkedList(), generateAnotherLinkedList()));
    }

    @Test
    void should_return_node_for_intersection_lists_when_intersection_is_at_the_end_of_both_lists() {
        LinkedListNode intersectionNode = new LinkedListNode(10);

        LinkedListNode oneList =  generateInputLinkedList();
        oneList.appendToTail(intersectionNode);
        LinkedListNode anotherList = generateAnotherLinkedList();
        anotherList.appendToTail(intersectionNode);

        assertEquals(intersectionNode, Intersection.getIntersectNode(oneList, anotherList));
    }

    @Test
    void should_return_node_for_intersection_lists_when_intersection_is_in_the_middle() {
        LinkedListNode intersectionNode = new LinkedListNode(11);

        LinkedListNode oneList =  generateInputLinkedList();
        oneList.appendToTail(intersectionNode);
        intersectionNode.appendToTail(generateAnotherLinkedList());

        assertEquals(intersectionNode, Intersection.getIntersectNode(oneList, intersectionNode));
    }


    @Test
    void should_return_node_for_intersection_lists_when_intersection() {
        LinkedListNode oneList =  generateInputLinkedList();
        LinkedListNode anotherList = generateAnotherLinkedList();
        LinkedListNode intersectionNode = oneList.next;
        anotherList.appendToTail(intersectionNode);

        assertEquals(intersectionNode, Intersection.getIntersectNode(oneList, intersectionNode));
    }

    @Test
    void should_return_null_for_non_intersection_lists_with_copies_of_same_objects() {
        LinkedListNode list =  generateInputLinkedList();
        LinkedListNode listWithSameValues = generateInputLinkedList();

        assertNull(Intersection.getIntersectNode(list, listWithSameValues));
    }
}