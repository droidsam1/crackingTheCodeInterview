/*
Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabccccca would become a2b1c5a1.
If the "compressed" string would not become smaller than the original string,
your method should return the original string. You can assume the string has only uppercase and lowercase letters (a-z)
 */

//Could we assume too, that letters would only be the English alphabet letters?
public class StringCompression {

    private StringBuilder compressed;

    public String compress(String input) {

        if (noEnoughCharsToCompress(input)) {
            return input;
        }
        this.compressed = new StringBuilder();
        int letterCounter = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            letterCounter++;
            if(i == input.length() - 1 ||  c != input.charAt(i +1)){
                this.compressed.append(c);
                this.compressed.append(letterCounter);
                letterCounter = 0;
            }
        }

        return returnSmallerString(input, compressed.toString());
    }

    private boolean noEnoughCharsToCompress(String input) {
        return input.length() < 3;
    }

    private String returnSmallerString(String input, String compressedString) {
        if (compressedString.length() < input.length()) {
            return compressedString;
        }
        return input;
    }
}
