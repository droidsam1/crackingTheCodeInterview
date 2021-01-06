import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionTest {
    //  Input: 3-> 5-> 8 -> 5 -> 10 -> 2 -> 1 [partition =5]
    private static LinkedListNode generateExampleInputLinkedList() {
        LinkedListNode head = new LinkedListNode(3);
        head.appendToTail(new LinkedListNode(5));
        head.appendToTail(new LinkedListNode(8));
        head.appendToTail(new LinkedListNode(5));
        head.appendToTail(new LinkedListNode(10));
        head.appendToTail(new LinkedListNode(2));
        head.appendToTail(new LinkedListNode(1));
        return head;
    }


    // Input: 3-> 5-> 8 -> 4 -> 10 -> 2 -> 1 [partition =4]
    private static LinkedListNode generateAnotherExampleInputLinkedList() {
        LinkedListNode head = new LinkedListNode(3);
        head.appendToTail(new LinkedListNode(5));
        head.appendToTail(new LinkedListNode(8));
        head.appendToTail(new LinkedListNode(4));
        head.appendToTail(new LinkedListNode(10));
        head.appendToTail(new LinkedListNode(2));
        head.appendToTail(new LinkedListNode(1));
        return head;
    }

    private static <T> void assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(LinkedListNode<Integer> actual, Integer partition) {
        boolean reachedMiddle = false;
        while (actual != null) {
            if(actual.data == partition){
                reachedMiddle = true;
            }
            if(reachedMiddle){
                Assertions.assertTrue(partition <= actual.data);
            }else{
                Assertions.assertTrue(partition > actual.data);
            }
            actual = actual.next;
        }
    }

    @Test
    void partitionExample() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateExampleInputLinkedList(), 5), 5);
    }

    @Test
    void anotherPartitionExample() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateAnotherExampleInputLinkedList(), 4), 4);
    }

    @Test
    void partitionWithMiddleValueAsLowestValueInLinkedList() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateExampleInputLinkedList(), 1), 1);
    }

    @Test
    void partitionWithMiddleValueAsHighestValueInLinkedList() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateExampleInputLinkedList(), 10), 10);
    }

    @Test
    void partitionWithPartitionValueAsHeadValue() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateExampleInputLinkedList(), 3), 3);
    }


    @Test
    void partitionWithPartitionValueNotPresentInLinkedList() {
        assertValuesLeftPartitionAreLowerAndRightValuesAreHigher(Partition.partition(generateExampleInputLinkedList(), 3), 30);
    }
}