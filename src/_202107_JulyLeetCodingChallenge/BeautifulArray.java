package _202107_JulyLeetCodingChallenge;

import java.util.HashMap;
import java.util.Map;

public class BeautifulArray {
    Map<Integer, int[]> tracker;

    public int[] beautifulArray(int N) {
        tracker = new HashMap<>();
        tracker.put(1, new int[]{1});
        return helper(N);
    }

    private int[] helper(int N) {
        if (!tracker.containsKey(N)) {
            int index = 0;
            int[] res = new int[N];
            for (int x : helper((N + 1) / 2)) {
                res[index++] = 2 * x - 1;
            }
            for (int x : helper(N / 2)) {
                res[index++] = 2 * x;
            }
            tracker.put(N, res);
        }
        return tracker.get(N);
    }
}
