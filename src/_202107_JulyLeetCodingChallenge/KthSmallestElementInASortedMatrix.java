package _202107_JulyLeetCodingChallenge;

import java.util.Arrays;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[m - 1][n - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(matrix, mid, k, n)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
//        int[] matrix2d = new int[matrix.length * matrix.length];
//
//        int index = 0;
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                matrix2d[index++] = matrix[i][j];
//            }
//        }
//        Arrays.sort(matrix2d);
//        return matrix2d[k - 1];
    }

    private static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
