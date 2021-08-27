package _202108_AugustLeetCodingChallenge;

public class _331_VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        char[] str = preorder.toCharArray();
        int out = 0, in = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ',') continue;
            in++;
            if (out < in) return false;
            if (str[i] <= '9' && str[i] >= '0') {
                out += 2;
                while (i < str.length - 1 && str[i + 1] >= '0' && str[i + 1] <= '9') i++;
            }
        }
        return out == in;
    }
}
