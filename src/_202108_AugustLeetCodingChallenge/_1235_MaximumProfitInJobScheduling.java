package _202108_AugustLeetCodingChallenge;

import java.util.Arrays;

public class _1235_MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[startTime.length];
        int[][] time = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            time[i][0] = startTime[i];
            time[i][1] = endTime[i];
            time[i][2] = profit[i];
        }
        Arrays.sort(time, (a, b) -> (a[1] - b[1]));
        dp[0] = time[0][2];
        for (int i = 1; i < startTime.length; i++) {
            dp[i] = time[i][2];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = (left + right + 1) >> 1;
                if (time[mid][1] <= time[i][0]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (time[left][1] <= time[i][0]) {
                dp[i] += dp[left];
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
