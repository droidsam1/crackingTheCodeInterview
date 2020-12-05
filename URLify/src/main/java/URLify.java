public class URLify {


    //Write a method to replace all spaces in a string with %20.
    // You may assume that the string has sufficient space at the end to hold the additional characters,
    // and that you are given "true" length off the string
    // (Note: if implementing in Java, please use a character array so that you can perform this operation in place.)

    //here I assuming that I will recive an exact spare chars to fit the entire string, if a receive more extra chars it will not work
    public static void executeInPlace(char[] inputString, int realLengthOfString) {
        int index = inputString.length - 1;
        for (int i = realLengthOfString - 1; i > 0; i--) {
            if (inputString[i] != ' ') {
                inputString[index--] = inputString[i];
            } else {
                inputString[index--] = '0';
                inputString[index--] = '2';
                inputString[index--] = '%';
            }
        }
    }

    //similar to book solution
    public static void execute(char[] inputString, int realLengthOfString) {
        int newStringLength = calculateNewStringLength(inputString, realLengthOfString);

        if(newStringLength == realLengthOfString){
            return;
        }


        // the answer in the book uses something that not applies to Java: tries to use an /0 to indicate the
        //termination of the array, while this something valid in C, is makes no sense in java
        //        if(newStringLength < inputString.length){
        //            inputString[newStringLength] = '/0';
        //        }


        int index = newStringLength - 1;
        for (int i = realLengthOfString - 1; i > 0; i--) {
            if (inputString[i] != ' ') {
                inputString[index--] = inputString[i];
            } else {
                inputString[index--] = '0';
                inputString[index--] = '2';
                inputString[index--] = '%';
            }
        }
    }

    private static int calculateNewStringLength(char[] inputString, int realLengthOfString) {

        int spaces = 0;
        for (int i = 0; i < realLengthOfString; i++) {
            if (inputString[i] == ' ') {
                spaces++;
            }
        }
        return realLengthOfString + spaces * 2;
    }
}
