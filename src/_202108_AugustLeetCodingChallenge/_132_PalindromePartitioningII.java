package _202108_AugustLeetCodingChallenge;

public class _132_PalindromePartitioningII {
    class Solution {
        /*
        Space complexity: O(n)
        Time Complexity: O(n^2);
        */
        public int minCut(String s) {
            if (s == null || s.isEmpty() || s.length() <= 1) return 0;
            int[] mem = new int[s.length()];
            mem[0] = 0;
            for (int i = 0; i < s.length(); i++) {
                mem[i] = i;
            }
            for (int i = 1; i < s.length(); i++) { //O(n)
                findPalindrome(s, mem, i, i);  // o(n)
                findPalindrome(s, mem, i - 1, i); // 2* o(n)
            }
            return mem[s.length() - 1];
        }

        public void findPalindrome(String s, int[] mem, int left, int right) {

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (left == 0) {
                    mem[right] = 0;
                } else {
                    mem[right] = Math.min(mem[right], mem[left - 1] + 1);
                }
                left--;
                right++;
            }
        }
    }
}
