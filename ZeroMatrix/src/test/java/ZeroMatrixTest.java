import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroMatrixTest {

    @Test
    void makeColAndRowZeroIfElementIsZero() {
        int[][] inputMatrix = {{1,2,4,5} ,{5,6,7,8}, {9,0,1,2}};
        int[][] expectedMatrix = {{1,0,4,5} ,{5,0,7,8}, {0,0,0,0}};

        ZeroMatrix.makeColAndRowZeroIfElementIsZero(inputMatrix);

        assertArrayEquals(expectedMatrix,inputMatrix);
    }

    @Test
    void makeNoModificationsIfNotZeros() {
        int[][] inputMatrix = {{1,2,4,5} ,{5,6,7,8}, {9,1,1,2}};
        int[][] expectedMatrix = {{1,2,4,5} ,{5,6,7,8}, {9,1,1,2}};

        ZeroMatrix.makeColAndRowZeroIfElementIsZero(inputMatrix);

        assertArrayEquals(expectedMatrix,inputMatrix);
    }

    @Test
    void makeColAndRowZeroIfElementIsZeroFor4x2() {
        int[][] inputMatrix = {{0,2,4,5} ,{5,6,7,8}};
        int[][] expectedMatrix = {{0,0,0,0} ,{0,6,7,8}};

        ZeroMatrix.makeColAndRowZeroIfElementIsZero(inputMatrix);

        assertArrayEquals(expectedMatrix,inputMatrix);
    }
}