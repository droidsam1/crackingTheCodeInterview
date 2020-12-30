import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteMiddleNodeTest {

    private static LinkedListNode generateAlphabetLinkedList(int nLetters) {
        LinkedListNode head = new LinkedListNode('A');
        for(char c = 'B'; c <= 'Z' && c< 'A' + nLetters-1; ++c)
            head.appendToTail(new LinkedListNode(c));
        return head;
    }

    private static <T> void assertNotContainsNodeWithData(LinkedListNode list, T data){
        while(list.next != null){
            assertNotEquals(data, list.data);
            list = list.next;
        }
    }


    @Test
    void shouldDeleteNodeWithLetterCInTheExample() {
        LinkedListNode alphabetLinkedList = generateAlphabetLinkedList(6);
        while(alphabetLinkedList.next != null && !alphabetLinkedList.data.equals('C')){
            alphabetLinkedList = alphabetLinkedList.next;
        }

        DeleteMiddleNode.delete(alphabetLinkedList);
        assertNotContainsNodeWithData(alphabetLinkedList, 'C');
    }


}