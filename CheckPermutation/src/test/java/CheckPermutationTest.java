import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {

    @Test
    void should_return_false_for_distinct_strings() {
        Assertions.assertFalse(CheckPermutation.isPermutation("aa","bb"));
    }

    @Test
    void should_return_false_for_distinct_one_strings() {
        Assertions.assertFalse(CheckPermutation.isPermutation("a","b"));
    }


    @Test
    void should_return_true_for_equals_strings() {
        Assertions.assertTrue(CheckPermutation.isPermutation("aa","aa"));
    }

    @Test
    void should_return_true_for_a_permutation_strings() {
        String randomString = UUID.randomUUID().toString();
        String randomStringSorted = randomString.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
        Assertions.assertTrue(CheckPermutation.isPermutation(randomString,randomStringSorted));
    }
}