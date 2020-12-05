import java.util.Arrays;

public class CheckPermutation {

    //Given two strings, write a method to decide if one is permutation of the other

    //Should ask if the comparison should be case sensitive or if whitespace is significant.
    // Here I assuming both are significant
    public static boolean isPermutation(String oneInput, String anotherInput) {

        if (oneInput.length() != anotherInput.length()) {
            return false;
        }

        char[] oneInputCharArray = oneInput.toCharArray();
        char[] anotherInputCharArray = anotherInput.toCharArray();

        Arrays.sort(oneInputCharArray);
        Arrays.sort(anotherInputCharArray);

        return new String(oneInputCharArray).equals(new String(anotherInputCharArray));
    }


}
