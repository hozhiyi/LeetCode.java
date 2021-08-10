package _202108_AugustLeetCodingChallenge;

public class _926_FlipStringToMonotoneIncreasing {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            char[] ch = s.toCharArray();
            int onescount = 0;
            int flipcount = 0;

            for (int i = 0; i < s.length(); i++) {
                if (ch[i] == '0') {
                    if (onescount == 0) continue;
                    flipcount++;
                } else {
                    onescount++;
                }
                if (flipcount > onescount) {
                    flipcount = onescount;
                }
            }

            return flipcount;
        }
    }
}
