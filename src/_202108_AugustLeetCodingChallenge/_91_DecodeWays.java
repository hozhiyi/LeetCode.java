package _202108_AugustLeetCodingChallenge;

public class _91_DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            //说明无解
            return 0;
        }
        char[] charArray = s.toCharArray();
        int last_2 = 1, last_1 = 1;  //last_2 代表i-2  last_1 代表i-1 temp 代表当前
        for (int i = 1; i < s.length(); i++) {
            int temp = last_1;

            if (charArray[i] == '0') {
                if (charArray[i - 1] == '1' || charArray[i - 1] == '2') {
                    temp = last_2;
                } else {
                    return 0;
                }
            } else if (charArray[i - 1] == '1' || (charArray[i - 1] == '2' && charArray[i] - '0' > 0 && charArray[i] - '0' < 7)) {
                temp += last_2;
            }
            last_2 = last_1;
            last_1 = temp;
        }
        return last_1;
    }
}
