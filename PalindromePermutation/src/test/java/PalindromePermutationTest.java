import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {

    @Test
    void should_return_true_for_example() {
        String exampleString = "Tact Coa";
        assertTrue(PalindromePermutation.isPermutation(exampleString));
    }

    @Test
    void should_return_true_for_a_one_word_palindrome() {
        String exampleString = "abba";
        assertTrue(PalindromePermutation.isPermutation(exampleString));
    }

    @Test
    void should_return_true_for_common_palindrome() {
        String exampleString = "No lemon, no melon";
        assertTrue(PalindromePermutation.isPermutation(exampleString));
    }

    @Test
    void should_return_true_for_common_palindrome_permutation() {
        String exampleString = "lemon melon , no No";
        assertTrue(PalindromePermutation.isPermutation(exampleString));
    }

    @Test
    void should_return_true_for_a_one_word_palindrome_permutation() {
        String exampleString = "cbbaac";
        assertTrue(PalindromePermutation.isPermutation(exampleString));
    }

    @Test
    void should_return_false_for_a_one_word_non_palindrome() {
        String exampleString = "ab";
        assertFalse(PalindromePermutation.isPermutation(exampleString));
    }
    @Test
    void should_return_false_for_a_non_palindrome() {
        String exampleString = "how are you?";
        assertFalse(PalindromePermutation.isPermutation(exampleString));
    }
}