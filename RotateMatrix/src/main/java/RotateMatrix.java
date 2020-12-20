public class RotateMatrix {



    /*
            Given a image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place ?
            123      741
            456  --->852
            789      963


            qwer     uzaq
            asdf     ixsw
            zxcv     ocde
            uiop     pvfr

         */
    public static void rotateInPlace(int[][] squareMatrix) {
        assert (squareMatrix.length == squareMatrix[0].length);

        int length = squareMatrix.length -1;

        //rotacion en "circulos concentricos", de fuera a adentro
        for (int i = 0; i < squareMatrix.length / 2; i++) {
            // roto las esquinas
            int ul = squareMatrix[i][i];
            int ur = squareMatrix[i][length-i];
            int dr = squareMatrix[length- i][length-i];
            int dl = squareMatrix[length- i][i];

            squareMatrix[i][i] = dl;
            squareMatrix[i][length-i] = ul;
            squareMatrix[length- i][length-i] = ur;
            squareMatrix[length- i][i] = dr;

            for (int x = i +1; x < length - i; x++) {
                 ul = squareMatrix[i][x];
                 ur = squareMatrix[x][length-i];
                 dr = squareMatrix[length-i][length-x];
                 dl = squareMatrix[length-x][i];

                squareMatrix[i][x] = dl;
                squareMatrix[x][length-i] = ul;
                squareMatrix[length-i][length-x] = ur;
                squareMatrix[length-x][i] = dr;
            }
        }
    }

}
