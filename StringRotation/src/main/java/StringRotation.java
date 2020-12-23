/*
    Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
    ("waterbottle" is a rotation of "erbottlewat")
 */
public class StringRotation {

    public static boolean isStringRotation(String oneInput, String anotherInput) {
        if (oneInput.length() == 0 || oneInput.length() != anotherInput.length()) {
            return false;
        }
        return iSubstring(oneInput.concat(oneInput), anotherInput);
    }


    private static boolean iSubstring(String mainString, String substring) {
        return mainString.contains(substring);
    }
}
