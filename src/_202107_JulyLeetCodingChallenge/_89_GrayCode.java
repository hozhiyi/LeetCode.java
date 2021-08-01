package _202107_JulyLeetCodingChallenge;

import java.util.ArrayList;
import java.util.List;

public class _89_GrayCode {
    public static void main(String[] args) {
        System.out.println(generateGrayArr(3).toString());
    }

    static List<Integer> generateGrayArr(int n) {
        List<Integer> answer = new ArrayList<>();

        if (n <= 0)
            return answer;

        ArrayList<String> arr = new ArrayList<String>();

        arr.add("0");
        arr.add("1");

        int i, j;
        for (i = 2; i < (1 << n); i = i << 1) {

            for (j = i - 1; j >= 0; j--)
                arr.add(arr.get(j));

            for (j = 0; j < i; j++)
                arr.set(j, "0" + arr.get(j));

            for (j = i; j < 2 * i; j++)
                arr.set(j, "1" + arr.get(j));
        }

        for (i = 0; i < arr.size(); i++) {
            answer.add(Integer.parseInt(arr.get(i), 2));
        }
        return answer;
    }
}
