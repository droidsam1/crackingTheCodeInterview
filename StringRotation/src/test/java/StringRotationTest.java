import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {

    @Test
    void shouldReturnTrueForExampleTest() {
        String oneInput = "waterbottle";
        String rotateInput = "erbottlewat";

        assertTrue(StringRotation.isStringRotation(oneInput, rotateInput));
    }

    @Test
    void shouldReturnTrueForSameInput() {
        String oneInput = "waterbottle";
        String rotateInput = "waterbottle";

        assertTrue(StringRotation.isStringRotation(oneInput, rotateInput));
    }

    @Test
    void shouldReturnFalseForDistinctInput() {
        String oneInput = "waterbottle";
        String rotateInput = "aaterbottle";

        assertFalse(StringRotation.isStringRotation(oneInput, rotateInput));
    }

    @Test
    void shouldReturnFalseForASubstringWithSameLength() {
        String oneInput = "waterbottle";
        String rotateInput = "aaabottleaa";

        assertFalse(StringRotation.isStringRotation(oneInput, rotateInput));
    }

    @Test
    void shouldReturnFalseForInputsWithDifferentLength() {
        String oneInput = "waterbottle";
        String rotateInput = "waterbottl";

        assertFalse(StringRotation.isStringRotation(oneInput, rotateInput));
    }
}