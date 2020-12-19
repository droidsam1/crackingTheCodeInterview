import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    @Test
    void shouldReturnCompressedExample() {

        String exampleInput = "aabccccca";
        String exampleResult = "a2b1c5a1";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }

    @Test
    void shouldReturnInputWhenOneCharInput() {

        String exampleInput = "a";
        String exampleResult = "a";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }


    @Test
    void shouldReturnInputWhenNotCompression() {

        String exampleInput = "ab";
        String exampleResult = "ab";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }

    @Test
    void shouldReturnInputWhenAllDifferentCharsInInput() {

        String exampleInput = "qwertyuiopasdfghjklzxcvbnm";
        String exampleResult = "qwertyuiopasdfghjklzxcvbnm";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }


    @Test
    void shouldReturnCompressedForSameLetterRepetitions() {

        String exampleInput = "aaaaaaaaaaaaaaaaaaaa";
        String exampleResult = "a20";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }

    @Test
    void shouldReturnCompressedForStringsWithRepetitions() {

        String exampleInput = "aaaaaaaaaaaaaaaaaaaazzzzzzzzzzaaaaaaaaaaaaaaaaaaaazzzzzzzzzz";
        String exampleResult = "a20z10a20z10";

        assertEquals(exampleResult,new StringCompression().compress(exampleInput));
    }
}