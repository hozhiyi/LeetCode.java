package _202108_AugustLeetCodingChallenge;

import java.util.*;

public class _850_RectangleAreaII {
    class Solution {
        public int rectangleArea(int[][] rectangles) {
            int mod = 1_000_000_007;
            long res = 0;
            List<int[]> recList = new ArrayList<>();
            for (int[] rec : rectangles)
                addRectangle(recList, rec, 0);

            for (int[] rec : recList)
                res = (res + ((long) (rec[2] - rec[0]) * (long) (rec[3] - rec[1]))) % mod;

            return (int) res % mod;
        }

        public void addRectangle(List<int[]> recList, int[] curRec, int start) {
            if (start >= recList.size()) {
                recList.add(curRec);
                return;
            }

            int[] r = recList.get(start);

            // No overlap
            if (curRec[2] <= r[0] || curRec[3] <= r[1] || curRec[0] >= r[2] || curRec[1] >= r[3]) {
                addRectangle(recList, curRec, start + 1);
                return;
            }

            if (curRec[0] < r[0])
                addRectangle(recList, new int[]{curRec[0], curRec[1], r[0], curRec[3]}, start + 1);

            if (curRec[2] > r[2])
                addRectangle(recList, new int[]{r[2], curRec[1], curRec[2], curRec[3]}, start + 1);

            if (curRec[1] < r[1])
                addRectangle(recList, new int[]{Math.max(r[0], curRec[0]), curRec[1], Math.min(r[2], curRec[2]), r[1]}, start + 1);

            if (curRec[3] > r[3])
                addRectangle(recList, new int[]{Math.max(r[0], curRec[0]), r[3], Math.min(r[2], curRec[2]), curRec[3]}, start + 1);
        }
    }
}
