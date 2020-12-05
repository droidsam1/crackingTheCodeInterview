import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class URLifyTest {

    @Test
    void should_urlify_example() {
        String exampleInput = "Mr John Smith    ";
        String expected = "Mr%20John%20Smith";

        char [] urlyfied = exampleInput.toCharArray();
        URLify.execute(urlyfied,13);
        Assertions.assertEquals(expected,new String(urlyfied));
    }

    @Test
    void should_not_urlify_if_is_not_needed() {
        String expected = "Mr%20John%20Smith";

        char [] urlyfied = expected.toCharArray();
        URLify.execute(urlyfied,expected.length());
        Assertions.assertEquals(expected,new String(urlyfied));
    }


    @Test
    void should_urlify_example_with_lot_of_spaces() {
        String exampleInput = "Mr         h                  ";
        String expected = "Mr%20%20%20%20%20%20%20%20%20h";

        char [] urlyfied = exampleInput.toCharArray();
        URLify.execute(urlyfied,12);
        Assertions.assertEquals(expected,new String(urlyfied));
    }


    @Test
    void should_urlify_example_with_more_spaces_at_end_that_needed() {
        String exampleInput = "Mr John Smith              ";
        String expected = "Mr%20John%20Smith";

        char [] urlyfied = exampleInput.toCharArray();
        URLify.execute(urlyfied,13);
        Assertions.assertEquals(expected,new String(urlyfied).trim());
    }

}