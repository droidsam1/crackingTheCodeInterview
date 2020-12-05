import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    //Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures
//    public static boolean isUnique(String input) {
//        Set<Character> characterSet = new HashSet<>();
//        for (Character c : input.toCharArray()) {
//            characterSet.add(c);
//        }
//        return characterSet.size() == input.length();
//    }


    public static boolean isUnique(String input) {
        final int EXTENDED_ASCII = 256;

        if(input.length()> EXTENDED_ASCII){
            return false;
        }

        char[] alphabet = new char[EXTENDED_ASCII];
        for (int c : input.toCharArray()) {
            ++alphabet[c];
            if(alphabet[c] > 1){
                return false;
            }
        }
        return true;
    }

}
