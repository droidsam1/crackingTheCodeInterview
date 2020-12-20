import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {

    @Test
    void rotateInPlaceFor3x3Matrix() {
        int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rotateMatrix = {{7,4,1},{8,5,2},{9,6,3}};
        RotateMatrix.rotateInPlace(inputMatrix);
        assertArrayEquals(rotateMatrix,inputMatrix);

    }

    @Test
    void rotateInPlaceFor4x4Matrix() {
        int[][] inputMatrix = {{'q','w','e','r'},{'a','s','d','f'}, {'z','x','c','v'}, {'u','i','o','p'}};
        int[][] rotateMatrix = {{'u','z','a','q'},{'i','x','s','w'}, {'o','c','d','e'}, {'p','v','f','r'}};
        RotateMatrix.rotateInPlace(inputMatrix);
        assertArrayEquals(rotateMatrix,inputMatrix);
    }

    @Test
    void rotateInPlaceFor5x5Matrix() {
        int[][] inputMatrix = {{-2,7,0,6,-2},{1,-1,3,2,2}, {3,4,0,5,3}, {2,5,-4,-2,2}, {0,3,-1,1,-4}};
        int[][] rotateMatrix = {{0,2,3,1,-2},{3,5,4,-1,7}, {-1,-4,0,3,0}, {1,-2,5,2,6}, {-4,2,3,2,-2}};
        RotateMatrix.rotateInPlace(inputMatrix);
        assertArrayEquals(rotateMatrix,inputMatrix);
    }




}