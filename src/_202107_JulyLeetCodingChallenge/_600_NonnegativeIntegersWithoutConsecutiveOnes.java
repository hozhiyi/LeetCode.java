package _202107_JulyLeetCodingChallenge;

public class _600_NonnegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int n) {
        int x = 1, y = 2;
        int res = 0;
        n++;
        while (n > 0) {
            if ((n & 3) == 3)
                res = 0;
            res += x * (n & 1);
            n >>= 1;
            int t = x + y;
            x = y;
            y = t;
        }
        return res;
    }
}
