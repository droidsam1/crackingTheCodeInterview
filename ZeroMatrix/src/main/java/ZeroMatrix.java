import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ZeroMatrix {
    /*
        Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
     */
    public static void makeColAndRowZeroIfElementIsZero(int[][] inputMatrix) {
        assert (inputMatrix.length != inputMatrix[0].length);

        boolean[] colsWithZeros = new boolean[inputMatrix[0].length];
        boolean[] rowsWithZeros = new boolean[inputMatrix.length];

        for (int row = 0; row < inputMatrix.length; row++) {
            for (int col = 0; col < inputMatrix[row].length; col++) {
                if (inputMatrix[row][col] == 0) {
                    colsWithZeros[col] = true;
                    rowsWithZeros[row] = true;
                }
            }
        }
        for (int i = 0; i < colsWithZeros.length; i++) {
            if(colsWithZeros[i]){
                replaceColumnWithZeros(inputMatrix, i);
            }
        }
        for (int i = 0; i < rowsWithZeros.length; i++) {
            if(rowsWithZeros[i]){
                replaceRowWithZeros(inputMatrix, i);
            }
        }
    }

    private static void replaceColumnWithZeros(int[][] inputMatrix, int col){
        //replace column
        for (int i = 0; i < inputMatrix.length; i++) {
            inputMatrix[i][col] = 0;
        }
    }

    private static void replaceRowWithZeros(int[][] inputMatrix, int row){
        //replace column
        for (int i = 0; i < inputMatrix[row].length; i++) {
            inputMatrix[row][i] = 0;
        }
    }

}
