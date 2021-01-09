/*
    Implement a function to check if a linked list is a palindrome
 */

public class Palindrome {
    public static boolean isPalindrome(LinkedListNode list) {
        assert (list != null);
        LinkedListNode reverseList = reverse(list);

        while (list != null) {
            if (!list.data.equals(reverseList.data)) {
                return false;
            }
            reverseList = reverseList.next;
            list = list.next;
        }
        return true;
    }

    private static LinkedListNode reverse(LinkedListNode head) {
        assert (head != null);
        LinkedListNode currentNode = null;
        LinkedListNode reverseListHead = null;
        while (head != null) {
            if (currentNode == null) {
                currentNode = new LinkedListNode(head.data);
                reverseListHead = currentNode;
            } else {
                currentNode = reverseListHead;
                reverseListHead = new LinkedListNode(head.data);
                reverseListHead.next = currentNode;
            }
            head = head.next;
        }

        return reverseListHead;
    }

}
