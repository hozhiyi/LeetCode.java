package _202107_JulyLeetCodingChallenge;

public class CustomSortString {
    public static void main(String[] args) {
        String S = "exv";
        String T = "xwvee";
        System.out.println(customSortString(S, T));
        System.out.println(customSortString2(S, T));
    }

    // 1st 0 ms solution
    public static String customSortString(String S, String T) {
        // Step 1: count the freq of each char in T
        int[] freq = new int[26];

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            freq[c - 'a']++;
        }

        // step 2: scan the string S and print the number of chars in T
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (freq[c - 'a'] > 0) {
                sb.append(c);
                freq[c - 'a']--;
            }
        }

        // step 3: scan the freq again and append anything not zero
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return sb.toString();
    }

    // 2nd 0 ms solution
    public static String customSortString2(String order, String str) {
        int i;
        int M = order.length();
        int N = str.length();
        char ch;

        int[] counts = new int[26];

        for (i = 0; i < N; i++) {
            counts[str.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (i = 0; i < M; i++) {
            ch = order.charAt(i);
            while (counts[ch - 'a'] != 0) {
                result.append(ch);
                --counts[ch - 'a'];
            }
        }

        for (i = 0; i < 26; i++) {
            while (counts[i] != 0) {
                result.append((char) ('a' + i));
                --counts[i];
            }
        }

        return result.toString();
    }
}
