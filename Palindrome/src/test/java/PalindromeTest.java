import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    private static LinkedListNode generateIntegerPalindromeExample() {
        LinkedListNode head = new LinkedListNode(7);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(7));
        return head;
    }

    private static LinkedListNode generateLargeStringPalindromeExample() {
        LinkedListNode head = new LinkedListNode('d');
        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('b'));
        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('l'));
        head.appendToTail(new LinkedListNode('e'));

        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('r'));
        head.appendToTail(new LinkedListNode('r'));
        head.appendToTail(new LinkedListNode('o'));
        head.appendToTail(new LinkedListNode('z'));

        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('l'));
        head.appendToTail(new LinkedListNode('a'));

        head.appendToTail(new LinkedListNode('z'));
        head.appendToTail(new LinkedListNode('o'));
        head.appendToTail(new LinkedListNode('r'));
        head.appendToTail(new LinkedListNode('r'));
        head.appendToTail(new LinkedListNode('a'));

        head.appendToTail(new LinkedListNode('e'));
        head.appendToTail(new LinkedListNode('l'));
        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('b'));
        head.appendToTail(new LinkedListNode('a'));
        head.appendToTail(new LinkedListNode('d'));

        return head;
    }

    private static LinkedListNode generateANotPalindromeExample() {
        LinkedListNode head = new LinkedListNode(7);
        head.appendToTail(new LinkedListNode(1));
        head.appendToTail(new LinkedListNode(1));
        return head;
    }


    @Test
    void shouldReturnTrueForAStringPalindrome() {
        assertTrue(Palindrome.isPalindrome(generateLargeStringPalindromeExample()));
    }

    @Test
    void shouldReturnTrueForAIntegerPalindrome() {
        assertTrue(Palindrome.isPalindrome(generateIntegerPalindromeExample()));
    }

    @Test
    void shouldReturnFalseForAPalindrome() {
        assertFalse(Palindrome.isPalindrome(generateANotPalindromeExample()));
    }
}