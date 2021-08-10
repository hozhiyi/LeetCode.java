package _202108_AugustLeetCodingChallenge;

public class _926_FlipStringToMonotoneIncreasing {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int l = s.length();
            int[] tracker = new int[l + 1];

            for (int i = 0; i < l; i++) {
                tracker[i + 1] = tracker[i] + (s.charAt(i) == '1' ? 1 : 0);
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < l; i++) {
                res = Math.min(res, tracker[i] + l - i - (tracker[l] - tracker[i]));
            }
            return res;
        }
    }
}
