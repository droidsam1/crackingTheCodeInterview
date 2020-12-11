import java.util.Arrays;

public class PalindromePermutation {


    //Question for interviewer, are spaces and case sensitive relevant to this problem? Are input limited to ascii characters?
    //supposing they are not, and is only ascii
    public static boolean isPermutation(String input) {

        char[] inputAsArraySorted = input.toLowerCase().trim().toCharArray();
        Arrays.sort(inputAsArraySorted);

        int[] symbolsCount = new int[256];

        for (int a : inputAsArraySorted) {
            if (a != ' ') {
                ++symbolsCount[a];
            }
        }

        int oddsCount = 0;
        for (int i : symbolsCount) {
            if (i != 0 && i % 2 != 0) {
                oddsCount++;
            }
        }
        return oddsCount <= 1;
    }
}
