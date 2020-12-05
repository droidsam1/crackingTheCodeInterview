import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {


    @Test
    void should_return_true_for_string_with_only_one_char(){
        assertTrue(IsUnique.isUnique("a"));
    }


    @Test
    void should_return_false_for_string_with_repeated_char(){
        assertFalse(IsUnique.isUnique("qwertyuiopasdfghjklzxcvbnmi"));
    }


    @Test
    void should_return_false_for_string_with_repetitions(){
        String generatedString = generateRandomString();
        assertFalse(IsUnique.isUnique(generatedString + generatedString.substring(0,1)));
    }


    @Test
    void should_return_true_for_string_without_repetitions(){
        String generatedString = generateStringWithoutRepetitions();
        assertTrue(IsUnique.isUnique(generatedString));
    }


    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    private String generateStringWithoutRepetitions(){
        return Arrays.asList(generateRandomString().split(""))
                .stream()
                .distinct()
                .collect(Collectors.joining());
    }

}