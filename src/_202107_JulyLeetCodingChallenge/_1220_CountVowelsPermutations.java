package _202107_JulyLeetCodingChallenge;

public class _1220_CountVowelsPermutations {
    static final int mod = (int) 1e9 + 7;

    public static int countVowelPermutation(int n) {
        long[][] A = new long[5][5];
        A[0][1] = 1;
        A[1][0] = A[1][2] = 1;
        A[2][0] = A[2][1] = A[2][3] = A[2][4] = 1;
        A[3][2] = A[3][4] = 1;
        A[4][0] = 1;

        long[][] M = power(A, n - 1);
        long res = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res = (res + M[i][j]) % mod;
            }
        }
        return (int) res;
    }

    private static long[][] power(long[][] A, int k) {
        int N = A.length;
        long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            C[i][i] = 1;
        }
        while (k > 0) {
            if ((k & 1) != 0) C = multiply(A, C);
            A = multiply(A, A);
            k = k >> 1;
        }
        return C;
    }

    private static long[][] multiply(long[][] A, long[][] B) {
        int N = A.length;
        long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return C;
    }
//    public static int countVowelPermutation(int n) {
//        // To avoid the large output value
//        int MOD = (int) (1e9 + 7);
//
//        // Initialize 2D dp array
//        long[][] dp = new long[n + 1][5];
//
//        // Initialize dp[1][i] as 1 since
//        // string of length 1 will consist
//        // of only one vowel in the string
//        for (int i = 0; i < 5; i++) {
//            dp[1][i] = 1;
//        }
//
//        // Directed graph using the
//        // adjacency matrix
//        int[][] relation = new int[][]{
//                {1}, {0, 2},
//                {0, 1, 3, 4},
//                {2, 4}, {0}
//        };
//
//        // Iterate over the range [1, N]
//        for (int i = 1; i < n; i++) {
//
//            // Traverse the directed graph
//            for (int u = 0; u < 5; u++) {
//                dp[i + 1][u] = 0;
//
//                // Traversing the list
//                for (int v : relation[u]) {
//
//                    // Update dp[i + 1][u]
//                    dp[i + 1][u] += dp[i][v] % MOD;
//                }
//            }
//        }
//
//        // Stores total count of permutations
//        long ans = 0;
//
//        for (int i = 0; i < 5; i++) {
//            ans = (ans + dp[n][i]) % MOD;
//        }
//
//        // Return count of permutations
//        return (int) ans;
//    }

    public static void main(String[] args) {
        int N = 2;
        System.out.println(countVowelPermutation(N));
    }
}
