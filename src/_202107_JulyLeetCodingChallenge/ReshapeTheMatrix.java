package _202107_JulyLeetCodingChallenge;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (m * n != r * c)
            return mat;
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] ans = matrixReshape(mat, r, c);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }
}
