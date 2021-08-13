package _202108_AugustLeetCodingChallenge;

public class _73_SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstColumn = false;
            for (int i = 0; i < matrix.length; i++) { // rows
                if (matrix[i][0] == 0) {
                    firstColumn = true;
                }
                for (int j = 1; j < matrix[0].length; j++) { // columns
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            // set first row to zero
            if (matrix[0][0] == 0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
            // set first column to zero
            if (firstColumn) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
