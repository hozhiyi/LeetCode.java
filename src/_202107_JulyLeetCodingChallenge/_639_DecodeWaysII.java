package _202107_JulyLeetCodingChallenge;

public class _639_DecodeWaysII {
    public static void main(String[] args) {
        String s1 = "*", s2 = "1*", s3 = "*12*";
        //System.out.println(numDecodings1(s1));
        //System.out.println(numDecodings1(s2));
        System.out.println(numDecodings1(s3));

    }
    // 7 ms solution
    public static int numDecodings1(String s) {
        int[] a1 = new int[58];
        a1['*'] = 9;
        for (int i = '0'; i <= '9'; ++i) a1[i] = 1;

        int[] a2 = new int[58];
        a2['*'] = 6;
        for (int i = '0'; i <= '6'; ++i) a2[i] = 1;

        final int MOD = 1000000007;
        long q = 1;
        long p = 1;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            long one = p * parseOne(c);
            long two = q * parseTwo(s, i, a1, a2);

            q = p;
            p = one + two;

            if (p == 0) return 0;
            p %= MOD;
        }
        return (int) p;
    }

    private static int parseOne(char c) {
        switch (c) {
            case '0':
                return 0;
            case '*':
                return 9;
            default:
                return 1;
        }
    }

    private static int parseTwo(String s, int i, int[] a1, int[] a2) {
        if (i < 1) return 0;
        char a = s.charAt(i - 1);
        char b = s.charAt(i);

        switch (a) {
            case '1':
                return a1[b];
            case '2':
                return a2[b];
            case '*':
                return a1[b] + a2[b];
            default:
                return 0;
        }
    }

    // 39000 KB solution
    public int numDecodings2(String s) {

        long ae = 1;
        long e1 = 0;
        long e2 = 0;
        long mod = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long tae = 0, te1 = 0, te2 = 0;

            if (ch == '*') {
                tae = (ae * 9 + e1 * 9 + e2 * 6) % mod;
                te1 = ae;
                te2 = ae;

            } else {
                tae = (ae * (ch == '0' ? 0 : 1) + e1 + e2 * (ch > '6' ? 0 : 1)) % mod;
                te1 = ae * (ch == '1' ? 1 : 0);
                te2 = ae * (ch == '2' ? 1 : 0);
            }
            ae = tae;
            e1 = te1;
            e2 = te2;
        }
        return (int) ae;
    }
}
