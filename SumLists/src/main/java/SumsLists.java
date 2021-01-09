/*
    You have two numbers represented by linked list, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1's digit is a t the head of the list. Write a function that
    adds the two numbers and returns athe sum as a linked list.
    EXAMPLE
    Input (7-> 1 -> 6) + (5 -> 9 -> 2) That is 617 + 295
    Output 2 -> 1 -> 9 That is 912
    FOLLOW UP
    Suppose the digits are store in forward order. Repeat the above problem
    Input (6-> 1 -> 7) + (2 -> 9 -> 5) That is 617 + 295
    Output 9 -> 1 -> 2 That is 912
 */

public class SumsLists {

    public static LinkedListNode reverseSum(LinkedListNode a, LinkedListNode b) {
        assert (a != null);
        assert (b != null);

        int result = reverse(getNumber(a)) + reverse(getNumber(b));

        return convertToLinkedList(reverse(result));
    }

    public static LinkedListNode sum(LinkedListNode a, LinkedListNode b) {
        assert (a != null);
        assert (b != null);

        int result = getNumber(a) + getNumber(b);

        return convertToLinkedList(result);
    }

    private static LinkedListNode convertToLinkedList(Integer number) {
        LinkedListNode result = null;
        LinkedListNode currentDigit = null;
        for (char digit : number.toString().toCharArray()) {
            if (result == null) {
                result = new LinkedListNode(Integer.valueOf(String.valueOf(digit)));
                currentDigit = result;
            } else {
                currentDigit.next = new LinkedListNode(Integer.valueOf(String.valueOf(digit)));
                currentDigit = currentDigit.next;
            }
        }
        return result;
    }

    private static Integer reverse(Integer number) {
        StringBuilder sb = new StringBuilder();
        char[] digitsArray = number.toString().toCharArray();

        for (int i = digitsArray.length - 1; i >= 0; i--) {
            sb.append(digitsArray[i]);
        }
        return Integer.valueOf(sb.toString());
    }

    private static Integer getNumber(LinkedListNode<Integer> inputList) {
        StringBuilder sb = new StringBuilder();
        while (inputList != null) {
            sb.append(inputList.data);
            inputList = inputList.next;
        }
        return Integer.valueOf(sb.toString());
    }
}