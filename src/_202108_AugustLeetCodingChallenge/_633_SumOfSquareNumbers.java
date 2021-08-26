// Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
package _202108_AugustLeetCodingChallenge;

public class _633_SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));

    }
    public static boolean judgeSquareSum(int c) {
        //fermat's theorem
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c = c / i;
                }
                if (i % 4 == 3 && count % 2 != 0) return false;
            }
        }
        return c % 4 != 3;
    }
}
