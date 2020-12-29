/*
    Implement an algorithm to find the kth to last element of a singly linked list
 */
public class ReturnKthToLast {

    public static LinkedListNode getKthToLast(LinkedListNode listHead, int kth) {
        LinkedListNode element = listHead;

        int size = getSizeOfLinkedList(listHead);

        assert (kth <= size);

        for (int i = 0; i < (size - kth); i++) {
            element = element.next;
        }
        return element;
    }


    private static int getSizeOfLinkedList(LinkedListNode listHead) {
        int size = 0;
        while (listHead != null && listHead.next != null) {
            size++;
            listHead=listHead.next;
        }
        return size;
    }

}
