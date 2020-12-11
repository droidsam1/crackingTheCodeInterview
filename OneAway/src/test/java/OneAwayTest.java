import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OneAwayTest {

    @Test
    void should_return_true_for_same_word() {
        Assertions.assertTrue(OneAway.isOneOrZeroEditAway("pale","pale"));
    }

    @Test
    void should_return_true_for_one_common_word() {
        Assertions.assertTrue(OneAway.isOneOrZeroEditAway("australia","oustralia"));
    }

    @Test
    void should_return_true_for_example() {
        Assertions.assertTrue(OneAway.isOneOrZeroEditAway("pale","ple"));
        Assertions.assertTrue(OneAway.isOneOrZeroEditAway("pales","pale"));
        Assertions.assertTrue(OneAway.isOneOrZeroEditAway("pale","bale"));
    }

    @Test
    void should_return_false_for_example() {
        Assertions.assertFalse(OneAway.isOneOrZeroEditAway("pale","bake"));
    }

    @Test
    void should_return_false_for_different_words() {
        Assertions.assertFalse(OneAway.isOneOrZeroEditAway("abcdf","uiopl"));
    }
}