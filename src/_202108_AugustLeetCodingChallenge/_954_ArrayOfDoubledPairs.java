package _202108_AugustLeetCodingChallenge;

public class _954_ArrayOfDoubledPairs {
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            if (arr == null || arr.length == 0) return true;
            int max = Integer.MIN_VALUE;
            for (int i : arr) max = Math.max(max, Math.abs(i));

            int[] neg = new int[max + 1];
            int[] pos = new int[max + 1];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) pos[arr[i]]++;
                else neg[Math.abs(arr[i])]++;
            }

            if (pos[0] % 2 != 0) return false;

            for (int i = 1; i < pos.length; i++) {
                if (pos[i] > 0) {
                    if (i * 2 >= pos.length || pos[2 * i] < pos[i]) return false;

                    pos[2 * i] -= pos[i];
                }

                if (neg[i] > 0) {
                    if (i * 2 >= neg.length || neg[2 * i] < neg[i]) return false;

                    neg[2 * i] -= neg[i];
                }
            }

            return true;
        }
    }
}
