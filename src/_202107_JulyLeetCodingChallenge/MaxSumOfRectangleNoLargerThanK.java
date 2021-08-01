package _202107_JulyLeetCodingChallenge;

public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] matrix = { {1,0,1},{0,-2,3}};
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix,k));
    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {

        int maxSum = Integer.MIN_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < cols; i++) {

            // Starting at each column we incrementally go till end
            // [0], [0,1], [0,1,2]
            // [1], [1,2]
            // [2]

            int[] rowSum = new int[rows];
            for (int col = i; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    rowSum[row] += matrix[row][col];
                }

                // We have calculated the row sum till the current column
                // Now it is time to mind the max subarray sum we can achieve lesser than k
                int maxSumUnderK = maxSubarrayLessThanK(rowSum, k);
                maxSum = Math.max(maxSum, maxSumUnderK);

                if (maxSum == k) return k;
            }
        }
        return maxSum;
    }

    // This is Kadane's algorithm .. a bit modified
    private static int maxSubarrayLessThanK(int[] array, int k) {
        int maxSumUnderK = Integer.MIN_VALUE;

        // Best possible data structure to keep stuff in sorted order and get back in log n time
        java.util.TreeSet<Integer> sortedPreviousSums = new java.util.TreeSet<>();
        sortedPreviousSums.add(0);

        int incrementalSum = 0;
        for (int i = 0; i < array.length; i++) {
            incrementalSum += array[i];

            // Now we try to find if our sorted sum list is having
            // any thing just larger than (sum - k), say that is previousSum
            // If there is an element we know we can go close to k as much as (sum - previousSum)
            Integer previousSum = sortedPreviousSums.ceiling(incrementalSum - k);
            if (previousSum != null) {
                maxSumUnderK = Math.max(maxSumUnderK, incrementalSum - previousSum);
            }

            sortedPreviousSums.add(incrementalSum);
        }

        return maxSumUnderK;
    }
}
