package _202108_AugustLeetCodingChallenge;

public class _522_LongestUncommonSubsequenceII {
    public int findLUSlength(String[] s) {
        int maxLength = -1, n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i].length() > maxLength) {
                int j = -1;
                while (++j < n) if (i != j && isStrSub(s[i], s[j])) break;
                if (j == n) maxLength = s[i].length();
            }
        }
        return maxLength;
    }

    private static boolean isStrSub(String str, String s1) {
        int i1 = 0, i2 = 0;
        while (i1 < str.length() && i2 < s1.length()) {
            if (str.charAt(i1) == s1.charAt(i2++)) i1++;
        }
        return i1 == str.length();
    }
}
