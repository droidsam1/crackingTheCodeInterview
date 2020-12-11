public class OneAway {
    //There are three types of edits that can performed on strings:
    // insert a character, remove a character, or replace a character.
    // Given two strings , write a function to check if they are one edit (or zero edits) away

    //as always ask if spaces or case sensitive are important
    public static boolean isOneOrZeroEditAway(String oneInput, String anotherInput) {

        if (areLengthDifferencesBiggerThanOne(oneInput, anotherInput)) {
            return false;
        }
        int[] charsCount = new int[256];

        for (int a : oneInput.trim().toCharArray()) {
            ++charsCount[a];
        }
        for (int a : anotherInput.trim().toCharArray()) {
            --charsCount[a];
        }

        int differencesCount = 0;
        for (int i : charsCount) {
            if (i != 0) {
                differencesCount++;
            }
        }
        return differencesCount <= 2;

    }

    private static boolean areLengthDifferencesBiggerThanOne(String oneInput, String anotherInput) {
        return Math.abs(oneInput.trim().length() - anotherInput.trim().length()) > 1;
    }
}
