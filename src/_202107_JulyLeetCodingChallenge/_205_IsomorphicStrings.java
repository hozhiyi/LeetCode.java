package _202107_JulyLeetCodingChallenge;

public class _205_IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("egcd", "adfd"));
        System.out.println(isIsomorphic("abab", "baba"));
    }

    public static boolean isIsomorphic(String str1, String str2) {
        char[] map = new char[256];
        boolean[] used = new boolean[256];
        char[] sc = str1.toCharArray();
        char[] tc = str2.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            if (map[sc[i]] == 0) {
                if (used[tc[i]]) {
                    return false;
                }
                map[sc[i]] = tc[i];
                used[tc[i]] = true;
            } else if (map[sc[i]] != tc[i]) {
                return false;
            }
        }
        return true;
    }
}
